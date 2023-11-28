package ym.jsp.board.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ym.jsp.board.Rq;
import ym.jsp.board.controller.UsrArticleController;
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

    String requestUri = req.getRequestURI();
    String[] requestUriBits = requestUri.split("/");

    int minBitsCount = 4;

    if (requestUriBits.length < minBitsCount) {
      rq.appendBody("""
            <script>
              alert('올바른 요청이 아닙니다.');
              location.replace('/home/main');
            </script>
          """);
    }

    int controllerTypeNameIndex = 1;
    int controllerNameIndex = 2;
    int controllerMethodNameIndex = 3;

    String controllerTypeName = requestUriBits[controllerTypeNameIndex];
    String controllerName = requestUriBits[controllerNameIndex];
    String actionMethodName = requestUriBits[controllerMethodNameIndex];

    System.out.printf("%s/%s/%s\n", controllerTypeName, controllerName, actionMethodName);

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

    if(controllerName.equals("article")) {
      UsrArticleController usrArticleController = new UsrArticleController(rq);

      switch (actionMethodName) {
        case "list":
          usrArticleController.actionList();
      }
    }

    MysqlUtil.closeConnection();
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}