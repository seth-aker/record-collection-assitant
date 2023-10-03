import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'
import SearchResults from './modules/searchResults.js'
Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if (currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  modules: {
    sr: SearchResults
  },
  state: {
    isLoading: true,
    token: currentToken || '',
    user: currentUser || {},
    publicCollections: [],
    userLibrary: [],
    userCollections: [],
    isPremium: false,
  },

  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user', JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
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
    SET_IS_PREMIUM(state, isPremium) {
      state.isPremium = isPremium;
    },

  },
  // actions: {
  //   async setIsPremium({ commit }, isPremium) {
  //     try {
  //       commit('SET_IS_PREMIUM', isPremium);
  //   await axios.post('/register', { isPremium });
    
  //     } catch (error) {
  //       if (error.response) {
  //         console.error('Response Error:', error.response.data);
  //         console.error('Status Code:', error.response.status);
  //       } else if (error.request) {
  //         console.error('Request Error:', error.request);
  //       } else {
     
  //         console.error('General Error:', error.message);
  //       }
  //     }
  // },
  // }
  });
