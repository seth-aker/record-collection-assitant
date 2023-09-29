<template>



   <b-modal v-model="showPopup" title="Sleeves Premium Just for You!">
   <p> Would you like to try 1 free month of Sleeves?</p>
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
}
    },


    

// TODO: fix this method to submit isPremium status
        becomePremium(){
        this.closePopup;
        return this.user.isPremium;
        }
        // saveChoice(){
        //       axios.post
        // }
    }

</script>

<style scoped>

  .modal {
  display: none;
  position: fixed;
  z-index: 1;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.4);
  overflow: auto;
}

.modal-content {
  background-color: #fefefe;
  margin: 15% auto;
  padding: 20px;
  border: 1px solid #888;
  width: 50%;
}

.close {
  color: #aaa;
  float: right;
  font-size: 28px;
  font-weight: bold;
  cursor: pointer;
}
</style>


