package com.sist.vo;
/*
 * 
 * 
 * FNO                                       NOT NULL NUMBER
 POSTER                                    NOT NULL VARCHAR2(1000)
 NAME                                      NOT NULL VARCHAR2(300)
 TYPE                                      NOT NULL VARCHAR2(100)
 ADDRESS                                   NOT NULL VARCHAR2(500)
 PHONE                                     NOT NULL VARCHAR2(100)
 SCORE                                              NUMBER(2,1)
 THEME                                     NOT NULL VARCHAR2(4000)
 PRICE                                              VARCHAR2(100)
 TIME                                               VARCHAR2(200)
 SEAT                                               VARCHAR2(100)
 CONTENT                                            CLOB
 LINK                                               VARCHAR2(300)
 */

import lombok.Data;

@Data
public class FoodVO {
	private int fno;
	private double score;
	private String poster,name,type,address,phone,theme,price,seat,time,sessionId;

}
