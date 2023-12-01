package ym.jsp.board.interceptor;

import ym.jsp.board.Rq;
import ym.jsp.board.dto.Member;

public class BeforeActionInterceptor extends Interceptor {
  @Override
  public boolean runBeforeAction(Rq rq) {
    if (rq.getSessionAttr("loginedMember") != null) {
      rq.setLogined(true);
      rq.setLoginedMember(rq.getSessionAttr("loginedMember"));
      rq.setLoginedMemberId(rq.getLoginedMember().getId());
    }

    rq.setAttr("rq", rq);

    return true;
  }
}