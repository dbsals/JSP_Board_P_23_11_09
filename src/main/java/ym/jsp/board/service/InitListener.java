package ym.jsp.board.service;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import ym.jsp.board.app.App;

@WebListener
public class InitListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    App.init();
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {

  }
}