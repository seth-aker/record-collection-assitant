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
export default {
  name: "LoginRegistrationButton",
  
  methods: {
    showLoginPage(){
      this.$router.push({name: 'login'});
    },
    showRegisterPage(){
      this.$router.push({name: 'register'});
    },
     showHomePage(){
      this.$router.push({name: 'home'});
    },
     showCollectionsPage(){
      this.$router.push({name: 'collections'});
    },
     showContactPage(){
      this.$router.push({name: 'contact'});
    },
  }
};


</script>

<style scoped>

.nav-bar-buttons {
  display: flex;
  align-items: space;

 

}
.registration-login{
  display: flex;
  flex-grow: 1;
  justify-content: flex-end;
}

.general-information{
  display: flex;
  justify-content: flex-start;
}

.rounded-button {
  display: flex;
  border-radius: 20px; /* Rounded corners */
  
  background-color: #40c5a4; /* Background color */
  color: #fff; /* Text color */
  padding: 15px 30px; /* Padding for a bigger button */
  border: none;
  cursor: pointer;
  padding: -25px;
}

.rounded-button:hover {
  background-color: #1e8c72; /* Darker color on hover */
}

</style>