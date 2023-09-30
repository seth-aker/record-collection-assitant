<template>
  <div>
        <image-spinner v-show="showSpinner"/>
        <div v-show="userCollections.length != 0 && !showSpinner">
            <div id="collection-row" 
                v-for="curCollection in userCollections"
                :key="curCollection.id">
                <div id="collection-container">
                    <collection-card :collectionId="curCollection.id"/>
                </div>
            </div>
        </div>
        <div class="no-items-msg" v-show="userCollections.length === 0 && !showSpinner">
            No collections found.
        </div>
    </div> 
</template>

<script>
import CollectionCard from './CollectionCard.vue';

export default {
    name: 'collection-list',
    components: {
        CollectionCard
    },
    data() {
        return {
            showSpinner: true,
            
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