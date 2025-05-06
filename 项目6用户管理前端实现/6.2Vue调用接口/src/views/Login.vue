<template>
	<h3>登录</h3>
	<div><label>账户:
			<input v-model="userName" /></label>
	</div>
	<div><label>密码:
			<input v-model="password" type="password" /></label>
	</div>
	<div><button @click="login()">登录</button></div>
</template>

<script>
	import axios from 'axios';
	import apiUrls from '../api/common';

	export default {
		data() {
			return {
				userName: 'admin',
				password: '11111'
			};
		},
		created() {
			document.title = '用户登录';
		},
		mounted() {},
		methods: {
			login() {
				axios.post(apiUrls.userLogin, {
						userName: this.userName,
						password: this.password
					})
					.then(response => {
						if (response.data.code == 200) {
							alert(response.data.msg);
							localStorage.setItem("token",response.data.token);
							this.$router.push("/news");
						} else
							alert(response.data.msg);
					})
					.catch(error => {
						alert("系统出错" + error);
					});
			}
		}
	};
</script>

<style>
</style>