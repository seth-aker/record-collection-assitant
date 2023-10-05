<template>
  <div class="album-art">
    <!-- Display album art here -->
    <router-link v-if="isCollection" :to="{name: 'collection-view', params: {collectionId: albumId}}">
      <img :src="imageUrl" :alt="albumName" />
    </router-link>
    
    <router-link v-if="!isCollection" :to="{name: 'record-page', params: {recordId: albumId}}">
      <img :src="imageUrl" :alt="albumName" />
    </router-link>
  </div>
</template>

<script>
import errImage from '../assets/onErr.jpg'
export default {
 props: ['albumImageUrl', 'albumName', 'albumId', 'isCollection'],
 computed: {
   imageUrl() {
     return this.albumImageUrl != null ? this.albumImageUrl : errImage;
   }
 }
}
</script>

<style scoped>
.album-art {
  background-color: #fff;
  border-radius: 7px;
}
img {
  width: 100%;
  height: 100%;
  border-radius: 7px;
}

a {
  background-color: transparent;
}

</style>