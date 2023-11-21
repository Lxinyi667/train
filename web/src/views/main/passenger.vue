<template>
    <a-button type="primary" @click="showModal">新增</a-button>
    <a-modal v-model:visible="visible" title="乘车人" @ok="handleOk">
        <p>Some contents...</p>
        <p>Some contents...</p>
        <p>Some contents...</p>
    </a-modal>
</template>
<script setup>
import { ref } from 'vue'
const visible = ref(false)

const showModal = () => {
  visible.value = true
}
const handleOk = (e) => {
  console.log(e)
  visible.value = false
}
</script>
<style scoped>
</style>
