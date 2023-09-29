<template>
    <div>
        <image-spinner v-show="showSpinner"/>
        <div v-show="userLibrary.length != 0 && !showSpinner">
            <div id="record-row" 
                v-for="curRecord in userLibrary"
                :key="curRecord.id"
                :record="curRecord">
                <div id="record-container">
                    <album-art id="record-list-panel" :albumImageUrl="curRecord.thumb" 
                    :albumName="curRecord.title">
                </div>
            </div>
        </div>
        <div class="no-items-msg" v-show="userLibrary.length === 0 && !showSpinner">
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