package com.sist.chat;

import java.util.ArrayList;
import java.util.*;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/site/chat/chat-ws") //접속하는 지점
public class ChatServer {
	// 저장 => 접속자 정보 저장
	private static List<Session> users=Collections.synchronizedList(new ArrayList<Session>()); //동기화프로그램
	//websocket에 존재하는 session
	
	
	//클라이언트에 접속시 호출되는 메소드
	@OnOpen
	public void onOpen(Session session)
	{
		users.add(session);
		System.out.println("클라이언트 접속:"+session.getId());
	}
	// 클라이언트가 퇴장한 경우
	@OnClose
	public void onClose(Session session)
	{
		users.remove(session);
		System.out.println("클라이언트 퇴장:"+session.getId());
	}
	// 채팅 => 문자열 전송
	@OnMessage
	public void onMessage(String message,Session session) throws Exception
	{
		System.out.println(session.getId()+"님의 메세지:"+message);
		Iterator<Session> iter=users.iterator();//접속한 모든 사람
//		while(iter.hasNext()) {
//			
//			iter.next().getBasicRemote().sendText(message);
//		}
		// 같은 결과 for문으로
		for(Session s:users)
		{
		    s.getBasicRemote().sendText(message);	
		}
	}
}
