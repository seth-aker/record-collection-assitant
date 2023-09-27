<template>
  <header class="right-section">
    <div class="login-container">
      <input type="text" class="login-input" id="login-input" placeholder="Login">
      <input type="password" class="login-input" id="password-input" placeholder="Password">
      <!-- Register button -->
      <button class="register-button" id="register-button">Register</button>
    </div>
    <h1>SLEEVES</h1>
  </header>
</template>

<script>
export default {
  name: 'Header',
};
</script>

<style scoped>

.login-container {
  display: flex;
  justify-content: flex-end;
  align-items: center;
  gap: 10px;
}

.login-input {
  width: 100px; 
  padding: 5px;
}

.register-button {
  background-color: #007bff; 
  color: #fff; 
  padding: 5px 10px;
  border: none;
  cursor: pointer;
}

header {
    color: #fff;
    padding: 10px;
    text-align: center;
    position: absolute;
    left: 0;
    right: 0;
    top: 0;
}

h1 {
    font-size: 130px;
    font-family: "KEEPT___", Arial, sans-serif;
    color: #00d4ff;
}

@font-face {
  font-family: 'KEEPT___'; 
  src: url('@/assets/fonts/KEEPT___.TTF') format('truetype');
}

</style>