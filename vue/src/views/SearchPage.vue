<template>
  <div class="search-page" @request-search="search">
    <loading-icon v-show="isLoading" />
    <search-box @requestSearch='search'/>
    <search-filters />
    <collection-list />
    <div class="record-list" >
      <record-list :records="$store.state.sr.searchResultsRecords" />

    </div>
  </div>
  
</template>

<script>
import CollectionList from '../components/CollectionList.vue';
import LoadingIcon from '../components/LoadingIcon.vue';
import RecordList from '../components/RecordList.vue';
import SearchBox from '../components/SearchBox.vue';
import SearchFilters from '../components/SearchFilters.vue'
import searchService from '../services/SearchService.js';

export default {
  name: 'searchPage',
  components: { CollectionList, RecordList, SearchBox, LoadingIcon , SearchFilters},
  data() {
    return {
      isLoading: true
    }
  },
  created() {
      this.search();
  },
  methods: {
      search() {
        this.isLoading = true;
        searchService.searchRecords(this.$store.getters.searchQuery)
            .then(response => {
              this.$store.commit("SET_SEARCH_RESULTS_RECORDS", response.data.results)
              this.isLoading = false;
            })
      },
  }



}
</script>

<style>

</style>