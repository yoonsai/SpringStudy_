package com.sist.service;

import java.util.List;

import com.sist.vo.FoodVO;
import com.sist.vo.MemberVO;

public interface FoodService {
	public List<FoodVO> FoodListData(int start,int end);
	
	public int FoodTotalPage();
	
	public FoodVO foodDetailData(int no);
	
	public MemberVO isLogin(String id,String pwd);

}
