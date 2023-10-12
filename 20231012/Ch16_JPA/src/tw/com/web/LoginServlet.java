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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@EJB
	private MyUserBeanLocal myUserBean;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MyUser myUser = new MyUser();
		myUser.setAccount("Vivin");
		myUser.setPassword("12345");
		System.out.println("Login:"+myUserBean.login(myUser));
	}
}
