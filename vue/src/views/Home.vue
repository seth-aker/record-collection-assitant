<template>
  <div>
    <About></About>

    <SearchBox></SearchBox>

    <div class="custom-content">
      
      <div class="genres">
       

      </div>
    </div>

    
  </div>
</template>

<script>
import About from "@/components/About.vue";

import SearchBox from "@/components/SearchBox.vue"; 


export default {
  components: {
   
    About,
    SearchBox,
   
  },
};
</script>

<style scoped>

</style>