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
    },
    
    addRecordToUserCollection(collectionId, record){
        return axios.post(`/collections/${collectionId}`, record)
    },

    removeRecordFromCollection(collectionId, recordId) {
        return axios.delete(`/collections/${collectionId}/${recordId}`)
    },
    
    createNewCollection(collection, isPublic) {
        return axios.post(`/collections/create/${isPublic}`, collection)
    },

    deleteCollection(collectionId) {
        return axios.delete(`/collections/${collectionId}`)
    }
}