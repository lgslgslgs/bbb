package com.lgs.bbb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lgs.bbb.entity.Profess;
import com.lgs.bbb.service.ProfessService;

import net.sf.json.JSONArray;

//רҵ������
@WebServlet("/profess/*")
public class ProfessController extends BaseServlet{
	//����˽�л�ProfessService����
	private ProfessService ps=new ProfessService();
	
	//����loadAllProfess����,����רҵ��Ϣ
	protected void loadAllProfess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//������Χ�л�ȡ����
		int pro_depid=Integer.parseInt(req.getParameter("pro_depid"));
		//����ps�����еļ���רҵ����
		List<Profess> list=ps.loadAllProfess(pro_depid);
		//������תΪjson��ʽ���ַ���
		String jsonStr=JSONArray.fromObject(list).toString();
		//������д����Ӧ��
		//������Ӧ�ı����ʽ
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(jsonStr);
	}
}
