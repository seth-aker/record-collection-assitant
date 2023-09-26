<template>
  <button class="genre-button" :data-genre="genreData">{{ genreName }}</button>
</template>

<script>
export default {
  name: 'GenreButton',
  props: {
    genreName: String, // Pass the genre name as a prop
    genreData: String // Pass additional genre data as a prop
  }
}
</script>

<style scoped>

</style>