const state = () => ({
    search: '',
    curPage: 1,
    searchType: 'release',
    searchResultsRecords: [],
    resultsPerPage: 25,
    maxPages: 0,
    genre: ""
})

const getters = {
    searchQuery(state) {
        let q = `q=${state.search}&type=${state.searchType}&per_page=${state.resultsPerPage}`;
        if(state.curPage != 1) {
            q += `&page=${state.curPage}`;
        }
        if(state.genre != null) {
            q += `&genre=${state.genre}`
        }
        return q;
    },
   
    
}

const actions = {

}

const mutations = {
    SET_CUR_PAGE(state, pageNum) {
        state.curPage = pageNum;
      },
    UPDATE_PER_PAGE(state, perPage) {
        state.resultsPerPage = perPage
    },
    UPDATE_SEARCH(state, term) {
        state.search = term;
      },
    SET_SEARCH_RESULTS_RECORDS(state, records) {
        state.searchResultsRecords = records;
    },
    SET_MAX_PAGES(state, maxPages) {
        state.maxPages = maxPages;
    },
    SET_GENRE_SEARCH(state, genre) {
        state.genre = genre;
    }
}

export default {
    namespaced: false,
    state,
    getters,
    actions,
    mutations,
    modules: {}
}