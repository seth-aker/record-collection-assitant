import Footer from "@/components/Footer.vue"; 




<template>
  <div id="app">

    <div id="nav">
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token !== ''">Logout</router-link>

      <nav-bar-vue />
      

    <router-view />

     <Footer />
  </div>
</template>

<script>

import NavBarVue from './components/NavBar.vue'
import Footer from './components/Footer.vue';

export default {
  name: 'MainApp',

  components: {
    NavBarVue,
    Footer,
    
  }

}
</script>
<style>
body {
  margin: 0;
}

#app {
  background-image: url('../public/pinkYellow.jpg'); 
  background-size: cover; 
  background-position: center; 
  background-repeat: no-repeat; 
   
}


</style>