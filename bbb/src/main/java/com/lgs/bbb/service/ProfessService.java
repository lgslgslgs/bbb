package com.lgs.bbb.service;

import java.util.List;

import com.lgs.bbb.dao.ProfessDao;
import com.lgs.bbb.entity.Profess;

//专业service,处理专业相关业务逻辑
public class ProfessService {
	//创建私有化对象
	private ProfessDao pd=new ProfessDao();
	
	/**
	 * 根据传入的系别id,调用pd对象中的加载专业方法,获取专业信息
	 * @param pro_depid
	 * @return 包含专业信息的集合
	 */
	public List<Profess> loadAllProfess(int pro_depid){
		return pd.loadAllProfess(pro_depid);
	}
}
