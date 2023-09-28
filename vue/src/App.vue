<template>
  <div id="app">
    <div class="background"></div> <!-- New background element -->
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token !== ''">Logout</router-link>
      </div>
    <div id = "login-registration">
        <login-registration-button />
  </div>
    <router-view />
  </div>
</template>

<script>
import LoginRegistrationButton from "./components/LoginButton.vue"

export default {
  components: {
    LoginRegistrationButton
  }

}
</script>
<style scoped>

#app {
  background-image: url('../public/pinkYellow.jpg'); 
  background-size: cover; 
  background-position: center; 
  background-repeat: no-repeat; 
   
}
.login-registration{
  display: flex ;
width: 100%;
padding-top: 35px;
padding-right: 10px;
}

</style>