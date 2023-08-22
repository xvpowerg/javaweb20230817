package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showValue")
public class ShowValueServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		String count = req.getParameter("count");
		int countInt = 0;
		try {
			countInt = Integer.parseInt(count);	
		}catch(Exception ex) {
			
		}
		
		char ch = 'A';
		for(int i = 0; i < countInt;i++) {
			char v = (char)(ch + i);
			out.println(v);
		}
	}
}
