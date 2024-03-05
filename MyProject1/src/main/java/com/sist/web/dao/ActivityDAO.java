package com.sist.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sist.web.entity.Activity;
import com.sist.web.entity.Food;


public interface ActivityDAO extends JpaRepository<Activity, Integer> {
	
	public Activity findByNo(int no);
	
	@Query(value="SELECT * "
			+ "FROM activity ORDER BY hit DESC "
			+ "LIMIT 0,4",nativeQuery=true)
	public List<Activity> activityMainListData();
	
	@Query(value="SELECT * "
			+ "FROM activity WHERE title LIKE CONCAT('%',:title,'%') ORDER BY no ASC "
			+ "LIMIT :start,12",nativeQuery=true)
	public List<Activity> activityListData(@Param("start") Integer start,@Param("title") String title);
	
	@Query(value="SELECT COUNT(*) FROM activity WHERE title LIKE CONCAT('%',:title,'%')",nativeQuery=true)
	public int activityRowCount(@Param("title") String title);
}
