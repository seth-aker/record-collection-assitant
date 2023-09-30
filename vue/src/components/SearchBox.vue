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

     this.$emit('updateSearchResults');
    },
    goToSearchPage() {
      this.$router.push({name: 'search-page', query: { q: this.searchInput}})
    }
  }
  
}
</script>


<style scoped>
.search-box {
    text-align: center;
    margin-top: 20px;
    padding-bottom: 100px;
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


</style>