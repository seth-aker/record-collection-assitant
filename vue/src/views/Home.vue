<template>
  <div>
<<<<<<< HEAD
    <search-box class="search" />
    <SlideShow></SlideShow>
=======
     <search-box />
    <SlideShow></SlideShow>
    

    <TopArtistSlideshow></TopArtistSlideshow>

    <TopGenreSlideshow></TopGenreSlideshow>

>>>>>>> f46764911841a968a78c3eaad36d52aabfe7c0f7
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

<<<<<<< HEAD
.search {
display: flex;
justify-content: center;
}

.user-view {
  display: flex;
  justify-content: space-evenly;
=======
.slideshow {
margin-top: 100px;
margin-bottom: 100px;
>>>>>>> f46764911841a968a78c3eaad36d52aabfe7c0f7
}

</style>