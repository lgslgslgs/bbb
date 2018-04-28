package com.lgs.bbb.service;

import java.util.List;

import com.lgs.bbb.dao.StudentDao;
import com.lgs.bbb.entity.Student;
//学生类:处理学生相关业务逻辑
public class StudentService {
	//创建sutdentdao的私有化对象sd
	private StudentDao sd=new StudentDao();
	
	/**
	 * 调用sd对象的loadAllStudent方法,获取学生数据
	 * @param page
	 * @param rows
	 * @return 返回学生数据
	 */
	public List<Student> loadAllStudent(int page,int rows){
		return sd.loadAllStudent(page, rows);
	}
	public int getStudentCount() {
		return sd.getStudentCount();
	}
	
	/**
	 * 调用sd对象的deleteStudent方法,删除学生信息
	 * @param s_ids
	 * @return true or false
	 */
	public boolean deleteStudent(String s_ids) {
		int result = sd.deleteStudent(s_ids);
		if(result==1) {
			return true;
		}
		return false;
	}
	
	/**
	 * 通过传入的学生对象stu,修改数据库中对应id的学生的信息
	 * @param stu
	 * @return true or false
	 */
	public boolean updateStudent(Student stu) {
		int result = sd.updateStudent(stu);
		if(result==1) {
			return true;
		}
		return false;
	}
}
