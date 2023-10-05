<template>
  <div class="record-card">
    <album-art :albumImageUrl="recordInfo.thumb" :albumName="recordInfo.title" :albumId="recordInfo.id" class="album-art"/>
    <div class="record-info">
      <div class="record-text">
        <router-link class="record-title" :to="{name: 'record-page', params: {recordId : recordInfo.id}}">{{ recordTitle }}</router-link>
        <div class="record-artist">{{ recordArtist }}</div>
      </div>
      <div class="buttons">
        <button class="tooltipadd" id="add-record-btn" @click="addToCollection" v-show="isHome">
          <font-awesome-icon class="add-record-icon" icon='fa-regular fa-plus-square' v-show="!recordAdded" />
          <span class="tooltiptextadd">Add this record to a collection</span>
          <font-awesome-icon class="record-added-icon" icon='fa-regular fa-circle-check' v-show="recordAdded" />
        </button>
        <button class="tooltipadd" id="add-record-btn" @click="addToLibrary" v-show="!isHome">
          <font-awesome-icon class="add-record-icon" icon='fa-regular fa-plus-square' v-show="!recordAdded" />
          <span class="tooltiptextadd">Add this record to you library</span>
          <font-awesome-icon class="record-added-icon" icon='fa-regular fa-circle-check' v-show="recordAdded" />
        </button>
        <div class="button" v-show="isHome">
          <button class="tooltipdelete" id="delete-record-btn" @click="deleteRecord">
            <font-awesome-icon class="delete-record-icon" icon="fa-regular fa-square-minus" />
            <span class="tooltiptextdelete">Remove this record</span>
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import AlbumArt from './AlbumArt.vue'
import recordService from '../services/RecordService.js'

export default {
  name: "recordInfo",
  props: ['recordInfo','isHome'], 
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
        
    },
    deleteRecord() {
      return ;
    },
    addToLibrary() {
      return ;
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
    background-color: transparent;
    border: none;
    cursor: pointer;
    font-size: 1.2rem;
}

.add-record-icon:hover {
  color: #d0d319;
}

.delete-record-icon:hover {
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
   -webkit-text-stroke:0.5px #E00A86;
   
  
   
  
}

.record-text {
  display: flex;
  flex-direction: column;
  font-size: 1.9rem;
  font-family: 'KEEPT___', Verdana, Geneva, Tahoma, sans-serif;
  color: #eff13f;

}

.record-artist {
  font-size: 1.7rem;
  font-style: italic;
  
}

#delete-record-btn {
    display: flex;
    padding: 0, 2px;
    margin: 0;
    color: #eff13f;
    background-color: transparent;
    border: none;
    cursor: pointer;
    font-size: 1.2em;
    grid-area: button;
}

.buttons {
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
}

.tooltipadd {
  position: relative;
  display: inline-block;
  border: 1px solid #eff13f;
  
}

.tooltipdelete {
  position: relative;
  display: inline-block;
  border: 1px solid #eff13f;
  
}

.tooltipadd .tooltiptextadd {
  visibility: hidden;
  width: 120px;
  background-color: transparent;
  color: #eff13f;
  text-align: center;
  padding: 5px 0;
  border-radius: 6px;
  font-family: "KEEPT___", Arial, sans-serif;
  position: absolute;
  z-index: 1;
  width: 120px;
  bottom: 150%;
  left: 50%;
  margin-left: -105px;
  margin-bottom: 20px;
  
}

.tooltipdelete .tooltiptextdelete {
  visibility: hidden;
  width: 120px;
  background-color: transparent;
  color: #eff13f;
  text-align: center;
  padding: 5px 0;
  border-radius: 6px;
  font-family: "KEEPT___", Arial, sans-serif;
  position: absolute;
  z-index: 1;
  width: 120px;
  bottom: 150%;
  left: 50%;
  margin-left: -105px;
  margin-bottom: 50px;
  
}

.tooltipadd:hover .tooltiptextadd {
  visibility: visible;
  
}

.tooltipdelete:hover .tooltiptextdelete {
  visibility: visible;
  
}
</style>