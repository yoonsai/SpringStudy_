package com.sist.mapper;

import com.sist.dao.*;
import java.util.*;

import org.apache.ibatis.annotations.Select;
public interface FoodMapper {
	// 카테고리별 맛집
	@Select("SELECT fno,name,address,phone,type FROM food_house WHERE cno=#{cno}")
	public List<FoodVO> foodCategoryListData(int cno);
	
	// 맛집의 정보

     @Select("SELECT * FROM food_house WHERE fno=#{fno}") 
     public FoodVO foodDetailListData(int fno);
}
