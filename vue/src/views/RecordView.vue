<template>
  <div class="record-page">
    <loading-icon v-show="isLoading" />
    <div >
      <h2>{{ recordDTO.title }}</h2>
      <album-art class="album" :albumImageUrl="recordDTO.images[0].uri" :albumName="recordDTO.title" :albumId="recordDTO.id"/>
      <div class="record-info" > 
        <ul>
          <li v-for="artist in recordDTO.artists" :key="artist.id">Artist: {{ artist.name }}</li>

  <!-- TODO: need to make it so the last element of genre list doesn't get a comma; -->
          <li>Genres: <span v-for="(genre, index) in recordDTO.genres" :key="index">{{ genre }}, </span></li>

          <li>Label: {{ recordDTO.labels[0].name }}</li>

  <!-- TODO: need to make it so the last element of genre list doesn't get a comma; -->
          <li>Stlyes: <span v-for="(style, index) in recordDTO.styles" :key="index">{{ style }}, </span></li>

          <li>Year: {{ recordDTO.year }}</li>

          <li>Notes: {{ recordDTO.userNotes }} </li>

          <li>Condition: {{ recordDTO.condition}} </li>

          <li>Tags: <span v-for="(tag, index) in recordDTO.tags" :key="index">{{tag}}</span></li>
        </ul>
      </div>
      <button id="add-record-btn" @click="addToCollection" >
        <font-awesome-icon class="record-added-icon" icon='fa-regular fa-circle-check' v-if="recordAdded" />
      </button>
      <!-- <button id="remove-record-btn" @click="removeRecord">
        <font-awesome-icon class="x-icon" icon="fa-regular fa-circle-x-mark" v-show="recordAdded" />
      </button> -->
      <add-record-form v-if="showForm" :record="$store.state.currentRecord"  />
      <button @click="toggleForm" v-show="!showForm && recordAdded">Add notes</button>
      <button @click="toggleForm" v-show="showForm">Cancel</button>
      
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
              }
            }).catch( () => {
              alert("Oops! Something went wrong and the record was not added to your library")
            })
        }
      },
      toggleForm() {
        this.showForm = !this.showForm;
      }
    }
}
</script>

<style scoped>
.album {
  width: 600px;
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
</style>