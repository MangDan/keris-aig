import Vue from 'vue'
import App from './App.vue'
import './registerServiceWorker'
import router from './router'
import vuetify from './plugins/vuetify'
import axios from 'axios'
import base64 from 'base64-utf8'

axios.defaults.baseURL = 'http://140.238.7.121:8000'
axios.defaults.headers.post["Content-Type"] = "application/json";
axios.defaults.headers.get["Content-Type"] = "application/json";

// Axios에서 DefaultURL 외에 여러개 URL등록할 때 이런식으로 사용....
// 호출할때는 this.$detection...
const detection = axios.create({
  baseURL: 'http://132.145.90.23:11975',
  //baseURL: 'http://221.163.201.60:11715',
  headers: {
    'Content-Type': 'multipart/form-data'
  }
});

const generation = axios.create({
  baseURL: 'http://132.145.90.23:11976',
  //baseURL: 'http://221.163.201.60:11716',
  headers: {
    'Content-Type': 'multipart/form-data'
  }
});

const iscream = axios.create({
  //baseURL: 'http://cms.aimath.home-learn.com',
  baseURL: 'http://132.145.90.23:11720',
  headers: {
    'Content-Type': 'multipart/form-data'
  }
});

const local = axios.create({
  baseURL: ''
});

Vue.prototype.$detection = detection;
Vue.prototype.$generation = generation;
Vue.prototype.$iscream = iscream;
Vue.prototype.$local = local;

Vue.config.productionTip = false

Vue.prototype.$EventBus = new Vue();
Vue.prototype.$axios = axios;
Vue.prototype.$base64 = base64;

new Vue({
  router,
  vuetify,
  render: h => h(App)
}).$mount('#app')