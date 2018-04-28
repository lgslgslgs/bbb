package com.lgs.bbb.dao;
//教师Dao 操作数据库

import java.util.List;

import com.lgs.bbb.entity.Teacher;
import com.lgs.bbb.util.JDBCUtil;

public class TeacherDao {
	
	/**
	 *根据传入的page(页数),rows(每一页显示的数据条数), 查询数据库中的教师信息
	 * @param page
	 * @param rows
	 * @return 教师信息
	 */
	public List<Teacher> queryTeacher(int page,int rows){
		List<Teacher> list=JDBCUtil.querys(Teacher.class, "select * from tb_teachers limit ?,?",((page-1)*rows),rows);
		return list;
	}
	
	/**
	 * 查询数据库中所有教师的总数
	 * @return 教师总数
	 */
	public int queryTeacherCount() {
		return JDBCUtil.querys(Teacher.class, "select * from tb_teachers").size();
	}
	
	/**
	 * 根据传入的教师id,删除数据库中的对应数据
	 * @param t_ids
	 * @return true or false
	 */
	public boolean deleteTeacherByT_ids(String t_ids) {
		int result = JDBCUtil.update("delete from tb_teachers where t_id in("+t_ids+")");
		if(result==1) {
			return true;
		}
		return false;
	}
}
