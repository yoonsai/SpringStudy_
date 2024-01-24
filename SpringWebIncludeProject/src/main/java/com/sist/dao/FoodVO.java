package com.sist.dao;

import lombok.Data;

@Data
public class FoodVO {
	private int fno,hit;
	private double score;
	private String name,address,type,poster,phone,theme,price,seat,time,content,rday;
}
