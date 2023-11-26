<template>
<div>{{dailyTrainTicket }}</div>
</template>

<script setup>
const dailyTrainTicket = Sessionstorage.get('dailyTrainTicket') || {}
console.Log('下单的车次信息', dailyTrainTicket)
</script>
