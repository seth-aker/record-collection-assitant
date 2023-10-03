import axios from "axios";

export default {

    getCollection(collectionId) {
        return axios.get(`/collections/${collectionId}`)
    },

    getPublicCollections() {
        return axios.get('/collections/public')
    },

    getUserCollections() {
        return axios.get(`/collections/my-collections`)
    },

    getTrendingCollections(numOfCollections) {
        return axios.get(`/collections/public/${numOfCollections}`)
    }

    
}