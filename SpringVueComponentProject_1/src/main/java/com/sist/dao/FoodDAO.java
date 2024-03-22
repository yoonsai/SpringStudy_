package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.FoodMapper;
import com.sist.vo.FoodVO;

//스프링에 의해 메모리 할당 => 필요시마다 사용이 가능 => 클래스 관리자
//클래스 : 컴포넌트, => 여러개 묶어서 관리하는 영역 (container) => 스프링은 컨테이너다

@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	
    public List<FoodVO> foodListData(int start,int end)
    {
    	return mapper.foodListData(start, end);
    }
	
	public int foodTotalPage() {
		return mapper.foodTotalPage();
	}
}
