/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.15
 * Generated at: 2023-11-21 11:32:14 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.member;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import java.util.Map;
import ym.jsp.board.Rq;

public final class join_jsp extends org.apache.jasper.runtime.HttpJspBase
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

  Rq rq = new Rq(request, response);

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("<head>\r\n");
      out.write("  <meta charset=\"UTF-8\">\r\n");
      out.write("  <meta name=\"viewport\"\r\n");
      out.write("        content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\r\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n");
      out.write("  <title>회원 가입</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<style>\r\n");
      out.write("  body, ul, li {\r\n");
      out.write("    margin: 0;\r\n");
      out.write("  }\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("  function JoinForm_submit(form) {\r\n");
      out.write("    let JoinForm__submitDone = false;\r\n");
      out.write("    if(JoinForm__submitDone) {\r\n");
      out.write("      alert('처리 중입니다.');\r\n");
      out.write("      return;\r\n");
      out.write("    }\r\n");
      out.write("    form.loginId.value = form.loginId.value.trim();\r\n");
      out.write("    if(form.loginId.value.length == 0) {\r\n");
      out.write("      alert('로그인 아이디를 입력해주세요');\r\n");
      out.write("      form.loginId.focus();\r\n");
      out.write("      return;\r\n");
      out.write("    }\r\n");
      out.write("    form.loginPw.value = form.loginPw.value.trim();\r\n");
      out.write("    if(form.loginPw.value.length == 0) {\r\n");
      out.write("      alert('로그인 비번을 입력해주세요');\r\n");
      out.write("      form.loginPw.focus();\r\n");
      out.write("      return;\r\n");
      out.write("    }\r\n");
      out.write("    form.loginPwConfirm.value = form.loginPwConfirm.value.trim();\r\n");
      out.write("    if(form.loginPwConfirm.value.length == 0) {\r\n");
      out.write("      alert('로그인 비번 확인을 입력해주세요');\r\n");
      out.write("      form.loginPwConfirm.focus();\r\n");
      out.write("      return;\r\n");
      out.write("    }\r\n");
      out.write("    if(form.loginPw.value != form.loginPwConfirm.value) {\r\n");
      out.write("      alert('로그인 비번이 일치하지 않습니다.');\r\n");
      out.write("      form.loginPwConfirm.focus();\r\n");
      out.write("      return;\r\n");
      out.write("    }\r\n");
      out.write("    form.name.value = form.name.value.trim();\r\n");
      out.write("    if(form.name.value.length == 0) {\r\n");
      out.write("      alert('이름을 입력해주세요.');\r\n");
      out.write("      form.name.focus();\r\n");
      out.write("      return;\r\n");
      out.write("    }\r\n");
      out.write("    form.email.value = form.email.value.trim();\r\n");
      out.write("    if(form.email.value.length == 0) {\r\n");
      out.write("      alert('이메일을 입력해주세요.');\r\n");
      out.write("      form.email.focus();\r\n");
      out.write("      return;\r\n");
      out.write("    }\r\n");
      out.write("    form.submit();\r\n");
      out.write("    JoinForm__submitDone = true;\r\n");
      out.write("  }\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"member_join_box\">\r\n");
      out.write("  <div class=\"con\">\r\n");
      out.write("    <h1>회원가입</h1>\r\n");
      out.write("\r\n");
      out.write("    <form action=\"doJoin\" method=\"POST\" onsubmit=\"JoinForm_submit(this); return false;\">\r\n");
      out.write("      <div>로그인 아이디 : <input autocomplete=\"off\" placeholder=\"아이디를 입력해주세요.\" name=\"loginId\" type=\"text\"></div>\r\n");
      out.write("      <div>로그인 패스워드 : <input autocomplete=\"off\" placeholder=\"비밀번호를 입력해주세요.\" name=\"loginPw\" type=\"password\"></div>\r\n");
      out.write("      <div>로그인 패스워드 확인 : <input autocomplete=\"off\" placeholder=\"비밀번호를 확인을 입력해주세요.\" name=\"loginPwConfirm\" type=\"password\"></div>\r\n");
      out.write("      <div>이름 : <input autocomplete=\"off\" placeholder=\"이름을 입력해주세요.\" name=\"name\" type=\"text\"></div>\r\n");
      out.write("      <div>이메일 : <input autocomplete=\"off\" placeholder=\"이메일은 입력해주세요.\" name=\"email\" type=\"email\"></div>\r\n");
      out.write("      <div class=\"btn-group\">\r\n");
      out.write("        <button type=\"submit\">회원가입</button>\r\n");
      out.write("        <button type=\"button\">\r\n");
      out.write("          <a href=\"list\">취소</a>\r\n");
      out.write("        </button>\r\n");
      out.write("      </div>\r\n");
      out.write("    </form>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
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
