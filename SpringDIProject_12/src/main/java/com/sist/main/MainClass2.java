package com.sist.main;
import java.util.*;
import java.io.*;
import com.sist.temp.*;
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		    String path="C:\\springDev\\springStudy\\SpringDIProject_12\\src\\main\\java";
		    String pack="com.sist.temp";
		    path=path+"\\"+pack.replace(".", "\\");
		    System.out.println(path);
			File dir=new File(path);
			File[] files=dir.listFiles();
			for(File f:files)
			{
				String ff=f.getName();
				String ext=ff.substring(ff.lastIndexOf(".")+1);
				System.out.println(ext);
				if(ext.equals("java"))
				{
					String ss=ff.substring(0,ff.lastIndexOf("."));
					String res=pack+"."+ss;
					System.out.println(res);
				}
			}
		    
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
