<template>
  <form @submit.prevent="saveRecordInfo">
      <span class="input-title">Notes:</span>
      <textarea v-model="newNotes" name="user-notes" id="" cols="50" rows="10"></textarea>
      <div class="tags-div">
        <div class="input-tags" >
            <input v-model="newTag" placeholder="Add a tag..." @keydown.enter.prevent="addTag">
            <font-awesome-icon class="add-tag" icon="fa-solid fa-arrow-right" @click="addTag"/>
            <!-- <div class="add-tag" @click="addTag">
                <font-awesome-icon icon="fa-solid fa-plus"/>
                <span>Add tag</span>
            </div> -->
        </div>

        <div class="display-tags">
            <span class="input-title">Tags:</span>
            <span v-for="(tag, index) in newTags" :key="index" class="tag-to-add"> {{tag}} <font-awesome-icon icon="fa-regular fa-circle-xmark" @click="cancelTag(index)"/></span>

        </div>
      </div>
      
        
      

      <select v-model="condition" class="condition">
          <option disabled value="">--Select a Condition--</option>
          <option value="Mint">Mint</option>
          <option value="Near Mint">Near Mint</option>
          <option value="Very Good">Very Good</option>
          <option value="Good">Good</option>
          <option value="Fair">Fair</option>
          <option value="Poor">Poor</option>
      </select>
      <button type="submit" >Save</button>
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
        newTag: "",
        newTags: []
    }
},
methods: {
    saveRecordInfo() {
        this.recordDTO.userNotes = this.newNotes;
        this.recordDTO.tags.push(...this.newTags);
        this.recordDTO.condition = this.condition;
        RecordService.updateRecordInfo(this.recordDTO).then(response => {
            if(response.status === 200){
               this.recordDTO = response.data
               alert("Record Updated") 
               this.$emit("hideForm")
            }
        }).catch(()=> {
            alert("An error occured updating this record's information")
        })
    },
    addTag() {
        if(this.newTag !== "") {
            this.newTags.push(this.newTag) 
            this.newTag = "";
        } else {
            alert("Cannot add an empty tag")
        }
    },
    cancelTag(tagIndex) {
        this.newTags.splice(tagIndex, 1);
    }
  
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
    width: 100%;
    color: #eff13f;
    background-color: #40c5a4f6;
    border-radius: 5px;
    height: 90%;
}
textarea {
    width: 97%;
    border-radius: 5px;
    align-self: center;
}
button {
    width: 10%;
    margin: 5px;
}
.add-tag {
    border:#eff13f 2px solid;
    border-radius: 15px;
    margin-left: 5px;
}
.add-tag:hover {
    color: #e2e475;
    border-color:#e2e475;
}
.input-title {
    margin-left: 15px;
}
.tags-div {
    display: flex;
    width: 97%;
    margin: 10px 5px 10px 5px
}

.input-tags {
    display: flex;
    align-items: center;
}
.input-tag {
    width: 40%;
}
.display-tags{
    flex-basis: 100%;
    display: flex;
    flex-wrap: wrap;
    align-items: center;
}
.tag-to-add {
    color: #40c5a4f6;
    background-color: #eff13f;
    border-radius: 15px;
    padding: 2px 10px 2px 10px;
    margin: 2px 5px 2px 5px
}
.condition {
    width: 40%;
    margin: 10px 10px 10px 5px;
}
</style>