<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="ym.jsp.board.Rq" %>

<%
  Rq rq = new Rq(request, response);
  List<Map<String, Object>> articleListMap = (List<Map<String, Object>>) rq.getAttr("articleListMap");
%>

<title>게시물 리스트</title>

<h1>== 게시물 리스트 ==</h1>

<% for(Map<String, Object> articleRow : articleListMap) { %>
  <div>
    <%= articleRow.get("id") %>
    <%= articleRow.get("regDate") %>
    <%= articleRow.get("updateDate") %>
    <%= articleRow.get("title") %>
  </div>
<% } %>