<template>
  <div class="record-page">
    <loading-icon v-show="isLoading" />
    <div class="record-content">
      <h2>{{ recordDTO.title }}
        <div class="add-or-remove-icon" v-if="!recordAdded" @click="addToCollection">
          <font-awesome-icon  icon='fa-regular fa-plus-square'/>
          <span>Add to Library</span>
        </div>
        <div class="add-or-remove-icon" v-show="recordAdded" @click="removeFromLib">
          <font-awesome-icon class="x-icon" icon="fa-regular fa-circle-xmark" />
          <span>Remove from Library</span>
        </div>  
        </h2>
      <div class="album">
          <album-art  :albumImageUrl="recordDTO.images[0].uri" :albumName="recordDTO.title" :albumId="recordDTO.id"/>
      </div>
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
         <tr>
           <th>Facts</th>
           <td>| {{ notes }}</td>
         </tr>
       </table>
      </section>

      <section class="user-record-info">
         <div class="user-notes" v-show='recordDTO.userNotes !== "" && recordDTO.userNotes !== null' >
          <h3>Notes</h3>
          <div class="user-text">- {{ recordDTO.userNotes }}</div>
        </div>
        <div class="condition" v-show='recordDTO.condition !== "" && recordDTO.condition !== null'>
          <h3>Condition</h3>
          <div class="user-text">- {{ recordDTO.condition }}</div>
        </div>
        <div class="tags" v-show="recordDTO.tags.length > 0">
          <h3>Tags</h3>
          <div class="tags-list">
            <span v-for="(tag, index) in recordDTO.tags" :key="index" class="tag">{{tag}} <font-awesome-icon icon="fa-regular fa-circle-xmark" @click="removeTag(index)"/></span>
          </div>
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
          const records = response.data;
          records.forEach(record => {
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
      },
      removeTag(tagIndex) {
        const tagName = this.recordDTO.tags[tagIndex];
        recordService.deleteTag(this.$route.params.recordId, tagName).then(resp => {
          if(resp.status === 204) {
            this.recordDTO.tags.splice(tagIndex, 1);
          }
        })
      }
    },
    computed: {
      notes() {
        const notesLength = this.recordDTO.notes.length;
        if(notesLength < 251){
          return this.recordDTO.notes;
        } else {
          return this.recordDTO.notes.substring(0, 251);
        }
      }
    }
}
</script>

<style scoped>
.record-content {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-rows: 1fr 6fr 3fr;
  grid-template-areas: "title title"
                       "photo details"
                       "form userInfo";
  border: #40c5a4f6 2px solid;
  margin-bottom: 25px;
  background-color:#dfdfdfbe;
  width: 95%;
}



.album {
   grid-area: photo;
  border-bottom: #40c5a4 3px solid;
  padding: 25px;
}
.add-or-remove-icon {
  display: flex;
  align-items: center;
  border: #40c5a4 2px solid;
  padding: 5px;
  border-radius: 5px;
  cursor: pointer;
}
.add-or-remove-icon svg{
    padding: 0, 5px;
    margin: 0;
    margin-right: 5px;
    color:#eff13f;
    border: none;
    cursor: pointer;
    font-size: 30px;
    border-radius: 5px;
}
.add-or-remove-icon span {
  font-size: 16px;

}

.add-or-remove-icon:hover {
  background-color: #40c5a4;
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
  text-align: left;
  border-bottom: #40c5a4 3px solid;
  
}

.record-info tr {
  height: 65px;
}

.user-record-info {
  grid-area: userInfo;
}
h2 {
  display: flex;
  justify-content: space-around;
  align-items: center;
  font-size: 50px;
  color: #eff13f;
  font-family: "KEEPT___", Arial, sans-serif;
  grid-area: title;
  border-bottom: #40c5a4 3px solid;
  margin: 0;
}
h3 {
  display: flex;
  justify-content: flex-start;
  color: #eff13f;
  font-family: "KEEPT___", Arial, sans-serif;
  border-bottom: #40c5a4 2px solid;
  padding: 10px;
  margin: 10px;

}
.form {
  grid-area: form;
  padding: 15px;
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 90%;
  border: #40c5a4 2px solid;
  margin: 10px;
}
.form button {
  width: 20%;
  margin: 5px;
  background-color: transparent ;
  border: #40c5a4 1px solid;
  border-radius: 5px;
  cursor: pointer;
  padding: 5px;
  font-family: "KEEPT___", Arial, sans-serif;
  color:#eff13f ;
}

.form button:hover {
  background-color:#40c5a4;
}

.user-text {
  color: #eff13f;
   padding: 10px;
  margin: 10px;
  font-family:"KEEPT___", Arial, sans-serif;
}

.tags {
  display: flex;
  flex-direction: column;
}
.tags-list {
  display: flex;
  margin-left: 15px;
}
.tag {
    font-size: 20px;
    display: flex;
    align-items: center;
    color: #40c5a4f6;
    background-color: #eff13f;
    border-radius: 15px;
    padding: 2px 10px 2px 10px;
    margin: 2px 5px 2px 5px;
    width: fit-content;
}

.tag svg {
  padding-left: 5px ;
  font-size: 14px ;
}



</style>