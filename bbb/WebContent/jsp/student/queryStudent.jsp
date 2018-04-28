<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/easyui/themes/default/easyui.css">   
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/easyui/themes/icon.css"> 
	
	<style type="text/css">
		#ff div{
			text-align: center;
			margin: 10px;
		}
		#IDCard label{
			margin-left: -10px;
		}
	</style>
</head>
<body>
	<table id="dg"></table>  
	<div id="win" style="display: none;">
		<form id="ff" method="post">
		    <div>
		        <label for="name">学生编号:</label>
		        <input name="s_no" class="easyui-textbox" style="width:200px"> 
		    </div>
		    <div>
		        <label for="email">学生姓名:</label>
		        <input name="s_name" class="easyui-textbox" style="width:200px"> 
		    </div>
		    <div id="IDCard">   
		        <label for="name">身份证号码:</label>   
		        <input name="s_zip" class="easyui-textbox" style="width:200px"> 
		    </div>
		    <div>   
		        <label for="name">入学时间:</label>   
		        <input editable="false" name="s_indate" class="easyui-datebox" style="width:200px">
		    </div>
		    <div>   
		        <label for="name">所属系别:</label>
		        <input id="dep" name="dep_name" style="width:200px">
		    </div>
		    <div>
		        <label for="name">所属专业:</label>
		        <input id="pro" name="pro_name" style="width:200px">
		    </div>
		    <div>
		    	<input type="submit" class="easyui-linkbutton" style="width:80px" value="提交"/>
		    	<input type="button" class="easyui-linkbutton" style="width:80px" value="重置"/>
		    </div>
		</form>
	</div>  


	<script type="text/javascript" src="<%=request.getContextPath() %>/easyui/jquery.min.js"></script>   
	<script type="text/javascript" src="<%=request.getContextPath() %>/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/easyui/locale/easyui-lang-zh_CN.js"></script>   
	
	<script type="text/javascript">
		var s_id;
		var s_dep_no;
		var s_pro_id;
		//加载学生表格信息
		$('#dg').datagrid({
		    url:'<%=request.getContextPath()%>/student/loadAllStudent',
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
						handler: updateStudent
					},'-',{
						iconCls: 'icon-remove',
						text:'删除',
						//当触发点击事件是调用deleteStudent()函数
						handler: deleteStudent
					}],
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
		
		//删除学生方法
		function deleteStudent(){
			//获取被选中项
			var selections=$('#dg').datagrid('getSelections');
			//判断被选中项是否为空
			if(selections.length<=0){
				//若为空则不进行删除操作
				alert("被选中项为空,删除失败!");
				return;
			}
			var s_ids=[];
			for(var i=0;i<selections.length;i++){
				s_ids[i]=selections[i].s_id;
			}
			//异步请求删除选中项
			$.post('<%=request.getContextPath()%>/student/deleteStudent',{s_ids:s_ids.join()},function(data){
				//若返回结果为真,删除成功,刷新数据
				if(data){
					$('#dg').datagrid('reload');
				}else{
					alert("删除失败!");
				}
			},'text');
		};
		
		//修改学生信息方法
		function updateStudent(){
			//获取被选中项
			var selections=$('#dg').datagrid('getSelections');
			//判断被选中项是否为空
			if(selections.length!=1){
				//若为空则不进行删除操作
				alert("选中项为空或选中项多于一个,删除失败!");
				return;
			}
			//弹出修改窗口
			$('#win').window({    
			    width:600,    
			    height:400,    
			    modal:true,
			    collapsible:false,
			    minimizable:false,
			    maximizable:false,
			    draggable:true,
			    title:"修改学生信息"
			});
			//回填信息到修改窗口
			s_id=selections[0].s_id;
			var s_no=selections[0].s_no;
			var s_name=selections[0].s_name;
			var s_zip=selections[0].s_zip;
			var s_indate=selections[0].s_indate;
			var dep_name=selections[0].dep_name;
			var pro_name=selections[0].pro_name;
			s_dep_no=selections[0].s_dep_no;
			s_pro_id=selections[0].s_pro_id;
			$('#ff input[textboxname="s_no"]').textbox('setValue',s_no);
			$('#ff input[textboxname="s_id"]').textbox('setValue',s_no);
			$('#ff input[textboxname="s_name"]').textbox('setValue',s_name);
			$('#ff input[textboxname="s_zip"]').textbox('setValue',s_zip);
			$('#ff input[textboxname="s_indate"]').textbox('setValue',s_indate);
			$('#ff input[textboxname="dep_name"]').textbox('setValue',dep_name);
			$('#ff input[textboxname="pro_name"]').textbox('setValue',pro_name);
			//加载下拉框中的值
			//系别下拉列表
			$('#dep').combobox({    
			    url:'<%=request.getContextPath()%>/depart/loadAllDepart',
			    valueField:'dep_id',
			    textField:'dep_name',
			    editable:false,
			  //默认选中要修改的被选中项中相应的系别
			    value:s_dep_no
			});
			
			//专业下拉专业列表(需在系别选中后加载)
			//系别下拉框的值
			var dep_value=$('#dep').combobox('getValue');
			loadProfess(dep_value);
			//默认选中要修改的被选中项中相应的专业
			$('#pro').combobox('setValue',s_pro_id);
			//当系别下拉框的值更改时,更新专业表的值
			$('#dep').combobox({
				onChange:function(newValue, oldValue){
					$('#pro').combobox('clear');
					//加载专业下拉专业列表
					loadProfess(newValue);
				}
			});
		};
		
		//加载专业方法
		function loadProfess(newValue){
			$('#pro').combobox({    
			    url:'<%=request.getContextPath()%>/profess/loadAllProfess',
			  	//发送请求数据
			    queryParams: {
					"pro_depid" :newValue
				},
			    valueField:'pro_id',    
			    textField:'pro_name',
			    editable:false
			});
		};
		//提交表单
		$('#ff').form({    
		    url:'<%=request.getContextPath()%>/student/updateStudent',    
		    onSubmit: function(param){ 
		        param.s_id = s_id;    
		        param.s_dep_no = s_dep_no;    
		        param.s_pro_id = s_pro_id;  
		        //关闭窗口
		        $('#win').window('close');
		        //刷新表格
		        $('#dg').datagrid('reload');
		    }    
		});  
	</script>
</body>
</html>