package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface SeoulMapper {
	@Select("SELECT no,title FROM seoul_nature ORDER BY no ASC")
	public List<SeoulVO> natureListData();
	
	@Select("SELECT no,title,msg,address FROM seoul_nature WHERE no=#{no}")
	public SeoulVO natureDetailData(int no);
	
	@Select("SELECT no,title,msg,address FROM seoul_nature WHERE title LIKE '%'||#{title}||'%'")
	public List<SeoulVO> natureFindData(String title);
	
	@Select("SELECT no,title FROM seoul_shop ORDER BY no ASC")
	public List<SeoulVO> shopListData();
	
	@Select("SELECT no,title,msg,address FROM seoul_shop WHERE no=#{no}")
	public SeoulVO shopDetailData(int no);
	
	@Select("SELECT no,title,msg,address FROM seoul_shop WHERE title LIKE '%'||#{title}||'%'")
	public List<SeoulVO> shopFindData(String title);
}
