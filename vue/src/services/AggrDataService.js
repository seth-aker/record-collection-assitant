import axios from 'axios';

export default{


   getDataStats() {
        return axios.get(`/site-stats`)
    },

    


}    