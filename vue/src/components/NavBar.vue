<template>
  <nav>
    <section class="nav-bar-buttons nav-bar-left">
      <div id="home" class="rounded-button">
        <router-link :to="{ name: 'home' }" class="gradient-text">HOME</router-link>
      </div>
      <div id="collections" class="rounded-button dropdown">
        <p class="gradient-text">COLLECTIONS</p>
        <ul class="dropdown-options">
          <li class="option" id="public-collections">
            <router-link :to="{ name: 'collection-view', params: { collectionId: 'public' } }" class="gradient-text">PUBLIC COLLECTIONS</router-link>
          </li>
          <li class="option" id="my-collections">

            <router-link :to="{ name: 'user-home', params: { username: $store.state.user.username } }" class="gradient-text">MY COLLECTIONS</router-link>


          </li>
        </ul>
      </div>
      <div id="contact" class="rounded-button">
        <router-link :to="{ name: 'contact' }" class="gradient-text">CONTACT</router-link>
      </div>
    </section>

<h1>
      <font-awesome-icon class="record-icon" icon="fa-solid fa-record-vinyl" />
      <span class="gradient-text2">SLEEVES</span>
    </h1>
    

    <section class="nav-bar-buttons nav-bar-right">
      <div id="login" v-show="!loggedIn" class="rounded-button">
        <router-link :to="{ name: 'login' }" class="gradient-text">LOGIN</router-link>
      </div>
      <div id="registry" v-show="!loggedIn" class="rounded-button">
        <router-link :to="{ name: 'register' }" class="gradient-text">REGISTER</router-link>
      </div>
      <div v-show="loggedIn" class="rounded-button">
        <a @click.prevent="logout" class="gradient-text">LOGOUT</a>
      </div>
      <font-awesome-icon icon="fa-solid fa-user-circle" class="user-icon rounded-button" v-show="loggedIn" />
    </section>
  </nav>
</template>

<script> 



export default {
  name: "NavBar",

  computed: {
    loggedIn() {
       const user = this.$store.state.user;
       return user.username != null;
    },
    
    isPremium: {
      get() {
        return this.$store.state.isPremium;
      },
      set(newValue) {
        this.$store.dispatch('setIsPremium', newValue);
      },
    },
  },
  methods: {
    logout() {
      this.$store.commit('LOGOUT');
      this.$router.push({name: 'home'})
    }
  }
  

}

</script>


<style scoped>

nav {
  display: flex;
  justify-content: space-between;
  height: 160px;
  
}
.nav-bar-buttons {
  display: flex;
  align-items: center;
  padding: 10px 20px;
  
  
}

 .nav-bar-left{
   display: flex;

 }
 

 .nav-bar-right {
   display: flex;
 }
.rounded-button {
  border-radius: 20px; /* Rounded corners */
  background-color: #40c5a400; /* Background color */
  padding: 15px; /* Padding for a bigger button */
  border: none;
  cursor: pointer;
  height: 15px;
  z-index: 1;
  margin: 5px;
  font-family: 'KEEPT___', Verdana, Geneva, Tahoma, sans-serif;
  align-items: center;
  justify-content: center;
  display: flex;

  -webkit-text-stroke:0.5px  black; 
  

}

.rounded-button:hover {
  background-color: #40c5a4; /* Darker color on hover */
-webkit-text-stroke:0.5px black;
opacity: .9;
}


h1 {
    font-size: 130px;
    font-family: "KEEPT___", Arial, sans-serif;
    margin: 0;
    position: absolute;
    top: 0;
    width: 100vw;
    text-align: center;
    

 
    -webkit-text-stroke:1px #40c5a4 ; ; /* width and color */
 
  
}

.record-icon {
  margin-bottom: 8px;
  margin-right: 8px;
  font-size: 90px;
  border: #40c5a4 solid 5px;
  border-radius: 56px;
   background: linear-gradient(180deg, rgba(239,241,63,1) 38%, rgb(224, 10, 134) 77%);
}

.rounded-button a {

  text-decoration: none;
  font-family: 'KEEPT___', Verdana, Geneva, Tahoma, sans-serif;
  font-size: 25px;
  
  
  
 
}

.dropdown {
    display: flex;
    align-items: center;
    flex-direction: column;
    position: relative;
    transition: 250ms border-radius;
}



.dropdown-options {
  visibility: hidden;
  opacity: 0;
  float: left;
  width: 135%;
  left: 0;
  top: 0px;
  transition: 250ms ease-in-out;
  display: flex;
  flex-direction: column;
  position: absolute;
  list-style: none;
  background: #40c5a400;
  padding: 0;
  border-radius: 0 20px 20px 20px;
}

.dropdown:hover .dropdown-options {
  opacity: 1;
  visibility: visible;
  top: 29px
}

.dropdown:hover{
  border-radius: 20px 20px 0 0;
}

.option {
 padding: 10px;

}

#public-collections:hover {
  background-color: #40c5a4;
  border-radius: 0px 20px 0 0;
}

#my-collections:hover {
  background-color: #40c5a4;
  border-radius: 0 0 20px 20px ;
  
}

p{
  padding: 0;
  margin: 0;
  color: #eff13f;
  font-family: 'KEEPT___', Verdana, Geneva, Tahoma, sans-serif;
  font-size: 25px;
  
  
}
.user-icon {
  color: #eff13f;
  height: 25px;
  padding: 10px
  
  
}
.gradient-text {
  background: linear-gradient(180deg, rgba(64,197,164,1) 0%, rgba(239,241,63,1) 100%);
  -webkit-background-clip: text; /* For browser compatibility */
  background-clip: text;
  color: transparent;
  text-decoration: none;
  font-size: 25px;
}

.gradient-text2 {
  background: linear-gradient(180deg, rgba(239,241,63,1) 38%, rgb(224, 10, 134) 77%);
  -webkit-background-clip: text; /* For browser compatibility */
  background-clip: text;
  color: transparent;
  
  


  top: 0;
  width: 100vw;
  text-align: center;
  -webkit-text-stroke: 1px #40c5a4; /* Optional text stroke */
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