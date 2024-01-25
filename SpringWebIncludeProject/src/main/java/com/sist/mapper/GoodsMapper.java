package com.sist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.dao.GoodsVO;

import lombok.experimental.StandardException;

public interface GoodsMapper {
	@Select("SELECT no,goods_name,goods_poster,goods_price,num "
			+ "FROM (SELECT no,goods_name,goods_poster,goods_price,rownum as num "
			+ "FROM (SELECT no,goods_name,goods_poster,goods_price "
			+ "FROM goods_all ORDER BY no)) "
			+ "WHERE num BETWEEN #{start} and #{end}")
	public List<GoodsVO> goodsListData(@Param("start") int start, @Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM goods_all")
	public int goodsTotalPage();
	
	@Update("UPDATE goods_all SET hit=hit+1 WHERE no=#{no}")
	public void goodsHitIncrement(int no);
	
	@Select("SELECT * FROM goods_all WHERE no=#{no}")
	public GoodsVO goodsDetailData(int no);
	
} 
