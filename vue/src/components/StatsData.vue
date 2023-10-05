<template>


<div>
{{ this.$store.state.dataStats.recordCount }}
</div>
</template>

<script>


 import dataStats from '../services/dataStats.js'
export default {

   name: "data-stats",
data(){
   
    return{
            stats:[
                  

         ] 
    }
},
    created(){
        // this.isloading = true;
            dataStats.getDataStats()
                .then(response => {
             this.$store.commit('SET_DATA_STATS', response.data);
        //    this.isLoading = false;
        });

        }

}      
    



</script>

<style>
</style>