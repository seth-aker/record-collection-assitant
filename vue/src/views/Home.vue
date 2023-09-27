<template>
  <div>
    <!-- Include your Header component -->
    <Header></Header>


    <NavBar></NavBar>


    <About></About>

    <SearchBox></SearchBox>

    <div class="custom-content">
      
      <div class="genres">
        <!-- Add genre buttons or content here -->
      </div>
    </div>

    <!-- Include your Footer component -->
    <Footer></Footer>
  </div>
</template>

<script>
import Header from "@/components/Header.vue";
import NavBar from "@/components/NavBar.vue";
import About from "@/components/About.vue";
import Footer from "@/components/Footer.vue";
import SearchBox from "@/components/SearchBox.vue"; // Corrected import path

export default {
  components: {
    Header,
    NavBar,
    About,
    SearchBox,
    Footer,
  },
};
</script>

<style scoped>
/* Your scoped styles here */
</style>