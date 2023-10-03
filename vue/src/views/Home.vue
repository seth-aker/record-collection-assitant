<template>
  <div>
    <loading-icon v-show="isLoading" />
    <search-box />
    <slide-show :items="this.$store.state.trendingCollections" />
    
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
import PopularArtist from '../components/PopularArtist.vue';
import TopArtistSlideshow from '../components/TopArtistSlideshow.vue';
import TopGenreSlideshow from '../components/TopGenreSlideshow.vue';
import CollectionService from '../services/CollectionService';
import RecordService from '../services/RecordService';
import LoadingIcon from '../components/LoadingIcon.vue';
import SlideShow from '../components/SlideShow.vue';


export default {
  components: {
    SearchBox,
    TopArtistSlideshow,
    TopGenreSlideshow,
    PopularArtist,
    LoadingIcon,
    SlideShow,
  },

  created() {
      CollectionService.getTrendingCollections(20).then(response => {
        const collections = response.data;
        collections.forEach(collection => {
          RecordService.getRecordInfo(collection.recordIds[0]).then(resp => {
            collection.imgUrl = resp.data.images[0].uri
            this.$store.commit("ADD_TO_TRENDING_COLLECTIONS", collection)
          })
        })
        
        this.isLoading = false;
      })
      //call topArtists
  },
  data() {
    return {
      isLoading: true,
      
      
    }
  }
};
</script>

<style scoped>

.slideshow {
margin-top: 100px;
margin-bottom: 100px;
}

</style>