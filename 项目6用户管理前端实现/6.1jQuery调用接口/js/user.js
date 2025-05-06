$(document).ready(function() {
	const url = new URL(window.location.href);
	const params = new URLSearchParams(url.search);
	let pageNum = 3;
	let pageSize = 2;
	if (params.size != 0) {
		pageNum = params.get("pageNum");
		pageSize = params.get("pageSize");
	}
	showPageUser(pageNum, pageSize);
	showPage(pageNum, pageSize);
	// showUser();
});

function showUser() {
	$.ajax({
		type: "GET",
		url: path.userList,
		dataType: "JSON",
		success: function(data) {
			//判断数据是否为空,result返回的是一个列表数据，就是js数组
			$("#user").empty(); //清空节点
			if (data.code == 200)
				$.each(data.data, function(i, val) {
					$("#user").append("<li><a href='javascript:alert(" + val.id + ")'>" + val.userName +
						"</a><a href='edit.html?id=" + val.id +
						"'>【修改】</a><a href='javascript:void(0)' onclick=delUser(\'" + val.id +
						"\');>【删除】</a></li>");
				});
			else
				alert("没有成功获取数据");
		},
		error: function() {
			alert("系统出错");
		}
	});
}

function showPageUser(pageNum, pageSize) {
	$.ajax({
		type: "GET",
		url: path.userPage + "?pageNum=" + pageNum + "&pageSize=" + pageSize,
		dataType: "JSON",
		success: function(data) {
			//判断数据是否为空,result返回的是一个列表数据，就是js数组
			$("#user").empty(); //清空节点
			if (data.code == 200)
				$.each(data.data, function(i, val) {
					$("#user").append("<li><a href='javascript:alert(" + val.id + ")'>" + val.userName +
						"</a><a href='edit.html?id=" + val.id +
						"'>【修改】</a><a href='javascript:void(0)' onclick=delUser(\'" + val.id +
						"\');>【删除】</a></li>");
				});
			else
				alert("没有成功获取数据");
		},
		error: function() {
			alert("系统出错");
		}
	});
}

function showPage(pageNum, pageSize) {
	$.ajax({
		type: "GET",
		url: path.userCount,
		dataType: "JSON",
		success: function(data) {
			//判断数据是否为空,result返回的是一个列表数据，就是js数组
			$("#page").empty(); //清空节点
			total = data; //总记录数
			// pageSize=2;//每页显示条数
			// curPage=page;//当前页
			totalPage = Math.ceil(total / pageSize); //总页数
			for (var i = 1; i <= totalPage; i++)
				$("#page").append("<a href='index.html?pageNum=" + i + "&pageSize=" + pageSize + "'>【" + i +
					"】</a>");
			$("#page").append(" " + pageNum + " / " + totalPage);
		},
		error: function() {
			alert("没有成功获取数据");
		}
	});
}

function delUser(id) {
	$.ajax({
		type: "delete",
		url: path.userDelete + "?userId=" + id,
		success: function(json) {
			if (json.code == 200) {
				alert(json.msg);
				location.href = "index.html";
			} else {
				alert("删除用户失败！");
			}
		},
		error: function() {
			alert("系统出错");
		}
	});
}