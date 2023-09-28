<template>
  <nav>
    <section class="nav-bar-buttons nav-bar-left">
      <div id="home" class="rounded-button">
          <router-link :to="{name: 'register'}">HOME </router-link>
      </div>
      <div id="collections" class="rounded-button">
        <router-link :to="{name: 'collections'}">COLLECTIONS</router-link>
      </div>
      
      <div id="contact" class="rounded-button">
        <router-link :to="{name: 'contact'}">CONTACT</router-link>
      </div>
    </section>

  <section class="nav-bar-buttons ">
   
    <h1>SLEEVES</h1>

    <section class="nav-bar-buttons nav-bar-right">
    
      <div id="login" class="rounded-button">
        <router-link :to="{name: 'login'}">LOGIN</router-link>
      </div>
      
      <div id="registry" class="rounded-button">
          <router-link :to="{name: 'register'}">REGISTER</router-link>
      </div>
  </section>
 </nav>
</template>

<script> 

export default {
name: "NavBar",
};
</script>


<style scoped>
nav {
  display: flex;
  justify-content: space-between;
}

#nav-bar-buttons{
  display: flex;
}
.nav-bar-buttons {
  display: flex;
}
.registration-login{
  display: flex;
  justify-content: flex-end;
}

.rounded-button {
  display: flex;
  border-radius: 20px; /* Rounded corners */
  background-color: #40c5a4; /* Background color */
  color: #fff; /* Text color */
  padding: 15px; /* Padding for a bigger button */
  border: none;
  cursor: pointer;
  height: 15px;
  z-index: 1;
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
}

@font-face {
  font-family: 'KEEPT___'; 
  src: url('@/assets/fonts/KEEPT___.TTF') format('truetype');
}


</style>