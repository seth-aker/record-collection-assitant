<template>
  <div>
    <search-box class="search" />
    <SlideShow></SlideShow>
    <PopularArtist></PopularArtist>
    <div class="custom-content">
      <div class="genres">
        
      </div>
    </div>
  </div>
</template>

<script>
import SearchBox from "@/components/SearchBox.vue";
import SlideShow from "@/components/SlideShow.vue";
import PopularArtist from '../components/PopularArtist.vue';


export default {
  components: {
    SearchBox,
    SlideShow,
    PopularArtist,
  }
};
</script>

<style scoped>

.search {
display: flex;
justify-content: center;
}

.user-view {
  display: flex;
  justify-content: space-evenly;
}

</style>