package com.lgs.bbb.dao;

import java.util.List;

import com.lgs.bbb.entity.Student;
import com.lgs.bbb.util.JDBCUtil;
//ѧ��Dao
public class StudentDao {
	//��ȡ��ǰҳ����ʾ������,���ݴ����page(ҳ��),rows(ÿһҳ��ʾ����������),����ָ��������
	public List<Student> loadAllStudent(int page,int rows){
		List<Student> list=JDBCUtil.querys(Student.class, "select ts.*,td.dep_name,tp.pro_name from tb_students ts join tb_depart td on ts.s_dep_no=td.dep_id join tb_profess tp on ts.s_pro_id=tp.pro_id limit ?,?",(page-1)*rows,rows);
		return list;
	}
	//��ȡѧ�������е�����
	public int getStudentCount(){
		return JDBCUtil.querys(Student.class, "select * from tb_students").size();
	}
	
	//ɾ��ѧ������
	public int deleteStudent(String s_ids) {
		return JDBCUtil.update("delete from tb_students where s_id in("+s_ids+")");
	}
	
	//�޸�ѧ������
	public int updateStudent(Student stu) {
		return JDBCUtil.update("update tb_students set s_name=?,s_zip=?,s_indate=?,s_dep_no=?,s_pro_id=? where s_id=?",
								stu.getS_name(),stu.getS_zip(),stu.getS_indate(),stu.getS_dep_no(),stu.getS_pro_id(),stu.getS_id());
	}
}
