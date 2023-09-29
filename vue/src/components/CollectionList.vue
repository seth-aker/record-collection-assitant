<template>
  <collection-view
  v-for="curCollection in filteredCollections"
  />
</template>

<script>
import CollectionView from "./CollectionView";

export default {
    name: 'collection-list',
    components: {
        CollectionView
    },
    data() {
        return {

        }

    },
    computed: {
        filteredCollections() {
            return null;
        }
    }
}

</script>

<style>

</style>