<template>
<div class="nav">
        
        <button class="dropdown"><router-link>Login</router-link></button>
        <router-link :>Register</router-link>
</div>
</template>

<script> 

export default {

  name: "NavBar",

  methods: {
    showHome(){
      this.$router.push({name: 'home'});
    },

  }
};
</script>

<style scoped>
div{
  display: flex;
  position: fixed;

}

.dropdown:hover{

}


</style>