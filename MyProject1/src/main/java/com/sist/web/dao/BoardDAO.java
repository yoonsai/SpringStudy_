package com.sist.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sist.web.entity.Board;
import com.sist.web.entity.BoardVO;

public interface BoardDAO extends JpaRepository<Board, Integer>{
	//상세보기
	public Board findByNo(int no);
	
	@Query(value="SELECT * "
			+ "FROM thboard ORDER BY no DESC "
			+ "LIMIT :start,7",nativeQuery = true)
	public List<Board> boardListData(@Param("start") int start); 
}
