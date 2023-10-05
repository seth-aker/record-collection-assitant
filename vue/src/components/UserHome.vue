<template>
  <div>
    <loading-icon v-show="isLoading"/>
    <search-box></search-box>
    <div class="user-dashboard" v-show="!isLoading">
      <div class="user-heading-left">
        <h1>Collections</h1>
        <div>
          <button id="add-collection-btn" class="button tooltip">
            <font-awesome-icon class="add-record-icon" icon='fa-regular fa-plus-square'/>
            <span class="tooltiptext">Add a Collection</span>
          </button>
        </div>
      </div>
      <div class="user-heading-right">
        <h1>Library</h1>
      </div>
      <div class="user-view-left">
        <collection-list :collections="this.$store.state.userCollections"/>
      </div>
      <div class="user-view-right">
        <record-list :records="$store.state.userLibrary" :isHome="this.isHome"/>
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
          isLoading: false,
          isHome: true
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

.user-heading-right {
  display: flex;
  justify-content: space-around;
  font-family: "KEEPT___", Arial, sans-serif;
  font-size: 2rem;
  -webkit-text-stroke:1px #40c5a4 ;
  color: #eff13f;
}

.user-heading-left {
  display: flex;
  justify-content: center;
  align-items: center;
  font-family: "KEEPT___", Arial, sans-serif;
  font-size: 2rem;
  -webkit-text-stroke:1px #40c5a4 ;
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

#add-collection-btn {
    display: flex;
    padding: 0, 0;
    margin: 0;
    color: #eff13f;
    background-color: transparent;
    border: none;
    cursor: pointer;
    font-size:2rem;
    grid-area: button;
}

.button {
    display: flex;
    justify-content: center;
    align-items: center;
}

.add-record-icon:hover {
  color: #d0d319;
}

.tooltip {
  position: relative;
  display: inline-block;
  border: 1px solid #eff13f;
}

.tooltip .tooltiptext {
  visibility: hidden;
  width: 120px;
  background-color: transparent;
  color: #eff13f;
  text-align: center;
  padding: 5px 0;
  border-radius: 6px;
  font-family: "KEEPT___", Arial, sans-serif;
  font-size: 1em;
  -webkit-text-stroke:1px #40c5a4 ;
  position: absolute;
  z-index: 1;
  top: -25px;
  left: 105%;
}

.tooltip:hover .tooltiptext {
  visibility: visible;
}

</style>