<template>
  <div class="login-button-container">
    <button class="rounded-button">LOGIN</button>
    <button class="rounded-button">REGISTER</button>
  </div>
</template>

<script>
export default {
  name: "LoginButton",
};
</script>

<style scoped>

.login-button-container {
  display: flex;
  justify-content: flex-end; /* buttons to the right side */
  align-items: center; /* Center vertically */
  margin-top: -45px;
}

.rounded-button {
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
</style>