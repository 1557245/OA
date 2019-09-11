/**
 * 用户登录
 */
function login(){
	return dateVerify();
}


/**
 * 验证用户信息
 * @returns {Boolean}
 */
function dateVerify() {
	var account = $("#account").val();
	var password = $("#pwd").val();
	
	if (account == '' || account==null) {
		alert("帐号不允许为空！");
		return false;
	}
	var accountVer = /^((1[3|4|5|7|8][0-9]{1})+\d{8})$/;
	if (!accountVer.test(account)) {
		alert("请输入正确的账号！");
		return false;
	}
	if (password == '' || password==null) {
		alert("密码不允许为空！");
		return false;
	}
	return true;
}

$(function(){
	$("#msg").click(function(){
	alert("heiheihie");
	var account = $("#account").val();
	var password = $("#pwd").val();
	$.ajax({
		url:"user/tlogin",
		type:"post",
		data:{
			taccount:account,
			tpassword:password
		},
		dataType:"json",
		success:function(data){
			alert("jdjdjd");
			if($.trim(data)){
				alert(data);
				return false;
			}
		}
	})
})
})
