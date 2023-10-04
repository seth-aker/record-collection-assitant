<template>
    <div class="pager-container">
      <span v-show="curPage > 1" @click="prevPage"><font-awesome-icon icon="fa-solid fa-caret-left"/> {{ (curPage - 1) }} </span>
       
      Page 
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
    font-size: 24px;
    color: white;
    background-color: #40c5a4;
    margin-left: 30%;
    margin-right: 30%;
    margin-top: 10px;
    margin-bottom: 10px;

}

.next-page {
    margin: 5px;
    cursor: pointer;
}

</style>