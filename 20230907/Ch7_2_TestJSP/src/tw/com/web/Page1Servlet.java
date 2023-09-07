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
		PrintWriter out =  resp.getWriter();
		String title = req.getParameter("title");
		String strCount = req.getParameter("count");
		int count = strCount == null?0:Integer.parseInt(strCount);
		out.print("<html>");
		
		out.print("<head>");
		out.print("<title>");
		//title
			out.print(title);
		out.print("</title>");
		out.print("</head>");
		
		out.print("<body>");
		//count
		char c1 = 'A';
		out.print("<ol>");
		for(int i =1; i <= count;i++) {
			out.print("<li>");
			out.print(c1++);
			out.print("</li>");
		}
		out.print("</ol>");
		out.print("</body>");
		
		out.print("</html>");
	}
}
