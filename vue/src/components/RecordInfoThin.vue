<template>
  <span class="recordInfo">
    <album-art :albumImageUrl="recordDTO.thumb" :albumName="recordDTO.title" />
    <div>{{ recordDTO.title }}</div>
  </span>
</template>

<script>
import AlbumArt from './AlbumArt.vue'
import recordService from '../services/RecordService.js'
export default {
  name: "recordInfo",
  props: ['recordId'], 
  components: { AlbumArt },
  data() {
      return {
          recordDTO: ""
      }
  },
  created() {
      recordService.getRecordInfo(this.recordId).then(response => {
          this.recordDTO = response.data;
      })
  }

}
</script>

<style>

</style>