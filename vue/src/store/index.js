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
    premium: false,
    trendingCollections: [],
    currentRecord: {},
    dataStats:{},
    topTenRecords:{},
    topTenArtists:{},
    
    collection:{
      records: []
    }
 
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
    SET_IS_PREMIUM(state, premium) {
      state.premium = premium;
    },
    ADD_TO_TRENDING_COLLECTIONS(state, collection) {
      state.trendingCollections.push(collection);
    },
    CLEAR_TRENDING(state) {
      state.trendingCollections = [];
    },
    SET_CUR_RECORD(state, record ) {
      state.currentRecord = record;
    },
    REMOVE_RECORD_FROM_LIBRARY(state, recordId) {
      state.userLibrary = state.userLibrary.filter( record => {
        return record.id != recordId;
      })
    },
    REMOVE_COLLECTION_FROM_COLLECTIONS(state, collectionId) {
      state.userCollections = state.userCollections.filter( coll => {
        return coll.id != collectionId;
      })
    },
    ADD_RECORD_TO_LIBRARY(state, record) {
      state.userLibrary.push(record);
    },
    ADD_COLLECTION_TO_COLLECTIONS(state,collection) {
      state.userCollections.push(collection);
    },
    SET_DATA_STATS(state, stats){
      state.dataStats=stats;
    },
    SET_TOP_TEN_RECORDS(state, record){
      state.topTenRecords = record;
    },
    REMOVE_RECORD_FROM_COLLECTION(state, collection) {
      const newUserCollections = state.userCollections.filter( coll => {
        return coll.id != collection.id;
      });
      newUserCollections.push(collection);
      state.userCollections = newUserCollections;
    },

    SET_TOP_TEN_ARTISTS(state, topArtists) {
      state.topTenArtists = topArtists;
    }
  },
  getters: {
    memberCount(state){
      return state.dataStats.memberCount;
    },
    recordCount(state){
      return state.dataStats.recordCount;
    },
    avgRecordPerCollection(state){
      return state.dataStats.avgRecordPerCollection;
    },
    mostActiveUser(state){
    return state.dataStats.avgRecordPerCollection;
    },
    premiumCount(state){
      return state.dataStats.premiumCount;
    },
    collectionCount(state){
      return state.dataStats.collectionCount;
    },
    topTenArtists(state){
      return state.dataStats.topTenArtists;
    },
  }
  
  });
