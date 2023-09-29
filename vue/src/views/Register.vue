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
      <div class="create-account-button">
      <button @click="showModal = true" type="submit">Create Account</button>
<subscribe-premium-vue />
      </div>
      <p><router-link :to="{ name: 'login' }">Already have an account? Log in.</router-link></p>
    </form>
  </div>
</template>

<script>
import SubscribePremiumVue from '../components/SubscribePremium.vue';
import authService from '../services/AuthService';


export default {
  name: 'register',
  components: {
SubscribePremiumVue,
  },
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
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
align-items: center;
padding-top: 70px;
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

p{
  display: flex;
  justify-content: center;
  align-items: center;
}

.username{
   color:#F8E73B;
}


</style>

