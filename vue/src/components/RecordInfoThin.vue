<template>
  <span class="recordInfo">
    <album-art :albumImageUrl="recordInfo.thumb" :albumName="recordInfo.title" />
    <div>{{ recordInfo.title }}</div>
  </span>
</template>

<script>
import AlbumArt from './AlbumArt.vue'
export default {
  name: "recordInfo",
  props: ['recordInfo'], 
  components: { AlbumArt },
 


}
</script>

<style scoped>
span {
    display: flex;
    align-items: center;
}

album-art {
  height: 10vh;
}
</style>