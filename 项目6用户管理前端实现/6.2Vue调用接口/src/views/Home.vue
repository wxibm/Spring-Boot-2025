<template>
	<h3>所有用户数据</h3>
	<router-link to="/?pageNum=1&pageSize=2">主页</router-link>
	<router-link to="/add">添加</router-link>
	<router-link to="/login">登录</router-link>
	<ul>
		<li v-for="user in users" :key="user.id">
			<a href="javascript:void(0)" @click="fetchId(user.id)">{{ user.userName }}</a>
			<a :href="'/edit?id=' + user.id">编辑</a>
			<router-link :to="{path:'/edit',query:{id:user.id}}">编辑</router-link>
			<a href="javascript:void(0)" @click="delUsers(user.id)">删除</a>
		</li>
	</ul>
	<ul>
		<li v-for="pageUser in pageUsers" :key="pageUser.id">
			<a href="javascript:void(0)" @click="fetchId(pageUser.id)">{{ pageUser.userName }}</a>
			<router-link :to="{path:'/edit',query:{id:pageUser.id}}">编辑</router-link>
			<a href="javascript:void(0)" @click="delUsers(pageUser.id)">删除</a>
		</li>
	</ul>
	<div>
		<span v-for="page in pages" :key="page">
			<router-link :to="{path:'/',query: { pageNum: page,pageSize:pageSize }}"
				@click.native="fetchPageUsers(page, pageSize)">【{{page}}】</router-link>
		</span>
		{{pageNum}}/{{pages}}
	</div>
</template>

<script>
	import axios from 'axios';
	import apiUrls from '../api/common';

	export default {
		// 页面需要用到的变量
		data() {
			return {
				users: [],
				pageUsers: [],
				pages: [],
				pageNum: this.$route.query.hasOwnProperty("pageNum") ? this.$route.query.pageNum : 1,
				pageSize: this.$route.query.hasOwnProperty("pageSize") ? this.$route.query.pageSize : 2,
				// pageSize: this.$route.query.pageSize,
			};
		},
		// Vue开始后执行的第二个生命周期函数，在created中，data和methods都已经初始化完成。如果要调用methods中的方法，或者操作data中的数据，最早只能在created中操作！！
		created() {
			document.title = "所有用户数据";
			// this.fetchUsers();
			// 获取URL地址的参数
			let pageNum = this.$route.query.hasOwnProperty("pageNum") ? this.$route.query.pageNum : 1;
			let pageSize = this.$route.query.hasOwnProperty("pageSize") ? this.$route.query.pageSize : 2;
			this.$router.push("/?pageNum=" + pageNum + "&pageSize=" + pageSize);
			this.fetchPageUsers(pageNum, pageSize);
			this.showPage(pageNum, pageSize);
			// console.log("pageSize="+pageSize);
		},
		// mounted方法只会在Vue实例的初始化过程中触发一次
		mounted() {
			// console.log("mounted");
		},
		// 页面需要用到的方法
		methods: {
			fetchUsers() {
				axios.get(apiUrls.userList)
					.then(response => {
						if (response.data.code == 200)
							this.users = response.data.data;
						else
							alert("没有成功获取数据");
					})
					.catch(error => {
						alert("系统出错" + error);
					});
			},
			fetchPageUsers(pageNum, pageSize) {
				axios.get(apiUrls.userPage + "?pageNum=" + pageNum + "&pageSize=" + pageSize)
					.then(response => {
						if (response.data.code == 200) {
							this.pageUsers = response.data.data;
							this.pageNum = pageNum;
						} else
							alert("没有成功获取数据");
					})
					.catch(error => {
						console.error('系统出错：', error);
					});
			},
			showPage(pageNum, pageSize) {
				axios.get(apiUrls.userCount)
					.then(response => {
						this.pages = Math.ceil(response.data / pageSize); //总页数
					})
					.catch(error => {
						console.error('系统出错：', error);
					});
			},
			fetchId(id) {
				alert(id);
				console.log(id);
			},
			delUsers(id) {
				// axios.delete(url + '?' + new URLSearchParams(params))
				// axios.delete(url, {params: params})
				axios.delete(apiUrls.userDelete, {
						params: {
							userId: id
						}
					})
					.then(response => {
						if (response.data.code == 200) {
							alert(response.data.msg);
							this.fetchUsers();
						} else
							alert("删除用户失败！");
					})
					.catch(error => {
						alert("系统出错" + error);
					});
			}
		}
	};
</script>

<style>
	a {
		margin: 5px;
		text-decoration: none;
	}
</style>