import axios from "axios";

export default {

    getRecordInfo(recordId) {
        return axios.get(`/records/${recordId}`)
    },

    addRecordToUserLib(record){
        return axios.post('/records', record);
    },

    deleteRecordFromUserLib(record) {
        return axios.delete('/records', record);
    },

    updateRecordInfo(record) {
        return axios.put('/records', record);
    },

    searchRecords(searchQuery) {
        return axios.get(`/records/search?q=${searchQuery}`);
    }

}