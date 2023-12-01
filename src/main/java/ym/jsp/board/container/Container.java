package ym.jsp.board.container;

import ym.jsp.board.controller.UsrArticleController;
import ym.jsp.board.controller.UsrHomeController;
import ym.jsp.board.controller.UsrMemberController;
import ym.jsp.board.repository.ArticleRepository;
import ym.jsp.board.repository.MemberRepository;
import ym.jsp.board.service.ArticleService;
import ym.jsp.board.service.MemberService;

public class Container {
  public static MemberRepository memberRepository;
  public static ArticleRepository articleRepository;

  public static MemberService memberService;
  public static ArticleService articleService;

  public static UsrHomeController usrHomeController;
  public static UsrMemberController usrMemberController;
  public static UsrArticleController usrArticleController;

  public static void init() {
    memberRepository = new MemberRepository();
    articleRepository = new ArticleRepository();

    memberService = new MemberService();
    articleService = new ArticleService();

    usrHomeController = new UsrHomeController();
    usrMemberController = new UsrMemberController();
    usrArticleController = new UsrArticleController();
  }
}