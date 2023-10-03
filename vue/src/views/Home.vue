<template>
  <div>
     <search-box />
    <SlideShow></SlideShow>
    

    <TopArtistSlideshow></TopArtistSlideshow>

    <TopGenreSlideshow></TopGenreSlideshow>

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
import TopArtistSlideshow from '../components/TopArtistSlideshow.vue';
import TopGenreSlideshow from '../components/TopGenreSlideshow.vue';

export default {
  components: {
    SearchBox,
    SlideShow,
    TopArtistSlideshow,
    TopGenreSlideshow,
    PopularArtist,
  }
};
</script>

<style scoped>

.slideshow {
margin-top: 100px;
margin-bottom: 100px;
}

</style>