package ym.jsp.board.controller;

import ym.jsp.board.Rq;

public class UsrHomeController {
  private Rq rq;
  public UsrHomeController(Rq rq) {
    this.rq = rq;
  }

  public void showMain() {
    rq.jsp("home/main");
  }
}