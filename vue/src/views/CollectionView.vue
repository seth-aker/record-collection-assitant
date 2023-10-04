<template>
  <div class="record-collection">
    <div class="container" v-for="record in records" :key="record.id" >
      <record-card :recordInfo="record"/>
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
      records: []
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

</style>