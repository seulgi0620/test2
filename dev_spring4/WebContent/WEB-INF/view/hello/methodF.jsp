<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Cookie cooks[] = request.getCookies();
	if (cooks != null && cooks.length > 0) {
		for (int i = 0; i < cooks.length; i++) {
			if (cooks[i].getName().equals("mem_id")) {
				out.print("쿠키에서 읽어들인 값==>" + cooks[i].getValue());
				out.print("<br>");
			}
		}
	}
	String msg = (String)request.getAttribute("msg");
	String msg2 = (String)request.getAttribute("msg2");
	String msg3 = (String)request.getAttribute("msg3");
	out.print("msg : " + msg);
	out.print("<br>");
	out.print("msg2 : " + msg2);
	out.print("<br>");
	out.print("msg3 : " + msg3);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>methodF.jsp[WEB-INF아래]</title>
</head>
<body>
methodF.jsp페이지 입니다.
methodF.jsp[WEB-INF아래]
</body>
</html>