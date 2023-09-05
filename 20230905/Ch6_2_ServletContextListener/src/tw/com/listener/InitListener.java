package tw.com.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContext app =sce.getServletContext();
		String acc = app.getInitParameter("acc");
		String pwd = app.getInitParameter("pwd");
		app.setAttribute("acc", acc);
		app.setAttribute("pwd", pwd);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("contextDestroyed");
	}
}
