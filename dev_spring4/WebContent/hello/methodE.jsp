<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Cookie cooks[] = request.getCookies();
	if (cooks != null && cooks.length > 0) {
		for (int i = 0; i < cooks.length; i++) {
			if (cooks[i].getName().equals("mem_id")) {
				out.print("쿠키에서 읽어들인 값==>" + cooks[i].getValue());
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>methodE.jsp[WebContent아래]</title>
</head>
<body>

</body>
</html>