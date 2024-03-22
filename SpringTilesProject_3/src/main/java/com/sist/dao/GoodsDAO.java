package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.GoodsMapper;
import com.sist.vo.GoodsVO;

@Repository
public class GoodsDAO {
	@Autowired
	private GoodsMapper mapper;
	
    public List<GoodsVO> goodsListData(Map map)
    {
    	return mapper.goodsListData(map);
    }
	public int goodsTotalpage(Map map) 
	{
		return mapper.goodsTotalpage(map);
	}
	public GoodsVO goodsDetailData(Map map)
	{
		return mapper.goodsDetailData(map);
	}
}
