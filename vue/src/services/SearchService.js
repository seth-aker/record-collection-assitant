import axios from "axios";

export default {
    
    searchRecords(searchQuery) {
        return axios.get(`/search?${searchQuery}`);
    },

    searchByGenre(searchQuery) {
        return axios.get(`/search?${searchQuery}`)
    }
}