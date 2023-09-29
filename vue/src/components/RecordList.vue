<template>
    <div>
        <image-spinner v-show="showSpinner"/>
        <div v-show="curPageRecords.length != 0 && !showSpinner">
            <div id="record-row" 
                v-for="curRecord in curPageRecords"
                :key="curRecord.id"
                :record="curRecord">
                <div id="record-container">
                    <album-art id="record-list-panel" :albumImageUrl="curRecord.thumb" 
                    :albumName="curRecord.title">
                </div>
            </div>
        </div>
        <div class="no-items-msg" v-show="curPageRecords.length === 0 && !showSpinner">
            No records found.
        </div>
    </div>  
</template>

<script>
import AlbumArt from './AlbumArt.vue';

export default {
    name: "record-list",
    components: {

        AlbumArt
    },
    data() {
        return {
            showSpinner: false
        }
    },
    computed: {
        filteredRecords() {
            return null;
        },
        newReleaseFilter() {
            return null;
        },
        curPageRecords() {
            return this.$store.state.curPageRecords;
        }
    },
    methods: {
        
    },
    created() {
        this.$store.commit("SET_CUR_PAGE",1);
    }

}
</script>

<style>

</style>