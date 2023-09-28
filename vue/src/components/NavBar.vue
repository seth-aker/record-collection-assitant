<template>
  <header>
    <button class="rounded-button">HOME</button>
    <button class="rounded-button">COLLECTIONS</button>
    <button class="rounded-button">CONTACT</button>

    
    <login-button />
  </header>
</template>

<script> 


export default {
  name: "NavBar",
  components: {

  // I took the login button off the nav temporarily!

  },
};
</script>

<style scoped>

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