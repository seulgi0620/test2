<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//서버에서 로컬PC에 저장된 쿠키값을 담을 변수 선언
	String cmem_name = null;
//클라이언트에 저장된 쿠키 정보는 여러가지를 담을 수 있어요. 그래서 배열이죠...
//클라이언트가 11번가에 접속할 때마다 11번가 서버는 클라이언트에 쿠키값을 요청하죠
//그래서 그 사용자가 찜한 상품 정보를 쿠키로부터 읽어올 수 있겠죠
//그래서 요청 객체를 사용해서 값을 읽어오는 거에요.
	Cookie cooks[] = request.getCookies();
	if(cooks != null && cooks.length > 0){
		//쿠키 정보가 여러가지라서 반복문 처리했구요..
		for(int i=0; i<cooks.length; i++){
			//쿠키 정보에는 브라우저마다 세션아이디값도 같이 담겨 있어요.
			//그래서 나는 한개를 담아도 기본이 2개에서 시작되고 
			//그 중 사용자 정보만 가져와서 비교해야 하니깐....
			if("cmem_name".equals(cooks[i].getName())){
				cmem_name = cooks[i].getValue();
				
			}
		}
	}
%>
쿠키값 확인해봐요 <%=cmem_name %> <br>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 폼[WEB-INF]</title>
<%@ include file="../../../../common/easyui_common.jsp"%>
<script type="text/javascript">
	function login() {
		$("#f_login").attr("method", "get");
		$("#f_login").attr("action", "/ch9/member/login.mvc");
		$("#f_login").submit();
	}
	//로그아웃 처리하는데 DB연동이 필요한가요?
	//네 이면 모델2
	//아니 이면 모델1으로 처리해도 되겠죠?
	function logout(){
		location.href="./logout.jsp";
	}		
</script>
</head>
<body>
	<%
		if (cmem_name == null) {
	%>
	<!-- 쿠키가 없니? 로그인을 안한거야? -->
	<form id="f_login">
		아이디<input class="easyui-textbox" data-options="iconCls:'icon-man'"style="width: 200px"> 
		암호 <input class="easyui-textbox" data-options="iconCls:'icon-lock'" style="width: 200px"type="password"> 
		<a id="btn_login" href="javascript:login()" class="easyui-linkbutton">로그인</a>
	</form>
	<%
		} 
		else 
		{
	%>
	<!-- 로그인하고 온거야? -->
		<%=cmem_name %> 님 환영합니다.
		<a id="btn_logout" href="javascript:logout()" class="easyui-linkbutton">로그아웃</a>
	<%
		}
	%>
</body>
</html>