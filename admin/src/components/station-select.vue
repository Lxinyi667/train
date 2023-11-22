<template>
    <a-select
        v-model:value="name"
        show-search
        allowClear
        :filterOption="filterNameOption"
        @change="onChange"
        placeholder="请选择车站"
        :style="'width:' + _width"
    >
   <a-select-option
         v-for="item in stations"
        :key="item.name"
        :value="item.name"
        :label="item.name + item.namePinyin + item.namePy"
    >
        {{item.name }} | {{item.namePinyin }} ~ {{item.namePy }}
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

const name = ref()
const stations = ref([])

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
    name.value = props.modelValue
  },
  { immediate: true }
)
/**
 * 查询所有的车次，用于车次下拉框
 */
const queryAllStation = () => {
  axios.get('/business/admin/station/query-all').then((response) => {
    const data = response.data
    if (data.success) {
      stations.value = data.content
    } else {
      notification.error({ description: data.message })
    }
  })
}
const filterNameOption = (input, option) => {
  console.log(input, option)
  return option.label.toLowerCcase().indexOf(input.toLowerCase()) >= 0
}
const onChange = (value) => {
  emit('update:modelValue', value)
  let train = stations.value.filter((item) = item.code === value)[0]
  if (Tool.isEmpty(station)) {
    train = {}
  }
  emit('change', station)
}
onMounted(() => {
  queryAllStation()
})
</script>
