package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.mapper.*;

@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	public List<FoodVO> foodListData(){
		return mapper.foodListData();
	}
	public FoodVO foodDetailData(int fno) {
		return mapper.foodDetailData(fno);
	}
	
}
