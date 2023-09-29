import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    allReleases: [],

    publicCollections: [],
    userLibrary: [],
    userCollections: [],
    totalReleases: 0,
    curPage: 1,
    curPageReleases: [],
    totalCollections: 0,
    curPageCollections: [],
    search:'',
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    SET_ALL_RELEASES(state, data) {
      state.allReleases = data;
    },
    SET_PUBLIC_COLLECTIONS(state, data) {
      state.publicCollections = data;
    },
    SET_USER_LIBRARY(state, data) {
      state.userLibrary = data;
    },
    SET_USER_COLLECTIONS(state, data) {
      state.userCollections = data;
    },
    SET_TOTAL_RELEASES(state, count) {
      state.totalReleases = count;
    },
    SET_CUR_PAGE(state, pageNum) {
      state.curPage = pageNum;
    },
    SET_CUR_PAGE_RELEASES(state, releases) {
      state.curPageReleases = releases;
    },
    SET_TOTAL_COLLECTIONS(state, count) {
      state.totalCollections = count;
    },
    SET_CUR_PAGE_COLLECTIONS(state, collections) {
      state.curPageCollections = collections;
    },
    UPDATE_SEARCH(state, term) {
      state.search = term;
      state.curPage = 1;
    }
  }
})
