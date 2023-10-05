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
        this.$router.push({name: 'search-page',
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
.search-filters {
  display: flex;
  justify-content: center;
  color: #eff13f;
  
}

.num-page {
  color: #E00A86;
  font-size: 16px; 
  padding: 10px; 
  font-family: 'KEEPT___', Verdana, Geneva, Tahoma, sans-serif;
  background-color: #40c5a4;
   border-radius: 20px;
   opacity: 90%;
}
</style>