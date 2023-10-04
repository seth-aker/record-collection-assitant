<template>
  <form @submit="saveRecordInfo">
      <textarea v-model="userNotes" name="user-notes" id="" cols="50" rows="10"></textarea>
      <div>Tags:</div>
      <div v-for="(tag, index) in tags" :key="index">{{tag}}</div>
      <input v-model="newTag" placeholder="Add a tag...">
      <font-awesome-icon icon="fa-solid fa-plus" @click="tags.push(newTag)"/>
      
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
      <button>Cancel</button>
  </form>
</template>

<script>
import RecordService from '../services/RecordService'

export default {
name: 'add-record-form',
props: ['recordId'],
data() {
    return {
        recordDTO: {},
        userNotes: "",
        tags: [],
        numOfTags: 1, 
        condition: '',
        newTag: ""
    }
},
methods: {
    saveRecordInfo() {
        this.recordDTO.userNotes = this.userNotes;
        this.recordDTO.tags = this.tags;
        this.recordDTO.condition = this.condition;
        RecordService.updateRecordInfo(this.recordDTO).then(response => {
            if(response.status === 200){
               alert("Record Updated") 
            }
        }).catch(()=> {
            alert("An error occured updating this record's information")
        })
    }
},
created(){
    RecordService.getRecordInfo(this.recordId).then(response => {
        this.recordDTO = response.data;
        this.userNotes = response.data.userNotes;
        this.tags = response.data.tags
        this.condition = response.data.condition;
    })
}
}
</script>

<style scoped>

</style>