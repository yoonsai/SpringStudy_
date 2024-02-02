package com.sist.mapper;

import com.sist.vo.*;
import java.util.*;
// SQL 문장을 저장 => MyBatis가 구현

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
public interface FoodMapper {
	@Select("SELECT fno,poster,name,num "
			+ "FROM (SELECT fno,poster,name,rownum as num "
			+ "FROM (SELECT fno,poster,name FROM food_menu_house ORDER BY fno ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> FoodListData(@Param("start") int start, @Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM food_menu_house")
	public int FoodTotalPage();
	
	@Select("SELECT fno,score,poster,name,type,address,phone,theme,price,seat,time FROM food_menu_house WHERE fno=#{fno}")
	public FoodVO foodDetailData(int no);
}
