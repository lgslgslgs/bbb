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

//专业控制器
@WebServlet("/profess/*")
public class ProfessController extends BaseServlet{
	//创建私有化ProfessService对象
	private ProfessService ps=new ProfessService();
	
	//处理loadAllProfess请求,加载专业信息
	protected void loadAllProfess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//从请求范围中获取参数
		int pro_depid=Integer.parseInt(req.getParameter("pro_depid"));
		//调用ps对象中的加载专业方法
		List<Profess> list=ps.loadAllProfess(pro_depid);
		//将集合转为json格式的字符串
		String jsonStr=JSONArray.fromObject(list).toString();
		//将数据写入响应中
		//设置响应的编码格式
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(jsonStr);
	}
}
