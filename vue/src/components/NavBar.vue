<template>
  <div class="nav-bar-buttons">
    <div class="registration-login">
      <router-link to="({/login})">
        <button id="login" class="rounded-button">&nbsp;&nbsp;LOGIN&nbsp;&nbsp;</button>
      </router-link>
      <router-link to="/register">
        <button id="registry" class="rounded-button">REGISTER</button>
      </router-link>
    </div>
    <div class="general-information">
      <router-link to="/home">
        <button id="home" class="rounded-button">HOME</button>
      </router-link>
      <router-link to="/collections">
        <button id="collections" class="rounded-button">COLLECTIONS</button>
      </router-link>
      <router-link to="/contact">
        <button id="contact" class="rounded-button">CONTACT</button>
      </router-link>
    </div>
  </div>
</template>

<script> 

export default {

   name: "NavBar",
  components: {
  
  
  },
  methods: {
 
  }
};
</script>

<style scoped>
div{
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


</style>