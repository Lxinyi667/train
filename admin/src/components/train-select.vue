<template>
    <a-select
        v-model:value="trainCode"
        show-search
        allowClear
        :filterOption="filterTrainCodeOption"
        @change="onChange"
        placeholder="请选择车次"
        :style="'width:' + _width"
    >
   <a-select-option
         v-for="item in trains"
        :key="item.code"
        :value="item.code"
        :label="item.code + item.start + item.end"
    >
        {{item.code }} | {{item.start }} ~ {{item.end }}
    </a-select-option>
    </a-select>
</template>

<script setup>
import { defineProps, defineEmits, onMounted, ref, watch } from 'vue'
import axios from 'axios'
import notification from 'ant-design-vue'

const props = defineProps({
  modelValue: {
    type: String,
    default: ''
  },
  width: {
    type: String,
    default: ''
  }
})

const emit = defineEmits(['update:modelValue', 'change'])

const trainCode = ref()
const trains = ref([])

const _width = ref(props.width)
if (Tool.isEmpty(props.width)) {
  _width.value = '100%'
}
// 利用watch,动态获取父组件的值，
// 如果放在onMounted或其它方法里，则只有第一次有效
watch(
  () => props.modelValue,
  () => {
    console.log('props.modelValue', props.modelValue)
    trainCode.value = props.modelValue
  },
  { immediate: true }
)
/**
 * 查询所有的车次，用于车次下拉框
 */
const queryAllTrain = () => {
  const list = SessionStorage.get(SESSION_ALL_TRAIN)
  if (Tool.isNotEmpty(list)) {
    console.log('queryAllTrain 读取缓存')
    trains.value = list
  } else {
    axios.get('/business/admin/train/query-all').then((response) => {
      const data = response.data
      if (data.success) {
        trains.value = data.content
        console.log('queryAllTrain 保存缓存')
        SessionStorage.set(SESSION_ALL_TRAIN, trains.value)
      } else {
        notification.error({ description: data.message })
      }
    })
  }
}
const filterTrainCodeOption = (input, option) => {
  console.log(input, option)
  return option.label.toLowerCase().indexOf(input.toLowerCase()) >= 0
}
const onChange = (value) => {
  emit('update:modelValue', value)
  let train = trains.value.filter((item) => item.code === value)[0]
  if (Tool.isEmpty(train)) {
    train = {}
  }
  emit('change', train)
}
onMounted(() => {
  queryAllTrain()
})
</script>
