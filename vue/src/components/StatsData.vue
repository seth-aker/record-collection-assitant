<template>
  <div>
    {{ this.$store.state.dataStats.memberCount }}
    {{ this.$store.state.dataStats.collectionCount }}
    {{ this.$store.state.dataStats.premiumUserCount }}
    {{ this.$store.state.dataStats.avgRecordsInCollection }}
    {{ this.$store.state.dataStats.mostActiveUser }}

     {{ this.$store.state.dataStats.artistsBestRecord }}
    {{ this.$store.state.dataStats.downloadNumber }}

 <!-- {{ this.$store.state.dataStats.downloadNumber }}
    {{ this.$store.state.dataStats.topTenRecords }}
    {{ this.$stroe.state.dataStats.topTenArtists}} -->
     </div> 
</template>

<script>
import dataStats from "../services/dataStats.js";

export default {
  data() {
    return {
    };
  },
  computed: {},
  created() {

     // this.isloading = true;
    dataStats.getDataStats()
      .then((response) => {
        console.log("Response from API:", response.data);
        this.$store.commit("SET_DATA_STATS", response.data);
        //    this.isLoading = false;
      })
      .catch((error) => {
        console.error("Error fetching data stats:", error);
      });
  },
};
</script>

<style>
</style>
    