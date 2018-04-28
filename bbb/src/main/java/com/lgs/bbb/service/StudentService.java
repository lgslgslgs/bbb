package com.lgs.bbb.service;

import java.util.List;

import com.lgs.bbb.dao.StudentDao;
import com.lgs.bbb.entity.Student;
//ѧ����:����ѧ�����ҵ���߼�
public class StudentService {
	//����sutdentdao��˽�л�����sd
	private StudentDao sd=new StudentDao();
	
	/**
	 * ����sd�����loadAllStudent����,��ȡѧ������
	 * @param page
	 * @param rows
	 * @return ����ѧ������
	 */
	public List<Student> loadAllStudent(int page,int rows){
		return sd.loadAllStudent(page, rows);
	}
	public int getStudentCount() {
		return sd.getStudentCount();
	}
	
	/**
	 * ����sd�����deleteStudent����,ɾ��ѧ����Ϣ
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
	 * ͨ�������ѧ������stu,�޸����ݿ��ж�Ӧid��ѧ������Ϣ
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
