package com.sist.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.sist.vo.FoodVO;
import com.sist.vo.NoticeVO;
import com.sist.vo.RecipeVO;

public interface FoodService {
	
	public List<FoodVO> foodFindData(Map map);
	public int foodFindCount(Map map);
	public FoodVO foodDetailData(int fno);
	public List<FoodVO> foodListData(Map map);
	public int foodListCount();
	public FoodVO foodListDetailData(int fno);
	public List<NoticeVO> noticeTop7();
	public List<FoodVO> foodTop7();
	public List<FoodVO> foodHome12();
	public List<String> foodAllData();
	public List<FoodVO> foodNameInfoData(String name);
	public List<RecipeVO> foodRecipeData(String title);
}
