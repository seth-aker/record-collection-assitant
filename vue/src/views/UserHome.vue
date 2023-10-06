<template>
  <div>
    <loading-icon v-show="isLoading"/>
    <search-box></search-box>
    <div class="user-dashboard" v-show="!isLoading">
      <div class="user-heading-left">
        <h1>Collections</h1>
        <div v-on-clickaway="away">
          <button 
          id="add-collection-btn"
          class="button tooltip">
            <font-awesome-icon 
            @click="showForm = true"
            class="add-record-icon" 
            icon='fa-regular fa-plus-square'
            v-show="!showForm"/>
            <span class="tooltiptext">Add a Collection</span>

          </button>
          <button class="tooltipclose" id="delete-coll-btn" 
          @click="away" v-show="showForm">
            <font-awesome-icon class="delete-coll-icon" 
            icon="fa-regular fa-square-minus" />
            <span class="tooltiptextclose">Close form</span>
          </button>
            <add-collection-form id="form" 
            v-show="showForm" 
            @hideForm="showForm = false"/>
        </div>
      </div>
      <div class="user-heading-right">
        <h1>Library</h1>
      </div>
      <div class="user-view-left">
        <collection-list 
        :collections="this.$store.state.userCollections"/>
      </div>
      <div class="user-view-right">
        <record-list 
        :records="$store.state.userLibrary" :isHome="isHome"/>
      </div>
    </div>
    <div class="custom-content">
      
      <div class="genres">
       

      </div>
    </div>


  </div>
</template>

<script>
import SearchBox from "@/components/SearchBox.vue";

import CollectionList from '../components/CollectionList.vue';
import RecordList from '../components/RecordList.vue';
import CollectionService from '../services/CollectionService';
import RecordService from '../services/RecordService';
import LoadingIcon from '../components/LoadingIcon.vue';
import AddCollectionForm from '../components/AddCollectionForm.vue';
import { mixin as clickaway } from "vue-clickaway";

export default {
  name: 'user-home',
  mixins: [clickaway],

  components: {
    SearchBox,
    CollectionList,
    RecordList,
    LoadingIcon,
    AddCollectionForm
  },
  data() {
        return {
          isLoading: false,
          isHome: true,
          showForm: false
        }
    },
    computed: {
        
    },
    methods: {
      away () {
        this.showForm = false;
      }
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

div .record-list {
  display: flex;
  flex-wrap: wrap;
  justify-content: flex-start;
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
  display: flex;
}

#add-collection-btn {
    display: flex;
    padding: 0, 0;
    margin: 0 0 0 15px;
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
  top: -100px;
  left: -300%;
}

.tooltip:hover .tooltiptext {
  visibility: visible;
}

.tooltipclose {
  position: relative;
  display: inline-block;
  border: 1px solid #eff13f;
}

.tooltipclose .tooltiptextclose {
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
  top: -150%;
  left: 50%;
}

.tooltipclose:hover .tooltiptextclose {
  visibility: visible;
}

#delete-coll-btn {
    display: flex;
    padding: 0, 2px;
    margin: 0;
    color: #eff13f;
    background-color: transparent;
    border: none;
    cursor: pointer;
    font-size: 1em;
}

.delete-coll-icon:hover {
  color: #d0d319;
}

#form {
  display: flex;
  flex-direction: column;
  align-items: center;
  font-family: "KEEPT___", Arial, sans-serif;
    color: #40c5a4;
  -webkit-text-stroke:1px rgb(224, 10, 134);
  font-size: 1.25rem;
  border: #40c5a4 solid 1px;
  border-radius: 5px;
  background-color: #eff13f; 
  position: relative;
  left: 30px;
}
</style>