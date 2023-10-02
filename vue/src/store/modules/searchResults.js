const state = () => ({
    search: '',
    curPage: 1,
    searchType: 'release',
    searchResultsRecords: [],
    resultsPerPage: 25
})

const getters = {
    searchQuery(state) {
        return `q=${state.search}&type=${state.searchType}&per_page=${state.resultsPerPage}`;
    },
    
}

const actions = {

}

const mutations = {
    SET_CUR_PAGE(state, pageNum) {
        state.curPage = pageNum;
      },
    UPDATE_SEARCH(state, term) {
        state.search = term;
        state.curPage = 1;
      },
    SET_SEARCH_RESULTS_RECORDS(state, records) {
        state.searchResultsRecords = records;
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