<template>
  <div class="record-card">
    <album-art :albumImageUrl="recordInfo.thumb" :albumName="recordInfo.title" class="album-art"/>
      <router-link class="record-title" :to="{name: 'record-page', params: {recordId : recordInfo.id}}">{{ recordTitle }}</router-link>
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
    background-color: #40c5a4;
    padding: 3px;
    border-radius: 10px;
    border: black solid 1px;
    font-family: Verdana, Geneva, Tahoma, sans-serif;
}

.album-art {
  width: 90%;
}
#add-record-btn {
    padding: 5px;
    background-color: #333;
    color: #fff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 12px;
}

#add-record-btn:hover {
  background-color: #555;
}

.record-text {
  display: flex;
  flex-direction: column;
  font-size: 16px;
}

.record-artist {
  font-size: 12px;
  font-style: italic;
}
</style>