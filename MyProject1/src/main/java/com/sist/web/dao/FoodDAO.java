package com.sist.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sist.web.entity.Food;

/*
 * 
 * NO int 
TITLE text 
POSTER text 
HIT int 
CONT text 
MENU text 
ADDR text 
PHONE text 
RESTDAY text 
BHOUR text 
TAG text 
HEART int 
DEIMAGE text 
RDATE text 
JJIM int
 */

public interface FoodDAO extends JpaRepository<Food, Integer>{
	@Query(value="SELECT * "
			+ "FROM food ORDER BY no ASC "
			+ "LIMIT :start,12",nativeQuery=true)
	public List<Food> foodListData(@Param("start") int start);
	
	public Food findByNo(int no);
	
	@Query(value="SELECT COUNT(*) FROM food",nativeQuery=true)
	public int foodRowCount();
}
