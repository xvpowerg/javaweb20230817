package tw.com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String acc = req.getParameter("acc");
		String pwd = req.getParameter("pwd");
		HttpSession session = req.getSession();
		if (acc.equals("qwer") && pwd.equals("12345")) {
			session.setAttribute("login", true);
			resp.sendRedirect("p1/p1_1.html");
		}else {
			resp.sendRedirect("p2/login.html");
		}
	}
}
