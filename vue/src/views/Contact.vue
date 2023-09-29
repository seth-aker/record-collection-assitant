<template>
  <div>
    <h2>CONTACT THE SLEEVES TEAM!</h2>
    
    
    <div class="linkedin-profiles">
      <a href="https://www.linkedin.com/in/kirby-moore/" target="_blank">Kirby Moore</a><br>
      <a href=" " target="_blank">LinkedIn Profile 2</a><br>
      <a href=" " target="_blank">LinkedIn Profile 3</a><br>
      <a href=" " target="_blank">Linkedin Profilek</a><br>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Contact',
}
</script>

<style>
h2 {
  font-size: 30px;
  font-family: "KEEPT___", Arial, sans-serif;
  color: #eff13f;
  margin-top: 20px;
  display: flex;
  align-content: center;
  justify-content: center;
  padding-top: 200px;
}

.linkedin-profiles {
  font-size: 16px;
  display: flex;
  align-content: top;
  justify-content: center;
  padding-top: 200px;
  min-height: 100vh;
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