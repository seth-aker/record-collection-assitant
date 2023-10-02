<template>
  <div>
        
        <div v-show="userCollections.length != 0 && !isLoading">
            <div id="collection-row" 
                v-for="curCollection in collections"
                :key="curCollection.id">
                <div id="collection-container">
                    <collection-card :collectionId="curCollection.id"/>
                </div>
            </div>
        </div>
        <div class="no-items-msg" v-show="userCollections.length === 0 && !isLoading">
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
    props: ['collections'],
    data() {
        return {
            isLoading: false,
            
            
        }
    },
    computed: {

    },
    methods: {
        
    },
    created() {
        
    }

}

</script>

<style>

</style>