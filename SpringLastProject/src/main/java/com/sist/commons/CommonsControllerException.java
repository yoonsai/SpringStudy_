package com.sist.commons;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.io.*;
import java.sql.*;
@ControllerAdvice
public class CommonsControllerException {
	@ExceptionHandler(RuntimeException.class)
	public void runtimeException(RuntimeException ex)
	{
		System.out.println("=================== RuntimeException 발생 ====================");
		ex.printStackTrace();
		System.out.println("=============================================================");
	}
	
	@ExceptionHandler(IOException.class)
	public void IOException(IOException ex)
	{
		System.out.println("=================== IOException 발생 ====================");
		ex.printStackTrace();
		System.out.println("=============================================================");
	}
	@ExceptionHandler(SQLException.class)
	public void SQLException(SQLException ex)
	{
		System.out.println("=================== SQLException 발생 ====================");
		ex.printStackTrace();
		System.out.println("=============================================================");
	}
	
	
	
}
