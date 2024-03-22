package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.ReserveDAO;
import com.sist.vo.FoodVO;
import com.sist.vo.ReserveVO;
@Service
public class ReserveServiceImpl implements ReserveService{
	@Autowired
	private ReserveDAO dao;
	@Override
	public List<FoodVO> foodReserveData(String type) {
		// TODO Auto-generated method stub
		return dao.foodReserveData(type);
	}

	@Override
	public void foodReserveInsert(ReserveVO vo) {
		// TODO Auto-generated method stub
		dao.foodReserveInsert(vo);
	}

	@Override
	public List<ReserveVO> reserveMypageData(String userId) {
		// TODO Auto-generated method stub
		return dao.reserveMypageData(userId);
	}

	@Override
	public void reserveCancel(int rno) {
		// TODO Auto-generated method stub
		dao.reserveCancel(rno);
	}

	@Override
	public List<ReserveVO> reserveAdminpageData() {
		// TODO Auto-generated method stub
		return dao.reserveAdminpageData();
	}

	@Override
	public void ReserveOk(int rno) {
		// TODO Auto-generated method stub
		dao.ReserveOk(rno);
	}

	@Override
	public ReserveVO reserveInfoData(int rno) {
		// TODO Auto-generated method stub
		return dao.reserveInfoData(rno);
	}

}
