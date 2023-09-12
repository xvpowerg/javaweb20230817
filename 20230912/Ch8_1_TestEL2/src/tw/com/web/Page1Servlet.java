package tw.com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap<>();
		map.put("map1", "MapValue");
		map.put("map2 key", "Map2Value");
		
		
		req.setAttribute("user1", "Ken");
		req.setAttribute("user Vivin", "Vivin");
		req.setAttribute("myMap", map);
		req.getRequestDispatcher("/page1.jsp").forward(req, resp);
	}
}
