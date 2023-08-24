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
	private String[] skillArray = {"Java","Python","Golang"};
	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out =  resp.getWriter();
		out.println("Page1");
		//String skill = req.getParameter("skill"); 
		String[] skills = req.getParameterValues("skill");
		for (String s : skills) {
			int index = Integer.parseInt(s);
			out.println("Skill:"+skillArray[index]);
		}
		
	}
}
