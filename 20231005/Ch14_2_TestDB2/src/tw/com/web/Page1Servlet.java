package tw.com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.db.DbTools;
import tw.com.db.MySqlUser;
import tw.com.db.UserDao;

@WebServlet("/page1")
public class Page1Servlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			UserDao userDao = new MySqlUser();
			boolean b1 = userDao.regisrter("Ben",  "123456");
			System.out.println(b1);
			//DbTools.getConnection();
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}
}
