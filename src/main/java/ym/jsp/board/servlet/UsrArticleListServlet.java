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

    int page = rq.getIntParam("page", 1);
    int itemInAPage = 20;
    int limitFrom = (page - 1) * itemInAPage;

    SecSql sql = new SecSql();
    sql.append("SELECT COUNT(*)");
    sql.append("FROM article");

    int totalCount = MysqlUtil.selectRowIntValue(sql);
    int totalPage = (int)Math.ceil((double) totalCount / itemInAPage);

    sql = new SecSql();
    sql.append("SELECT A.*, M.name AS writerName");
    sql.append("FROM article AS A");
    sql.append("INNER JOIN `member` AS M");
    sql.append("ON A.memberId = M.id");
    sql.append("ORDER BY A.id DESC");
    sql.append("LIMIT ?, ?", limitFrom, itemInAPage);

    List<Map<String, Object>> articleListMap = MysqlUtil.selectRows(sql);

    rq.setAttr("articleListMap", articleListMap);
    rq.setAttr("page", page);
    rq.setAttr("totalPage", totalPage);

    rq.jsp("article/list");

    MysqlUtil.closeConnection();
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}