package com.sist.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;
public interface BoardMapper {
	@Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num "
			+ "FROM (SELECT no,subject,name,regdate,hit,rownum as num "
			+ "FROM (SELECT /*+INDEX_DESC(vueBoard vb_no_pk)*/no,subject,name,regdate,hit FROM vueBoard)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(@Param("start") int start, @Param("end") int end);//2개 이상 데이터를 넣으려면 param이 있어야됨
	
	@Select("SELECT CEIL(COUNT(*)/10.0) FROM vueBoard")
	public int boardTotalPage();
	
	@Insert("INSERT INTO vueBoard(no,name,subject,content,pwd) VALUES(vb_seq.nextval,#{name, jdbcType=VARCHAR},#{subject, jdbcType=VARCHAR},#{content, jdbcType=VARCHAR},#{pwd, jdbcType=VARCHAR})")
	public void boardInsert(BoardVO vo);
	
	//상세보기 
	@Select("SELECT no,subject,name,hit,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,content,pwd "
			+ "FROM vueBoard WHERE no=#{no}")
	public BoardVO BoardDetailData(int no);
	
	@Update("UPDATE vueBoard SET hit=hit+1 WHERE no=#{no}")
	public void hitIncrement(int no);
	//수정
	@Select("SELECT pwd FROM vueBoard WHERE no=#{no}")
	public String boardGetPassword(int no);
	
	@Update("UPDATE vueBoard SET name=#{name},subject=#{subject},content=#{content} WHERE no=#{no}")
	public void boardUpdate(BoardVO vo);
	//삭제
	@Delete("DELETE FROM vueBoard WHERE no=#{no}")
	public void boardDelete(int no);
}
