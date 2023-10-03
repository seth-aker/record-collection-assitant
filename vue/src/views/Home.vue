<template>
  <div>
     <search-box />
    <SlideShow :items="collections" ></SlideShow>
    
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
import CollectionService from '../services/CollectionService';
import RecordService from '../services/RecordService';

export default {
  components: {
    SearchBox,
    SlideShow,
    TopArtistSlideshow,
    TopGenreSlideshow,
    PopularArtist,
  },
  created() {
      CollectionService.getTrendingCollections(20).then(response => {
        this.collections = response.data
        this.collections.forEach(collection => {
          RecordService.getRecordInfo(collection.recordIds[0]).then(resp => {
            collection.imgUrl = resp.data.images[0].uri
          })
        })
      })
      //call topArtists
  },
  data() {
    return {
      collections: []
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