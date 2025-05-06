<template>
	<h3>添加用户数据</h3>
	<div><label>主键:
			<input v-model="id" /></label>
	</div>
	<div><label>账户:
			<input v-model="userName" /></label>
	</div>
	<div><label>密码:
			<input v-model="password" /></label>
	</div>
	<div><label>头像:
			<input v-model="userAvatar" /></label>
	</div>
	<div><label>时间:
			<input v-model="createDate" /></label>
	</div>
	<div><button @click="addUser()">添加</button></div>
</template>

<script>
	import axios from 'axios';
	import apiUrls from '../api/common';

	export default {
		// 页面需要用到的变量
		data() {
			return {
				id: '',
				userName: '',
				password: '',
				userAvatar: '',
				createDate: ''
			};
		},
		// Vue开始后执行的第二个生命周期函数，在created中，data和methods都已经初始化完成。如果要调用methods中的方法，或者操作data中的数据，最早只能在created中操作！！
		created() {
			document.title = '添加用户数据';
		},
		// mounted方法只会在Vue实例的初始化过程中触发一次
		mounted() {
		},
		// 页面需要用到的方法
		methods: {
			addUser() {
				axios.post(apiUrls.userInsert, {
						id: this.id,
						userName: this.userName,
						// 注意密码的复杂度
						password: this.password,
						userAvatar: this.userAvatar,
						createDate: this.createDate
					})
					.then(response => {
						if (response.data.code == 200) {
							alert(response.data.msg);
							this.$router.push("/");
						} else
							alert("添加用户失败！");
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