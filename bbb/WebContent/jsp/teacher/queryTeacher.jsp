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
		    url:'<%=request.getContextPath()%>/teacher/loadAllTeacher',
		    //表格下方显示分页工具栏
		    pagination:true,
		    //每一页显示的数据条数
		    pageSize:2,
		    //更改每一页显示数据条数的一个select
		    pageList:[2,4,6,8,10],
		    //填充满页面
		    fitColumns:true,
		    //显示行号
		    rownumbers:true,
		    //在表格上方显示工具栏
		    toolbar: [{
				iconCls: 'icon-add',
				text:'添加',
				handler: function(){alert('编辑按钮')}
			},'-',{
				iconCls: 'icon-edit',
				text:'修改',
				handler: function(){alert('编辑按钮')}
			},'-',{
				iconCls: 'icon-remove',
				text:'删除',
				//当触发点击事件是调用deleteTeacher()函数
				handler: deleteTeacher
			}],
		    columns:[[
		    	{field:'t_id',checkbox:true},
		        {field:'t_no',title:'教师编号',width:200},
		        {field:'t_name',title:'教师姓名',width:200},
		        {field:'t_zip',title:'身份证号码',width:200},
		        {field:'t_date',title:'入职时间',width:200},
		        {field:'dep_name',title:'所属系别',width:200},
		    ]]
		});  
		//删除教师方法
		function deleteStudent(){
			//获取被选中项
			var selections=$('#dg').datagrid('getSelections');
			//判断被选中项是否为空
			if(selections.length<=0){
				//若为空则不进行删除操作
				alert("被选中项为空,删除失败!");
				return;
			}
			var t_ids=[];
			for(var i=0;i<selections.length;i++){
				t_ids[i]=selections[i].t_id;
			}
			//异步请求删除选中项
			$.post('<%=request.getContextPath()%>/teacher/deleteTeacher',{t_ids:t_ids.join()},function(data){
				//若返回结果为真,删除成功,刷新数据
				if(data){
					$('#dg').datagrid('reload');
				}else{
					alert("删除失败!");
				}
			},'text');
		}
	</script>
</body>
</html>