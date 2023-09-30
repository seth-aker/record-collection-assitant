import axios from "axios";

export default {

    getCollection(collectionId) {
        return axios.get(`/collections/${collectionId}`)
    },

    getPublicCollections() {
        return axios.get('/collections/public')
    },

    getUserCollections(userName) {
        return axios.get(`/collections/users?name=${userName}`)
    },

    

    
}