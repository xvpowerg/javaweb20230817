package tw.com.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page3")
public class Page3Servlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<String> names = new ArrayList<>();
		names.add("Ken");
		names.add("Vivin");
		names.add("Lucy");
		req.setAttribute("names", names);
		req.getRequestDispatcher("/page3.jsp").
		forward(req, resp);
		
	}
}
