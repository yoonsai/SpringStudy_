package com.sist.dao;

import java.util.List;

public class SeoulDAO {
	private SeoulMapper mapper;
	
	public void setMapper(SeoulMapper mapper) {
		this.mapper = mapper;
	}
	public List<SeoulVO> natureListData()
	{
		return mapper.natureListData();
	}
	public SeoulVO natureDetailData(int no)
	{
		return mapper.natureDetailData(no);
	}
	
	public List<SeoulVO> natureFindListData(String title)
	{
		return mapper.natureFindData(title);
	}

	public List<SeoulVO> shopListData()
	{
		return mapper.shopListData();
	}
	public SeoulVO shopDetailData(int no)
	{
		return mapper.shopDetailData(no);
	}
	
	public List<SeoulVO> shopFindListData(String title)
	{
		return mapper.shopFindData(title);
	}
}
