package com.sist.web;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.sist.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.manager.FoodRecommandManager;
import com.sist.service.FoodServiceImpl;

@RestController
@RequestMapping("food/")
/*
 * 사용자(클라이언트 => 브라우저) => 요청(URL) .do
 *                                   ===== 현재 사이트에서 가능
 * ========================================================
 * Dispatcher => 요청받기 (request,response)
 *    web.xml에 셋팅을 한다
 *    => WebApplicationContext => 사용자가 등록한 클래스 관리
 *       ===============> 관리가 필요한 모든 클래스를 xml에 설정해서 전송
 *         <init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>/WEB-INF/config/application-*.xml</param-value>
		   </init-param>
 *    => HadlerMapping : 요청시에 처리하는 Controller/RestController를 찾는 역할
 *    = ViewResolver : JSP찾아서 request를 전송
 * =======================================================================
 * Model : Controler / RestController
 *         => HandlerMapping에서 해당 메소드를 찾을 수 있게 만든다
 *                              =======
 *                              @GetMapping,@PostMapping,@RequestMapping
 *         => 조립기
 *            요청을 받아서 => 응답하기 
 *                   처리 => DB
 * ========================================
 * Mapper : 테이블 1개를 다루는 경우
 * Service : 관련된 Mapper가 여러개 있는 경우
 * DAO 
 * ======================================== DB연동 (MyBatis는 데이터 베이스 연결)
 * View(JSP) : 화면 출력
 * ======================================== 요청 (for, a, axios, ajax)
 * 
 * list.do ===========> dispatcherServlet 
 *                               ===> list.do처리 메소드를 찾아라
 *                                    HadlerMapping
 *                               ---------------------------
 *                               ===> list.do에 대한 처리 ==> 개발자
 *                                    @GetMapping("list.do")
 *                               ===> JSP 응답값을 전송 / 화면 변경
 *                               ---------------------------- Model
 *                                         @Controller, @RestController
 *                               ===> JSP를 찾아서 request를 전송
 *                                    =======================
 *                                     ViewResolver ==> 경로명, 확장자 확인 => 등록
 *                                     
 * Model
 * =====
 *  => RestController
 *       => 다른 언어와 연동 ==> JSON
 *       => 자바스트립트와 자바 연동
 *          자바 => VO => {} (Object)
 *          자바 => List => [] (Array)
 *          
 *  => Controller : 화면 이동 (변경)
 *      => forward => request를 전송할 경우
 *                   ========= 스프링에서 제공하는 전송 객체 : Model
 *                    return "폴더명/jsp이름";
 *      => redirect => 재호출 => .do
 *                    request를 초기화
 *                    return "redirect:...do";
 *                    _ok
 * 
 */
public class FoodRestController {
	@Autowired
	private FoodRecommandManager mgr;
	
	@Autowired
	private FoodServiceImpl service;
	
	@GetMapping(value="find_vue.do",produces="text/plain;charset=UTF-8")
	public String food_find_list(int page,String fd) throws Exception
	{
		int rowsize=12;
		int start=(rowsize*page)-(rowsize-1);
		int end=rowsize*page;
		Map map=new HashMap();
		map.put("address", fd);
		map.put("start", start);
		map.put("end", end);
		List<FoodVO> list=service.foodFindData(map);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(list);
		return json;
	}
	@GetMapping(value="page_vue.do",produces="text/plain;charset=UTF-8")
	public String food_find_page(int page,String fd) throws Exception
	{
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		Map map=new HashMap();
		map.put("address", fd);
		int totalpage=service.foodFindCount(map);
		if(endPage>totalpage)
			endPage=totalpage;
		map=new HashMap();
		map.put("startPage", startPage);
		map.put("curpage", page);
		map.put("endPage", endPage);
		map.put("totalpage", totalpage);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		return json;
	}
	/*
	 * 
	 * 중요
	 * = 어노테이션은 반드시 밑에 있는 변수,메소드,클래스를 제어
	 */
	@GetMapping(value="detail_vue.do",produces="text/plain;charset=UTF-8")
	public String food_detail(int fno) throws Exception
	{
		FoodVO vo=service.foodDetailData(fno);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(vo);
		return json;
		
	}
	@GetMapping(value="food_cookie_vue.do",produces = "text/plain;charset=UTF-8")
	   public String food_cookie(HttpServletRequest request) throws Exception
	   {
		   Cookie[] cookies=request.getCookies();
		   List<FoodVO> list=new ArrayList<FoodVO>();
		   int k=0;
		   if(cookies!=null)
		   {
			   for(int i=cookies.length-1;i>=0;i--)
			   {
			       if(k<9)
			       {
			    	   // new Cookie("food_"+fno, String.valueOf(fno))
			    	   //            =======getName() ======= getValue()
			    	   if(cookies[i].getName().startsWith("food_"))
			    	   {
			    		   String fno=cookies[i].getValue();
			    		   FoodVO vo=service.foodDetailData(Integer.parseInt(fno));
			    		   list.add(vo);
			    	   }
			    	   k++;
			       }
			   }
		   }
		   
		   ObjectMapper mapper=new ObjectMapper();
		   String json=mapper.writeValueAsString(list);
		   return json;
	   }
	
