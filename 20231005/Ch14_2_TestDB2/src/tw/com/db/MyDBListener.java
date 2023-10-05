package tw.com.db;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyDBListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContext context =   sce.getServletContext();
		String url = context.getInitParameter("db_url");
		String user = context.getInitParameter("db_account");
		String password = context.getInitParameter("db_password");
		DbTools.setAccount(user);
		DbTools.setPassword(password);
		DbTools.setUrl(url);
		System.out.println(url+":"+user+":"+password);
	}
}
