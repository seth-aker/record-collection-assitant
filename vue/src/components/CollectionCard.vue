<template>
  <div class="collection-card">
    <album-art :albumImageUrl="recordDTO.thumb" :albumName="recordDTO.title" :albumId="recordDTO.id"/>
    <div class="collection-info">
        <div class="collection-name">
            <div class="collection-name">{{ collection.name }}</div>
        </div>
        <div class="user-name">
            <div>By: {{ collection.userName }}</div>
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
}

.collection-info {
    display: flex;
    flex-direction: column;
}

div.collection-info {
    font-size: 12px;
    font-style: italic;
}


</style>