import axios from "axios";

export default {

    addRecordToUserLib(record){
        return axios.post('/record', record);
    },

    deleteRecordFromUserLib(record) {
        return axios.delete('/record', record);
    },

    updateRecordInfo(record) {
        return axios.put('/record', record);
    },

    
}