package com.sist.dao;
// MapperFactoryBean에서 해당 인터페이스를 구현
/*
 *  1. <select> => @Select()
 *  2. id  => 메소드명
 *  3. resultType => 리턴형
 *  4. parameterType => 매개변수
 * 
 */
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
public interface StudentMapper {
	/*
	 *  <select id="studentListData" resultType="StudentVO">
	 *     SELECT * FROM student
	 *  </select>
	 * 
	 */
	@Select("SELECT * FROM student")
	public List<StudentVO> studentListData();
	/*
	 *  <select id="studentDetailData" resultType="StudentVO" parameterType="int">
	 *     SELECT * FROM student WHERE hakbun=#{hakbun}
	 *  </select>
	 * 
	 * 
	 * #{hakbun} 
	 * $ => 테이블명
	 */
	@Select("SELECT * FROM student WHERE hakbun=#{hakbun}")
	public StudentVO studentDetailData(int hakbun);

	
	@Insert("INSERT INTO student VALUES(std_hak_seq.nextval,#{name},#{kor},#{eng},#{math})")
	public void studentInsertData(StudentVO vo);
	
	@Delete("DELETE FROM student WHERE hakbun=#{hakbun}")
	public void studentDelete(int hakbun);
	
	@Update("UPDATE student SET name=#{name},kor=#{kor},eng=#{eng},math=#{math} WHERE hakbun=#{hakbun}")
	public void studentUpdate(StudentVO vo);
	/*
	 * 
	 *  CRUD 
	 *  Create Read Update Delete
	 *  => INSERT SELECT 
	 */
}
