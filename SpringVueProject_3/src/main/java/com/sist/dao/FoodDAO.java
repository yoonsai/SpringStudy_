package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.mapper.FoodMapper;

@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	public List<FoodVO> foodFindData(String address){
		return mapper.foodFindData(address);
	}
	
}
