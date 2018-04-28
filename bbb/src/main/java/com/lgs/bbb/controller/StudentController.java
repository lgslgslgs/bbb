package com.lgs.bbb.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lgs.bbb.entity.Student;
import com.lgs.bbb.service.StudentService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/student/*")
public class StudentController extends BaseServlet{
	//创建私有化StudentService对象 ss
	private StudentService ss=new StudentService();
	
	//处理loadAllStudent请求,加载学生信息
	protected void loadAllStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取请求参数
		int page=Integer.parseInt(req.getParameter("page"));
		int rows=Integer.parseInt(req.getParameter("rows"));
		//调用ss对象中的加载学生信息方法,并接受返回的数据
		List<Student> list = ss.loadAllStudent(page,rows);
		//调用ss对象中的获取学生信息的总条数
		int count=ss.getStudentCount();
		//将获取到的学生数据和总条数放入到map集合中
		Map<String, Object> data=new HashMap<>();
		//total对应页面中的前端框架easyui的表格获取数据总条数
		data.put("total", count);
		//rows对应获取数据的集合
		data.put("rows", list);
		//设置响应的编码格式
		resp.setCharacterEncoding("utf-8");
		//将map集合转成json格式的字符串
		String jsonStr = JSONObject.fromObject(data).toString();
		//将数据写入到响应中
		resp.getWriter().write(jsonStr);
	}
	
	//处理deleteStudent请求,删除请求中传入的学生id所相应的的学生信息
	protected void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取请求参数s_ids
		String s_ids=req.getParameter("s_ids");
		//调用ss对象中的删除学生信息方法,并接受返回结果
		boolean result=ss.deleteStudent(s_ids);
		//设置响应的编码格式
		resp.setCharacterEncoding("utf-8");
		//将结果写入到响应中
		resp.getWriter().write(result+"");
	}
	
	//处理updateStudent请求,修改数据库中对应id的学生信息为传入参数的值
	protected void updateStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd",Locale.CHINA);
		//获取请求参数
		int s_id=Integer.parseInt(req.getParameter("s_id"));
		String s_name=req.getParameter("s_name");
		String s_zip=req.getParameter("s_zip");
		String s_indate=req.getParameter("s_indate");
		int s_dep_no=Integer.parseInt(req.getParameter("s_dep_no"));
		int s_pro_id=Integer.parseInt(req.getParameter("s_pro_id"));
		//封装到Student实体类
		Student stu=null;
		try {
			stu = new Student(s_id, s_name, s_zip, sdf.parse(s_indate), s_dep_no, s_pro_id);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//调用ss对象中的修改学生信息方法,并接受返回结果
		boolean result=ss.updateStudent(stu);
		//设置响应的编码格式
		resp.setCharacterEncoding("utf-8");
		//将结果写入到响应中
		resp.getWriter().write(result+"");
	}
	
}
