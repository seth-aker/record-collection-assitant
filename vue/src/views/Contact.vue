<template>
  <div>
    <h2>MEET THE SLEEVES TEAM!</h2>
    
    <div class="linkedin-profiles">
      <div class="profile">
        <img src="kirby.jpg" alt="Kirby Moore">
        <a href="https://www.linkedin.com/in/kirby-moore/" target="_blank">Kirby Moore</a>
      </div>
      
      <div class="profile">
        <img src="image.jpg" alt="Seth Aker">
        <a href="https://www.linkedin.com/in/sethaker" target="_blank">Seth Aker</a>
      </div>
      
      <div class="profile">
        <img src="john.jpg" alt="John Joyce">
        <a href="https://www.linkedin.com/in/johnjoyc/" target="_blank">John Joyce</a>
      </div>
      
      <div class="profile">
        <img src="joshua.jpg" alt="Joshua Janosek">
        <a href="https://www.linkedin.com/in/joshuajanosek" target="_blank">Joshua Janosek</a>
      </div>
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