package tw.com.tools;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitImagePath implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		String path = sce.getServletContext().getInitParameter("my_path");
		ImageTools.setImagePath(path);
	}
}
