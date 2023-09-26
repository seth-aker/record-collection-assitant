<template>
  <nav id="menu">
    <ul>
      <li><router-link to="/">HOME</router-link></li>
      <li><router-link to="/about">ABOUT SLEEVES</router-link></li>
      <li><router-link to="/collections">COLLECTIONS</router-link></li>
      <li><router-link to="/register">REGISTER</router-link></li>
      <li><router-link to="/genres">GENRES</router-link></li>
      <li><router-link to="/new-releases">NEW RELEASES</router-link></li>
    </ul>
  </nav>
</template>

<script>
export default {
  name: 'NavBar'
}
</script>

<style scoped>

</style>