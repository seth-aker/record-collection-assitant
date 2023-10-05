<template>
  <div class="search-bar">
    <input type="text" id="search-input" placeholder="Search by genre, artist, or song..." 
      v-model="searchInput" 
      @keyup="updateSearch" 
      @keypress.enter="goToSearchPage">

    <button id="search-button" @click.prevent="goToSearchPage">Search</button>
  </div>
</template>

<script>
// import recordService from '../services/RecordService'

export default {
  name: "search-bar",
  data() {
    return {
      searchInput: ''
    }
  },
  methods: {
    updateSearch() {
     this.$store.commit("UPDATE_SEARCH", this.searchInput);

    },
    goToSearchPage() {
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


<style scoped>
.search-box {
    display: flex;
    text-align: center;
    margin-top: 20px;
    padding-bottom: 10000px;
    padding-top: 100px;
    background-color: #E00A86;
      -webkit-text-stroke:0.5px #E00A86;
   

}

#search-input {
    padding: 10px;
    width: 30%;
    border: 1px solid #ccc;
    border-radius: 20px;
    font-size: 20px;
     background-color: #40c5a4;

      color: #eff13f;
   font-family: 'KEEPT___', Verdana, Geneva, Tahoma, sans-serif;
}

#search-button {
    padding: 10px 20px;
    background-color: #333;
    color: #eff13f;
    border: none;
    border-radius: 20px;
    cursor: pointer;
    font-size: 20px;
    background: linear-gradient(180deg, rgba(239,241,63,0.7455357142857143) 37%, rgba(224,10,134,0.7231267507002801) 100%);

  font-family: 'KEEPT___', Verdana, Geneva, Tahoma, sans-serif;
    -webkit-text-stroke:0.5px #E00A86;
}

#search-button:hover {
    background-color: #555;
}
.search-bar {
  display: flex;
  justify-content: center;
  margin-top: 60px;
  margin-bottom: 40px;
}

</style>