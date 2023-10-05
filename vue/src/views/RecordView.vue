<template>
  <div class="record-page">
    <loading-icon v-show="isLoading" />
    <div class="record-content">
      <h2>{{ recordDTO.title }}
        <div class="add-or-remove-icon" v-if="!recordAdded">
          <font-awesome-icon  icon='fa-regular fa-plus-square' @click="addToCollection"/>
          <span>Add to Library</span>
        </div>
        <div class="add-or-remove-icon" v-show="recordAdded">
          <font-awesome-icon class="x-icon" icon="fa-regular fa-circle-xmark" @click="removeFromLib" />
          <span>Remove from Library</span>
        </div>  
        </h2>
      <album-art class="album" :albumImageUrl="recordDTO.images[0].uri" :albumName="recordDTO.title" :albumId="recordDTO.id"/>
      <section class="record-info" > 
       <table>
         <tr>
           <th>Artists</th>
           <td><span v-for="artist in recordDTO.artists" :key="artist.id">|  {{ artist.name }}  </span></td>
         </tr>
         <tr>
           <th>Genres</th>
           <td><span v-for="(genre, index) in recordDTO.genres" :key="index">|  {{ genre }}  </span></td>
         </tr>
         <tr>
           <th>Label</th>
            <td>|  {{ recordDTO.labels[0].name }} </td>
         </tr>
         <tr>
           <th>Styles</th>
           <td><span v-for="(style, index) in recordDTO.styles" :key="index">|  {{ style }}  </span></td>
         </tr>
         <tr>
           <th>Released</th>
           <td>|  {{ recordDTO.year }} </td>
         </tr>
       </table>
      </section>

      <section class="user-record-info">
         <div class="user-notes" v-show='recordDTO.userNotes !== "" && recordDTO.userNotes !== null' >
          <h3>Notes</h3>
          <div>{{ recordDTO.userNotes }}</div>
        </div>
        <div class="condition" v-show='recordDTO.condition !== "" && recordDTO.condition !== null'>
          <h3>Condition</h3>
          <div>{{ recordDTO.condition }}</div>
        </div>
        <div class="tags" v-show="recordDTO.tags.length > 0">
          <h3>Tags</h3>
          <div v-for="(tag, index) in recordDTO.tags" :key="index" class="tag">{{tag}}</div>
          </div>  
       </section>
      
      <div class="form">
         
          <button @click="toggleForm" v-show="!showForm && recordAdded">Add notes</button>
          <button @click="toggleForm" v-show="showForm">Cancel</button>
          <add-record-form v-if="showForm" :record="$store.state.currentRecord" @hideForm="showForm = false" />
      </div>
    </div>
  </div>
</template>

<script>
import recordService from "../services/RecordService.js"
import AlbumArt from "../components/AlbumArt.vue"
import LoadingIcon from '../components/LoadingIcon.vue'
import AddRecordForm from '../components/AddRecordForm.vue'

export default {
    components: {
      AlbumArt,
        LoadingIcon,
        AddRecordForm
 
    },
    
    data() {
      return {
        recordDTO : [],
        isLoading: true,
        recordAdded: false,
        showForm: false
      }
    },
    created() {
        this.isLoading = true;
        const recordId = this.$route.params.recordId;
        recordService.getRecordInfo(recordId)
        .then(response => {
          this.recordDTO = response.data;
          this.$store.commit('SET_CUR_RECORD', response.data);
          this.isLoading = false;
        })
        recordService.getUserLibrary().then(response => {
          response.data.forEach(record => {
            if(record.id === recordId) {
              this.recordAdded = true;
            }
          })
        });
    },
    methods: {
      addToCollection() {
        if(!this.recordAdded) {
          recordService.addRecordToUserLib(this.recordDTO).then(resp => {
              if(resp.status === 201) {
                this.recordAdded = true
                alert("Record Added")
              }
            }).catch( () => {
              alert("Oops! Something went wrong and the record was not added to your library")
            })
        }
      },
      toggleForm() {
        this.showForm = !this.showForm;
      },
      removeFromLib() {
        if(this.recordAdded) {
          recordService.deleteRecordFromUserLib(this.recordDTO.id).then(response => {
            if(response.status === 204) {
              alert("Record removed from user's libray")
              this.recordAdded = false;
              this.$store.commit("REMOVE_RECORD_FROM_LIBRARY", this.recordDTO.id)
              this.recordDTO.userNotes = "";
              this.recordDTO.condition = "",
              this.recordDTO.tags = [];
              this.showForm = false;
                       
            }
          }).catch(() => {
            alert("Oops! Something went wrong and the record was not removed from your library")
          })
        }
      }
    }
}
</script>

<style scoped>
.record-content {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-rows: 1fr 3fr 2fr;
  grid-template-areas: "title title"
                       "photo details"
                       "form userInfo";
  border: #40c5a4f6 2px solid;
  margin-bottom: 25px;
}


.album {
  width: 600px;
  grid-area: photo;
  margin: 25px;
}
.add-or-remove-icon {
  display: flex;
  align-items: center;

}
.add-or-remove-icon svg{
    padding: 0, 5px;
    margin: 0;
    color: #40c5a4f6;
    border: none;
    cursor: pointer;
    font-size: 30px;
    border-radius: 5px;
}
.add-or-remove-icon span {
  font-size: 16px;
}

.add-or-.add-or-remove-icon:hover {
  color: #33977e;
}

.x-icon {
   padding: 0, 5px;
    margin: 0;
    color: #40c5a4;
    
    border: none;
    cursor: pointer;
    font-size: 30px;
    border-radius: 30px;
}

.x-icon:hover {
  color: #33977e;
}

.record-added-icon {
  cursor: default;
}
.record-page {
  display: flex;
  justify-content: center;
  align-content: center;
}

.record-info {
  display: flex;
  justify-content: flex-start;
  align-content: center;
  font-size: 20px;
  color: #eff13f;
  font-family: "KEEPT___", Arial, sans-serif;
  grid-area: details;
  
}

.user-record-info {
  grid-area: userInfo;
}
h2 {
  display: flex;
  justify-content: center;
  font-size: 50px;
  color: #eff13f;
  font-family: "KEEPT___", Arial, sans-serif;
  grid-area: title;
  align-items: center;
}
h3 {
  display: flex;
  justify-content: center;
  color: #eff13f;
  font-family: "KEEPT___", Arial, sans-serif;
}
.form {
  grid-area: form;
}
</style>