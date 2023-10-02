<template>
  <div class="album-art">
    <!-- Display album art here -->
    <img :src="albumImageUrl" :alt="albumName" />
  </div>
</template>

<script>
export default {
  props: ['albumImageUrl', 'albumName']
}
</script>

<style scoped>
.album-art {
  background-color: #fff;
}
img {
  width: 100%;
  height: 100%;
}

</style>