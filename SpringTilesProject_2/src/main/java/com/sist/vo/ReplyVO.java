package com.sist.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	private int rno,fno;
	private String id,msg,name,dbday;
	private Date regdate;
}
