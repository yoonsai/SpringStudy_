<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.container{
   margin-top: 50px;
}
.row{
   margin: 0px auto;
   width: 960px;
}
#recvMsg{
    border: 1px solid;
    height: 500px;
    overflow: auto;
}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.5.2/sockjs.min.js"></script>
<script type="text/javascript">
let websocket;
let name;
function connection()
{
	name=$('#name').val();
	if(name.trim()==="")
    {
		$('#name').focus();
		return;
    }
	websocket=new WebSocket("ws://localhost:8080/web/site/chat/chat-ws")
	websocket.onopen=onOpen; // onOpen는 사용자 정의함수
	websocket.onclose=onClose;
	websocket.onmessage=onMessage;
	// Callback등록
}
function onOpen(event)
{
	alert("채팅 서버와 연결되었습니다...")
}
function onClose(event)
{
	alert("채팅 서버와 연결이 해제되었습니다...")
}
function onMessage(event)
{
	let data=event.data; // 보낸 데이터 => "msg[이름]:message"
	if(data.substring(0,4)=="msg:")
    {
		appendMessage(data.substring(4));
    }
}
function appendMessage(msg)
{
    $('#recvMsg').append(msg+"<br>")
    let ch=$('#chatArea').height() //스크롤바 위치 조정
    let m=$('#recvMsg').height()-ch
    $('#chatArea').scrollTop(m)
}
function send(){
	let msg=$('#sendMsg').val()
	if(msg.trim()==="")
    {
		$('#sendMsg').focus();
		return;
    }
	websocket.send('msg:['+name+"]"+msg)
	$('#sendMsg').val("")
	$('#sendMsg').focus()
}
$(function(){
	$('#startBtn').click(function(){
		connection();
	})
	$('#endBtn').click(function(){
		websocket.close();
	})
	$('#sendBtn').click(function(){
		send();
	})
	$('#sendMsg').keydown(function(key){
		if(key.keyCode==13)
		{
			send()
		}
	})
})
</script>
</head>
<body>
  <div class="container">
    <h1 class="text-center">실시간 채팅(WebSocket)</h1>
    <div class="row">
      <table class="table">
        <tr>
         <td>
           <input type="text" class="input-sm" id="name" size=15>
           <input type="button" class="btn-sm btn-danger" id="startBtn" value="입실">
           <input type="button" class="btn-sm btn-info" id="endBtn" value="퇴실">
         </td>
         </tr>
          <tr>
         <td>
           <div id="chatArea">
             <div id="recvMsg"></div>
           </div>
         </td>
        </tr>
         <tr>
         <td>
           <input type="text" class="input-sm" id="sendMsg" size=100>
           <input type="button" class="btn-sm btn-primary" id="sendBtn" value="전송">
         </td>
        </tr>
      </table>
    </div>
  </div>
</body>
</html>