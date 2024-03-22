package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;
public interface FoodMapper {
  @Select("SELECT fno,poster,name,num "
		 +"FROM (SELECT fno,poster,name,rownum as num "
		 +"FROM (SELECT fno,poster,name "
		 +"FROM food_menu_house "
		 +"WHERE address LIKE '%'||#{address}||'%' "
		 +"ORDER BY fno ASC)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<FoodVO> foodFindData(Map map);
  
  @Select("SELECT CEIL(COUNT(*)/20.0) FROM food_menu_house "
		 +"WHERE address LIKE '%'||#{address}||'%'")
  public int foodFindCount(Map map);
  
  /*
   *   private int fno;
       private double score;
       private String poster,name,type,address,phone,theme,price,time,seat,sessionId;
   */
      @Select("SELECT fno,score,poster,name,type,address,phone,theme,price,time,seat "
		     +"FROM food_menu_house "
		     +"WHERE fno=#{fno}")
      public FoodVO foodDetailData(int fno);
  
      @Update("UPDATE food_menu_house SET "
    		 +"hit=hit+1 "
    		 +"WHERE fno=#{fno}")
      public void foodHitIncrement(int fno);
  
      @Select("SELECT fno,poster,name,num "
			 +"FROM (SELECT fno,poster,name,rownum as num "
			 +"FROM (SELECT fno,poster,name "
			 +"FROM food_menu_house "
			 +"ORDER BY fno ASC)) "
			 +"WHERE num BETWEEN #{start} AND #{end}")
	  public List<FoodVO> foodListData(Map map);
	  
	  @Select("SELECT CEIL(COUNT(*)/20.0) FROM food_menu_house")
	  public int foodListCount();
	  
	  @Select("SELECT fno,name,rownum "
			 +"FROM (SELECT fno,name "
			 +"FROM food_menu_house ORDER BY hit DESC) "
			 +"WHERE rownum<=7")
	  public List<FoodVO> foodTop7();
	  
	  @Select("SELECT fno,name,poster,rownum "
				 +"FROM (SELECT fno,name,poster "
				 +"FROM food_menu_house ORDER BY hit DESC) "
				 +"WHERE rownum<=12")
	  public List<FoodVO> foodHome12();
	  
	  @Select("SELECT name FROM food_menu_house WHERE length(name)>1 ORDER BY fno ASC")
	  public List<String> foodAllData();
	  
	  @Select("SELECT fno,name,poster "
			 +"FROM food_menu_house "
			 +"WHERE name=#{name}")
	  public List<FoodVO> foodNameInfoData(String name);
	  
	  
	  @Select("SELECT no,title,poster,rownum "
			 +"FROM recipe "
			 +"WHERE no IN(SELECT no FROM recipe "
			 +"INTERSECT SELECT no FROM recipeDetail) "
			 +"AND REGEXP_LIKE(title,#{title}) "
			 +"AND rownum<=12")
	  public List<RecipeVO> foodRecipeData(String title);
	  
}
