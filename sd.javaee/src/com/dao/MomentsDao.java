package com.dao;

import java.util.List;

import com.model.Moments;

import jdbc.config.JDBCUtils;

public class MomentsDao {
	
	public void saveMoments(Moments moment) {
		
		String sql = "insert into moments ( MID , MCONTENT , IMGS ) values ( SEQ_MOMENTS.nextval , ? , ? )";
		Object[] params = { moment.getMcontent() , moment.getImgs() };
		
		JDBCUtils util = new JDBCUtils();
		int row = util.executeUpdate(sql, params);
		System.out.println(row + " 条 朋友圈 添加成功 . ");
		
	}
	
	public List<Moments> getMoments() {
		String sql = "select * from moments";
		
		JDBCUtils util = new JDBCUtils();
		List<Moments> moments = (List<Moments>) util.findByType(sql, Moments.class , null);
		return moments;
	}

}
