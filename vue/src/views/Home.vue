<template>
  <div>
    <loading-icon v-show="isLoading" />
    <search-box />
    <slide-show :items="this.$store.state.trendingCollections" name="TRENDING COLLECTIONS" /> 
    <slide-show :items="this.$store.state.topTenRecords" name="TOP 25 RECORDS"></slide-show>

    <TopGenreSlideshow></TopGenreSlideshow>

    
    <div class="custom-content">
      <div class="genres">
        
      </div>
    </div>
  </div>
</template>

<script>
import SearchBox from "@/components/SearchBox.vue";
import TopGenreSlideshow from '../components/TopGenreSlideshow.vue';
import CollectionService from '../services/CollectionService';
import RecordService from '../services/RecordService';
import LoadingIcon from '../components/LoadingIcon.vue';
import SlideShow from '../components/SlideShow.vue';
import dataStats from '../services/AggrDataService'


export default {
  components: {
    SearchBox,
    TopGenreSlideshow,
    LoadingIcon,
    SlideShow,
  },

  created() {
    this.$store.commit('CLEAR_TRENDING')
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
      dataStats.getDataStats()
      .then(response => {
        this.$store.commit('SET_DATA_STATS', response.data);
         const topTenRecords = response.data.topTenRecords;
          topTenRecords.forEach(eachRecord => {
            eachRecord.imgUrl = eachRecord.thumb;
              eachRecord.name = eachRecord.title;
        })
         this.$store.commit('SET_TOP_TEN_RECORDS', topTenRecords);
      })
      .catch((error) => {
          console.error("Error fetching data stats:", error);  
      });
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