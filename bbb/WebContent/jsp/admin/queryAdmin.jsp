<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/easyui/themes/default/easyui.css">   
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/easyui/themes/icon.css"> 
</head>
<body>
	<table id="dg"></table>  


	<script type="text/javascript" src="<%=request.getContextPath() %>/easyui/jquery.min.js"></script>   
	<script type="text/javascript" src="<%=request.getContextPath() %>/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/easyui/locale/easyui-lang-zh_CN.js"></script>   
	
	<script type="text/javascript">
		$('#dg').datagrid({
		    url:'<%=request.getContextPath()%>/student/loadAllStudent',
		    pagination:true,
		    pageSize:2,
		    pageList:[2,4,6,8,10],
		    fitColumns:true,
		    rownumbers:true,
		    columns:[[
		    	{field:'s_id',checkbox:true},
		        {field:'s_no',title:'学生编号',width:200},
		        {field:'s_name',title:'学生姓名',width:200},
		        {field:'s_zip',title:'身份证号码',width:200},
		        {field:'s_indate',title:'入学时间',width:200},
		        {field:'dep_name',title:'所属系别',width:200},
		        {field:'pro_name',title:'所属专业',width:200}
		    ]]
		});  
	</script>
</body>
</html>