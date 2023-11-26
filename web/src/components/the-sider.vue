<template>
<a-layout-sider width="200" style="background:#fff">
            <a-menu
            v-model:selectedKeys="selectedKeys"
            v-model:openKeys="openKeys"
            mode="inline"
            :style="{ height:'100%', borderRight:0 }"
            >
            <a-sub-menu key="subl">
            <template #title>
                <span>
                    <user-outlined />
                    subnav 1
                </span>
            </template>
            <a-menu-item key="1">optionl</a-menu-item>
            <a-menu-item key="2">option2</a-menu-item>
            <a-menu-item key="3">option3</a-menu-item>
            <a-menu-item key="4">option4</a-menu-item>
            </a-sub-menu>
            <a-sub-menu key="sub2">
            <template #title>
                <span>
                <laptop-outlined />
                subnav 2
                </span>
            </template>
            <a-menu-item key="5">option5</a-menu-item>
            <a-menu-item key="6">option6</a-menu-item>
            <a-menu-item key="7">option7</a-menu-item>
            <a-menu-item key="8">option8</a-menu-item>
            </a-sub-menu>
            <a-sub-menu key="sub3">
                <template #title>
                    <span>
                        <notification-outlined />
                        subnav 3
                    </span>
                </template>
                <a-menu-item key="9">option9</a-menu-item>
                <a-menu-item key="10">option10</a-menu-item>
                <a-menu-item key="11">optionl1</a-menu-item>
                <a-menu-item key="12">option12</a-menu-item>
            </a-sub-menu>
              <a-menu-item key="/welcome">
                    <router-link to="/welcome"><coffee-outlined /> 欢迎</router-link>
                </a-menu-item>
                <a-menu-item key="/passenger">
                    <router-link to="/passenger">
                         <user-outlined />乘车人管理
                    </router-link>
                </a-menu-item>
                <a-menu-item key="/ticket">
                    <router-link to="/ticket">
                         <user-outlined />余票查询
                    </router-link>
                </a-menu-item>
        </a-menu>
    </a-layout-sider>
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
<style scoped></style>
