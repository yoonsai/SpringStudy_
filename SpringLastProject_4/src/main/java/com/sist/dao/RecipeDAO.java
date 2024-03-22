package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class RecipeDAO {
   @Autowired
   private RecipeMapper mapper;
   
   public List<RecipeVO> recipeHome12()
   {
	   return mapper.recipeHome12();
   }
   public List<ChefVO> chefHome12()
   {
	   return mapper.chefHome12();
   }
   
   public int recipeCount()
   {
	   return mapper.recipeCount();
   }
   public List<RecipeVO> recipeListData(int start,int end)
   {
	   return mapper.recipeListData(start, end);
   }
   public int recipeTotalPage()
   {
	   return mapper.recipeTotalPage();
   }
   public List<ChefVO> chefListData(int start,int end)
   {
	   return mapper.chefListData(start, end);
   }
   public int chefTotalPage()
   {
	   return mapper.chefTotalPage();
   }
   
   public List<RecipeVO> chefDetailData(Map map)
   {
	   return mapper.chefDetailData(map);
   }
   public int chefDetailTotalPage(int cno)
   {
	   return mapper.chefDetailTotalPage(cno);
   }
   
   public List<RecipeVO> chefDetailFindData(Map map)
   {
	   return mapper.chefDetailFindData(map);
   }
   public int chefDetailFindTotalPage(Map map)
   {
	   return mapper.chefDetailFindTotalPage(map);
   }
   public RecipeDetailVO recipeDetailData(int no)
   {
	   return mapper.recipeDetailData(no);
   }
   public List<GoodsVO> recipeGoodsData(String goods_name)
   {
	   return mapper.recipeGoodsData(goods_name);
   }
}
