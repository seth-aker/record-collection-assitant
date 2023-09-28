<template>
  <div class="login-button-container">
    <button @click="showLoginPage" id="login" class="rounded-button">&nbsp;&nbsp;LOGIN&nbsp;&nbsp;</button>
   <button @click="showRegisterPage" id="register" class="rounded-button">REGISTER</button>
  </div>
</template>

<script>
export default {
  name: "LoginRegistrationButton",
  
  methods: {
    showLoginPage(){
      this.$router.push('/login');
    },
    showRegisterPage(){
      this.$router.push({name: 'register'});
    }
  }
};




</script>

<style scoped>

.login-button-container {
  display: flex;
  justify-content:flex-end;
  flex-shrink: 1;
   /* buttons to the right side */
  align-items: center; /* Center vertically */
  margin-right: 15px;
}

.rounded-button {
  display: flex;
  border-radius: 20px; /* Rounded corners */
  
  background-color: #40c5a4; /* Background color */
  color: #fff; /* Text color */
  padding: 15px 30px; /* Padding for a bigger button */
  border: none;
  cursor: pointer;
}

.rounded-button:hover {
  background-color: #1e8c72; /* Darker color on hover */
}

.login{
  margin-left: 5px;
}
</style>