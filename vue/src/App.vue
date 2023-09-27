<template>
  <div id="app">
    <div class="background"></div> <!-- New background element -->
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token !== ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>

<style scoped>

#app {
  background-image: url('../public/pinkYellow.jpg'); 
  background-size: cover; 
  background-position: center; 
  background-repeat: no-repeat; 
   
}


</style>
