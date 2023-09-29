<template>

   <b-modal v-model="showPopup" title="Sleeves Premium Just for You!">
   <p> Would you like to try 1 free month of Sleeves Premium?</p>
    <button @click="isPremium(true)">Yes</button>
    <button @click="isPremium(false)">No</button>
   </b-modal>
   
</template>

<script>
export default {
    name: 'Premium-Subscribe',
    data(){
return {
    showPopup: false,
};
    },

// TODO: fix this method to submit isPremium status
    methods: {
        isPremium(){
        this.showPopup = false;

        return this.user.isPremium
        },
        // saveChoice(){
        //       axios.post
        // }
    }

}
</script>

<style>
button{
  
}

</style>