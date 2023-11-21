<template>
    <a-layout-header class="header">
            <div class="logo">
                您好：{{ member.mobile }}
                <route-link to="/login">退出登录</route-link>
            </div>
            <a-menu
                v-model:selectedKeys="selectedKeys1"
                theme="dark"
                mode="horizontal"
                :style="{lineHeight:'64px'}"
            >
                <a-menu-item key="1">nav 1</a-menu-item>
                <a-menu-item key="2">nav 2</a-menu-item>
                <a-menu-item key="3">nav 3</a-menu-item>
            </a-menu>
        </a-layout-header>
</template>

<script setup>
import { ref } from 'vue'
import store from '@/store'
const member = store.state.member

const selectedKeys1 = ref(['2'])
</script>
<style scoped></style>
