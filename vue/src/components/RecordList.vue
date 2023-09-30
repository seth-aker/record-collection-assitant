<template>
    <div>
        <image-spinner v-show="showSpinner"/>
        <div v-show="userLibrary.length != 0 && !showSpinner">
            <div id="record-row" 
                v-for="curRecord in userLibrary"
                :key="curRecord.id"
                :record="curRecord">
                <record-info-thin :recordId="curRecord.id"/>
            </div>
        </div>
        <div class="no-items-msg" v-show="userLibrary.length === 0 && !showSpinner">
            No records found.
        </div>
    </div>  
</template>

<script>
import RecordInfoThin from './RecordInfoThin.vue';

export default {
    name: "record-list",
    components: {
        RecordInfoThin
    },
    data() {
        return {
            showSpinner: true
        }
    },
    computed: {
        userLibrary() {
            return this.$store.state.userLibrary;
        }
    },
    methods: {
        
    },
    created() {
        
    }

}
</script>

<style>

</style>