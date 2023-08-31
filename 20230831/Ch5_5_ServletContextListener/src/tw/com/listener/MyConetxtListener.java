package tw.com.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyConetxtListener implements ServletContextListener{
		@Override
		public void contextInitialized(ServletContextEvent sce) {
			// TODO Auto-generated method stub
			System.out.println("MyConetxtListener");
			ServletContext conx = sce.getServletContext();
			conx.setAttribute("count", 100);
		}
}
