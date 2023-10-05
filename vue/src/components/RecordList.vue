<template>
    <div class="record-list">  
         <record-card 
                v-for="record in records"
                :key="record.id" :recordInfo="record"
                :isHome="isHome"/>
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
    props: ['records','isHome'],

}
</script>

<style scoped>
.record-card {
    margin: 10px;
    width: 20%;
    min-width: 80px;
    
}
</style>