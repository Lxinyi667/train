<template>
    <a-row class="login">
        <a-col :span="8" :offset="8" class="login-main">
        <h1 style="text-align: center"><rocket-two-tone/>12306售票系统</h1>
        <a-form
            :model="loginForm"
            name="basic"
            autocomplete="off"
            @finish="onFinish"
            @finishFailed="onFinishFailed"
        >
        <a-form-item
            label=""
            name="mobile"
            :rules="[{required:true,message:'请输入手机号！'}]"
        >
        <a-input v-model:value="loginForm.mobile" placeholder="手机号"/>
        </a-form-item>

        <a-form-item
            label=""
            name="code"
             :rules="[{required:true,message:'请输入验证码！'}]"
             >
            <a-input v-model:value="loginForm.code">
                <template #addonAfter>
                    <a @click="sendCode">获取验证码</a>
                </template>
            </a-input>
            </a-form-item>
            <a-form-item>
                <a-button type="primary" block html-type="submit"></a-button>
            </a-form-item>
        </a-form>
        </a-col>
        </a-row>
</template>
<script setup>
import { reactive } from 'vue'
const loginForm = reactive({
  mobile: '13000000000',
  code: ''
})

const onFinish = (values) => {
  console.log('Success:', values)
}
const onFinishFailed = (errorInfo) => {
  console.log('Failed:', errorInfo)
}
</script>
<style scoped>
.login-main h1{
    font-size: 25px;
    font-weight: bold;
}
.login-main{
    margin-top: 100px;
    padding: 30px 30px 20px;
    border: 2px solid pink;
    border-radius: 10px;
    background-color: #fcfcfc;
}
</style>
