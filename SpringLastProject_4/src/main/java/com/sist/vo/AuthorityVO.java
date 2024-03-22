package com.sist.vo;

import lombok.Data;

/*
 *   보안 (security) => id (userId,userName,userPwd)
 *       권한 ==> ROLE_ADMIN , ROLE_MENAGER , ROLE_USER , ROLE_GUEST
 *   => 1. 비밀번호 암호화 
 *   => 2. 권한 부여 
 *   => 3. 자동로그인 
 *   => 4. ID 저장
 *   => 메소드 보안  
 */
@Data
public class AuthorityVO {
  private String userId,authority;
}
