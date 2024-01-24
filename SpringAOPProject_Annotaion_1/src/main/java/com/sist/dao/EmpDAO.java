package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAO {
	private MyDataSource ds;
	private Connection conn;
	private PreparedStatement ps;
	public void setDs(MyDataSource ds) {
		this.ds = ds;
	}
	/*
	 *  @Autowired
	 *  => 자동 주입
	 *  public class A
	 *  {
	 *     @Autowired
	 *     private B b; => FIELD
	 *     
	 *     @Autowired 
	 *     public A(B b) => 생성자
	 *     {
	 *     }
	 *     
	 *     @Autowired
	 *     public void setB(B b) => setter
	 *     {
	 *     }
	 *     
	 *     @Autowired
	 *     public void init(B b) => 일반 메소드
	 *     {
	 *     }
	 *  }
	 *  
	 * 
	 * 
	 */
	@Autowired
	public EmpDAO(MyDataSource ds)
	{
		this.ds=ds;
		try {
			Class.forName(ds.getDriver());
		}catch(Exception e)
		{
			
		}
	}
	public void getConnection()
	{
		try
		{
		   conn=DriverManager.getConnection(ds.getUrl(),ds.getUsername(),ds.getPassword());
		   
		}catch(Exception e)
		{
			
		}
	}
	public void disConnection()
	{
		try {
			
			if(ps!=null)
				ps.close();
			if(conn!=null)
				conn.close();
		}catch(Exception e) {}
	}
	//전체 목록
	public List<EmpVO> empListData()
	{
		List<EmpVO> list=new ArrayList<EmpVO>();
		try {
			//Around
			String sql="SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD'),sal FROM emp";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				EmpVO vo=new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setDbday(rs.getString(4));
				vo.setSal(rs.getInt(5));
				list.add(vo);
			}
			//Around
		}catch(Exception ex)
		{
			//After-Throwing
			ex.printStackTrace();
		}finally {
			// after => disConnection
		}
		return list;
	}
	//상세보기
	public EmpVO empDetailData(int empno)
	{
		EmpVO vo=new EmpVO();
		try {
			//Around
			String sql="SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD'),sal FROM emp WHERE empno="+empno;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setDbday(rs.getString(4));
				vo.setSal(rs.getInt(5));
			//Around
		}catch(Exception ex)
		{
			//After-Throwing
			ex.printStackTrace();
		}finally {
			// after => disConnection
		}
		return vo;
	}
	
}
