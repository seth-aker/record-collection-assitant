<template>
    <div class="pager-container">
      <span class="next-page" v-show="curPage > 1" @click="prevPage"><font-awesome-icon icon="fa-solid fa-caret-left"/> {{ (curPage - 1) }} </span>
       
      <span class="current-page" >{{ curPage }}</span>
      
      <span class="next-page" v-show="curPage < $store.state.sr.maxPages"  @click="nextPage">{{ (curPage + 1 ) }} <font-awesome-icon icon="fa-solid fa-caret-right"/> </span>
    </div>
</template>

<script>
// import apiService from '../services/ApiService'
export default {
  name: 'item-pager',
  props: ["curPage", "maxPages"],
  data() {
    return {
      pageNumEdit: 1
    }
  },
  created() {
    // this.updatePageProducts();
  },
  computed: {

  },
  methods: {
      nextPage() {
          if (this.curPage < this.maxPages) {
            this.$store.commit('SET_CUR_PAGE', this.curPage + 1)
            this.$emit('requestSearch');
          }
      },
      prevPage() {
          if (this.curPage > 1) {
              this.$store.commit('SET_CUR_PAGE', this.curPage - 1)
              this.$emit('requestSearch');
            
          }
      },
  }
};
</script>

<style scoped>
.pager-container {
    font-size: 26px;
    color: #eff13f;
    background-color: #40c5a4;
    margin-left: 40%;
    margin-right: 40%;
    margin-top: 5px;
    margin-bottom: 15px;
    
    font-family: "KEEPT___", Arial, sans-serif;
    -webkit-text-stroke:0.5px #E00A86;
     border-radius: 40px;
     display: flex;
     justify-content: center;
     align-items: center;
     opacity: 90%;

}

.next-page {
    margin: 15px;
    cursor: pointer;
    color: #E00A86;
    -webkit-text-stroke:0.5px #eff13f;
    
}

</style>