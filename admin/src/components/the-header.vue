<template>
  <a-layout-header class="header">
    <div class="logo">
      <router-link to="/welcome" style="color: white; font-size: 18px">
        12306 管理后台
      </router-link>
    </div>
    <div style="float: right; color: white">欢迎使用 12306 管理后台</div>
    <a-menu
      v-model:selectedKeys="selectedKeys"
      theme="dark"
      mode="horizontal"
      :style="{ lineHeight: '64px' }"
    >
      <a-menu-item key="/welcome">
        <router-link to="/welcome"> <coffee-outlined /> 欢迎 </router-link>
      </a-menu-item>
      <a-menu-item key="/about">
        <router-link to="/about"> <user-outlined /> 关于 </router-link>
      </a-menu-item>
    </a-menu>
  </a-layout-header>
</template>

<script setup>
import { ref, watch } from 'vue'
import router from '@/router'

const selectedKeys = ref([])

watch(
  () => router.currentRoute.value.path,
  (newValue) => {
    console.log('watch', newValue)
    selectedKeys.value = []
    selectedKeys.value.push(newValue)
  },
  { immediate: true }
)
</script>

<style scoped>
.logo {
  float: left;
  height: 31px;
  width: 150px;
  color: white;
  font-size: 20px;
}
</style>
