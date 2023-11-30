package ym.jsp.board.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ym.jsp.board.Rq;
import ym.jsp.board.controller.UsrArticleController;
import ym.jsp.board.controller.UsrHomeController;
import ym.jsp.board.controller.UsrMemberController;
import ym.jsp.board.util.MysqlUtil;
import ym.jsp.board.util.SecSql;

import java.io.IOException;
import java.util.Map;

@WebServlet("/usr/*")
public class DispatcherServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    MysqlUtil.setDBInfo("localhost", "ym", "aa48aa76", "jspboard");
    MysqlUtil.setDevMode(true);

    Rq rq = new Rq(req, resp);

    HttpSession session = req.getSession();

    boolean isLogined = false;
    int loginedMemberId = -1;
    Map<String, Object> loginedMemberRow = null;

    if (session.getAttribute("loginedMemberId") != null) {
      loginedMemberId = (int) session.getAttribute("loginedMemberId");
      isLogined = true;

      SecSql sql = new SecSql();
      sql.append("SELECT * FROM `member`");
      sql.append("WHERE id = ?", loginedMemberId);
      loginedMemberRow = MysqlUtil.selectRow(sql);
    }

    rq.setAttr("isLogined", isLogined);
    rq.setAttr("loginedMemberId", loginedMemberId);
    rq.setAttr("loginedMemberRow", loginedMemberRow);

    switch (rq.getControllerTypeName()) {
      case "usr"
          -> {
        UsrHomeController usrHomeController = new UsrHomeController();
        UsrArticleController usrArticleController = new UsrArticleController();
        UsrMemberController usrMemberController = new UsrMemberController();

        switch (rq.getControllerName()) {
          case "home" -> usrHomeController.performAction(rq);
          case "article" -> usrArticleController.performAction(rq);
          case "member" -> usrMemberController.performAction(rq);
        }
      }
    }

    MysqlUtil.closeConnection();
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}