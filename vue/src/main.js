import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import store from './store/index'
import axios from 'axios'
import { library } from '@fortawesome/fontawesome-svg-core'

import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

import { faPlusSquare, faAddressBook, faCircleCheck, faCircleXmark, faSquareMinus} from '@fortawesome/free-regular-svg-icons'
import { faBars, faPlus, faUserCircle} from '@fortawesome/free-solid-svg-icons'

library.add(faPlusSquare, faUserCircle, faBars, faAddressBook, faCircleCheck, faCircleXmark,faSquareMinus, faPlus);

Vue.component('font-awesome-icon', FontAwesomeIcon)

Vue.config.productionTip = false

axios.defaults.baseURL = process.env.VUE_APP_REMOTE_API;

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
