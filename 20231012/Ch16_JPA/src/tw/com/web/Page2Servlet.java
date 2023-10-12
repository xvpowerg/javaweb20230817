package tw.com.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.ejb.MyUserBeanLocal;
import tw.com.jpa.MyUser;

@WebServlet("/page2")
public class Page2Servlet extends HttpServlet {
	
	@EJB
	private MyUserBeanLocal userBean;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MyUser myUser = new MyUser();
//		myUser.setId(1);
//		myUser.setAccount("Vivin");
//		myUser.setPassword("12345");
		
		myUser = userBean.findUserByAccount("Vivin");
		//System.out.println(myUser);
		boolean b1 = userBean.deleteUser(myUser);
		System.out.println("Delete:"+b1);
	}
}
