package ym.jsp.board.interceptor;

import ym.jsp.board.Rq;

public abstract class Interceptor {
  abstract public boolean runBeforeAction(Rq rq);
}