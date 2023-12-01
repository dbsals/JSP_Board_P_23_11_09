package ym.jsp.board.interceptor;

import ym.jsp.board.Rq;

public class NeedLogoutInterceptor extends Interceptor {
  @Override
  public boolean runBeforeAction(Rq rq) {
    return true;
  }
}