package ym.jsp.board.container;

import ym.jsp.board.controller.UsrArticleController;
import ym.jsp.board.controller.UsrHomeController;
import ym.jsp.board.controller.UsrMemberController;
import ym.jsp.board.interceptor.BeforeActionInterceptor;
import ym.jsp.board.interceptor.NeedLoginInterceptor;
import ym.jsp.board.interceptor.NeedLogoutInterceptor;
import ym.jsp.board.repository.ArticleRepository;
import ym.jsp.board.repository.MemberRepository;
import ym.jsp.board.service.ArticleService;
import ym.jsp.board.service.MemberService;

public class Container {
  public static BeforeActionInterceptor beforeActionInterceptor;
  public static NeedLoginInterceptor needLoginInterceptor;
  public static NeedLogoutInterceptor needLogoutInterceptor;

  public static MemberRepository memberRepository;
  public static ArticleRepository articleRepository;

  public static MemberService memberService;
  public static ArticleService articleService;

  public static UsrHomeController usrHomeController;
  public static UsrMemberController usrMemberController;
  public static UsrArticleController usrArticleController;

  public static void init() {
    beforeActionInterceptor = new BeforeActionInterceptor();
    needLoginInterceptor = new NeedLoginInterceptor();
    needLogoutInterceptor = new NeedLogoutInterceptor();

    memberRepository = new MemberRepository();
    articleRepository = new ArticleRepository();

    memberService = new MemberService();
    articleService = new ArticleService();

    usrHomeController = new UsrHomeController();
    usrMemberController = new UsrMemberController();
    usrArticleController = new UsrArticleController();
  }
}