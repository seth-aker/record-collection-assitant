<template>
  <span class="colletionInfo">
      <album-art :albumImageUrl="recordDTO.thumb" :albumName="recordDTO.title"/>
      <div>{{ collection.name}}</div>
      <div>{{collection.userName}}</div>
  </span>
</template>

<script>
import CollectionService from '../services/CollectionService'
import RecordService from '../services/RecordService'
import AlbumArt from './AlbumArt.vue'
export default {
    name: 'collection-card',
    props:['collectionId'],
    components: {
        AlbumArt

    },
    data() {
        return {
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
        CollectionService.getCollection(this.collectionId)
            .then(response => {
                this.collection = response.data;
                this.recordIds = this.collection.recordIds;
        this.recordId = this.recordIds[0];
        RecordService.getRecordInfo(this.recordId)
            .then(response => {this.recordDTO = response.data;
            });
        this.userId = this.collection.userId;
            });

        }
}
</script>

<style>

</style>