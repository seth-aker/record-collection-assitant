import axios from "axios";

export default {

    getRecordInfo(recordId) {
        return axios.get(`/records/${recordId}`)
    },

    addRecordToUserLib(record){
        return axios.post('/records', record);
    },

    deleteRecordFromUserLib(recordId) {
        return axios.delete(`/records/${recordId}`);
    },

    updateRecordInfo(record) {
        return axios.put(`/records/${record.id}`, record);
    },

    getUserLibrary() {
        return axios.get(`/records`)
    },

    deleteTag(recordId, tagName) {
        return axios.delete(`/records/${recordId}/${tagName}`)
    } 

}