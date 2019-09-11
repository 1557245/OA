/**
 * 修改与添加工作计划
 * @returns {Boolean}
 */
function workplanUpdate() {
	
	return dateVerify();
}

/**
 * 信息
 * @returns {Boolean}
 */
function dateVerify() {
	var name = $("#name").val();
	var summary = $("#summary").val();
	var problem = $("#problem").val();
	var plan = $("#plan").val();
	if (name == ''|| name==null) {
		alert("姓名不允许为空！");
		return false;
	}
	if (summary == '' || summary==null) {
		alert("本周总结不允许为空！");
		return false;
	}
	if (problem == '' || problem==null) {
		alert("本周问题不允许为空！");
		return false;
	}
	if (plan=="" || plan==null) {
		alert("下周计划不允许为空");
		return false;
	}
	return true;
}