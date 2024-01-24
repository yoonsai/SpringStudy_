package com.sist.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
// MVC기초 => Jquery => Vue
/*
 *  Spring MVC
 *   => 1. web.xml
 *         DispatcherServlet 등록 => 서블릿은 URL에 따라서 톰캣에 의해 호출
 *         =================
 *         | Servlet => init() => sevice() => destory()
 *                        |
 *                     WebApplicationContext() => 클래스 정보를 넘겨준다
 *                     =======================
 *                     <init-param>
 *                       <param-name>contextConfigLocation</param-name>
 *                       <param-name>/WEB-INF/config/application-*.xml</param-name>
 *                     </init-param>
 * 
 * 
 */
@Repository
public class DataBoardDAO {
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
	private DataBoardMapper mapper;
	public List<DataBoardVO> databoardListData(int start,int end)
	{

		return mapper.databoardListData(start, end);
	}
	public void databoardInsert(DataBoardVO vo) {
		
		mapper.databoardInsert(vo);
	}
	public int databoardTotalPage() {
		return mapper.databoardTotalPage();
	}
	public DataBoardVO databoardDetailData(int no)
	{
		mapper.hitIncrement(no);
		return mapper.databoardDetailData(no);
	}
	public void databoardDeleteData(int no)
	{
		mapper.databoardDeleteData(no);
	}
	public DataBoardVO databoardFileInfoData(int no)
	{
		return mapper.databoardFileInfoData(no);
	}
	public boolean dataBoardDeleteData(int no,String pwd)
	{
		boolean bCheck=false;
		String db_pwd=mapper.databoardGetPassword(no);
		if(encoder.matches(pwd, db_pwd))
		{
			bCheck=true;
			mapper.databoardDeleteData(no);
		}
		return bCheck;
	}
	public boolean databoardUpdate(DataBoardVO vo)
	{
		boolean bCheck=false;
		String db_pwd=mapper.databoardGetPassword(vo.getNo());
		if(encoder.matches(vo.getPwd(), db_pwd))
		{
			bCheck=true;
			mapper.databoardUpdate(vo);
		}
		return bCheck;
	}
}
