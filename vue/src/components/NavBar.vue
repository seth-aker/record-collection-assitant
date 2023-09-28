<template>
<div class="nav-bar-buttons">
    <div class="registration-login">
    <button @click="showLoginPage" id="login" class="rounded-button">&nbsp;&nbsp;LOGIN&nbsp;&nbsp;</button>
   <button @click="showRegisterPage" id="registry" class="rounded-button">REGISTER</button>
    </div>
    <div class="general-information">
        <button @click="showHomePage" id="home" class="rounded-button">HOME</button>
    <button @click="showCollectionsPage" id="collections" class="rounded-button">COLLECTIONS</button>
    <button @click="showContactPage" id="contact" class="rounded-button">CONTACT</button>
    </div>
  </div>
</template>

<script> 
import LoginButtonVue from '../components/LoginButton.vue';

export default {

   name: "NavBar",
  components: {
 LoginButtonVue
  
  
  },
  methods: {
    showHome(){
      this.$router.push({name: 'home'});
    },

  }
};
</script>

<style scoped>
div{
  display: flex;
  position: fixed;

}


</style>