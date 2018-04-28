<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">   
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css"> 
	
	<style>
		#aa ul{
			list-style: none;
			padding:0px;
			margin:0px;
			text-align: center;
			font-size: 15px;
		}
		#aa ul li{
			height:30px;
			line-height: 30px;
			background-color:#9FBEF5;
			cursor: pointer;
		}
		#aa ul li:hover{
			background-color:#92B3EE;
		}
	</style>
  
</head>
<body class="easyui-layout">   
    <div data-options="region:'north'" style="height:100px;"></div>   
    <div data-options="region:'south'" style="height:100px;"></div>   
    <div data-options="region:'west',title:'导航栏'" style="width:300px;">
    	<div id="aa" class="easyui-accordion" data-options="fit:true" style="width:300px;height:200px;">   
		    <div title="学生管理" data-options="iconCls:'icon-edit',selected:true">   
		        <ul>
		        	<li href="jsp/student/queryStudent.jsp">查询学生信息</li>
		        	<li href="jsp/student/addStudent.jsp">添加学生信息</li>
		        	<li href="jsp/student/updateStudent.jsp">修改学生信息</li>
		        	<li href="jsp/student/deleteStudent.jsp">删除学生信息</li>
		        </ul>
		    </div>   
		    <div title="教师管理" data-options="iconCls:'icon-edit'">
		    	 <ul>
		        	<li href="jsp/teacher/queryTeacher.jsp">查询教师信息</li>
		        	<li href="jsp/teacher/addTeacher.jsp">添加教师信息</li>
		        	<li href="jsp/teacher/updateTeacher.jsp">修改教师信息</li>
		        	<li href="jsp/teacher/deleteTeacher.jsp">删除教师信息</li>
		        </ul>
		    </div>   
		    <div title="管理员管理" data-options="iconCls:'icon-edit'"> 
		    	 <ul>
		        	<li href="jsp/admin/queryAdmin.jsp">查询管理员信息</li>
		        	<li href="jsp/admin/addAdmin.jsp">添加管理员信息</li>
		        	<li href="jsp/admin/updateAdmin.jsp">修改管理员信息</li>
		        	<li href="jsp/admin/deleteAdmin.jsp">删除管理员信息</li>
		        </ul>  
		    </div>   
		</div>  
    </div>   
    <div data-options="region:'center'" style="padding:5px;background:#eee;">
    	<div id="tt" class="easyui-tabs" data-options="fit:true" style="width:500px;height:250px;">   
		    <div title="首页" style="padding:20px;display:none;">   
		    	首页   
		    </div>   
		</div>  
    </div>   

	<script type="text/javascript" src="easyui/jquery.min.js"></script>   
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	
	<script type="text/javascript">
		$('#aa li').click(function(){
			//获取点击选项的标题及要打开的页面路径
			var val=$(this).text();
			var href=$(this).attr("href");
			console.log(href);
			//判断该标题的选项卡是否已打开
			var exists = $('#tt').tabs('exists',val);
			//如果已打开,则选中此选项卡并刷新
			if(exists){
				//选中选项卡
				$('#tt').tabs('select',val);
				// 调用 'refresh' 方法更新选项卡面板的内容
				// 获取选择的面板
				var tab = $('#tt').tabs('getSelected');
				//更新页面
				$('#tt').tabs('update', {
					tab: tab,
					options: {
						title: val,
						content:"<iframe style='width:100%;height:100%;border:none;' src='"+href+"'></iframe>"
					}
				});

				
				return;
			}
			//创建选项卡,标题为点击选项的标题
			$('#tt').tabs('add',{    
			    title:val,  
			    content:"<iframe style='width:100%;height:100%;border:none;' src='"+href+"'></iframe>",
			    closable:true
			}); 
		});
	</script>
</body>
</html>