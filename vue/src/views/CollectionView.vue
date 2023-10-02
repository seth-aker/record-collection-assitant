<template>
  <div class="record-collection">
    <div class="container" v-for="recordId in recordIds" :key="recordId" >
      <record-card :recordId="recordId"/>
    </div>
  </div>
</template>

<script>
import collectionService from '../services/CollectionService.js'

import RecordCard from '../components/RecordCard.vue'

export default {
  components: { RecordCard },
  name: 'Collection-View',
  data() {
    return {
      collectionDTO: [],
      isLoading: true,
      recordIds: []
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
      })

  }

}
</script>

<style>

</style>