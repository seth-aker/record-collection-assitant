<template>
  <div>
    <loading-icon v-show="isLoading"/>
    <SearchBox></SearchBox>
    <div class="user-heading">
              <h1>Collections</h1>
              <h1>Library</h1>
    </div>
      <div class="user-view">
        <collection-list :collections="this.$store.state.userCollections"/>
        <record-list :records="$store.state.userLibrary" />
      </div>
    <About></About>
    <div class="custom-content">
      
      <div class="genres">
       

      </div>
    </div>


  </div>
</template>

<script>
import About from "@/components/About.vue";
import CollectionList from '../components/CollectionList.vue';
import RecordList from '../components/RecordList.vue';
import CollectionService from '../services/CollectionService';
import RecordService from '../services/RecordService';
import LoadingIcon from '../components/LoadingIcon.vue';

export default {
  name: 'user-home',
  components: {
    CollectionList,
    RecordList,
    About,
    LoadingIcon
  },
  data() {
        return {
          isLoading: true
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
    }
};
</script>

<style scoped>
.user-view {
  display: flex;
  justify-content: space-evenly;
}

.user-heading {
  display: flex;
  justify-content: space-around;
}

</style>