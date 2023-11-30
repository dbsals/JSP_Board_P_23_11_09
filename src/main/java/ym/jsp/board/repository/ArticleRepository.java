package ym.jsp.board.repository;

import ym.jsp.board.dto.Article;
import ym.jsp.board.util.MysqlUtil;
import ym.jsp.board.util.SecSql;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArticleRepository {
  public int getTotalCount() {
    SecSql sql = new SecSql();
    sql.append("SELECT COUNT(*)");
    sql.append("FROM article");

    int totalCount = MysqlUtil.selectRowIntValue(sql);

    return totalCount;
  }

  public List<Article> getForPrintArticles(int itemInAPage, int limitFrom) {
    SecSql sql = new SecSql();
    sql.append("SELECT A.*, M.name AS extra__writerName");
    sql.append("FROM article AS A");
    sql.append("INNER JOIN `member` AS M");
    sql.append("ON A.memberId = M.id");
    sql.append("ORDER BY A.id DESC");
    sql.append("LIMIT ?, ?", limitFrom, itemInAPage);

    List<Map<String, Object>> selectRows = MysqlUtil.selectRows(sql);
    List<Article> articles = new ArrayList<>();

    for(Map<String, Object> selectRow : selectRows) {
      articles.add(new Article(selectRow));
    }

    return articles;
  }

  public int write(int loginedMemberId, String title, String content) {
    SecSql sql = new SecSql();
    sql.append("INSERT INTO article");
    sql.append("SET regDate = NOW()");
    sql.append(", updateDate = NOW()");
    sql.append(", title = ?", title);
    sql.append(", content = ?", content);
    sql.append(", memberId = ?", loginedMemberId);

    int id = MysqlUtil.insert(sql);

    return id;
  }

  public Article getForPrintArticleById(int id) {
    SecSql sql = new SecSql();
    sql.append("SELECT A.*, M.name AS extra__writerName");
    sql.append("FROM article AS A");
    sql.append("INNER JOIN `member` AS M");
    sql.append("ON A.memberId = M.id");
    sql.append("WHERE A.id = ?", id);
    sql.append("ORDER BY A.id DESC");

    return new Article(MysqlUtil.selectRow(sql));
  }

  public void modify(int id, String title, String content) {
    SecSql sql = new SecSql();
    sql.append("UPDATE article");
    sql.append("SET updateDate = NOW()");
    sql.append(", title = ?", title);
    sql.append(", content = ?", content);
    sql.append("WHERE id = ?", id);

    MysqlUtil.update(sql);
  }
}