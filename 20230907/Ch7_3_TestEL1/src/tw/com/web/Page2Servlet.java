package tw.com.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.com.beans.Item;

@WebServlet("/page2")
public class Page2Servlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session =  req.getSession();
		Item item1 = new Item("Item1",100);
		session.setAttribute("seValue", "sessionValue");
		session.setAttribute("item1", item1);
		ServletContext app = this.getServletContext();
		app.setAttribute("appValue", "applactionValue");
		List<String> names  = new ArrayList();
		names.add("Ken");
		names.add("Vivin");
		names.add("Lucy");
		session.setAttribute("names", names);
		
		
		
		
		req.getRequestDispatcher("/page2.jsp").forward(req, resp);
		
	}
}
