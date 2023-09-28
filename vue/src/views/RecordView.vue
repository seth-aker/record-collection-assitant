<template>
  <div class="record-page">
    <album-art :albumImageUrl="recordDTO.imageUrl" :albumName="recordDTO.record.title"/>
  </div>
</template>

<script>
import recordService from "../services/RecordService.js"
import AlbumArt from "../components/AlbumArt.vue"
export default {
    components: {
      AlbumArt
    },
    
    data() {
      return {
        recordDTO : {}
      }
    },
    created() {
        const recordId = this.$route.params.recordId;
        recordService.getRecordInfo(recordId)
        .then(response => {
          this.recordDTO = response.data;
        });
    }
}
</script>

<style>

</style>