<template>
  <div class="album-art">
    <!-- Display album art here -->
    <img :src="albumImageUrl" alt="Album Art" />
  </div>
</template>

<script>
export default {
  props: {
    albumImageUrl: String, // Pass the URL of the album art as a prop
  },
};
</script>

<style scoped>
.album-art {
  width: 200px;
  height: 200px;
  margin: 10px;
  background-color: #fff;
}

img {
  width: 100%;
  height: auto;
}
</style>