<template>
  <div>
    <SlideShow></SlideShow>
    <record-search />
    <PopularArtist></PopularArtist>
    <div class="custom-content">
      <div class="genres">
        
      </div>
    </div>
  </div>
</template>

<script>
import RecordSearch from "@/components/RecordSearch.vue";
import SlideShow from "@/components/SlideShow.vue";
import PopularArtist from '../components/PopularArtist.vue';


export default {
  components: {
    RecordSearch,
    SlideShow,
    PopularArtist,
    
  },
};
</script>

<style scoped>

</style>