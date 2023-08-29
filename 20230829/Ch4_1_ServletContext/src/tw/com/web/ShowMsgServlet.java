package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showMsg")
public class ShowMsgServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	   //中文正常顯示
	//	context.getAttribute("msg") 顯示無訊息
	  resp.setContentType("text/html;charset=utf-8");
	  PrintWriter out = resp.getWriter();
	  ServletContext context = getServletContext();
	  String msg = "無訊息";
	  if (context.getAttribute("msg")  != null) {
		  msg = context.getAttribute("msg").toString();
	  }
	  out.println("ShowMsg:"+msg);
	}
}
