<template>
  <div class="record-collection">
    <h2>{{collectionDTO.name}}</h2>
    <div class="collection-list">
      <div class="container" v-for="record in records" :key="record.id" >
      <record-card :recordInfo="record" :isCollection="isCollection"
      :collectionId="collectionId" :collection="collectionDTO"/>
    </div>

    </div>
    
    
  </div>
</template>

<script>
import collectionService from '../services/CollectionService.js'

import RecordCard from '../components/RecordCard.vue'
import RecordService from '../services/RecordService.js'


export default {
  components: { RecordCard },
  name: 'Collection-View',
  data() {
    return {
      collectionDTO: [],
      isLoading: true,
      recordIds: [],
      records: [],
      isCollection: true,
      collectionId: this.$route.params.collectionId
    }
  },
  computed: {
    
  },
  created() {
    const collectionId = this.$route.params.collectionId;
    collectionService.getCollection(collectionId)
      .then(response => {
        this.collectionDTO = response.data
        this.recordIds = this.collectionDTO.recordIds;
        this.recordIds.forEach(recordId => {
          RecordService.getRecordInfo(recordId).then(resp => {
            resp.data.thumb = resp.data.images[0].uri;
            this.records.push(resp.data)
          })
        }) 
        this.isLoading = false;
      })

  }

}
</script>

<style>
.container {
  display: flex;
  flex-wrap: wrap; /* Allow items to wrap to the next row if needed */
  justify-content: center; /* Center items horizontally within the container */
  gap: 20px; /* Add spacing between items */
  width: 20%;
  min-height: 420px;

}
.record-collection {
  display: flex;
  flex-direction: column;
  justify-items: center;
  align-items: center;
  flex-wrap: wrap;
}

.collection-list{
  width: 85vw;
  display: flex;
  flex-wrap: wrap;
  align-items: center;
  margin-bottom: 50px;
}

h2{
    display: flex;
    justify-content: center;
    align-items: center;
    font-family: "KEEPT___", Arial, sans-serif;
    font-size: 4rem;
    -webkit-text-stroke: 1px #40c5a4;
    color: #eff13f;
    text-decoration: underline;
}
</style>