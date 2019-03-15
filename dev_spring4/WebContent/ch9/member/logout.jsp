<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//쿠키에 담긴 정보 삭제 후 로그인 화면으로 이동 처리하세요.
	Cookie cooks[] = request.getCookies();
	if(cooks != null && cooks.length > 0){
		for(int i=0; i<cooks.length; i++){
			if("cmem_name".equals(cooks[i].getName())){
				Cookie cook = new Cookie("cmem_name","");
				cook.setMaxAge(0);
				cook.setPath("/");
				response.addCookie(cook);
			}
		}
	}
	response.sendRedirect("./loginForm.jsp");
%>