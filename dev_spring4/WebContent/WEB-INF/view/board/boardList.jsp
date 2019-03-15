<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List, java.util.Map" %>
    <%
    	List<Map<String,Object>> boardList = (List<Map<String,Object>>) request.getAttribute("boardList");
     %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
WEB-INF<br>
boardList.jsp
<%
	if(boardList!=null && boardList.size()>0){
		
	
%>
<%=boardList.get(0).get("BM_WRITER") %>
<%
	}
%>
</body>
</html>