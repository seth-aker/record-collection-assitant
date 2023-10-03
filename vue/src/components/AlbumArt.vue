<template>
  <div class="album-art">
    <!-- Display album art here -->
   <router-link :to="{name: 'record-page', params: {recordId: albumId}}"><img :src="albumImageUrl" :alt="albumName" /></router-link>
  </div>
</template>

<script>
export default {
  props: ['albumImageUrl', 'albumName', 'albumId']
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