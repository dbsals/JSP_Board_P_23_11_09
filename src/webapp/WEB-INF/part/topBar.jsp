<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="ym.jsp.board.Rq" %>

<%
  Map<String, Object> loginedMemberRow = (Map<String, Object>) request.getAttribute("loginedMemberRow");
  boolean isLogined = (boolean) request.getAttribute("isLogined");
  int loginedMemberId = (int) request.getAttribute("loginedMemberId");
%>

<style>
  body, ul, li {
    margin: 0;
    padding: 0;
    list-style : none;
</style>

<% if(isLogined) { %>
<div>
  "<%=loginedMemberRow.get("name")%>" 님 환영합니다.
</div>
<% } %>

<nav class="menu-box-1">
  <ul style="display:flex; gap: 0 10px">
    <li><a href="/usr/article/list">게시물 리스트</a></li>
    <li><a href="/usr/member/join">회원가입</a></li>
    <% if(!isLogined) { %>
    <li><a href="/usr/member/login">로그인</a></li>
    <% } %>
    <% if(isLogined) { %>
    <li><a href="/usr/member/doLogout">로그아웃</a></li>
    <% } %>
  </ul>
</nav>