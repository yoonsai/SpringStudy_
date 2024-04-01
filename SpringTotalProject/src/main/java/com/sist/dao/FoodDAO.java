package com.sist.dao;

import org.springframework.stereotype.Repository;

//

@Repository // 저장소 => 테이블을 한개 연결시에 주로 사용
// 관련된 DAO여러개 통합 => BI @Service
// => Controller / Service
// => 전송 / 처리목적
/*
 *    JDBC ====> DBCP ====> ORM
 *                          MyBatis
 *                          Hibernate ===== DataSet (자동 SQL) ====> JPA
 *                          
 *    Filter
 *    => 용도
 *       공통된 보안 및 인증 / 인가 관련 작업
 *       요청에 대한 로깅 / 검사
 *       이미지/데이터 압축
 *       
 *                             
 *      => MVC 구조에 대한 설명
 *      => servlet / jsp
 *    => Spring MVC에서 Http요청이 들어왔을 경우 흐름에 대해 설명
 *      => 면접 돌려서 나온다
 *    => 기타
 *      => Spring-Security의 구조 (필수)
 *      => AOP이용하는 방법 => 코드를 부분적으로 나눠서 모듈화 처리
 *      모든 프로그램은
 *         = 핵심
 *         = 공통 : getConnection, disConnection => 자동 호출
 *      OOP => 객체지향 프로그램
 *   
 *    Java
 *      => Java / Python => 차이점
 *      => Java에서 접근 지정어
 *      => JVM의 구조
 *      => GC
 *      => ****** CA                       
 *      
 *                   
 *     Proxy
 *                   
 * 
 */
public class FoodDAO {

}
