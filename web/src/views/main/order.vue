<template>
<div>{{ dailyTrainTicket }}</div>
</template>

<script setup>
const dailyTrainTicket = SessionStorage.get(SESSION_ORDER) || {}
console.Log('下单的车次信息', dailyTrainTicket)
</script>
