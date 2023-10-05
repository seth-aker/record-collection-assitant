<template>
  <div id="register" class="text-center">
    <form @submit.prevent="register">
    <div>

    </div>
  
      <h2 class="gradient-text">Create Account</h2>
      <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="form-input-group">
        <label for="username">Username:</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password:</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <div class="form-input-group">
        <label for="confirmPassword">Confirm Password:</label>
        <input type="password" id="confirmPassword" v-model="user.confirmPassword" required />
      </div>

       <div id="get-premium" class="form-input-group">
        <label>
           
         Sign me up for Sleeves Premium!<input type="checkbox" id="premiumCheckbox" v-model="user.premium" @change="togglePremium" />
         
        </label>
      </div>

      <div class="create-account-button">
      <button @click="showPopup = true" type="submit">Create Account</button>

      </div>
      <p><router-link :to="{ name: 'login' }">Already have an account? Log in.</router-link></p>
    
    </form>
    </div>

  
</template>

<script>

import authService from '../services/AuthService';


export default {
  name: 'register',
  components: {

  },
   
  data() {
    return {
       showPopup: false,
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
        premium: '',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    togglePremium() {
     const premium = this.user.premium;
  this.$store.dispatch('setPremium', premium);
    },
    
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
         console.log('premium in register:', this.user.premium); 
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>
@import url('https://fonts.cdnfonts.com/css/keep-on-truckin-2');

input#premiumCheckbox{
  display: inline-block;
 align-items: center; 
}

#flex-display{
  display: flex;
  justify-content: center;
  align-items: center;
}

form {
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  border-color:  #40c5a4 ;
  padding-left: 9px; padding-right: 9px;
  border-width: 20px;
  border-style:ridge;
   background: linear-gradient(180deg, rgba(239,241,63,0.7203256302521008) 37%, rgba(64,197,164,1) 100%);
  border-radius: 15px;
}

div#get-premium.form-input-group{
  display: flex;
  justify-content: space-evenly;
}

.form-input-group {
  display: flex;
  justify-content: space-between;
  padding-top: 15px;
  font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
  color:#F8E73B;
}

label {
  margin-right: 0.5rem;
}



h2{
  display: flex;
  justify-content: center;
  align-items: center;
      font-family: 'KEEPT___'; 
  src: url('@/assets/fonts/KEEPT___.TTF') format('truetype');
  font-size: 40px;
 color: #F8E73B;
 -webkit-text-stroke:0.5px  #9709aa;

}

#register {
display: flex;
justify-content: center;
align-items: top;
min-height: 100vh;
margin-top: 200px;

}

#form-input{
  justify-content: center;
  display: flex; flex-flow: column nowrap;
}

.create-account-button{
  display: flex 1;
 justify-content: center;
  align-items: center;
  padding-top: 20px;
}


.username{
   color:#F8E73B;
}


div.create-account-button{
  display: flex;
}


section{
  display: inline-block;
}
.premiumCheckbox{
  display: flex;
}

p{
  display: flex;
  justify-content: center;
}

button{
  display: inline-flex;
}
.get-premium{
  display: flex;
align-items: center;
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

