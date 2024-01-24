package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;

@Repository("cDao")
public class CategoryDAO {
	@Autowired
	// @Autowired => 스프링에서 mapper에 값을 주입해라 (setter)
	private CategoryMapper mapper; //private은 setter가 있어야 접근이 가능한데 private 침범

	public List<CategoryVO> foodCategoryData()
	{
		return mapper.foodCategoryData();
	}
	
	public CategoryVO categoryInfoData(int cno)
	{
		return mapper.categoryInfoData(cno);
	}
}
