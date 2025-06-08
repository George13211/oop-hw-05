package cs108.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AccountManagerListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().setAttribute("accountManager", new AccountManager());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
