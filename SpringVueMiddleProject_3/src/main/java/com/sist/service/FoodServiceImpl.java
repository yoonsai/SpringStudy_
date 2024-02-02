package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.*;
import com.sist.vo.*;

@Service
public class FoodServiceImpl implements FoodService{
    @Autowired
    private FoodDAO dao;
    
    @Autowired
    private MemberDAO mdao;
    
	@Override
	public List<FoodVO> FoodListData(int start, int end) {
		// TODO Auto-generated method stub
		return dao.FoodListData(start, end);
	}

	@Override
	public int FoodTotalPage() {
		// TODO Auto-generated method stub
		return dao.FoodTotalPage();
	}

	@Override
	public FoodVO foodDetailData(int no) {
		// TODO Auto-generated method stub
		return dao.foodDetailData(no);
	}

	@Override
	public MemberVO isLogin(String id, String pwd) {
		// TODO Auto-generated method stub
		return mdao.isLogin(id, pwd);
	}
	
	
	

}
