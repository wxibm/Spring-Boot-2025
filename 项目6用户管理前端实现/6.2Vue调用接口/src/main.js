import {
	createApp
} from 'vue'
import App from './App.vue'
// 下面这句为新增的，所以需要use(router)
import router from './router'
createApp(App).use(router).mount('#app')
// createApp(App).mount('#app')