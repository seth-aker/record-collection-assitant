<template>
  <div>
        <image-spinner v-show="showSpinner"/>
        <div v-show="userCollections.length != 0 && !showSpinner">
            <div id="collection-row" 
                v-for="curCollection in userCollections"
                :key="curCollection.id"
                :collectionId="curCollection.id">
                <div id="collection-container">
                    
                </div>
            </div>
        </div>
        <div class="no-items-msg" v-show="userCollections.length === 0 && !showSpinner">
            No collections found.
        </div>
    </div> 
</template>

<script>

export default {
    name: 'collection-list',
    components: {
    },
    data() {
        return {
            showSpinner: true
        }
    },
    computed: {
        userCollections() {
            return this.$store.state.userCollections;
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