<template>
  <nav>
    <section class="nav-bar-buttons nav-bar-left">
      <div id="home" class="rounded-button">
          <router-link :to="{name: 'home'}">HOME </router-link>
      </div>
      <div id="collections" class="rounded-button">
        <router-link :to="{name: 'collections'}">COLLECTIONS</router-link>
      </div>
      
      <div id="contact" class="rounded-button">
        <router-link :to="{name: 'contact'}">CONTACT</router-link>
      </div>
    </section>

    <h1>SLEEVES</h1>

    <section class="nav-bar-buttons nav-bar-right">

      <div id="login" v-if="!loggedIn" class="rounded-button">
        <router-link :to="{name: 'login'}">LOGIN</router-link>
      </div>
      <div id="registry" v-if="!loggedIn" class="rounded-button">
          <router-link :to="{name: 'register'}">REGISTER</router-link>
      </div>
      <button v-else @click="myProfile">My Profile</button>
  </section>
 </nav>

</template>

<script> 

import Login from "../views/Login.vue"

export default {



name: "NavBar",
data(){

return{
  loggedIn: false,
};
},
components: {
  Login,

},
methods: {

}




}

</script>


<style scoped>
 .nav-bar-left{
   display: flex;
   align-items: space-between;
 }

.nav-bar-buttons {
  display: flex;
  justify-content: space-between;
  align-items: center;
  position: fixed;
  top: 0;
  width: 100%;
   padding: 10px 20px;
}
.registration-login{
  display: flex;
  justify-content: flex-end;
}

.rounded-button {
  display: flex;
  border-radius: 20px; /* Rounded corners */
  background-color: #40c5a4; /* Background color */
  padding: 15px; /* Padding for a bigger button */
  border: none;
  cursor: pointer;
  height: 15px;
  z-index: 1;
  margin: 5px;
  font-family: 'KEEPT___', Verdana, Geneva, Tahoma, sans-serif;
  align-items: center;

}

.rounded-button:hover {
  background-color: #1e8c72; /* Darker color on hover */
}

h1 {
    font-size: 130px;
    font-family: "KEEPT___", Arial, sans-serif;
    color: #eff13f;
    margin: 0;
    position: absolute;
    top: 0;
    width: 100vw;
    text-align: center;
    margin-top: 20px;

}
.rounded-button a {
  color: #eff13f;
  text-decoration: none;
font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
}


@font-face {
  font-family: 'KEEPT___'; 
  src: url('@/assets/fonts/KEEPT___.TTF') format('truetype');
}

/* a {
  color: #eff13f;
  font-family: "KEEPT___", Arial, sans-serif;

} */



</style>