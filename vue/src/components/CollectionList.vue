<template>
    <div class="list-container">
        <collection-card v-for="curCollection in collections"
        :key="curCollection.id"
        :collectionId="curCollection.id"/>
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
div.collection-card {
    width: 49%;
}

.list-container {
    display: flex;
    flex-wrap: wrap;
    max-width: 100%;
    min-width: 90%;
    max-height: 600px;
}



</style>