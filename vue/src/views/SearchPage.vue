<template>
  <div class="search-page">
    <record-search />
    <collection-list />
    <record-list />
  </div>
  
</template>

<script>
import CollectionList from '../components/CollectionList.vue';
import RecordList from '../components/RecordList.vue';
import RecordSearch from '../components/RecordSearch.vue';
import searchService from '../services/SearchService.js';

export default {
  name: 'searchPage',
  components: { CollectionList, RecordList, RecordSearch },
  created() {
      this.search();
  },
  methods: {
      search() {
        searchService.searchRecords(this.$store.state.search)
            // .then(response => {
            //     this.$store.commit("")

            // })
      }
  }



}
</script>

<style>

</style>