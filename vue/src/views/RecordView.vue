<template>
  <div class="record-page">
    <div class="loading" v-if="isLoading">
      Loading
    </div>
    <div v-else >
      <h2>{{ recordDTO.title }}</h2>
      <album-art :albumImageUrl="recordDTO.thumb" :albumName="recordDTO.title" :albumId="recordDTO.id"/>
      <div class="record-info" > 
        <ul>
          <li v-for="artist in recordDTO.artists" :key="artist.id"> Artist: {{ artist.name }}</li>

  <!-- TODO: need to make it so the last element of genre list doesn't get a comma; -->
          <li> Genres: <span v-for="(genre, index) in recordDTO.genres" :key="index">{{ genre }}, </span></li>

          <li> Label: {{ recordDTO.labels[0].name }}</li>

  <!-- TODO: need to make it so the last element of genre list doesn't get a comma; -->
          <li> Stlyes: <span v-for="(style, index) in recordDTO.styles" :key="index">{{ style }}, </span></li>

          <li> Year: {{ recordDTO.year }}</li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
import recordService from "../services/RecordService.js"
import AlbumArt from "../components/AlbumArt.vue"

export default {
    components: {
      AlbumArt,
 
    },
    
    data() {
      return {
        recordDTO : [],
        isLoading: true
      }
    },
    created() {
        const recordId = this.$route.params.recordId;
        recordService.getRecordInfo(recordId)
        .then(response => {
          this.recordDTO = response.data;
          this.isLoading = false;
        });
    }
}
</script>

<style>

</style>