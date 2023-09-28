<template>
  <div>
    
    <Header></Header>
    


    <NavBar></NavBar>


    <About></About>

    <SearchBox></SearchBox>

    <PopularArtist></PopularArtist>
   
    <Footer></Footer>
  </div>
</template>

<script>
import Header from "@/components/Header.vue";
import NavBar from "@/components/NavBar.vue";
import About from "@/components/About.vue";
import Footer from "@/components/Footer.vue";
import SearchBox from "@/components/SearchBox.vue"; 
import PopularArtist from "@/components/PopularArtist.vue";

export default {
  components: {
    Header,
    NavBar,
    About,
    SearchBox,
    Footer,
    PopularArtist,
  },
};
</script>

<style scoped>

</style>