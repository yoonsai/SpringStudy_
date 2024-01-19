package com.sist.di;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {
	private CommonsDAO comm;
	private Connection conn;
	private PreparedStatement ps;
	public void setComm(CommonsDAO comm) {
		this.comm = comm;
	}
	public void init()
	{
		System.out.println("======사원정보======");
	}
	public List<EmpVO> empListData()
	{
		List<EmpVO> list=new ArrayList<EmpVO>();
		try {
			conn=comm.getConnection();
			String sql="SELECT empno,ename,job,hiredate FROM emp";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				EmpVO vo=new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setHiredate(rs.getDate(4));
				list.add(vo);
			}
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			comm.disConnection(conn, ps);
		}
		return list;
	}
	
}
