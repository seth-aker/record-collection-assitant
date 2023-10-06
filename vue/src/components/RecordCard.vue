<template>
  <div class="record-card">
    <album-art :albumImageUrl="recordInfo.thumb" 
    :albumName="recordInfo.title" 
    :albumId="recordInfo.id" class="album-art"/>
    <div class="record-info">
      <div class="record-text">
        <router-link class="record-title" 
        :to="{name: 'record-page', params: {recordId : recordInfo.id}}">
        {{ recordTitle }}
        </router-link>
        <div class="record-artist">{{ recordArtist }}</div>
      </div>
      <div class="buttons">
        <collection-dropdown :isHome="isHome" 
        :recordAdded="recordAdded" :isCollection="isCollection"
        @toggle-isNotVis="receiveEmit"
        @away-toggle="awayToggle">
          <collection-dropdown-content >
            <collection-dropdown-item v-for="collection in this.$store.state.userCollections" 
            :key="collection.id" :recordInfo="recordInfo" :collection="collection"
            >{{collection.name}}</collection-dropdown-item>
          </collection-dropdown-content>
        </collection-dropdown>
      </div>
        <div class="button">
          <button class="tooltipadd" id="add-record-btn" 
            @click="addToLibrary" v-show="!isHome && !isCollection">
            <font-awesome-icon class="add-record-icon" icon='fa-regular fa-plus-square' 
            v-show="!recordAdded" />
            <span class="tooltiptextadd">Add this record to you library</span>
            <font-awesome-icon class="record-added-icon" icon='fa-regular fa-circle-check' 
            v-show="recordAdded" />
          </button>
        <div class="button" v-show="(isHome && !isCollection && !isSearch) && !isNotVis">
          <button class="tooltipdelete" id="delete-record-btn" @click="deleteRecord">
            <font-awesome-icon class="delete-record-icon" icon="fa-regular fa-square-minus" />
            <span class="tooltiptextdelete">Remove this record from library</span>
          </button>
        </div>
        <div class="button" v-show="(!isHome && isCollection && !isSearch) && !isNotVis">
          <button class="tooltipdelete" id="delete-record-btn" @click="removeRecordFromCollection">
            <font-awesome-icon class="delete-record-icon" icon="fa-regular fa-square-minus" />
            <span class="tooltiptextdelete">Remove record from collection</span>
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import AlbumArt from './AlbumArt.vue'
import recordService from '../services/RecordService.js'
import CollectionDropdown from './CollectionDropdown.vue'
import CollectionDropdownContent from './CollectionDropdownContent.vue'
import CollectionDropdownItem from './CollectionDropdownItem.vue'
import CollectionService from '../services/CollectionService'

export default {
  name: "recordInfo",
  props: ['recordInfo','isHome','isCollection','collectionId','isSearch','collectionDTO'], 
  components: { AlbumArt, CollectionDropdown, CollectionDropdownContent, CollectionDropdownItem },
  data() {
    return {
      recordAdded: false,
      isNotVis: false
    }
  },
  methods: {
    awayToggle() {
      this.isNotVis = false;
    },
    receiveEmit(isNotVis) {
      this.isNotVis = isNotVis;
    },
    addToCollection() {
        recordService.getRecordInfo(this.recordInfo.id).then(response => {
          CollectionService.addRecordToUserCollection(this.collection.id, response.data).then(resp => {
            if(resp.status === 201) {
              alert("Record added to colleciton successfully.");
              this.recordAdded = true;
              const user = this.$store.state.username;
              this.$router.push(`/${user}`);
            }
          }).catch( () => {
            alert("Oops! Something went wrong and the record was not added to your collection")
          })
        })
        
    },
    deleteRecord() {
      if(confirm("Are you sure you want to delete this record from your library? \n\n(All custom information associated with this record will be lost)")) {
      recordService.deleteRecordFromUserLib(this.recordInfo.id)
        .then(rep => {
          if(rep.status === 200 || rep.status === 204){
              this.$store.commit("REMOVE_RECORD_FROM_LIBRARY", this.recordInfo.id);
              const user = this.$store.state.username;
              this.$router.push(`/${user}`);
            }
        }).catch( () => {
            alert("Oops! Something went wrong and the record was not removed from your library")
          })
      }
    },
    addToLibrary() {
      recordService.getRecordInfo(this.recordInfo.id)
        .then(response => {
          recordService.addRecordToUserLib(response.data)
            .then(resp => {
              if(resp.status === 201) {
              this.recordAdded = true
              this.$store.commit('ADD_RECORD_TO_LIBRARY',response.data)
              const user = this.$store.state.username;
              this.$router.push(`/${user}`);
            }
          }).catch( () => {
            alert("Oops! Something went wrong and the record was not added to your library")
          })
        })
    },
    removeRecordFromCollection() {
      CollectionService.removeRecordFromCollection(this.collectionId, this.recordInfo.id)
        .then(resp => {
          if(resp.status === 200 || resp.status === 204){
            this.$store.commit('REMOVE_RECORD_FROM_COLLECTION', resp.data);

          }
        }).catch( () => {
            alert("Oops! Something went wrong and the record was not removed from this colleciton")
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
    padding:5px;
    border-radius: 10px;
    border: solid #40c5a4 5px;
    font-family: Verdana, Geneva, Tahoma, sans-serif;
    background: linear-gradient(180deg, rgba(239,241,63,0.7203256302521008) 37%, rgba(64,197,164,1) 100%);

    
}

.album-art {
  width: 95%;

  
}
#add-record-btn {
    padding: 0, 5px;
    margin: 0;
    color: #eff13f;
    background-color: transparent;
    border: none;
    cursor: pointer;
    font-size: 1.7rem;
    
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
  
  justify-content: space-around;
  width: 100%;
  height: 100%;
   -webkit-text-stroke:0.5px #E00A86;
   
  
   
  
}

.record-text {
  display: flex;
  flex-direction: column;
  font-size: 0.8rem;
  font-family: 'KEEPT___', Verdana, Geneva, Tahoma, sans-serif;
  color: #eff13f;
  
}

.record-text a {
  text-decoration: none;
  font-size: 1.5rem;
  color: #eff13f;
}



.record-artist {
  font-size: 1.1rem;
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
    font-size: 1.7em;
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

.collection-name {
  font-family: "KEEPT___", Arial, sans-serif;
  color: #40c5a4;
  -webkit-text-stroke:1px #eff13f ;
  font-size: 1.1rem;
  margin-top: 3px;
}
</style>