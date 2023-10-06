<template>
  <div id="login">
    <form @submit.prevent="login">
      <h2 class="gradient-text">Login</h2>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password! Not groovy, man
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please stay groovy
      </div>
      <div class="input-block">
      <div class="form-input-group">
        <label for="username">Username:&nbsp;</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password: &nbsp;</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>

      <div class="sign-in-button">
      <button id="sign-in-button" type="submit">Sign in</button>
      </div>
      <p>
      <router-link :to="{ name: 'register' }">Need an account? Sign up.</router-link></p>
      </div>
    </form>
  </div>
</template>

<script>

import authService from "../services/AuthService";

export default {
  name: "login",
  components: {
    

  },
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push({name:'home'});
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
@import url('https://fonts.cdnfonts.com/css/keep-on-truckin-2');

form {
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
    padding-left: 42px; padding-right: 42px;
   padding-bottom: 50px;
     border-color: #40c5a4 ;
  border-width: 20px;
  border-style:ridge;
   background: linear-gradient(180deg, rgba(239,241,63,0.7203256302521008) 37%, rgba(64,197,164,1) 100%);
    border-radius: 15px;
}



.form-input-group {
  display: flex;
  justify-content: space-between;
  padding-top: 15px;
  font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
  color:#F8E73B;
}

#login{
 display: flex;
  flex-direction: column;
  justify-content: top;
  align-items: center;
  color:  #F8E73B;
  font-family: Verdana, Geneva, Tahoma, sans-serif;
  min-height: 100vh;
  margin-top: 200px;
}



h2{
  display: flex;
  justify-content: center;
    padding-bottom: -25px;
     font-family: 'KEEPT___'; 
  src: url('@/assets/fonts/KEEPT___.TTF') format('truetype');
  font-size: 50px;
   -webkit-text-stroke:0.5px  #9709aa /*width and color */
  
}


   
.sign-in-button{
display: flex;
  justify-content: center;
  align-items: center;
  padding-top: 20px;
}

p{
  display: flex;
  justify-content: center;
  align-items: center;
  font-family: Verdana, Geneva, Tahoma, sans-serif;
}
button{
  padding-left: 22px;
padding-right: 22px;
}
.username{
  color:#F8E73B
}

.gradient-text { 

  font-family: 'KEEPT___'; 
  src: url('@/assets/fonts/KEEPT___.TTF') format('truetype');
  font-size: 50px;
  -webkit-text-stroke: 0.5px #40c5a4; /* Width and color of the text stroke */
    background: linear-gradient(180deg, rgba(239,241,63,1) 38%, rgb(224, 10, 134) 77%);
  -webkit-background-clip: text; /* Clip the background to the text */
  color: transparent; /* Make the text color transparent to show the gradient */
  display: flex;
  justify-content: center;
  padding-bottom: -25px;
}



</style>


