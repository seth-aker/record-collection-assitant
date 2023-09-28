<template>

  <div class="nav-bar-buttons">
    <div class="registration-login rounded-button">
       <div id="login">
      <router-link to="login">
      &nbsp;&nbsp;LOGIN&nbsp;&nbsp;
      </router-link>
       </div>
        <div id="register">
      <router-link to="/register">
        REGISTER
      </router-link>
    </div>
    <div class="general-information rounded-button">
      <div id="home">
      <router-link to="/home">
       &nbsp;&nbsp;HOME&nbsp;&nbsp;
      </router-link></div>
        <div id="collections" >
      <router-link to="/collections">
       COLLECTION
      </router-link>
       </div>
       <div id="contact">
      <router-link to="/contact">
      CONTACT
      </router-link>
    </div>
 
  

 </div>
</template>

<script>
export default {
  name: "NavBar",

  methods: {},
};
</script>

<style scoped>
#nav-bar-buttons {
  display: flex;
  position: fixed;
}
.nav-bar-buttons {
  display: flex;
  align-items: space;
}
.registration-login {
  display: flex;
  flex-grow: 1;
  justify-content: flex-end;
}

.general-information {
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

.dropdown:hover {
}
</style>