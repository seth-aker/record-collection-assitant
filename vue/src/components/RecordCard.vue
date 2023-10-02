<template>
  <div class="record-card">
    <album-art :albumImageUrl="recordInfo.thumb" :albumName="recordInfo.title" />
      <div class="record-title">{{ recordTitle }}</div>
      <div class="record-artist">{{ recordArtist }}</div>
    <button id="add-record-btn" @click="addToCollection" >Add Record To Collection</button>
  </div>
</template>

<script>
import AlbumArt from './AlbumArt.vue'
export default {
  name: "recordInfo",
  props: ['recordInfo'], 
  components: { AlbumArt },
  methods: {
    addToCollection() {

    }
  },
  computed: {
    recordTitle() {
      const artistTitle = this.recordInfo.title.split(' - ');
      return artistTitle[1];
    },
    recordArtist() {
       const artistTitle = this.recordInfo.title.split(' - ');
      return artistTitle[0];
    }
  }


}
</script>

<style scoped>
.record-card {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin: 10px;
    height: 75px;
    background-color: grey;
    padding: 3px;
    font-family: Verdana, Geneva, Tahoma, sans-serif;
}

#add-record-btn {
    padding: 5px;
    background-color: #333;
    color: #fff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 16px;
}

#add-record-btn:hover {
  background-color: #555;
}

.record-text {
  display: flex;
  flex-direction: column;
}

.record-artist {
  font-style: italic;
}
</style>