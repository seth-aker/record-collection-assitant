<template>
  <div class="search-page">
    <search-box />
    <collection-list />
    <record-list />
  </div>
  
</template>

<script>
import CollectionList from '../components/CollectionList.vue'
import RecordList from '../components/RecordList.vue'
import SearchBox from '../components/SearchBox.vue'


export default {
  components: { CollectionList, RecordList, SearchBox },

}
</script>

<style>

</style>