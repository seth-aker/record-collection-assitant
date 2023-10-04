<template>
  <div class="search-page" >
    <loading-icon v-show="isLoading" />
    <search-box @requestSearch='search'/>
    <search-filters @requestSearch='search' />
    <!-- <collection-list /> -->
    <div class="record-list" >
     <record-card class="record-card" v-for="record in $store.state.sr.searchResultsRecords" :key="record.id" :recordInfo="record" :isHome="false" />
    </div>

    <item-pager :curPage="$store.state.sr.curPage" :maxPages="$store.state.sr.maxPages" @requestSearch='search'></item-pager>
  </div>
  
</template>

<script>

import LoadingIcon from '../components/LoadingIcon.vue';
import RecordCard from '../components/RecordCard.vue';
import SearchBox from '../components/SearchBox.vue';
import SearchFilters from '../components/SearchFilters.vue'
import searchService from '../services/SearchService.js';
import ItemPager from '../components/ItemPager.vue'

export default {
  name: 'searchPage',
  components: {  RecordCard, SearchBox, LoadingIcon , SearchFilters, ItemPager},
  data() {
    return {
      isLoading: true
    }
  },
  created() {
      this.$store.commit('SET_CUR_PAGE', 1);
      this.search();
  },
  methods: {
      search() {
        this.isLoading = true;
        searchService.searchRecords(this.$store.getters.searchQuery)
            .then(response => {
              this.$store.commit("SET_SEARCH_RESULTS_RECORDS", response.data.results)
              this.$store.commit("SET_MAX_PAGES", response.data.pagination.pages)
              this.isLoading = false;
            })
      },
  }



}
</script>

<style scoped>
.record-list {
  display: flex;
  flex-wrap: wrap;
}
  .record-card {
    margin: 10px;
    width: 20%;
    min-width: 80px;
}

</style>