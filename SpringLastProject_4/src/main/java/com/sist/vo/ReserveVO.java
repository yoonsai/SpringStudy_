package com.sist.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ReserveVO {
/*
 * rno NUMBER,
  fno NUMBER,
  userId VARCHAR2(20),
  rDate VARCHAR2(100),
  rTime VARCHAR2(20),
  rInwon VARCHAR2(20),
  regdate DATE,
  reserve_ok NUMBER DEFAULT 0,
 */
	private int rno,fno,reserve_ok;
	private String userId,rDate,rTime,rInwon,dbday;
	private Date regdate;
	private FoodVO fvo=new FoodVO();
}
