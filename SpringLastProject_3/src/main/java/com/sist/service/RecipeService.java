package com.sist.service;

import java.util.List;
import java.util.Map;

import com.sist.vo.ChefVO;
import com.sist.vo.GoodsVO;
import com.sist.vo.RecipeDetailVO;
import com.sist.vo.RecipeVO;

public interface RecipeService {
	public List<RecipeVO> recipeHome12();
	public List<ChefVO> chefHome12();
	public int recipeCount();
	public List<RecipeVO> recipeListData(int start,int end);
	public int recipeTotalPage();
	public List<ChefVO> chefListData(int start,int end);
	public int chefTotalPage();
	public List<RecipeVO> chefDetailData(Map map);
	public int chefDetailTotalPage(int cno);
	public List<RecipeVO> chefDetailFindData(Map map);
	public int chefDetailFindTotalPage(Map map);
	public RecipeDetailVO recipeDetailData(int no);
	public List<GoodsVO> recipeGoodsData(String goods_name);
}