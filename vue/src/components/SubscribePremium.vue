<template>

    <div class="subscribe-premium-serve">
      <span class="close" @click="closePopup">&times;</span>
      <p>Would you like to to enjoy 1 free month of Sleeves Premium?</p>
      <button @click="becomePremium(true)">Yes</button>
      <button @click="becomePremium(false)">No</button>
    </div>
</template>

<script>
export default {
    name: 'Premium-Subscribe',
    data(){
return {
    showPopup: false,
}
    },
    methods: {
openPopup(){
  this.showPopup = true;
},
closePopup(){
  this.showPopup = false;
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


