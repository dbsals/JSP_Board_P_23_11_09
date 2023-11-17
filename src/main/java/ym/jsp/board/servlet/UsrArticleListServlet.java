package ym.jsp.board.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ym.jsp.board.Rq;
import ym.jsp.board.util.MysqlUtil;
import ym.jsp.board.util.SecSql;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/usr/article/list")
public class UsrArticleListServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    MysqlUtil.setDBInfo("localhost", "ym", "aa48aa76", "jspboard");
    MysqlUtil.setDevMode(true);

    Rq rq = new Rq(req, resp);

    SecSql sql = new SecSql();
    sql.append("SELECT A.*");
    sql.append("FROM article AS A");
    sql.append("ORDER BY A.id DESC");

    List<Map<String, Object>> articleListMap = MysqlUtil.selectRows(sql);

    rq.setAttr("articleListMap", articleListMap);

    rq.jsp("article/list");

    MysqlUtil.closeConnection();
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}