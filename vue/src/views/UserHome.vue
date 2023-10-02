<template>
  <div>

    <SearchBox></SearchBox>
      <div class="user-view">
        <collection-list :collections="$store.state.userCollections"/>
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

export default {
  name: 'userhome',
  components: {
    CollectionList,
    RecordList,
    About
  },
  data() {
        return {
            username: ""
        }
    },
    computed: {
        
    },
    methods: {
        
    },
    created() {
      this.username = this.$store.state.user;
      CollectionService.getUserCollections(this.username)
        .then(response => {
          this.$store.commit('SET_USER_COLLECTIONS', response.data);
          });
      RecordService.getUserLibrary
        .then(response => {
          this.$store.commit('SET_USER_LIBRARY', response.data);
        });
    }
};
</script>

<style scoped>

</style>