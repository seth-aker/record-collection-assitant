<template>
  <div>
    <div>
      <strong>Member Count:</strong>
      {{ this.$store.state.siteStats.memberCount }}
    </div>
    <div>
      <strong>Avg Records per Collection:</strong>
      {{ this.$store.state.siteStats.avgRecordsInCollection }}
    </div>
    <div>
      <strong>Most Active User:</strong>
      {{ this.$store.state.siteStats.mostActiveUser }}
    </div>
    <div>
      <strong>Premium User Count:</strong>
      {{ this.$store.state.siteStats.premiumUserCount }}
    </div>
    <div>
      <strong>Record Count:</strong>
      {{ this.$store.state.siteStats.recordCount }}
    </div>
  </div>
</template>

<script>
import dataStats from "../services/AggrDataService";

export default {
  data() {
    return {
      isLoading: true,
    };
  },
  computed: {},
  created() {
    // this.isloading = true;
    dataStats
      .getDataStats()
      .then((response) => {
        this.$store.commit("SET_SITE_STATS", response.data);
        const siteStats = [
          response.data.recordCount,
          response.data.memberCount,
          response.data.mostActiveUser,
          response.data.premiumUserCount,
          response.data.collectionCount,
          response.data.avgRecordsInCollection,
        ];
        this.$store.commit("SET_SITE_STATS", siteStats);
      })
      .catch((error) => {
        console.error("Error fetching data stats:", error);
      });
  },
};
</script>

<style>
</style>