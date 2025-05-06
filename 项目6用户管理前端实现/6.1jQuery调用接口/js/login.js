$(document).ready(function() {
	$("#btn_login").click(function() {
		check();
	});
});

function check() {
	$.ajax({
		type: "POST",
		url: path.userLogin,
		dataType: "JSON",
		contentType: "application/json;charset=utf-8",
		data: JSON.stringify({
			userName: txt_userName.value,
			password: txt_password.value
		}),
		success: function(json) {
			if (json.code == 200) {
				alert(json.msg);
				//保存token
				localStorage.setItem("token",json.token);
				location.href = "news.html";
			} else {
				alert(json.msg);
			}
		},
		error: function() {
			alert(txt_userName.value);
			alert(txt_password.value);
			alert("系统出错!");
		}
	});
}