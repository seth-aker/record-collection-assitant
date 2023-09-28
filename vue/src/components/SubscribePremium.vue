<template>
  <div>
   <form @submit.prevent="handleSubmit">
    Would ypu like to try 1 free month of Sleeves?
       <div>
      <input
        type="radio"
        id="yes"
        value="yes"
        v-model="premiumSubscribe"
      />
      <label for="yes">Yes</label>
      <input
        type="radio"
        id="no"
        value="no"
        v-model="isPremium"
      />
      <label for="no">No</label>
    </div>
      <button type="submit">Submit</button>
    </form>
  </div>
</template>

<script>
export default {
    name: 'Premium-Subscribe',
    data(){
return {
    isPremium: false,

};
    },

// TODO: fix this method to submit isPremium status
    methods: {
        submitForm(){

        return this.user.isPremium
        }
    }

}
</script>

<style>

</style>