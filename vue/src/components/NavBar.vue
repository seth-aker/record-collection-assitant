<template>
  <nav>
    <section class="nav-bar-left">
      <div class="dropdown">
        <font-awesome-icon class="fa-icon" icon="fa-solid fa-bars" />
      <!-- <font-awesime-icon icon="fa-solid fa-bars-staggered" v-show="!hideMenu"/> -->
      <ul class="dropdown-options">
          <li class="option" id="home" v-show="$route.path != '/'">
            <router-link :to="{name: 'home'}" class="gradient-text">HOME </router-link>
          </li>
          <li class="option">
            <router-link :to="{name: 'search-page'}" class="gradient-text">SEARCH</router-link>
          </li>
          <li class="option" id="my-collections">
            <router-link :to="{ name: 'user-home', params: { username: $store.state.user.username } }" class="gradient-text">MY COLLECTIONS</router-link>
          </li>
          <li class="option">
             <router-link :to="{ name: 'contact' }" class="gradient-text">CONTACT US</router-link>
          </li>
        </ul>
    </div>
    </section>
    
    
    <!-- <section class="nav-bar-buttons nav-bar-left" v-show="!hideMenu">
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
    </section> -->

<h1 @click="goToHomePage">
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
      
      <font-awesome-icon icon="fa-solid fa-user-circle" class="user-icon rounded-button" v-show="loggedIn" 
              @click="$router.push({name: 'user-home', params: {username: $store.state.user.username}})"/>
    </section>
  </nav>
</template>

<script> 



export default {
  name: "NavBar",
  data() {
    return {
      hideMenu: true
    }
  },
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
    },
    goToHomePage() {
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
   z-index: 1;
   width: 33vw;
   align-items: center;
 }
 
 .fa-icon {
    border: #40c5a4f6 2px solid;
    border-radius: 5px;
    padding: 5px 8px 5px 9px;
    font-size: 40px;
    color: #40c5a4;
 }

 .nav-bar-right {
   display: flex;
   z-index: 1;
 }
.rounded-button {
   border: #40c5a4f6 2px solid;
  border-radius: 5px; /* Rounded corners */
  background-color: #40c5a400; /* Background color */
  padding: 15px; /* Padding for a bigger button */
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
  background-color: #40c5a4f6; /* Darker color on hover */
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
    z-index: 0;
    -webkit-text-stroke:1px #40c5a4f6 ; ; /* width and color */
    cursor: pointer;
  
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
.rounded-button:hover a {
  text-decoration: underline rgb(239,241,63) 2px;;
}
.dropdown {
    padding-left: 35px;
    display: flex;
    flex-direction: column;
    position: relative;
    justify-content: center;
    height: 75px;
}



.dropdown-options {
  visibility: hidden;
  opacity: 0;
  float: left;
  width: 20vw;
  left: 35px;
  top: 56px;
  transition: 150ms ease-in-out;
  display: flex;
  flex-direction: column;
  position: absolute;
  list-style: none;
  background: #40c5a400;
  padding: 0;
  border-radius: 0 20px 20px 20px;
  font-family: 'KEEPT___', Verdana, Geneva, Tahoma, sans-serif;
}

.dropdown:hover .dropdown-options {
  opacity: 1;
  visibility: visible;
  top: 48px;
  background-color: #40c5a4f6;
}

.dropdown:hover .fa-icon{
  background-color: #40c5a4f6; 
  border-radius: 5px 5px 5px 0px;
  color:#eff13f;
}

.option {
 padding: 10px;
}
.option:hover {
  text-decoration: underline rgb(239,241,63) 2px;
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
  height: 35px;
  padding: 4.5px
  
  
}
.gradient-text {
  /* background: linear-gradient(180deg, rgba(64,197,164,1) 0%, rgba(239,241,63,1) 100%); */
  background: linear-gradient(180deg, rgba(239,241,63,1) 38%, rgb(224, 10, 134) 77%);
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