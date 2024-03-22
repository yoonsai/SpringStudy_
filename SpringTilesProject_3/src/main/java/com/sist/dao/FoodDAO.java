package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.FoodMapper;
import com.sist.vo.FoodVO;

@Repository // id를 따로 설정안하면 foodDAO로 됨
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	
    public List<FoodVO> foodListData(int start,int end){
    	return mapper.foodListData(start, end);
    }
	
	public int foodTotalPage()
	{
		return mapper.foodTotalPage();
	}
	
	public FoodVO foodDetailData(int fno)
	{
		return mapper.foodDetailData(fno);
	}
	
}