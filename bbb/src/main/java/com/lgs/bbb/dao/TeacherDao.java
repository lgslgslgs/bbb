package com.lgs.bbb.dao;
//��ʦDao �������ݿ�

import java.util.List;

import com.lgs.bbb.entity.Teacher;
import com.lgs.bbb.util.JDBCUtil;

public class TeacherDao {
	
	/**
	 *���ݴ����page(ҳ��),rows(ÿһҳ��ʾ����������), ��ѯ���ݿ��еĽ�ʦ��Ϣ
	 * @param page
	 * @param rows
	 * @return ��ʦ��Ϣ
	 */
	public List<Teacher> queryTeacher(int page,int rows){
		List<Teacher> list=JDBCUtil.querys(Teacher.class, "select * from tb_teachers limit ?,?",((page-1)*rows),rows);
		return list;
	}
	
	/**
	 * ��ѯ���ݿ������н�ʦ������
	 * @return ��ʦ����
	 */
	public int queryTeacherCount() {
		return JDBCUtil.querys(Teacher.class, "select * from tb_teachers").size();
	}
	
	/**
	 * ���ݴ���Ľ�ʦid,ɾ�����ݿ��еĶ�Ӧ����
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
