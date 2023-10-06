<template>
  <div>
    <div>
      <strong>Member Count:</strong>
      {{ this.$store.getters.memberCount }}
    </div>
    <div>
      <strong>Avg Records per Collection:</strong>
      {{ this.$store.getters.avgRecordsInCollection }}
    </div>
    <div>
      <strong>Most Active User:</strong>
      {{ this.$store.getters.mostActiveUser }}
    </div>
    <div>
      <strong>Premium User Count:</strong>
      {{ this.$store.getters.premiumUserCount }}
    </div>
    <div>
      <strong>Record Count:</strong>
      {{ this.$store.getters.recordCount }}
    </div>
    <div>
      <strong> Top Artists:</strong>
      {{ this.$store.state.topTenArtists}}
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
    dataStats
      .getDataStats()
      .then((response) => {
        this.$store.commit('SET_SITE_STATS', response.data);
        this.$store.commit('SET_TOP_TEN_ARTISTS', response.data)
      })
      .catch((error) => {
        console.error("Error fetching data stats:", error);
      });
  },
};
</script>

<style>
</style>

<style>
</style>