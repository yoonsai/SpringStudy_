<%@page import="org.jsoup.nodes.Document"%>
<%@page import="org.jsoup.Jsoup"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String data="";
    try{
    	String no=request.getParameter("no");
    	// 일일박스오피스
    	// 실시간 예매율
    	// 좌석점유율순위
    	// 
    	String[] movies={"","searchMainDailyBoxOffice.do","searchMainRealTicket.do","searchMainDailySeatTicket.do"};
    	String url="https://www.kobis.or.kr/kobis/business/main/";
    	Document doc=Jsoup.connect(url+movies[Integer.parseInt(no)]).get();
    	//System.out.println(doc.toString());
    	data=doc.toString();
    	data=data.substring(data.indexOf("["),data.lastIndexOf("]")+1);
    }catch(Exception e){}

%>
<%=data%>