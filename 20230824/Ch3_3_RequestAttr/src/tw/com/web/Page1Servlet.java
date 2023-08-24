package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out =  resp.getWriter();
		out.println("Page1");
		String action = req.getParameter("action");
		action = action == null ? "" :action; 
		
		
		switch(action) {
		case "1":
			req.setAttribute("action", action);
			req.setAttribute("action_str", "News");
			req.getRequestDispatcher("/page2").
						forward(req, resp);
			break;
		case "2":
			req.setAttribute("action",action);
			req.setAttribute("action_str", "音樂");
			req.getRequestDispatcher("/page3").
				forward(req, resp);
			break;
		default:
			out.println("Error!");
		}
		//action 1 News
		//action 2 Music
		//action 其他 Error
	}
}
