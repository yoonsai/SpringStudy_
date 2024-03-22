package com.sist.mapper;
import java.util.*;
import com.sist.vo.*;
public interface BoardMapper {
  /*
   *   <select id="boardListData" resultType="BoardVO" parameterType="int">
	    SELECT no,subject,name,DATE_FORMAT(regdate,'%Y-%m-%d') as dbday,hit
	    FROM board
	    ORDER BY no DESC
	    LIMIT #{start},10
	  </select>
  */
   public List<BoardVO> boardListData(int start);
  /*
  <select id="boardTotalPage" resultType="int">
    SELECT CEIL(COUNT(*)/10.0) FROM board
  </select>
   */
   public int boardTotalPage();
   /*
    *  <insert id="boardInsert" parameterType="BoardVO">
		   INSERT INTO board(name,subject,content,pwd) 
		   VALUES(#{name},#{subject},#{content},#{pwd})
		  </insert>
    */
   public void boardInsert(BoardVO vo);
   /*
    *   <update id="hitIncrement" parameterType="int">
		   UPDATE board SET 
		   hit=hit+1
		   WHERE no=#{no}
		  </update>
  */
   public void hitIncrement(int no);
   /*
		  <select id="boardDetailData" resultType="BoardVO" parameterType="int">
		    SELECT no,name,subject,content,DATE_FORMAT(regdate,'%Y-%m-%d') as dbday,hit
		    FROM board
		    WHERE no=#{no}
		  </select>
    */
   public BoardVO boardDetailData(int no);
   /*
    *  <select id="boardGetPassword" resultType="String" parameterType="int">
    SELECT pwd
    FROM board
    WHERE no=#{no}
  </select>
  
  <update id="boardUpdateData" parameterType="BoardVO">
    UPDATE board SET name=#{name},content=#{content},subject=#{subject} WHERE no=#{no}
  </update>
    * 
    * 
    */
   public void boardUpdateData(BoardVO vo);
   
   public String boardGetPassword(int no);
}
