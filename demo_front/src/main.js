import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import './assets/common.css'
import store from "@/vuex/store";
import axios from "axios";

const app = createApp(App)

app.config.globalProperties.$axios = axios
app.config.globalProperties.$serverUrl = '//localhost:8080'
app.use(router)
    .use(store)
    .mount('#app')
