package com.lgs.bbb.service;
//����ϵ�����ҵ���߼�

import java.util.List;

import com.lgs.bbb.dao.DepartDao;
import com.lgs.bbb.entity.Depart;

public class DepartService {
	//����˽�л�ϵ��Dao����
	private DepartDao dd=new DepartDao();
	
	/**
	 * ����dd�еļ���ϵ�𷽷�,��ȡϵ����Ϣ,������
	 * @return
	 */
	public List<Depart> loadAllDepart(){
		return dd.loadAllDepart();
	}
}
