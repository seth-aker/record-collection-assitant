
<template>
  <div id="app">



      <nav-bar-vue />
      

    <router-view />
    <footer-vue />

  </div>
  
</template>

<script>
import FooterVue from './components/Footer.vue'
import NavBarVue from './components/NavBar.vue'

export default {
  name: 'MainApp',

  components: {
    NavBarVue,
    FooterVue,
  }
}
</script>

<style>
body {
  margin: 0;
}

#app {
  background-image: url('./assets/pinkYellowFaded.jpg'); 
  background-size: cover; 
  background-position: center; 
  background-repeat: no-repeat; 
}



</style>