<template>
  <div>
    <div>
      <strong>Member Count:</strong>
      {{ this.$store.getters.memberCount }}
    </div>
    <div>
      <strong>Amount of Records we Have:</strong>
      {{ this.$store.getters.recordCount }}
    </div>
    <div>
      <strong>Top Artists:</strong>
      {{ this.$store.getters.topTenArtists }}
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
        this.$store.commit('SET_DATA_STATS', response.data)
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