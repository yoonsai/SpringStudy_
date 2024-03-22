package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;

@Repository
public class FoodDAO {
   @Autowired
   private FoodMapper mapper;
   
   public List<FoodVO> foodFindData(Map map)
   {
	   return mapper.foodFindData(map);
   }
   
   public int foodFindCount(Map map)
   {
	   return mapper.foodFindCount(map);
   }
   
   public FoodVO foodDetailData(int fno)
   {
	   return mapper.foodDetailData(fno);
   }
   
   public List<FoodVO> foodListData(Map map)
   {
	   return mapper.foodListData(map);
   }
   
   public int foodListCount()
   {
	   return mapper.foodListCount();
   }
   
   public FoodVO foodListDetailData(int fno)
   {
	   mapper.foodHitIncrement(fno);
	   return mapper.foodDetailData(fno);
   }
   
   public List<FoodVO> foodTop7()
   {
	  return mapper.foodTop7();   
   }
   
   public List<FoodVO> foodHome12()
   {
	   return mapper.foodHome12();
   }
   public List<String> foodAllData()
   {
	  return mapper.foodAllData();   
   }
   public List<FoodVO> foodNameInfoData(String name)
   {
	   return mapper.foodNameInfoData(name);
   }
   public List<RecipeVO> foodRecipeData(String title)
   {
	   return mapper.foodRecipeData(title);
   }
}
