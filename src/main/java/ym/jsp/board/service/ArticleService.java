package ym.jsp.board.service;

import ym.jsp.board.container.Container;
import ym.jsp.board.dto.Article;
import ym.jsp.board.dto.Member;
import ym.jsp.board.dto.ResultData;
import ym.jsp.board.repository.ArticleRepository;
import ym.jsp.board.util.MysqlUtil;
import ym.jsp.board.util.SecSql;
import ym.jsp.board.util.Ut;

import java.util.List;
import java.util.Map;

public class ArticleService {
  private ArticleRepository articleRepository;

  public ArticleService() {
    articleRepository = Container.articleRepository;
  }

  public int getItemInAPage() {
    return 10;
  }
  public int getForPrintListTotalPage() {
    int itemInAPage = getItemInAPage();

    int totalCount = articleRepository.getTotalCount();
    int totalPage = (int)Math.ceil((double) totalCount / itemInAPage);

    return totalPage;
  }

  public List<Article> getForPrintArticles(int page) {
    int itemInAPage = getItemInAPage();
    int limitFrom = (page - 1) * itemInAPage;

    List<Article> articles = articleRepository.getForPrintArticles(itemInAPage, limitFrom);

    return articles;
  }

  public ResultData write(Member loginedMember, String title, String content) {
    int id = articleRepository.write(loginedMember, title, content);
    return ResultData.from("S-1", Ut.f("%d번 게시물이 생성되었습니다.", id), "id", id);
  }

  public Article getForPrintArticleById(int id) {
    return articleRepository.getForPrintArticleById(id);
  }

  public ResultData modify(int id, String title, String content) {
    articleRepository.modify(id, title, content);

    return ResultData.from("S-1", Ut.f("%d번 게시물이 수정되었습니다", id), "id", id);
  }

  public ResultData actorCanModify(Member loginedMember, Article article) {
    if(loginedMember.getId() != article.getMemberId()) {
      return ResultData.from("F-1", "권한이 없습니다.");
    }

    return ResultData.from("S-1", "수정이 가능합니다.");
  }

  public ResultData delete(int id) {
    articleRepository.delete(id);

    return ResultData.from("S-1", Ut.f("%d번 게시물이 삭제되었습니다.", id), "id", id);
  }

  public ResultData actorCanDelete(Member loginedMember, Article article) {

    if(loginedMember.getId() != article.getMemberId()) {
      return ResultData.from("F-1", "권한이 없습니다.");
    }

    return ResultData.from("S-1", "삭제가 가능합니다.");
  }
}