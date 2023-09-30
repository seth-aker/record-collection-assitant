<template>
  <div class="search-page">
    <search-box />
    <collection-list />
    <record-list />
  </div>
  
</template>

<script>
import CollectionList from '../components/CollectionList.vue';
import RecordList from '../components/RecordList.vue';
import SearchBox from '../components/SearchBox.vue';
import searchService from '../services/SearchService.js';

export default {
  name: 'searchPage',
  components: { CollectionList, RecordList, SearchBox },
  created() {
    //   this.search();
  },
  methods: {
      search() {
        const searchString = `q=${this.$route.query.q}`
        searchService.searchRecords(searchString)
            // .then(response => {
            //     this.$store.commit("")

            // })
      }
  }



}
</script>

<style>

</style>