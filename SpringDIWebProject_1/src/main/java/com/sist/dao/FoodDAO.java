package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.FoodMapper;
/*
 *  어노테이션 : 구분자
 *  ======
 *  1. 메모리 할당 요청 (선택적 어노테이션) => 클래스별 구분
 *     @Component
 *          |
 *  ----------------------------------------------
 *   |             |           |               |   @ContorllerAdvice  @RestController
 *  @Repository   @service    @Controller   @RestController
 *     => DAO      => BI        => Model       => Vue/React
 *  2. DI(주입)
 *     @Autowired :자동 주입
 *     @Inject
 *  3. AOP:공통모듈 : @Aspect => @Before, @After...
 * 
 */
@Repository("fDao") //메모리할당
public class FoodDAO {
	
	@Autowired
	private FoodMapper mapper;
	public List<FoodVO> foodListData(int start, int end)
	{
		return mapper.foodListData(start, end); 
	}
	public int foodTotalPage()
	{
		return mapper.foodTotalPage();
	}
}
