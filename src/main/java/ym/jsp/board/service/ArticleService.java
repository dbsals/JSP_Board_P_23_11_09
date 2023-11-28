package ym.jsp.board.service;

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
    articleRepository = new ArticleRepository();
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

  public List<Map<String, Object>> getArticleRows(int page) {
    int itemInAPage = getItemInAPage();
    int limitFrom = (page - 1) * itemInAPage;

    List<Map<String, Object>> articleRows = articleRepository.getArticleRows(itemInAPage, limitFrom);

    return articleRows;
  }

  public ResultData write(int loginedMemberId, String title, String content) {
    int id = articleRepository.write(loginedMemberId, title, content);
    return ResultData.from("S-1", Ut.f("%d번 게시물이 생성되었습니다.", id), "id", id);
  }
}