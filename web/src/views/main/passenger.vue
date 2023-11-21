<template>
    <a-button type="primary" @click="showModal">新增</a-button>
    <a-table :dataSource="passengers" :columns="columns" />
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
const passengers = ref([])

const passenger = reactive({
  id: undefined,
  memberId: undefined,
  name: undefined,
  idCard: undefined,
  type: undefined,
  createTime: undefined,
  updateTime: undefined
})
// const dataSource = [
//   {
//     key: '1',
//     name: '胡彦斌',
//     age: 32,
//     address: '西湖区湖底公园1号'
//   },
//   {
//     key: '2',
//     name: '胡彦祖',
//     age: 42,
//     address: '西湖区湖底公园1号'
//   }
// ]

const columns = [
  {
    title: '姓名',
    dataIndex: 'name',
    key: 'name'
  },
  {
    title: '年龄',
    dataIndex: 'age',
    key: 'age'
  },
  {
    title: '住址',
    dataIndex: 'address',
    key: 'address'
  }
]
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
const handleQuery = (param) => {
  axios.get('/member/passenger/query-list', {
    params: {
      page: param.page,
      size: param.size
    }
  })
    .then((response) => {
      const data = response.data
      if (data.success) {
        passengers.value = data.content.list
      } else {
        notification.error({ description: data.message })
      }
    })
}
onMounted(() => {
  handleQuery({
    page: 1,
    size: 2
  })
})
</script>
<style scoped>
</style>
