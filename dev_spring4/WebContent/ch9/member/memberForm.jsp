<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 우리가 만들었던 util의 HashMapBinder와  ModelAttribute를 비교 테스트 해 보자. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<%@ include file="../../common/easyui_common.jsp" %>
</head>
<body>
<!-- 
<form id="f_member" method="get" action="./memberAdd">
 -->
<form id="f_member" method="get" action="./memberAdd2">
	<h1>
		이름 : <input class="easyui-textbox" name="mem_name" style="width:100px">
		<br>
		HP : <input class="easyui-textbox" name="mem_hp" style="width:100px">
		<br>
		비번 : <input class="easyui-textbox" name="mem_pw" style="width:100px">
		<br>
	</h1>
	<input type="submit" value="전송">
</form>
</body>
</html>