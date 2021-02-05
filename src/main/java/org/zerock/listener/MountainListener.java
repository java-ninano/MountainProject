package org.zerock.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MountainListener implements ServletContextListener {

	  /**
     * Default constructor. 
     */
    public MountainListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	// Context Root -> Application 영역에 추가
    	ServletContext application = sce.getServletContext();
    	application.setAttribute("root", application.getContextPath());
    }
	
}
