package com.lgs.bbb.dao;


import java.util.List;

import com.lgs.bbb.entity.Profess;
import com.lgs.bbb.util.JDBCUtil;
//רҵDao
public class ProfessDao {
	/**
	 * ���ݴ����ϵ��id��ѯ���ݿ�����Ӧרҵ
	 * @param pro_depid
	 * @return �������רҵ�ļ���
	 */
	public List<Profess> loadAllProfess(int pro_depid){
		return JDBCUtil.querys(Profess.class, "select tp.*,td.dep_name from tb_profess tp join tb_depart td on tp.pro_depid=td.dep_id where pro_depid=?",pro_depid);
	}
}
