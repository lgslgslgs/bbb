package com.lgs.bbb.service;

import java.util.List;

import com.lgs.bbb.dao.ProfessDao;
import com.lgs.bbb.entity.Profess;

//רҵservice,����רҵ���ҵ���߼�
public class ProfessService {
	//����˽�л�����
	private ProfessDao pd=new ProfessDao();
	
	/**
	 * ���ݴ����ϵ��id,����pd�����еļ���רҵ����,��ȡרҵ��Ϣ
	 * @param pro_depid
	 * @return ����רҵ��Ϣ�ļ���
	 */
	public List<Profess> loadAllProfess(int pro_depid){
		return pd.loadAllProfess(pro_depid);
	}
}
