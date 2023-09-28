<template>
  <div>
    <About></About>

    <SearchBox></SearchBox>

    <div class="custom-content">
      
      <div class="genres">
       

      </div>
    </div>

    <Footer></Footer>
  </div>
</template>

<script>
import About from "@/components/About.vue";
import Footer from "@/components/Footer.vue";
import SearchBox from "@/components/SearchBox.vue"; 


export default {
  components: {
   
    About,
    SearchBox,
    Footer,
  },
};
</script>

<style scoped>

</style>