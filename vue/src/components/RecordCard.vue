<template>
  <div class="record-card">
    <album-art :albumImageUrl="recordInfo.thumb" :albumName="recordInfo.title" :albumId="recordInfo.id" class="album-art"/>
    <div class="record-info">
      <div class="record-text">
        <router-link class="record-title" :to="{name: 'record-page', params: {recordId : recordInfo.id}}">{{ recordTitle }}</router-link>
        <div class="record-artist">{{ recordArtist }}</div>
      </div>
      <button id="add-record-btn" @click="addToCollection" >
        <font-awesome-icon class="add-record-icon" icon='fa-regular fa-plus-square' v-show="!recordAdded" />
        <font-awesome-icon class="record-added-icon" icon='fa-regular fa-circle-check' v-show="recordAdded" />
        </button>
    </div>
  </div>
</template>

<script>

import AlbumArt from './AlbumArt.vue'
import recordService from '../services/RecordService.js'

export default {
  name: "recordInfo",
  props: ['recordInfo'], 
  components: { AlbumArt },
  data() {
    return {
      recordAdded: false
    }
  },
  methods: {
    addToCollection() {
        recordService.getRecordInfo(this.recordInfo.id).then(response => {
          recordService.addRecordToUserLib(response.data).then(resp => {
            if(resp.status === 201) {
              this.recordAdded = true
            }
          }).catch( () => {
            alert("Oops! Something went wrong and the record was not added to your library")
          })
        })
        
    }
  },
  computed: {

    recordTitle() {
      const artistTitle = this.recordInfo.title.split(' - ');
      if (artistTitle[1] === undefined) {
        return this.recordInfo.title;
      } else {
      return artistTitle[1];
      }
    },
    recordArtist() {
       const artistTitle = this.recordInfo.title.split(' - ');
       if (artistTitle[1] === undefined) {
         return this.recordInfo.artist;
       } else {
      return artistTitle[0];
       }
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
    border: solid #40c5a4 1px;
    font-family: Verdana, Geneva, Tahoma, sans-serif;
}

.album-art {
  width: 99%;
  margin: 2px;
}
#add-record-btn {
    padding: 0, 5px;
    margin: 0;
    color: #eff13f;
    background-color: #40c5a4;
    border: none;
    cursor: pointer;
    font-size: 30px;
}

.add-record-icon:hover {
  color: #d0d319;
}

.record-added-icon {
  cursor: default;
}

.record-info {
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 100%;
  height: 100%;
  
}

.record-text {
  display: flex;
  flex-direction: column;
  font-size: .9rem;
  
}

.record-artist {
  font-size: .8rem;
  font-style: italic;
}
</style>