package com.lgs.bbb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/teacher/*")
public class TeacherController extends BaseServlet{
	
	protected void loadAllTeacher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
