package com.sist.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.ibatis.annotations.Result;

import com.mysql.cj.xdevapi.PreparableStatement;

public class MainClass {
	public static void main(String[] args) {
		connection();
	}
	public static void connection() {
		String url="jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";
		String driver="com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url,"root","root");
			String sql="SELECT goods_name,goods_price FROM goods_all ORDER BY no ASC "
					+ "LIMIT 0,20";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2));
			}
			rs.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
