
<template>
  <div id="app">

    <div id="nav">
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token !== ''">Logout</router-link>
      </div>

      <nav-bar-vue />
      
<footer-vue />
    <router-view />



  

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
  background-image: url('../public/pinkYellow.jpg'); 
  background-size: cover; 
  background-position: center; 
  background-repeat: no-repeat; 
<<<<<<< HEAD
  
   
=======
>>>>>>> 0322be507003507e3e4407d7869ad6d9f253c97d
}

</style>