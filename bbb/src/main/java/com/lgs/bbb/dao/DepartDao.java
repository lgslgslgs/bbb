package com.lgs.bbb.dao;
//ϵ��dao

import java.util.List;

import com.lgs.bbb.entity.Depart;
import com.lgs.bbb.util.JDBCUtil;

public class DepartDao {
	/**
	 * �����ݿ��л�ȡϵ��������е�ϵ����Ϣ
	 * @return ����ϵ�����Ϣ�ļ���
	 */
	public List<Depart> loadAllDepart(){
		return JDBCUtil.querys(Depart.class,"select * from tb_depart");
	}
}
