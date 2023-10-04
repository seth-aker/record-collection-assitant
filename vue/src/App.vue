<template>
  <div id="app">
    <nav-bar-vue />
    <router-view />
    <footer-vue />
    <div class="background">
    
    </div>
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
  position: relative;
}

.background {
  background-image: url('./assets/pinkYellow.jpg'); 
  background-size: cover; 
  background-position: center top; /* Adjust the background position to center top */
  background-repeat: no-repeat;
  position: fixed; 
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: -1;
  filter: blur(3px);
}
</style>