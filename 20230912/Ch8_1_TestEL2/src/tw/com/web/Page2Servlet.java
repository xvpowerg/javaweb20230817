package tw.com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page2")
public class Page2Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String canShow = req.getParameter("canShow");
		String action = req.getParameter("action");
		action = action == null ? "0":action;
		
		
		req.setAttribute("canShow", Boolean.parseBoolean(canShow));
		req.setAttribute("action", Integer.parseInt(action));
		req.getRequestDispatcher("/page2.jsp").forward(req, resp);
	}
}
