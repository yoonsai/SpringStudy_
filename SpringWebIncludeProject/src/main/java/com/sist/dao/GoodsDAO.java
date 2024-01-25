package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.GoodsMapper;

@Repository
public class GoodsDAO {
	@Autowired
	private GoodsMapper mapper;
	
	public List<GoodsVO> goodsListData(int start, int end)
	{
		return mapper.goodsListData(start, end);
	}
	public int goodsTotalPage()
	{
		return mapper.goodsTotalPage();
	}
	public GoodsVO goodsDetailData(int no) {
		mapper.goodsHitIncrement(no);
		return mapper.goodsDetailData(no);
	}
	public GoodsVO goodsCookie(int no) {
		return mapper.goodsDetailData(no);
	}
}
