<template>
    <div>
        <div v-show="1">
            <div id="record-row" 
                v-for="record in records"
                :key="record.id">
                <record-info-thin :recordInfo="record"/>
            </div>
        </div>
        <!-- <div class="no-items-msg" v-show="records.length === 0">
            No records found.
        </div> -->
    </div>  
</template>

<script>
import RecordInfoThin from './RecordInfoThin.vue';

export default {
    name: "record-list",
    components: {
        RecordInfoThin
    },
    props: ['records'],

}
</script>

<style>

</style>