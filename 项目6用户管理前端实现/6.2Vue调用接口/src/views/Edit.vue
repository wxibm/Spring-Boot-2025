<template>
	<h3>修改用户数据</h3>
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
	<div><button @click="editUser(id.value)">修改</button></div>
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
			document.title = '修改用户数据';
			// 获取URL地址的参数
			let id = this.$route.query.id;
			this.readUsers(id);
		},
		// mounted方法只会在Vue实例的初始化过程中触发一次
		mounted() {
			// // 获取URL地址的参数
			// const params = this.$route.query;
			// console.log(params); // 输出包含所有参数的对象
		},
		// 页面需要用到的方法
		methods: {
			readUsers(id) {
				axios.get(apiUrls.userRead + id)
					.then(response => {
						console.log(id);
						if (response.data.code == 200) {
							this.id = response.data.data.id;
							this.userName = response.data.data.userName;
							this.password = response.data.data.password;
							this.userAvatar = response.data.data.userAvatar;
							this.createDate = response.data.data.createDate;
						} else {
							alert("显示用户失败");
						}
					})
					.catch(error => {
						alert("系统出错" + error);
					});
			},
			editUser(id) {
				axios.put(apiUrls.userUpdate, {
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
							alert("修改用户失败！");
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