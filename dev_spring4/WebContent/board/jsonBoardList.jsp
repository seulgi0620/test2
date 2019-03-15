<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page import="java.util.List, java.util.Map, com.google.gson.Gson" %>
<%
//파일명 - jsonBoardList.jsp
List<Map<String,Object>> jsonBoardList = (List<Map<String,Object>>)request.getAttribute("jsonBoardList");
if(jsonBoardList!=null){
	Gson g = new Gson();
	String jsonFor = g.toJson(jsonBoardList);
	out.print(jsonFor);
}
%>

