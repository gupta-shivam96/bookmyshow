import "bootstrap/dist/css/bootstrap.css";
import { createApp } from 'vue'
import App from './App.vue'
import "bootstrap/dist/js/bootstrap.js";
import router from './router/index.js'

createApp(App).use(router).mount('#app')