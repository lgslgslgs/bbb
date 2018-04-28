package com.lgs.bbb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lgs.bbb.entity.Depart;
import com.lgs.bbb.service.DepartService;

import net.sf.json.JSONArray;
//ϵ�������
@WebServlet("/depart/*")
public class DepartController extends BaseServlet{
	//����˽�л�DepartService����
	private DepartService ds=new DepartService();
	
	//�������ϵ����Ϣ����
	protected void loadAllDepart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//����ds�ļ���ϵ����Ϣ����,��ȡϵ����Ϣ
		List<Depart> list=ds.loadAllDepart();
		//��ϵ����Ϣ����תΪjson�ַ���
		String jsonStr=JSONArray.fromObject(list).toString();
		//д�뵽��Ӧ��
		resp.setCharacterEncoding("utf-8");//������Ӧ�ı����ʽ
		resp.getWriter().write(jsonStr);
	}
}
