 // 入口函数  

$(function() {
	// 前端输入非空检查
	$("#btnpublish").click(noticeCheck);
	// 我发布的公告，起始页码
	myPublishNotice(1);
	// 接收到的公告，起始页码
	receivedNotcie(1);
	// 获取所有待审批的公告，起始页码
	getAllWaitedNotice(1);
})

 // 检验通知公告数据
function noticeCheck() {
	var title = $("#title").val();
	var content = $("#content").val();
	var recipinets = $("#recipinet").find("input[type='checkbox']:checked");
	var istrue = 0;
	if (title == '') {
		alert("标题不允许为空");
		return false;
	}
	if (content == '') {
		alert("内容不允许为空！");
		return false;
	}
	for (var i = 0; i < recipinets.length; i++) {
		if (recipinets[i] == true) {
			istrue++;
		}
	}
	if (recipinets.length == 0) {
		alert("请选择接收人");
		return false;
	}

	return true;
}

 // 我的公告
function myPublishNotice(pageNum) {
	$.ajax({
		contentType : "application/json; charset=utf-8",
		type : "post",
		url : "noticeMyPageItem",
		data: JSON.stringify(pageNum),
		dataType : "json",
		success : function(data) {
			var content = "";
			var totalPage=data.totalPage;
			var notice=data.Notice;
			for (var i = 0; i < notice.length; i++) {
				var po = notice[i];
				content += '<tr>' 
						+ '<td>' + po.nid + '</td>' 
						+ '<td>' + po.title + '</td>' 
						+ '<td>' + po.ncontent + '</td>'
						+ '<td>' + isHaveAnnex(po.nstate,po.annex) + '</td>' 
						+ '<td>' + dateFormat(po.publishtime) + '</td>' 
						+ '<td>' + po.fontstate + '</td>' 
						+ '<td>' + isUpdate(po.n_asid, po.nid) + '</td>' 
						+ '</tr>'
			} // <button class="btn btn-primary btn" >下载附件</button>
			$("#publishTable").html(content);
			$("#currentpage").html(pageNum);
			$("#totalpage").html(totalPage);
		},
	})
}
// 发布公告的翻页
$(function() {
	
	$("#nextpage").click(function(){
		var currentpage = parseInt($("#currentpage").html());
		var totalpage = parseInt($("#totalpage").html());
		if(currentpage<totalpage){
			myPublishNotice(currentpage+1);
		}
	});
	$("#prepage").click(function(){
		var currentpage = parseInt($("#currentpage").html());
		var totalpage = parseInt($("#totalpage").html());
		if(currentpage>1){
			myPublishNotice(currentpage-1);
		}
	});
	$("#firstpage").click(function(){
		var currentpage = parseInt($("#currentpage").html());
		var totalpage = parseInt($("#totalpage").html());
		if(currentpage>1){
			myPublishNotice(1);
		}
	});
	$("#lastpage").click(function(){
		var currentpage = parseInt($("#currentpage").html());
		var totalpage = parseInt($("#totalpage").html());
		if(currentpage<totalpage){
			myPublishNotice(totalpage);
		}
	});
})
 // 日期格式化函数 直接取出来的是：2019-09-07T13:56:47.000+0000
function dateFormat(publishTime) {
	var time1 = publishTime.replace('T', ' ');
	var time2 = time1.replace('.000+0000', '');
	return time2;
}

 // 附件有无的操作显示 只有是审批通过的公告才能 有附件操作。首先判断是否有附件
function isHaveAnnex(annexStaues,annex2) {
	if(annex2=='无附件'){
		return '无附件'
	}else{
		if (annexStaues == 1 || annexStaues == 3) {
			return '不可操作'
		} else{
			return '<button onclick="downloadFile(\''+annex2+'\')" class="btn btn-primary btn" >' + '下载' + '</button>'
		}
	}
}
 // 审批界面附件的特殊处理
function isHaveExamAnnex(annex) {
	if(annex=='无附件'){
		return '无附件'
	}else{
			return '<button class="btn btn-primary btn" >' + '下载' + '</button>'
	}
}

// 只有在状态为待审批的时候 才能修改
function isUpdate(nstate, nid) {
	if (nstate == 1) {
		return '<a th:href="@{/noticeDetailPage}" class="btn btn-primary btn" id="updateNotice" onclick="updateNoticePageItem('
				+ nid + ')">' + '修改' + '</a>';
	} else {
		return '不可操作';
	}
}

// 修改 页面 
function updateNoticePageItem(nid) {
	$.ajax({
		contentType : "application/json; charset=utf-8",
		type : "post",
		url : "updateNoticePageItem",
		data : JSON.stringify(nid),
		dataType : "json",
		success : function(data) {
			window.location.href = "noticeDetailPage";
		},
	})
}


