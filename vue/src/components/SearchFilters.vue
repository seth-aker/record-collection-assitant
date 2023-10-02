<template>
  <div class="search-filters">
     <select class="num-page" v-model="perPage" @change="updatePerPage"> 
       <option value="25">25</option> 
       <option value="50">50</option> 
       <option value="100">100</option> 
       <option value="150">150</option> 
      </select> 
  </div>
</template>

<script>
export default {
    name: "search-filters",
    data() {
      return {
        perPage: 25
      }
    },
    methods: {
      updatePerPage() {
        this.$store.commit('UPDATE_PER_PAGE', this.perPage);
        this.$emit('requestSearch');
        this.$router.push({ 
                          query: {q: this.$store.state.sr.search, 
                                  type: this.$store.state.sr.searchType, 
                                  per_page: this.$store.state.sr.resultsPerPage} 
                          }).catch(error => {
                            if (error.name !== 'NavigationDuplicated' &&
                                !error.message.includes('Avoided redundant navigation to current location')
                                ) {
                                  console.log(error)
                                }
                            });
      }
    }
}
</script>

<style>

</style>