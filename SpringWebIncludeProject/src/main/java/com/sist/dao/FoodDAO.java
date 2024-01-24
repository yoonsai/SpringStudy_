package com.sist.dao;

import java.util.List;

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
}
