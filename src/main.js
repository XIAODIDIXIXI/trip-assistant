import { createApp } from 'vue'
import 'vant/lib/index.css'
import './assets/styles/global.css'
import App from './App.vue'
import router from './router'

const app = createApp(App)
app.use(router)
app.mount('#app')
