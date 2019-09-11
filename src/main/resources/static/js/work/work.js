

$(function(){
	/*用于分页，已弃用*/
	writeHtml();
});


































function xx(){
	var data1="${works.url}";
	alert(111);
	alert(data1);
}



function writeHtml(){
	
	var vurl=$("#url").val();
	var vcurent=$("#curent").val();
	
	alert("到这");
	$.ajax({
		url:"work/showparttojs",
		type:"post",
		dataType:"json",
		success:function(data){
			alert(data);
			var content = "";
			for(var i =data.beginPage;i<=data.endPage;i++){
				if(data.curent>1){
					content+='<a href="'+data.url+'&curent='+data.curent-1+'">上一页</a>';
				}
				if(data.curent==i){
					content+='》'+i+'《';
				}else{
					content+='<a href="'+data.url+'&curent='+i+'">'+i+'</a>';
				}
				if(data.curent<data.totalPage){
					content+='<a href="'+data.url+'&curent='+data.curent+1+'">下一页</a>';
				}
			}
			alert(content);
			$("#page").html(content);
		}
	})
	
}







//test
function html(){
	var works=$("#thisworks").val();
	alert(works);
	var content = "";
	alert(works.beginPage);
	alert(works.url);
	alert(2222);
	alert(works.endPage);
	for(var i =works.beginPage;i<=works.endPage;i++){
		alert("kakaka");
		if(works.curent>1){
			alert(works.curent);
			content+='<a href="'+works.url+'&curent='+works.curent-1+'">上一页</a>';
		}
		if(works.curent==i){
			alert(works.url);
			content+='》'+i+'《';
		}else{
			alert(works.beginPage);
			content+='<a href="'+works.url+'&curent='+i+'">'+i+'</a>';
		}
		if(works.curent<works.totalPage){
			alert(works.endPage);
			content+='<a href="'+works.url+'&curent='+works.curent+1+'">下一页</a>';
		}
	}
	alert(content);
	$("#page").html(content);
}













