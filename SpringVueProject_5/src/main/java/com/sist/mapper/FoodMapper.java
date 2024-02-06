package com.sist.mapper;

import java.util.*;
import org.apache.ibatis.annotations.Select;
import com.sist.dao.*;
/*
 * 
 * SELECT fno,name,poster FROM food_menu_house ORDER BY fno ASC LIMIT #{start},20 
 * => start부터 20개를 가져와라
 * 
 * 
 * 
 */
public interface FoodMapper {
	@Select("SELECT fno,name,poster,num "
			+ "FROM (SELECT fno,name,poster,rownum as num "
			+ "FROM (SELECT fno,name,poster "
			+ "FROM food_menu_house ORDER BY fno ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM food_menu_house")
	public int foodTotalPage();
	
	@Select("SELECT fno,name,poster,score,name,type,address,phone,theme,price,seat FROM food_menu_house WHERE fno=#{fno}")
	public FoodVO foodDetalData(int fno);
}
