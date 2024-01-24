package com.sist.dao;

import java.util.*;
import org.springframework.web.multipart.MultipartFile;
import lombok.Data;

@Data
public class DataBoardVO {
	private int no,hit,filecount;
	private String name,subject,content,pwd,dbday,filename,filesize;
	private Date regdate;
	private List<MultipartFile> files;
}
