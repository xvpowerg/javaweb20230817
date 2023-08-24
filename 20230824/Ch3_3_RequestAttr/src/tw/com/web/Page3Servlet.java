package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

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
	   PrintWriter out = resp.getWriter();
	   String action = req.getAttribute("action").toString();
	   String actionStr = req.getAttribute("action_str").toString();
	   out.println("Page3:"+action);
	   out.println("actionStr:"+actionStr);
	}
}
