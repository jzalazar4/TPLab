/* eslint-disable vue/multi-word-component-names 

import router from 'ej-libros/src/components/routes/routes.js';
//require('./bootstrap');
import vue from 'vue';
window.Vue = vue;
import App from 'ej-libros/src/App.vue';

// Axios
import VueAxios from 'vue-axios';
import axios from 'axios';

// Vue-router
import VueRouter from 'vue-router';
import { routes } from './components/routes/routes.js';

vue.use(VueRouter);
vue.use(VueAxios, axios);

const router = new VueRouter({
  mode:'history',
  routes
});

const app = new vue({
  el:'#app',
  router,
  render: h => h(App)
});
const router = createRouter({

  history: createMemoryHistory(),
  routes : routes
});

const app = createApp(App)
app.use(router)
app.mount('#app')
/*
new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
//import Vue from 'vue';
import App from 'ej-libros/src/App.vue';
import { createMemoryHistory, createRouter }  from 'vue-router';
import axios from 'axios';
import { routes } from './routes/routes';


// Configuración de Axios para que las solicitudes tengan la base URL del backend
// Reemplaza con la URL de tu backend
axios.defaults.baseURL = 'http://localhost:8082/libros'; 
// Configuración de Vue Router
//const { createApp } = Vue
;*
createApp(App).mount('#app');*/

import { createApp } from 'vue'
import App from './App.vue'

import router from './routes/routes.js'
import * as axios from 'axios'
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap"
import Vuelidate from 'vuelidate'
//const axiosInstance = axios.create({ timeout: 15000 })

axios.default.baseURL = 'http://localhost:8082/'; 
createApp(App).use(router).mount('#app')
//createApp(App).use(router).mount('#app')
//const app = createApp(RootComponent)

//app.config.globalProperties.$http = new HTTPService();