<template>
  <div class="record-collection">
    <div class="container" v-for="recordId in recordIds" :key="recordId" >
      <record-info-thin :recordId="recordId"/>
    </div>
  </div>
</template>

<script>
import collectionService from '../services/CollectionService.js'

import RecordInfoThin from '../components/RecordInfoThin.vue'

export default {
  components: { RecordInfoThin },
  name: 'Collections',
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