package com.lgs.bbb.dao;
//系别dao

import java.util.List;

import com.lgs.bbb.entity.Depart;
import com.lgs.bbb.util.JDBCUtil;

public class DepartDao {
	/**
	 * 从数据库中获取系别表中所有的系别信息
	 * @return 包含系别表信息的集合
	 */
	public List<Depart> loadAllDepart(){
		return JDBCUtil.querys(Depart.class,"select * from tb_depart");
	}
}