// 接收的公告
function receivedNotcie(pageNum1) {
	$.ajax({
		contentType : "application/json; charset=utf-8",
		type : "post",
		url : "myReceivedNotice",
		data: JSON.stringify(pageNum1),
		dataType : "json",
		success : function(data) {
			var contents="";
			var totalpage1=data.receivedTotalPage;
			var myReceivedNotice=data.myReceivedNotice;
			for (var i = 0; i < myReceivedNotice.length; i++) {
				var po=myReceivedNotice[i]
				contents += '<tr>' 
							+ '<td>' + po.nid + '</td>' 
							+ '<td>' + po.title + '</td>' 
							+ '<td>' + po.ncontent + '</td>'
							+ '<td>' + isHaveAnnex(po.nstate,po.annex) + '</td>' 
							+ '<td>' + dateFormat(po.publishtime) + '</td>' 
							+ '<td>' + po.publisher+ '</td>' 
							+'</tr>' 
			}
			$("#receiveTable").html(contents);
			$("#currentpage1").html(pageNum1);
			$("#totalpage1").html(totalpage1);
		},
	})
}
// 接收的公告的分页
$(function() {
	
	$("#nextpage1").click(function(){
		var currentpage1 = parseInt($("#currentpage1").html());
		var totalpage1 = parseInt($("#totalpage1").html());
		if(currentpage1<totalpage1){
			receivedNotcie(currentpage1+1);
		}
	});
	$("#prepage1").click(function(){
		var currentpage1 = parseInt($("#currentpage1").html());
		var totalpage1 = parseInt($("#totalpage1").html());
		if(currentpage1>1){
			receivedNotcie(currentpage1-1);
		}
	});
	$("#firstpage1").click(function(){
		var currentpage1 = parseInt($("#currentpage1").html());
		var totalpage1 = parseInt($("#totalpage1").html());
		if(currentpage1>1){
			receivedNotcie(1);
		}
	});
	$("#lastpage1").click(function(){
		var currentpage1 = parseInt($("#currentpage1").html());
		var totalpage1 = parseInt($("#totalpage1").html());
		if(currentpage1<totalpage1){
			receivedNotcie(totalpage1);
		}
	});
})
// 公告审批
function getAllWaitedNotice(pageNum3){
	$.ajax({
		contentType : "application/json; charset=utf-8",
		type : "post",
		url : "allWaitNotice",
		data: JSON.stringify(pageNum3),
		dataType : "json",
		success : function(data) {
			var contents="";
			var allWaitedNotice= data.allWaitedNotice
			var totalPage3= data.totalPage3
			for (var i = 0; i < allWaitedNotice.length; i++) {
				var po=allWaitedNotice[i];
				contents += '<tr class="success">' 
							+ '<td>' + po.nid + '</td>' 
							+ '<td>' + po.title + '</td>' 
							+ '<td>' + po.ncontent + '</td>'
							+ '<td>' + isHaveExamAnnex(po.annex) + '</td>' 
							+ '<td>' + dateFormat(po.publishtime) + '</td>' 
							+ '<td>' + po.publisher+ '</td>' 
							+ '<td>' 
							+ '<button onclick="agree('+po.nid+')" class="btn btn-primary btn" >' + '同意' + '</button>'+'&nbsp'
							+ '<button onclick="refuse('+po.nid+')" class="btn btn-primary btn" >' + '驳回' + '</button>'
							+ '</td>' 
							+'</tr>'
			}
			$("#allWaitedNotice").html(contents);
			$("#currentpage2").html(pageNum3);
			$("#totalpage2").html(totalPage3);
			// 没有记录条数的时候就不显示页码栏
			if(totalPage3==0){
				$("#pageNum2").hide();
			}
		},
	})
}

//公告审批的分页，有记录条数的时候
$(function() {
	
	$("#nextpage2").click(function(){
		var currentpage2 = parseInt($("#currentpage2").html());
		var totalpage2 = parseInt($("#totalpage2").html());
		if(currentpage2<totalpage2){
			getAllWaitedNotice(currentpage2+1);
		}
	});
	$("#prepage2").click(function(){
		var currentpage2 = parseInt($("#currentpage2").html());
		var totalpage2 = parseInt($("#totalpage2").html());
		if(currentpage2>1){
			getAllWaitedNotice(currentpage2-1);
		}
	});
	$("#firstpage2").click(function(){
		var currentpage2 = parseInt($("#currentpage2").html());
		var totalpage2 = parseInt($("#totalpage2").html());
		if(currentpage2>1){
			getAllWaitedNotice(1);
		}
	});
	$("#lastpage2").click(function(){
		var currentpage2 = parseInt($("#currentpage2").html());
		var totalpage2 = parseInt($("#totalpage2").html());
		if(currentpage2<totalpage2){
			getAllWaitedNotice(totalpage2);
		}
	});
})
 // 同意方法
function agree(nid){
	$.ajax({
		contentType : "application/json; charset=utf-8",
		type : "post",
		url : "agreeNotice",
		data : JSON.stringify(nid),
		dataType : "json",
		success : function(data) {
			getAllWaitedNotice(1);
		},
		
	})
}

 // 拒绝方法
function refuse(nid){
	$.ajax({
		contentType : "application/json; charset=utf-8",
		type : "post",
		url : "refuseNotice",
		data : JSON.stringify(nid),
		dataType : "json",
		success : function(data) {
			getAllWaitedNotice(1);
		},
	})
}

// 文件下载
function downloadFile(fileRote){
	alert("测试文件方法");
	$.ajax({
		contentType : "application/json; charset=utf-8",
		type : "post",
		url : "downloadFile",
		data : JSON.stringify(fileRote),
		dataType : "json",
		success : function(data) {
			alert("进来了");
			alert(data);
		},
	})
}