	@GetMapping(value="food_list_vue.do",produces="text/plain;charset=UTF-8")
	public String food_list(int page) throws Exception
	{
		int rowsize=20;
		int start=(rowsize*page)-(rowsize-1);
		int end=rowsize*page;
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		List<FoodVO> list=service.foodListData(map);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(list);
		return json;
	}
	@GetMapping(value="food_page_vue.do",produces="text/plain;charset=UTF-8")
	public String food_page(int page) throws Exception
	{
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		int totalpage=service.foodListCount();
		if(endPage>totalpage)
			endPage=totalpage;
		Map map=new HashMap();
		map.put("startPage", startPage);
		map.put("curpage", page);
		map.put("endPage", endPage);
		map.put("totalpage", totalpage);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		return json;
	}
	@GetMapping(value="food_detail_vue.do",produces="text/plain;charset=UTF-8")
	public String food_list_detail(int fno) throws Exception
	{
		FoodVO vo=service.foodListDetailData(fno);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(vo);
		return json;
	}
	@GetMapping(value="food_recommand_sub.do",produces="text/plain;charset=UTF-8")
	public String food_recommand(int no) throws Exception
	{
		String[] menu1= {
				"퇴근길","휴식","휴가","여행","드라이브","산책","운동"};
		String[] menu2= {
				"기분전환","외로움","슬픔","힘찬","이별","지침","설렘","우울","행복","불안","분노","기쁨"};
		String[] menu3= {
				"밝은","신나는","편안한","따뜻한","달콤한","시원한"};
		String[] menu4= {
				"봄","여름","가을","겨울","맑은날","추운날","흐린날","비오는날","더운날","눈오는날"};
		
		ObjectMapper mapper=new ObjectMapper();
		String json="";
		if(no==1)
		{
			json=mapper.writeValueAsString(menu1);
		}
		else if(no==2)
		{
			json=mapper.writeValueAsString(menu2);
		}
		else if(no==3)
		{
			json=mapper.writeValueAsString(menu3);
		}
		else if(no==4)
		{
			json=mapper.writeValueAsString(menu4);
		}
		return json;
	}
	
    @GetMapping(value="food_recommand_data.do",produces="text/plain;charset=UTF-8")
	public String food_recommand_data(String fd) throws Exception
	{
    	List<String> list=mgr.newsFind(fd);
    	List<String> fList=service.foodAllData();
    	//Pattern[] p=new Pattern[fList.size()];
    	/*
    	 * 1. 단어 => contains()
    	 * 2. 기호 : * (0이상) 맛있다, 맛있고, 맛있는 => 맛*   
    	 *          + (1이상) 맛+
    	 *          ? (0,1이상) 있거나 없거나
    	 *          | (선택)
    	 *          . (임의의 한글자) 맛.
    	 *                                           => 실제 기호를 가져올때는 \\를 앞에 붙여야함
    	 *          [] => 범위 [0-9]
    	 *                    [A-Za-z]
    	 *                    [가-힣]
    	 *          {} => 갯수
    	 *                    {1,3} = 1개~3개의 글자
    	 *                    
    	 *          ^ (시작)    ^[가-힣] = 한글로 시작
    	 *                     [^가-힣] = 한글을 제외하고
    	 *          $ (끝)
    	 *             
    	 */
    	Matcher[] m=new Matcher[fList.size()];
    	// 초기화 => 정규식
    	List<String> rList=new ArrayList<String>();

    	int[] count=new int[fList.size()];
    	for(String s:list)
    	{
    		System.out.println(s);
    		for(int i=0;i<m.length;i++){
    			if(s.contains(fList.get(i)))
    			{
    				System.out.println(fList.get(i));
    				rList.add(fList.get(i));
    				count[i]++;
    			}
    			
    		}

    	}
    	Set set=new HashSet();
  		for(int i=0;i<rList.size();i++)
  		{
  			set.add(rList.get(i));
  		}
  		List<FoodVO> dList=new ArrayList<FoodVO>();
    	Iterator iter=set.iterator();
    	while(iter.hasNext())
    	{
    		//set에 저장된 값을 가져올때 사용
    		String ss=iter.next().toString();
    		dList=service.foodNameInfoData(ss);
    	}
    	ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(dList);
    	return json;
	}
    @GetMapping(value="food_detail_recipe.do",produces="text/plain;charset=UTF-8")
	public String food_detail_recipe(String type) throws Exception
	{
    	String s=type.substring(0,type.indexOf("-"));
    	System.out.println("s="+s);
    	List<RecipeVO> list=service.foodRecipeData(s);
    	ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(list);
    	return json;
	}
}
