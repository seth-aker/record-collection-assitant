<template>
  <div class="collection-card">
      <div class="grid-control">
    <album-art :albumImageUrl="recordDTO.thumb" :albumName="recordDTO.title" :albumId="collectionId" isCollection="true"/>
        <div class="collection-info">
            <div class="collection-name">
                <div class="collection-name">{{ collection.name }}</div>
            </div>
            <div class="user-name">
                <div>By: {{ collection.userName }}</div>
            </div>
        </div>
        <div class="button">
        <button class="tooltip" id="delete-coll-btn" @click="deleteCollection" >
            <font-awesome-icon class="delete-coll-icon" icon="fa-regular fa-square-minus" />
            <span class="tooltiptext">Remove this collection</span>
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
        CollectionService.deleteCollection(this.collection.id)
            .then(rep => {
                if(rep.status === 200 || rep.status === 202){
                    alert("Collection deleted successfully.");
                    this.$store.commit("REMOVE_COLLECTION_FROM_COLLECTIONS", this.collection.id);
                    const user = this.$store.state.username;
                    this.$router.push(`/${user}`);
                    }
                }).catch( () => {
            alert("Oops! Something went wrong and the collection was not removed from your collections")
          })
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
            }).catch(() => {

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
  font-size: 1rem;
    /* font-style: italic; */
    grid-area: info;
    font-family: 'KEEPT___', Verdana, Geneva, Tahoma, sans-serif;
    color: #eff13f;
}

.button {
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 1.7rem;
}

.tooltip {
  position: relative;
  display: inline-block;
  border: 1px solid #eff13f;
}

.tooltip .tooltiptext {
  visibility: hidden;
  width: 120px;
  background-color: transparent;
  color: #eff13f;
  text-align: center;
  padding: 5px 0;
  border-radius: 6px;
  font-family: "KEEPT___", Arial, sans-serif;
  font-size: 1.5rem;
  position: absolute;
  z-index: 1;
  width: 120px;
  bottom: 150%;
  left: 50%;
  margin-left: -110px;
  -webkit-text-stroke:1px #40c5a4 ;
}

.tooltip:hover .tooltiptext {
  visibility: visible;
}
</style>