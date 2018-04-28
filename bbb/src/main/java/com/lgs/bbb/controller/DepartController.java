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
//系别控制器
@WebServlet("/depart/*")
public class DepartController extends BaseServlet{
	//创建私有化DepartService对象
	private DepartService ds=new DepartService();
	
	//处理加载系别信息请求
	protected void loadAllDepart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//调用ds的加载系别信息方法,获取系别信息
		List<Depart> list=ds.loadAllDepart();
		//将系别信息集合转为json字符串
		String jsonStr=JSONArray.fromObject(list).toString();
		//写入到响应中
		resp.setCharacterEncoding("utf-8");//设置响应的编码格式
		resp.getWriter().write(jsonStr);
	}
}
