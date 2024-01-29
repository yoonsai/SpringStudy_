package com.sist.mapper;

import java.util.*;
import com.sist.dao.*;

import org.apache.ibatis.annotations.Select;

public interface FoodMapper {
	@Select("SELECT fno,poster,name FROM food_menu_house WHERE fno BETWEEN 108 AND 127 ORDER BY fno")
	public List<FoodVO> foodListData();
	
	@Select("SELECT fno,poster,name,score,type,address,theme,price,time,seat FROM food_menu_house WHERE fno=#{fno}")
	public FoodVO foodDetailData(int fno);
}
