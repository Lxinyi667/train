<template>
    <p>
        <a-space>
            <a-button type="primary" @click="handleQuery()">刷新</a-button>
            <a-button type="primary" @click="showModal">新增</a-button>
        </a-space>
    </p>

    <a-table
    :dataSource="passengers"
    :columns="columns"
    :pagination="pagination"
    @change="handleTableChange"

    />
    <a-modal
    v-model:visible="visible"
    title="乘车人"
    @ok="handleOk"
    ok-text="确认"
    cancel-text="取消"
    >
       <a-form
        :model="passenger"
        :label-col="{span:4 }"
        :wrapper-col="{span:20 }"
        >
            <a-form-item label="姓名">
                <a-input v-model:value="passenger.name"/>
            </a-form-item>
            <a-form-item label="身份证">
                <a-input v-model:value="passenger.idCard"/>
            </a-form-item>
            <a-form-item label="类型">
                <a-select v-model:value="passenger.type">
                    <a-select-option value="1">成人</a-select-option>
                    <a-select-option value="2">儿童</a-select-option>
                    <a-select-option value="3">学生</a-select-option>
                </a-select>
            </a-form-item>
        </a-form>
    </a-modal>
</template>
<script setup>
import { ref, reactive, onMounted } from 'vue'
import { notification } from 'ant-design-vue'
import axios from 'axios'

const visible = ref(false)

const passenger = reactive({
  id: undefined,
  memberId: undefined,
  name: undefined,
  idCard: undefined,
  type: undefined,
  createTime: undefined,
  updateTime: undefined
})
const showModal = () => {
  visible.value = true
}

const handleOk = () => {
  axios.post('/member/passenger/save', passenger).then((response) => {
    const data = response.data
    if (data.success) {
      notification.success({ description: '保存成功！' })
      visible.value = false
    } else {
      notification.error({ description: data.message })
    }
  })
}
const passengers = ref([])
// 分页的三个属性名是固定的
const pagination = reactive({
  total: 0,
  current: 1,
  pagesize: 2
})

const columns = [
  {
    title: '姓名',
    dataIndex: 'name',
    key: 'name'
  },
  {
    title: '身份证',
    dataIndex: 'idCard',
    key: 'idCard'
  },
  {
    title: '类型',
    dataIndex: 'type',
    key: 'type'
  }
]
const handleQuery = (param) => {
  if (!param) {
    param = {
      page: 1,
      size: pagination.pageSize
    }
  }
  axios
    .get('/member/passenger/query-list', {
      params: {
        page: param.page,
        size: param.size
      }
    })
    .then((response) => {
      const data = response.data
      if (data.success) {
        passengers.value = data.content.list
        // 设置分页控件的值
        pagination.current = param.page
        pagination.total = data.content.total
      } else {
        notification.error({ description: data.message })
      }
    })
}
const handleTableChange = (pagination) => {
  console.Log('看看自带的分页参数都有啥：' + pagination)
  handleQuery({
    page: pagination.current,
    size: pagination.pageSize
  })
}
onMounted(() => {
  handleQuery({
    page: 1,
    size: pagination.pagesize
  })
})
</script>
<style scoped>
</style>
