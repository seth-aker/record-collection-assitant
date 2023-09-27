<template>
  <div id="login">
    <form @submit.prevent="login">
      <h1 >Sleeves</h1>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password! Not groovy, man
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please stay groovy
      </div>
      <div class="input-block">
      <div class="form-input-group">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
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
  components: {},
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
            this.$router.push("/");
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

 #main-grid{
    display: grid;
    grid-template-columns: 0.5fr 1fr 0.5fr;
    grid-template-rows: 0.5fr 0.5fr 1fr;
    column-gap: 50px;
    row-gap: 20px;
    grid-template-areas: 
    ". title ."
     ". form-input ."
     ". . .";
align-items: center;
 }

#h1{
  grid-area: title;
}
#input-block{
  grid-area: form-input;
}

.form-input-group{
  display: flex;
  justify-content: space-between;
  padding-top: 15px;
  
}

#login{
 display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  color: EA573B;

}

h1{
  display: flex;
  font-family: 'Keep on Truckin', sans-serif;
  font-size:400%;
  color: #9BDFFC;
  justify-content: center;

}
.sign-in-button{
display: flex;
  justify-content: center;
  align-items: center;
  padding-top: 15px;
}

p{
  display: flex;
  justify-content: center;
  align-items: center;
}

</style>

/**color: #9BDFFC; Sgt peppers sky

 #F8E73B; yellow

#E00A86; purple

#30B4CC; blue

EA573B; orange
**/


