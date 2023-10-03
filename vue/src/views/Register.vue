<template>
  <div id="register" class="text-center">
    <form @submit.prevent="register">
    <div>

    </div>
      <h2>Create Account</h2>
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
   
   <section id="get-premium"><p>Sign me up for one free month of Sleeves Premium!</p>
    <input type="checkbox" id="premiumCheckbox" v-model="user.isPremium" @change="togglePremium">
</section>
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
        isPremium: '',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    togglePremium() {
     const isPremium = this.user.isPremium;

 console.log('isPremium in togglePremium:', isPremium);
 
  this.$store.dispatch('setIsPremium', isPremium);
    },
      // if (isPremium) {
         
       
      // } else {
        
         
      // }
   },

    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
         console.log('isPremium in register:', this.user.isPremium); 
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

.form-input-group {
  display: flex;
  justify-content: space-between;
  padding-top: 15px;
  font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
  color: white;
}

label {
  margin-right: 0.5rem;
}

h1{
  display: flex;
  justify-content: center;
  font-family: 'Keep on Truckin', sans-serif;
  color:  #F8E73B;
  font-size: 400%;
}

h2{
  display: flex;
  justify-content: center;
  color: #F8E73B;
}

#register {
display: flex;
justify-content: center;
align-items: top;
min-height: 100vh;
margin-top: 200px;

}

#form{
  display: flex;
  flex-direction:row;
  
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
#premiumCheckbox{
  display: flex;
}

p{
  display: flex;
  justify-content: center;
}



button{
  display: inline-flex;
}
premium{
  display: flex;
align-items: center;
}


</style>

