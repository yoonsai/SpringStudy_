package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.ReserveMapper;
import com.sist.vo.FoodVO;
import com.sist.vo.ReserveVO;
@Repository
public class ReserveDAO {
	@Autowired
	private ReserveMapper mapper;
	public List<FoodVO> foodReserveData(String type)
	{
		return mapper.foodReserveData(type);
	}
	public void foodReserveInsert(ReserveVO vo)
	{
		mapper.foodReserveInsert(vo);
	}
	public List<ReserveVO> reserveMypageData(String userId)
	{
		return mapper.reserveMypageData(userId);
	}
	public void reserveCancel(int rno)
	{
		mapper.reserveCancel(rno);
	}
	public List<ReserveVO> reserveAdminpageData()
	{
		return mapper.reserveAdminpageData();
	}
	public void ReserveOk(int rno)
	{
		mapper.ReserveOk(rno);
	}
	public ReserveVO reserveInfoData(int rno)
	{
		return mapper.reserveInfoData(rno);
	}
}
