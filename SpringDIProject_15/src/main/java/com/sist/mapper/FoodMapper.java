package com.sist.mapper;
/*
 *  name => N
 *  address => A
 *  type => T
 *  name+address => NA
 *  name+type => NT
 *  name+address+type => NAT
 * 
 *  if(ss=="N")
 *  OR name LIKE ~
 *  else if(ss=="A")
 *  OR address LIKE ~
 *  else if(ss=="T")
 *  OR type LIKE ~
 *  
 * 
 */

import java.util.*;
// (name LIKE '%'||#{ss}||'%') OR (address LIKE '%'||#{ss}||'%')
import org.apache.ibatis.annotations.Select;

import com.sist.dao.FoodVO;
public interface FoodMapper {
//	 @Select("<script>"
//			 +"SELECT fno,name,type,address "
//			 +"FROM food_menu_house "
//			 +"WHERE "
//			 +"<trim prefix=\"(\" suffix=\")\" prefixOverrides=\"OR\">"
//			 +"<foreach collection=\"fsArr\" item=\"fd\">"
//			 +"<trim prefix=\"OR\">"
//			 +"<choose>"
//			 +"<when test=\"fd=='N'.toString()\">"
//			 +"name LIKE '%'||#{ss}||'%'"
//			 +"</when>"
//			 +"<when test=\"fd=='A'.toString()\">"
//			 +"address LIKE '%'||#{ss}||'%'"
//			 +"</when>"
//			 +"<when test=\"fd=='T'.toString()\">"
//			 +"type LIKE '%'||#{ss}||'%'"
//			 +"</when>"
//			 +"</choose>"
//			 +"</trim>"
//			 +"</foreach>"
//			 +"</trim>"
//			 +"</script>"
//			)

	@Select("<script>"
			 +"SELECT fno,name,type,address "
			 +"FROM food_menu_house "
			 +"WHERE "
			 +"<trim prefixOverrides=\"OR\">"
			 +"<foreach collection=\"fsArr\" item=\"fd\">"
			 +"<choose>"
			 +"<when test=\"fd=='N'.toString()\">"
			 +"OR name LIKE '%'||#{ss}||'%'"
			 +"</when>"
			 +"<when test=\"fd=='A'.toString()\">"
			 +"OR address LIKE '%'||#{ss}||'%'"
			 +"</when>"
			 +"<when test=\"fd=='T'.toString()\">"
			 +"OR type LIKE '%'||#{ss}||'%'"
			 +"</when>"
			 +"</choose>"
			 +"</foreach>"
			 +"</trim>"
			 +"</script>"
			)
	/*
	 * 
	 *  <trim prefix="(" suffix=")">
	 *      name LIKE '%'||#{ss}||'%'
	 *  </trim>
	 *  
	 *  => (name LIKE '%'||#{ss}||'%')
	 *  
	 *  <trim prefix="(" suffix=")" prefixOverrides="(">
	 *      name LIKE '%'||#{ss}||'%'
	 *  </trim>
	 *  
	 *  => name LIKE '%'||#{ss}||'%') => 앞에 (를 추가하고 뒤에 )를 추가한다음에 맨 앞에 (를 제거해달라 => (suffixOverrides=")")는 뒤에를 제거
	 *  
	 *  
	 *  <foreach>의 collection에는 배열아님 리스트만 들어갈 수 있다
	 *  <foreach collection="frArr" item="fd'> 
	 *  => for(String fd:frArr)
	 *     {
	 *     
	 *     }
	 */
	
	public List<FoodVO> foodFindData(Map map);
	
}
