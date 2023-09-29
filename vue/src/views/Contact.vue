<template>
  <div>
    <h2>MEET THE SLEEVES TEAM!</h2>
    
    <div class="linkedin-profiles">
<<<<<<< HEAD
      <a href="https://www.linkedin.com/in/kirby-moore/" target="_blank">Kirby Moore</a><br>
      <a href="https://www.linkedin.com/in/sethaker" target="_blank">Seth Aker</a><br>
      <a href=" " target="_blank">LinkedIn Profile 3</a><br>
      <a href=" " target="_blank">LinkedIn Profile 4</a><br>
=======
      <div class="profile">
        <img src="image.jpg" alt="Profile Image 1">
        <a href="" target="_blank">Name</a>
      </div>
      
      <div class="profile">
        <img src="image.jpg" alt="Profile Image 2">
        <a href="" target="_blank">Name</a>
      </div>
      
      <div class="profile">
        <img src="image.jpg" alt="Profile Image 3">
        <a href="" target="_blank">Name</a>
      </div>
      
      <div class="profile">
        <img src="kirby.jpg" alt="Profile Image 4">
        <a href="https://www.linkedin.com/in/kirby-moore/" target="_blank">Kirby Moore</a>
      </div>
>>>>>>> f334d8de21cf323cb805aa08808d61ef5a0a1aba
    </div>
  </div>
</template>

<script>
export default {
  name: 'Contact',
}
</script>

<style scoped>
h2 {
  font-size: 30px;
  font-family: "KEEPT___", Arial, sans-serif;
  color: #eff13f;
  margin-top: 200px;
  text-align: center; /* Center the text */
  display: flex;
  justify-content: center;
}

.linkedin-profiles {
  display: flex;
  flex-wrap: wrap; /* Allow profiles to wrap to the next line if there's not enough space */
  justify-content: center;
  margin-top: 100px;
  min-height: 100vh;
}

.profile {
  text-align: center; /* Center the profile image and name */
  margin: 20px; /* Add spacing between profiles */
}

.profile img {
  width: 160px; /* Set a fixed width for the profile images */
  height: 160px; /* Set a fixed height for the profile images */
  border-radius: 50%; /* Make the images round */
  display: flex;
}

.linkedin-profiles a {
  text-decoration: none;
  color: #40c5a4;
  font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
  font-size: 25px;

}

.linkedin-profiles a:hover {
  text-decoration: underline;
}
</style>