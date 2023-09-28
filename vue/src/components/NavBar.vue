<template>

<div>
        <login-button-vue />
</div>
</template>

<script> 
import LoginButtonVue from '../components/LoginButton.vue';

export default {

   name: "NavBar",
  components: {
 LoginButtonVue
  
  
  },
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


</style>