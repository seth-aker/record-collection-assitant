<template>
    <div  class="collection-name" @click="addToCollection" >
        <slot/>
    </div>
</template>

<script>
import recordService from '../services/RecordService.js'
import CollectionService from '../services/CollectionService'

export default {
    name: 'CollectionDropdownItem',
    props: ['recordInfo', 'collection'],
    data() {
        return {

        }
    },
    methods: {
        addToCollection() {
        recordService.getRecordInfo(this.recordInfo.id).then(response => {
          CollectionService.addRecordToUserCollection(this.collection.id, response.data).then(resp => {
            if(resp.status === 201) {
              this.recordAdded = true
              alert("Collection added successfully.");
            }
          }).catch( () => {
            alert("Oops! Something went wrong and the record was not added to your library")
          })
        })
        
    }
    }
}
</script>

<style scoped>
.collection-name {
  font-family: "KEEPT___", Arial, sans-serif;
  color: #40c5a4;
  -webkit-text-stroke:1px #eff13f ;
  font-size: 1.1rem;
  margin-top: 3px;
  z-index: 1;
  position :relative;
  border: #eff13f solid 1px;
  border-radius: 5px;
  right: 90px;
  
  
  background-color: rgb(224, 10, 134); 
  cursor: pointer;
  padding: 3px;
}

.collection-name:hover {
   background-color: rgb(160, 43, 111); 
}
</style>