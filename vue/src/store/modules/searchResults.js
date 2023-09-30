const state = () => ({
    search: '',
    curPage: 1,
    searchType: 'release'
})

const getters = {

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