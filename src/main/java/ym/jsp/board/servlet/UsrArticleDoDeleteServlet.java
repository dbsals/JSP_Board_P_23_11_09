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
import java.util.Map;

@WebServlet("/usr/article/doDelete")
public class UsrArticleDoDeleteServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    MysqlUtil.setDBInfo("localhost", "ym", "aa48aa76", "jspboard");
    MysqlUtil.setDevMode(true);

    Rq rq = new Rq(req, resp);

    int id = rq.getIntParam("id", 0);

    if(id == 0) {
      rq.appendBody("<script>alert('잘못 된 요청입니다.'); history.back(); </script>");
      return;
    }

    SecSql sql = new SecSql();

    sql.append("SELECT COUNT(*)");
    sql.append("FROM article AS A");
    sql.append("WHERE A.id = ?", id);

    boolean articleIsExists = MysqlUtil.selectRowBooleanValue(sql);

    if(articleIsExists == false) {
      rq.appendBody("""
          <script>
            alert('해당 게시물은 없는 게시물입니다.');
            location.replace('list');
          </script>
          """);
      return;
    }

    sql = new SecSql();
    sql.append("DELETE");
    sql.append("FROM article");
    sql.append("WHERE id = ?", id);

    MysqlUtil.delete(sql);

    rq.appendBody("""
        <script>
          alert('%d번 글이 삭제되었습니다.');
          location.replace('list');
        </script>
        """.formatted(id));

    MysqlUtil.closeConnection();
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}