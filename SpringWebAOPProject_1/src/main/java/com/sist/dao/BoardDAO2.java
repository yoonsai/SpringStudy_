package com.sist.dao;

import java.sql.*;

import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO2 {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin@localhost:1521:XE";
	public BoardDAO2()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e)
		{
			
		}
	}
	public void getConnection()
	{
		try {
			conn=DriverManager.getConnection(URL,"hr","happy");
		}catch(Exception e) {}
		
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
	
	//답변하기 
	/*
	 *  Insert => commit
	 *  Update => commit => error
	 *  Insert => commit
	 *  
	 *  트랜잭션 = 일괄처리
	 *  
	 *  Insert => commit 입고
	 *  
	 *  Insert => commit 재고
	 *  
	 *  commit
	 */
	public void boardReplyInsert(int pno,BoardVO vo)
	{
		try {
		
			//연결
			getConnection();
			//commit해제 
			conn.setAutoCommit(false);//Around
			String sql="SELECT group_id,group_step,group_tab FROM springReplyBoard WHERE no="+pno;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			int gi=rs.getInt(1);
			int gs=rs.getInt(2);
			int gt=rs.getInt(3);
			rs.close();
			ps.close();
			sql="UPDATE springReplyBoard SET group_step=group_step+1 WHERE group_id=? AND group_step>?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, gi);
			ps.setInt(2, gs);
			ps.executeUpdate();
			ps.close();
			// update
			/*                 gi   gs   gt
			 *   AAAA          1     0    0
			 *     => BBBB     1     1    1
			 *       => CCC    1     2    2
			 *   BBBB          2     0
			 */
			// insert
			sql="INSERT INTO springReplyBoard VALUES(sr_no_sql.nextval,?,?,?,?,SYSDATE,0,?,?,?,?,0)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getSubject());
			ps.setString(3, vo.getContent());
			ps.setString(4, vo.getPwd());
			ps.setInt(5, gi);
			ps.setInt(6, gs+1);
			ps.setInt(7, gt+1);
			ps.setInt(8, pno);
			ps.executeUpdate();
			ps.close();
			// update
			sql="UPDATE springReplyBoard SET depth=depth+1 WHERE no="+pno;
			ps=conn.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			conn.commit();
		}catch(Exception e)
		{
			try {
				conn.rollback(); //@AfterThrowing
				e.printStackTrace();
			}catch(Exception ex) {}
		}finally {
			try {
				conn.setAutoCommit(true); //@Around
			}catch(Exception ex) {}
		}
	}
}
