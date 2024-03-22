package com.sist.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.mapper.*;
import com.sist.vo.*;
import java.util.*;

//스프링에 관리 요청 => interface/VO(데이터형)
@Repository // id를 따로 설정안하면 foodDAO로 됨
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	
    public List<FoodVO> foodListData(int start,int end){
    	return mapper.foodListData(start, end);
    }
	
	public int foodTotalPage()
	{
		return mapper.foodTotalPage();
	}
	
	public FoodVO foodDetailData(int fno)
	{
		return mapper.foodDetailData(fno);
	}
	
}
