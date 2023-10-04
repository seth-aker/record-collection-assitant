<template>
  <div class="collection-card">
      <div class="grid-control">
    <album-art :albumImageUrl="recordDTO.thumb" :albumName="recordDTO.title" :albumId="recordDTO.id"/>
        <div class="collection-info">
            <div class="collection-name">
                <div class="collection-name">{{ collection.name }}</div>
            </div>
            <div class="user-name">
                <div>By: {{ collection.userName }}</div>
            </div>
        </div>
        <div class="button">
        <button id="delete-coll-btn" @click="deleteCollection" >
            <font-awesome-icon class="delete-coll-icon" icon="fa-regular fa-square-minus" />
        </button>
        </div>
    </div>
  </div>
</template>

<script>
import CollectionService from '../services/CollectionService'
import RecordService from '../services/RecordService'
import AlbumArt from './AlbumArt.vue'
// import LoadingIcon from '../components/LoadingIcon.vue';

export default {
    name: 'collection-card',
    props:['collectionId'],
    components: {
        AlbumArt,
        // LoadingIcon
    },
    data() {
        return {
            isLoading: false,
            collection:{},
            recordIds:[],
            recordDTO: "",
            recordId:"",
        }
    },
    computed: {

    },
    methods: {
        deleteCollection() {
            return;
        }
    },
    created() {
        this.isLoading = true;
        CollectionService.getCollection(this.collectionId)
            .then(response => {
                this.collection = response.data;
                this.recordIds = this.collection.recordIds;
                this.recordId = this.recordIds[0];
        RecordService.getRecordInfo(this.recordId)
            .then(response => {
                this.recordDTO = response.data;
                this.recordDTO.thumb = response.data.images[0].uri
            });
            });
        this.isLoading = false;
        }
}
</script>

<style scoped>
.collection-card {
    display: flex;
    flex-direction: column;
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
  grid-area: image;
}

#delete-coll-btn {
    display: flex;
    padding: 0, 2px;
    margin: 0;
    color: #eff13f;
    background-color: #40c5a4;
    border: none;
    cursor: pointer;
    font-size: 1.2em;
    grid-area: button;
}

.delete-coll-icon:hover {
  color: #d0d319;
}

.grid-control {
    display: grid;
    grid-template-columns: 5fr 1fr;
    grid-template-rows: 8fr 1fr;
    grid-template-areas: 
    "image image"
    "info button";
}

div.collection-info {
    font-size: 12px;
    font-style: italic;
    grid-area: info;
}

.button {
    display: flex;
    justify-content: center;
    align-items: center;
}


</style>