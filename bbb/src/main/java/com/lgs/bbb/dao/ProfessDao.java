package com.lgs.bbb.dao;


import java.util.List;

import com.lgs.bbb.entity.Profess;
import com.lgs.bbb.util.JDBCUtil;
//专业Dao
public class ProfessDao {
	/**
	 * 根据传入的系别id查询数据库中相应专业
	 * @param pro_depid
	 * @return 包含相关专业的集合
	 */
	public List<Profess> loadAllProfess(int pro_depid){
		return JDBCUtil.querys(Profess.class, "select tp.*,td.dep_name from tb_profess tp join tb_depart td on tp.pro_depid=td.dep_id where pro_depid=?",pro_depid);
	}
}
