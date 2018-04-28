package com.lgs.bbb.service;
//处理系别相关业务逻辑

import java.util.List;

import com.lgs.bbb.dao.DepartDao;
import com.lgs.bbb.entity.Depart;

public class DepartService {
	//创建私有化系别Dao对象
	private DepartDao dd=new DepartDao();
	
	/**
	 * 调用dd中的加载系别方法,获取系别信息,并返回
	 * @return
	 */
	public List<Depart> loadAllDepart(){
		return dd.loadAllDepart();
	}
}
