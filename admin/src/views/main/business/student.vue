<template>
    <p>
        <a-space>
            <a-button type="primary" @click="handleQuery()">刷新</a-button>
            
        </a-space>
    </p>
    <a-table :dataSource="students"
             :columns="columns"
             :pagination="pagination"
             @change="handleTableChange"
             :loading="loading">
        <template #bodyCell="{ column, record }">
            <template v-if="column.dataIndex === 'operation'">
            </template>
        </template>
    </a-table>
</template>

<script setup>
    import {ref, onMounted} from 'vue';
    import {notification} from "ant-design-vue";
    import axios from "axios";

    const visible = ref(false);
    let student = ref({
        id: undefined,
        name: undefined,
        phonenumber: undefined,
        age: undefined,
        email: undefined,
        school: undefined,
    });
    const students = ref([]);
    // 分页的三个属性名是固定的
    const pagination = ref({
        total: 0,
        current: 1,
        pageSize: 10,
    });
    let loading = ref(false);
    const columns = [
        {
            title: '',
            dataIndex: 'name',
            key: 'name',
        },
        {
            title: '',
            dataIndex: 'phonenumber',
            key: 'phonenumber',
        },
        {
            title: '',
            dataIndex: 'age',
            key: 'age',
        },
        {
            title: '',
            dataIndex: 'email',
            key: 'email',
        },
        {
            title: '',
            dataIndex: 'school',
            key: 'school',
        },
    ];


    const handleQuery = (param) => {
        if (!param) {
            param = {
                page: 1,
                size: pagination.value.pageSize
            };
        }
        loading.value = true;
        axios.get("/business/admin/student/query-list", {
            params: {
                page: param.page,
                size: param.size
            }
        }).then((response) => {
            loading.value = false;
            let data = response.data;
            if (data.success) {
                students.value = data.content.list;
                // 设置分页控件的值
                pagination.value.current = param.page;
                pagination.value.total = data.content.total;
            } else {
                notification.error({description: data.message});
            }
        });
    };

    const handleTableChange = (pagination) => {
        handleQuery({
            page: pagination.current,
            size: pagination.pageSize
        });
    };

    onMounted(() => {
        handleQuery({
            page: 1,
            size: pagination.value.pageSize
        });
    });
</script>