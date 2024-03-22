package com.sist.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.*;
import com.sist.vo.*;
public interface ReplyMapper {
	//목록
	@Select("SELECT no,rno,userId,userName,msg,TO_CHAR(regdate,'YYYY-MM-DD') as dbday FROM projectRecipeReply WHERE rno=#{rno} ORDER BY no DESC")
	public List<ReplyVO> replyListData(int rno);
	//추가
	@Insert("INSERT INTO projectRecipeReply(no,rno,userId,userName,msg) VALUES(prr_no_seq.nextval,#{rno},#{userId},#{userName},#{msg})")
	public void replyInsert(ReplyVO vo);
	//수정
	@Update("UPDATE projectRecipeReply SET msg=#{msg} WHERE no=#{no}")
	public void replyUpdate(ReplyVO vo);
	//삭제
	@Delete("DELETE FROM projectRecipeReply WHERE no=#{no}")
	public void replyDelete(int no);
}
