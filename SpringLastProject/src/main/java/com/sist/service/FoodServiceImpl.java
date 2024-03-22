package com.sist.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.FoodDAO;
import com.sist.dao.NoticeDAO;
import com.sist.vo.FoodVO;
import com.sist.vo.NoticeVO;
import com.sist.vo.RecipeVO;
@Service
public class FoodServiceImpl implements FoodService{
	@Autowired
	private FoodDAO fdao;
	@Autowired
	private NoticeDAO ndao;
	@Override
	public List<FoodVO> foodFindData(Map map) {
		// TODO Auto-generated method stub
		return fdao.foodFindData(map);
	}

	@Override
	public int foodFindCount(Map map) {
		// TODO Auto-generated method stub
		return fdao.foodFindCount(map);
	}

	@Override
	public FoodVO foodDetailData(int fno) {
		// TODO Auto-generated method stub
		return fdao.foodDetailData(fno);
	}

	@Override
	public List<FoodVO> foodListData(Map map) {
		// TODO Auto-generated method stub
		return fdao.foodListData(map);
	}

	@Override
	public int foodListCount() {
		// TODO Auto-generated method stub
		return fdao.foodListCount();
	}

	@Override
	public FoodVO foodListDetailData(int fno) {
		// TODO Auto-generated method stub
		return fdao.foodListDetailData(fno);
	}

	@Override
	public List<NoticeVO> noticeTop7() {
		// TODO Auto-generated method stub
		return ndao.noticeTop7();
	}

	@Override
	public List<FoodVO> foodTop7() {
		// TODO Auto-generated method stub
		return fdao.foodTop7();
	}

	@Override
	public List<FoodVO> foodHome12() {
		// TODO Auto-generated method stub
		return fdao.foodHome12();
	}

	@Override
	public List<String> foodAllData() {
		// TODO Auto-generated method stub
		return fdao.foodAllData();
	}

	@Override
	public List<FoodVO> foodNameInfoData(String name) {
		// TODO Auto-generated method stub
		return fdao.foodNameInfoData(name);
	}

	@Override
	public List<RecipeVO> foodRecipeData(String title) {
		// TODO Auto-generated method stub
		return fdao.foodRecipeData(title);
	}

	
	
}
