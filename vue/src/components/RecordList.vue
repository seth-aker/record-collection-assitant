<template>
    <div class="record-list">
            <div class="record-card" 
                v-for="record in records"
                :key="record.id">
                <record-card :recordInfo="record"/>
            </div>
        
        <!-- <div class="no-items-msg" v-show="records.length === 0">
            No records found.
        </div> -->
    </div>  
</template>

<script>
import RecordCard from './RecordCard.vue';

export default {
    name: "record-list",
    components: {
        RecordCard
    },
    props: ['records'],

}
</script>

<style scoped>
.record-card {
    width: 155px;
}
</style>