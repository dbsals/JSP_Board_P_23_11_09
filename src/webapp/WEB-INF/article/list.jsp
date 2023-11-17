<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="ym.jsp.board.Rq" %>

<%
  Rq rq = new Rq(request, response);
  List<Map<String, Object>> articleListMap = (List<Map<String, Object>>) rq.getAttr("articleListMap");
  int cPage = (int)rq.getAttr("page");
  int totalPage = (int)rq.getAttr("totalPage");
%>

<!doctype html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>게시물 리스트</title>
</head>
<body>
<style type="text/css">
  body, ul, li {
    margin: 0;
  }

  .section {
    display: flex;
    justify-content: center;
  }

  .page > a.red {
    color: red;
  }
</style>

<section class="section">
  <div class="con"">
    <h1>게시물 리스트</h1>

    <table border="1" style="border-collapse: collapse; text-align:center;">
      <colgroup>
        <col width="50">
        <col width="200">
        <col width="200">
        <col width="200">
      </colgroup>
      <thead>
      <tr>
        <th>번호</th>
        <th>작성날짜</th>
        <th>수정날짜</th>
        <th>제목</th>
      </tr>
      </thead>
      <tbody>
      <% for(Map<String, Object> articleRow : articleListMap) { %>
      <tr>
        <td><%= articleRow.get("id") %></td>
        <td><%= articleRow.get("regDate") %></td>
        <td><%= articleRow.get("updateDate") %></td>
        <td>
          <a href="detail?id=<%= articleRow.get("id")%>"><%= articleRow.get("title") %></a>
        </td>
      </tr>
      <% } %>
      </tbody>
    </table>
    <div class="btn-group">
      <a href="write">게시물 작성</a>
    </div>

    <div class="page" style="display:flex; justify-content: center; gap: 0 10px;">
      <% for(int i = 1; i <= totalPage; i++) { %>
        <a class="<%= cPage == i ? "red" : "" %>" href="list?page=<%=i%>"><%=i%></a>
      <% } %>
    </div>
  </div>
</section>

</body>
</html>