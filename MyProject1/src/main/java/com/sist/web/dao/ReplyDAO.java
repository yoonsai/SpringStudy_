package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.Reply;

import jakarta.transaction.Transactional;

public interface ReplyDAO extends JpaRepository<Reply, Integer>{
	@Query(value="SELECT * FROM myreply WHERE fno=:fno ORDER BY no DESC",nativeQuery = true)
	public List<Reply> replyListData(@Param("fno") int fno);
	   
	public Reply findByNo(int no);
	
	@Transactional
	public void deleteByNo(int no);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE myreply SET content=:content WHERE no=:no",nativeQuery = true)
	public void replyUpdate(@Param("content") String content,@Param("no") Integer no);
}
