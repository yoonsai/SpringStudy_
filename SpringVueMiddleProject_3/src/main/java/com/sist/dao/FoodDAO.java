package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.FoodMapper;
import com.sist.vo.FoodVO;
// 구현된 메퍼를 사용하는 클래스 => 유지보스를 할 경우에 => 다른 클래스에 영향
@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	
    public List<FoodVO> FoodListData(int start,int end)
    {
    	return mapper.FoodListData(start, end);
    }
    
	
	public int FoodTotalPage()
	{
		return mapper.FoodTotalPage();
	}

	public FoodVO foodDetailData(int no)
	{
		return mapper.foodDetailData(no);
	}
}
