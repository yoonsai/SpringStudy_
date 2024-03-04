package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Food {
	@Id
	private int no;
	private int hit,heart,jjim;
	private String title,poster,tag;
	private String cont,menu,addr,phone,restday,bhour,deimage;
}
