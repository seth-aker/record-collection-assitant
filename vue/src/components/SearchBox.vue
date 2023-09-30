<template>
  <form class="search-box" @submit.prevent="search(searchInput)">
    <input type="text" id="search-input" placeholder="Search by genre, artist, or song..." :v-model="searchInput">
    <button id="search-button">Search</button>
    <div class="upload-counter">
    </div>
  </form>
</template>

<script>
import recordService from '../services/RecordService'

export default {
  data() {
    return {
      searchInput: '',
    }
  },
  methods: {
    search(searchText) {
     this.$store.commit("UPDATE_SEARCH", searchText)
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