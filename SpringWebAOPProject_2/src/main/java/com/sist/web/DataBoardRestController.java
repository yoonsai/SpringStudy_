package com.sist.web;

import java.io.File;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.dao.DataBoardDAO;
import com.sist.dao.DataBoardVO;

@RestController
@RequestMapping("databoard/") // 공통되는 경로를 따로 빼줌
public class DataBoardRestController {
	@Autowired
	private DataBoardDAO dao;
	
	@PostMapping("delete_ok.do")
	public String databoard_delete(int no,String pwd,HttpServletRequest request)
	{
		String result="";
		String path=request.getSession().getServletContext().getRealPath("/")+"upload\\";
		System.out.println(request.getSession().getServletContext().getRealPath("/"));
		path=path.replace("\\", File.separator);
		try {
		    DataBoardVO vo=dao.databoardDetailData(no);
		    boolean bCheck=dao.dataBoardDeleteData(no, pwd);
		    if(bCheck==true)
		    {
		    	result="yes";
		    	if(vo.getFilecount()>0)
		    	{
		    		StringTokenizer st=new StringTokenizer(vo.getFilename(),",");
		    		while(st.hasMoreTokens())
		    		{
		    			String filename=st.nextToken();
		    			File file=new File(path+filename);
		    			file.delete();
		    			
		    		}
		    	}
		    }
		    else {
		    	result="no";
		    }
		}catch(Exception e)
		{
			
		}
		return result;
	}
}
