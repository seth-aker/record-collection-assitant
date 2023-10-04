<template>
  <form @submit.prevent="saveRecordInfo">
      <textarea v-model="newNotes" name="user-notes" id="" cols="50" rows="10"></textarea>
      <div>Tags:</div>
      <div v-for="(tag, index) in tags" :key="index">{{tag}}</div>
      <input v-model="newTag" placeholder="Add a tag...">
      <font-awesome-icon icon="fa-solid fa-plus" @click="addTag"/>
      
      <div>Condition: {{ condition }} </div>
      <select v-model="condition">
          <option disabled value="">--Select a Condition--</option>
          <option value="Mint">Mint</option>
          <option value="Near Mint">Near Mint</option>
          <option value="Very Good">Very Good</option>
          <option value="Good">Good</option>
          <option value="Fair">Fair</option>
          <option value="Poor">Poor</option>
      </select>
      <button type="submit">Save</button>
  </form>
</template>

<script>
import RecordService from '../services/RecordService'

export default {
name: 'add-record-form',
props: ['record'],
data() {
    return {
        recordDTO: {},
        userNotes: "",
        newNotes: "",
        tags: '',
        numOfTags: 1, 
        condition: '',
        newTag: ""
    }
},
methods: {
    saveRecordInfo() {
        this.recordDTO.userNotes = this.newNotes;
        this.recordDTO.tags = this.tags;
        this.recordDTO.condition = this.condition;
        RecordService.updateRecordInfo(this.recordDTO).then(response => {
            if(response.status === 200){
               this.recordDTO = response.data
               alert("Record Updated") 
            }
        }).catch(()=> {
            alert("An error occured updating this record's information")
        })
    },
    addTag() {
       this.tags.push(this.newTag) 
       this.newTag = "";
    },
  
},
created(){
    this.recordDTO = this.record;
    this.newNotes = this.record.userNotes;
    this.tags = this.record.tags;
    this.condtiion = this.record.condition;
}
}
</script>

<style scoped>
form {
    display: flex;
    flex-direction: column;
    width: 50vw;

}
</style>