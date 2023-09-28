<template>

  <section class="nav-bar-buttons">
   
      <router-link to="login">
        <div id="login" class="rounded-button">&nbsp;&nbsp;LOGIN&nbsp;&nbsp;</div>
      </router-link>
      <router-link to="/register">
        <div id="registry" class="rounded-button">REGISTER</div>
      </router-link>
      <router-link to="/home">
        <div id="home" class="rounded-button">&nbsp;&nbsp;HOME&nbsp;&nbsp;
      </router-link>
      <router-link to="/collections">
        <div id="collections" class="rounded-button">COLLECTIONS</div>
      </router-link>
      <router-link to="/contact">
        <div id="contact" class="rounded-button">CONTACT</div>
      </router-link>
 
 
  

 </section>
</template>

<script> 

export default {
name: "NavBar",

  methods: {
 
  }
};
</script>

<style scoped>
#nav-bar-buttons{
  display: flex;
  position: fixed;

}
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

.dropdown:hover{

}


</style>