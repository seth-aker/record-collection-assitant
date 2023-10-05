<template>
  <div class="record-collection">
    <div class="container" v-for="record in records" :key="record.id" >
      <record-card :recordInfo="record" :isCollection="isCollection"/>
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
      isCollection: true
    }
  },
  computed: {
    
  },
  created() {
    const collectionId = this.$route.params.collectionId;
    collectionService.getCollection(collectionId)
      .then(response => {
        this.collectionDTO = response.data
        this.isLoading = false;
        this.recordIds = this.collectionDTO.recordIds;
        this.recordIds.forEach(recordId => {
          RecordService.getRecordInfo(recordId).then(resp => {
            resp.data.thumb = resp.data.images[0].uri;
            this.records.push(resp.data)
          })
        })
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
  margin-bottom: 300px;
  margin-top: 50px;


}
.record-collection {
  display: flex;
  justify-items: center;
  align-items: center;
  
  

}

</style>