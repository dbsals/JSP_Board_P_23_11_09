package ym.jsp.board.app;

import ym.jsp.board.container.Container;
import ym.jsp.board.util.MysqlUtil;

public class App {
  private static boolean isDevMode() {
    // 이 부분을 false로 바꾸면 production 모드 이다.
    return true;
  }

  public static void init() {
    // DB 세팅
    MysqlUtil.setDBInfo("localhost", "ym", "aa48aa76", "jspboard");
    MysqlUtil.setDevMode(isDevMode());

    // 공용 객체 세팅
    Container.init();
  }
}