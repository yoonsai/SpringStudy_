package com.sist.mapper;

import java.util.*;
import org.apache.ibatis.annotations.Select;
import com.sist.dao.*;

public interface GoodsMapper {
	@Select("SELECT no,goods_name,goods_poster,goods_price,num "
			+ "FROM (SELECT no,goods_name,goods_poster,goods_price,rownum as num "
			+ "FROM (SELECT no,goods_name,goods_poster,goods_price "
			+ "FROM goods_all ORDER BY no ASC)) "
			+ "WHERE no BETWEEN #{start} AND #{end}")
	public List<GoodsVO> goodsListData(Map map);
	
	
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM goods_all")
	public int goodsTotalPage();
	
	
}
