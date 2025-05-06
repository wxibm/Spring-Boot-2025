<template>
	<h3>显示用户新闻</h3>
	<ul>
		<li v-for="New in news" :key="New.newsId">
			<a href="javascript:void(0)">{{ New.newsTitle }}</a>
		</li>
	</ul>
</template>

<script>
	import axios from 'axios';
	import apiUrls from '../api/common';

	export default {
		// 页面需要用到的变量
		data() {
			return {
				news: []
			};
		},
		// Vue开始后执行的第二个生命周期函数，在created中，data和methods都已经初始化完成。如果要调用methods中的方法，或者操作data中的数据，最早只能在created中操作！！
		created() {
			document.title = "显示用户新闻";
			this.fetchUserNews();
		},
		mounted() {},
		// 页面需要用到的方法
		methods: {
			fetchUserNews() {
				axios.get(apiUrls.userNews, {
						headers: {
							"token": localStorage.getItem("token")
						}
					})
					.then(response => {
						if (response.data.code == 200) {
							alert(localStorage.getItem("token"));
							this.news = response.data.data;
						} else
							alert("没有成功获取数据");
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