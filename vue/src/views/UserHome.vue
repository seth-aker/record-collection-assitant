<template>
  <div>
    <loading-icon v-show="isLoading"/>
    <search-box></search-box>
    <div class="user-dashboard" v-show="!isLoading">
      <div class="user-heading">
        <h1>Collections</h1>
      </div>
      <div class="user-heading">
        <h1>Library</h1>
      </div>
      <div class="user-view-left">
        <collection-list :collections="this.$store.state.userCollections"/>
      </div>
      <div class="user-view-right">
        <record-list :records="$store.state.userLibrary" />
      </div>
    </div>
    <About></About>
    <div class="custom-content">
      
      <div class="genres">
       

      </div>
    </div>


  </div>
</template>

<script>
import SearchBox from "@/components/SearchBox.vue";
import About from "@/components/About.vue";
import CollectionList from '../components/CollectionList.vue';
import RecordList from '../components/RecordList.vue';
import CollectionService from '../services/CollectionService';
import RecordService from '../services/RecordService';
import LoadingIcon from '../components/LoadingIcon.vue';

export default {
  name: 'user-home',
  components: {
    SearchBox,
    CollectionList,
    RecordList,
    About,
    LoadingIcon
  },
  data() {
        return {
          isLoading: false
        }
    },
    computed: {
        
    },
    methods: {
        
    },
    created() {
      this.isLoading = true;
      CollectionService.getUserCollections()
        .then(response => {
          this.$store.commit('SET_USER_COLLECTIONS', response.data);
          this.isLoading = false;
          });
      RecordService.getUserLibrary()
        .then(response => {
          this.$store.commit('SET_USER_LIBRARY', response.data);
          this.isLoading = false;
        });
      this.isLoading = false;
    }
};
</script>

<style scoped>

div.record-list {
  display: flex;
  flex-wrap: wrap;
}

.user-heading {
  display: flex;
  justify-content: space-around;
  font-family: "KEEPT___", Arial, sans-serif;
  color: #eff13f;
}

.user-dashboard {
  display: grid;
  grid-template-columns: 1fr 1fr;
}

.user-view-left {
  border-right: 2px solid;
  border-color: #eff13f;
}

</style>