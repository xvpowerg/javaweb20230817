package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.beans.Item;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
	Map<String,Item> itemMap = new HashMap();
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		Item i1 = new Item("雞腿",100);
		Item i2 = new Item("排骨",85);
		Item i3 = new Item("叉燒",90);
		itemMap.put("0", i1);
		itemMap.put("1", i2);
		itemMap.put("2", i3);
	}
	
	//輸出 勾選的內容
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out =   resp.getWriter();
		String[] items = req.getParameterValues("item");
		for(String key : items) {
			out.println(itemMap.get(key));
		}
	}
}
