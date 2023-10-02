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

}

#search-input {
    padding: 10px;
    width: 30%;
    border: 1px solid #ccc;
    border-radius: 5px;
    font-size: 16px;
}

#search-button {
    padding: 10px 20px;
    background-color: #333;
    color: #fff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 16px;
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