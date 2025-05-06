import {
	createRouter,
	createWebHistory
} from 'vue-router';

import Home from '../views/Home.vue'

const router = createRouter({
	routes: [{
			// 路径，/ 表示首页
			path: '/',
			// 使用组件（方式一）
			component: Home,
		},
		{
			path: '/add',
			component: () => import('../views/Add.vue')
		},
		{
			path: '/edit',
			component: () => import('../views/Edit.vue')
		},
		{
			path: '/login',
			component: () => import('../views/Login.vue')
		},
		{
			path: '/news',
			component: () => import('../views/News.vue')
		},
	],
	history: createWebHistory()
})
export default router;