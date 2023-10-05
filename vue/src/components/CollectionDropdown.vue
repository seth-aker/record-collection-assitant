<template>
  <div @click="toggleHideDeleteButton(); toggleCollectionList();" 
  v-on-clickaway="away" v-show="isHome">
      <slot name="toggler">
        <button class="tooltipadd" id="add-record-btn">
          <font-awesome-icon class="add-record-icon" 
          icon='fa-regular fa-plus-square' 
          v-show="!recordAdded && !isCollection" />
          <span class="tooltiptextadd">
            Add this record to a collection</span>
        </button>
      </slot>
      <slot/>
  </div>
</template>

<script>
import { mixin as clickaway } from "vue-clickaway";

export default {
    name: 'CollectionDropdown',
    mixins: [clickaway],
    props: ['isHome','recordAdded','isCollection'],
    provide () {
      return {
        sharedState: this.sharedState
      }
    },
    data () {
      return {
        sharedState: {
          active: false,
        }
      }
    },
  methods: {
    toggleCollectionList () {
      this.sharedState.active = !this.sharedState.active
    },
    toggleHideDeleteButton() {
      // if (this.isNotVis === false) {
        if(this.sharedState.active === false) {
          this.isNotVis = true;
          this.$emit('toggle-isNotVis',this.isNotVis);
        } else {
          this.isNotVis = false;
          this.$emit('toggle-isNotVis',this.isNotVis);
        }
      // }
      // this.isNotVis = !this.isNotVis;

    },
    away () {
      this.sharedState.active = false;
      if (this.isNotVis === true) {
      this.$emit('away-toggle');
      }
      // this.isNotVis = !this.isNotVis;
    }
  }
}
</script>

<style scoped>
#add-record-btn {
    padding: 0, 5px;
    margin: 0;
    color: #eff13f;
    background-color: transparent;
    border: none;
    cursor: pointer;
    font-size: 1.7rem;
}

.tooltipadd {
  position: relative;
  display: inline-block;
  border: 1px solid #eff13f;
}

.tooltipadd .tooltiptextadd {
  visibility: hidden;
  width: 120px;
  background-color: transparent;
  color: #eff13f;
  text-align: center;
  padding: 5px 0;
  border-radius: 6px;
  font-family: "KEEPT___", Arial, sans-serif;
  font-size: 1.3rem;
  position: absolute;
  z-index: 1;
  width: 120px;
  bottom: 150%;
  left: 50%;
  margin-left: -105px;
  margin-bottom: 5px;
  -webkit-text-stroke:1px #40c5a4 ;
}

.add-record-icon:hover {
  color: #d0d319;
}

.tooltipadd:hover .tooltiptextadd {
  visibility: visible;
}

</style>