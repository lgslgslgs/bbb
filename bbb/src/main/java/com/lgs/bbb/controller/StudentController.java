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
	//����˽�л�StudentService���� ss
	private StudentService ss=new StudentService();
	
	//����loadAllStudent����,����ѧ����Ϣ
	protected void loadAllStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡ�������
		int page=Integer.parseInt(req.getParameter("page"));
		int rows=Integer.parseInt(req.getParameter("rows"));
		//����ss�����еļ���ѧ����Ϣ����,�����ܷ��ص�����
		List<Student> list = ss.loadAllStudent(page,rows);
		//����ss�����еĻ�ȡѧ����Ϣ��������
		int count=ss.getStudentCount();
		//����ȡ����ѧ�����ݺ����������뵽map������
		Map<String, Object> data=new HashMap<>();
		//total��Ӧҳ���е�ǰ�˿��easyui�ı���ȡ����������
		data.put("total", count);
		//rows��Ӧ��ȡ���ݵļ���
		data.put("rows", list);
		//������Ӧ�ı����ʽ
		resp.setCharacterEncoding("utf-8");
		//��map����ת��json��ʽ���ַ���
		String jsonStr = JSONObject.fromObject(data).toString();
		//������д�뵽��Ӧ��
		resp.getWriter().write(jsonStr);
	}
	
	//����deleteStudent����,ɾ�������д����ѧ��id����Ӧ�ĵ�ѧ����Ϣ
	protected void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡ�������s_ids
		String s_ids=req.getParameter("s_ids");
		//����ss�����е�ɾ��ѧ����Ϣ����,�����ܷ��ؽ��
		boolean result=ss.deleteStudent(s_ids);
		//������Ӧ�ı����ʽ
		resp.setCharacterEncoding("utf-8");
		//�����д�뵽��Ӧ��
		resp.getWriter().write(result+"");
	}
	
	//����updateStudent����,�޸����ݿ��ж�Ӧid��ѧ����ϢΪ���������ֵ
	protected void updateStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd",Locale.CHINA);
		//��ȡ�������
		int s_id=Integer.parseInt(req.getParameter("s_id"));
		String s_name=req.getParameter("s_name");
		String s_zip=req.getParameter("s_zip");
		String s_indate=req.getParameter("s_indate");
		int s_dep_no=Integer.parseInt(req.getParameter("s_dep_no"));
		int s_pro_id=Integer.parseInt(req.getParameter("s_pro_id"));
		//��װ��Studentʵ����
		Student stu=null;
		try {
			stu = new Student(s_id, s_name, s_zip, sdf.parse(s_indate), s_dep_no, s_pro_id);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//����ss�����е��޸�ѧ����Ϣ����,�����ܷ��ؽ��
		boolean result=ss.updateStudent(stu);
		//������Ӧ�ı����ʽ
		resp.setCharacterEncoding("utf-8");
		//�����д�뵽��Ӧ��
		resp.getWriter().write(result+"");
	}
	
}
