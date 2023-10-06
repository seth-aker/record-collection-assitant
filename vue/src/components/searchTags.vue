<template>
  <div>
    <input v-model="searchQuery" type="text" placeholder="Search...">
    <button @click="search">Search</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      searchQuery: ''
    };
  },
  methods: {
    search() {
      // Handle the search logic here
      console.log('Search query:', this.searchQuery);
    }
  }
};
</script>