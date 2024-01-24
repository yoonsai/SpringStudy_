package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
@Repository("dao")  // EmpDAO => empDAO(default)
public class EmpDAO {
   //mapper를 구현한 클래스 주소를 자동주입
   @Autowired
   private EmpMapper mapper;
   public List<EmpVO> empListData()
   {
	   return mapper.empListData();
   }
}
