package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.FoodMapper;

@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	
    public List<FoodVO> foodListData(int start,int end)
    {
    	return mapper.foodListData(start,end);
    }
	
	public int foodTotalPage(){
		return mapper.foodTotalPage();
	}
	
	public FoodVO foodDetailData(int fno)
	{
		mapper.hitIncrement(fno);
		return mapper.foodDetailData(fno);
	}
	public FoodVO foodCookieData(int fno)
	{
		return mapper.foodDetailData(fno);//조회수를 증가시키면 안되서
	}
	public List<FoodVO> foodFindData(Map map)
	{
		return mapper.foodFindData(map);
		
	}
	public int foodFindTotalPage(Map map){
		return mapper.foodFindTotalPage(map);
	}
}
