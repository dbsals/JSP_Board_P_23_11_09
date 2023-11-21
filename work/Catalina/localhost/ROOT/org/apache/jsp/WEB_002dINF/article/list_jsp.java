/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.15
 * Generated at: 2023-11-21 11:51:18 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.article;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import java.util.List;
import java.util.Map;
import ym.jsp.board.Rq;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("ym.jsp.board.Rq");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("java.util.Map");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

  Rq rq = new Rq(request, response);
  List<Map<String, Object>> articleListMap = (List<Map<String, Object>>) rq.getAttr("articleListMap");
  int cPage = (int)rq.getAttr("page");
  int totalPage = (int)rq.getAttr("totalPage");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("<head>\r\n");
      out.write("  <meta charset=\"UTF-8\">\r\n");
      out.write("  <meta name=\"viewport\"\r\n");
      out.write("        content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\r\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n");
      out.write("  <title>게시물 리스트</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("  body, ul, li {\r\n");
      out.write("    margin: 0;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  .section {\r\n");
      out.write("    display: flex;\r\n");
      out.write("    justify-content: center;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  .page > a.red {\r\n");
      out.write("    color: red;\r\n");
      out.write("  }\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<section class=\"section\">\r\n");
      out.write("  <div class=\"con\"\">\r\n");
      out.write("    <h1>게시물 리스트</h1>\r\n");
      out.write("\r\n");
      out.write("    <table border=\"1\" style=\"border-collapse: collapse; text-align:center;\">\r\n");
      out.write("      <colgroup>\r\n");
      out.write("        <col width=\"50\">\r\n");
      out.write("        <col width=\"200\">\r\n");
      out.write("        <col width=\"200\">\r\n");
      out.write("        <col width=\"200\">\r\n");
      out.write("      </colgroup>\r\n");
      out.write("      <thead>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <th>번호</th>\r\n");
      out.write("        <th>작성날짜</th>\r\n");
      out.write("        <th>수정날짜</th>\r\n");
      out.write("        <th>제목</th>\r\n");
      out.write("      </tr>\r\n");
      out.write("      </thead>\r\n");
      out.write("      <tbody>\r\n");
      out.write("      ");
 for(Map<String, Object> articleRow : articleListMap) { 
      out.write("\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td>");
      out.print( articleRow.get("id") );
      out.write("</td>\r\n");
      out.write("        <td>");
      out.print( articleRow.get("regDate") );
      out.write("</td>\r\n");
      out.write("        <td>");
      out.print( articleRow.get("updateDate") );
      out.write("</td>\r\n");
      out.write("        <td>\r\n");
      out.write("          <a href=\"detail?id=");
      out.print( articleRow.get("id"));
      out.write('"');
      out.write('>');
      out.print( articleRow.get("title") );
      out.write("</a>\r\n");
      out.write("        </td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      ");
 } 
      out.write("\r\n");
      out.write("      </tbody>\r\n");
      out.write("    </table>\r\n");
      out.write("    <div class=\"btn-group\">\r\n");
      out.write("      <a href=\"write\">게시물 작성</a>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"page\" style=\"display:flex; justify-content: center; gap: 0 10px;\">\r\n");
      out.write("      ");
 if(cPage > 1) { 
      out.write("\r\n");
      out.write("      <a href=\"list?page=1\">◀</a>\r\n");
      out.write("      ");
 } 
      out.write("\r\n");
      out.write("      ");

      int pageMenuSize = 5;
      int from = cPage - pageMenuSize;

      if(from < 1) {
        from = 1;
      }

      int end = cPage + 10;

      if(end > totalPage) {
        end = totalPage;
      }

      for(int i = from; i <= end; i++) {
      out.write("\r\n");
      out.write("        <a class=\"");
      out.print( cPage == i ? "red" : "" );
      out.write("\" href=\"list?page=");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("</a>\r\n");
      out.write("      ");
 } 
      out.write("\r\n");
      out.write("      ");
 if(cPage < totalPage) { 
      out.write("\r\n");
      out.write("        <a href=\"list?page=");
      out.print(totalPage);
      out.write("\">▶</a>\r\n");
      out.write("      ");
 } 
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</section>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
