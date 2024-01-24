package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface SeoulMapper {
	@Select("SELECT no,title FROM seoul_shop ORDER BY no")
	public List<SeoulVO> shopListData();
	
	@Select("SELECT no,title,address FROM seoul_shop WHERE no=#{no}")
	public SeoulVO shopDetailData(int no);
	
	@Select("SELECT no,title FROM seoul_shop WHERE title LIKE '%'||#{title}||'%'")
	public List<SeoulVO> shopFindData(String title);
}
