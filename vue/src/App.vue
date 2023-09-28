<template>
  <div id="app">

    <div id="nav">
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token !== ''">Logout</router-link>

      <nav-bar-vue />
      

    <router-view />
  </div>
</template>

<script>

import NavBarVue from './components/NavBar.vue'

export default {
  name: 'MainApp',

  components: {
    NavBarVue,
    
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