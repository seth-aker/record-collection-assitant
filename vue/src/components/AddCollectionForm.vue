<template>
    <form @submit.prevent="createCollection">
        <div>
            <label for="name">Name:</label> <br>
            <input v-model="collection.name" 
            type="text" name="name" id="name" 
            size="10" maxlength="50" required>
        </div>
        <div>
            <input v-model="collection.isPublic" 
            type="checkbox" id="checkbox"/>
            <label for="checkbox">Make Public</label>
        </div>
        <button type="submit">Save</button>
    </form>
</template>

<script>
import CollectionService from '../services/CollectionService'

export default {
name: 'add-collection-form',
data() {
    return {
        collection: {
            name: '',
            isPublic: false},

    }
},
methods: {
createCollection() {
    
    CollectionService.createNewCollection(this.collection)
    .then(resp => {
    if(resp.status === 201){
        this.collection = resp.data;
        alert("Collection created successfully");
        this.$emit("hideForm");
        this.$store.commit("ADD_COLLECTION_TO_COLLECTIONS", this.collection);
        }
    })
    }
}
}
</script>

<style scoped>


</style>