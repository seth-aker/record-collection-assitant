<template>
  <div>
    <NavBar></NavBar>
    <SearchBox></SearchBox>
    <About></About>
    <GenreButton></GenreButton>
    <RecordList></RecordList>
    <AlbumArt></AlbumArt>
    <Footer></Footer>
  </div>
</template>

<script>
import NavBar from "@/components/NavBar.vue";
import SearchBox from "@/components/SearchBox.vue";
import About from "@/components/About.vue";
import GenreButton from "@/components/GenreButton.vue";
import RecordList from "@/components/RecordList.vue";
import AlbumArt from "@/components/AlbumArt.vue";
import Footer from "@/components/Footer.vue";

export default {
  components: {
    NavBar,
    SearchBox,
    About,
    GenreButton,
    RecordList,
    AlbumArt,
    Footer,
  },
};
</script>