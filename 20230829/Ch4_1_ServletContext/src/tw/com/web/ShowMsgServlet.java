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
	   //���奿�`���
	//	context.getAttribute("msg") ��ܵL�T��
	  resp.setContentType("text/html;charset=utf-8");
	  PrintWriter out = resp.getWriter();
	  ServletContext context = getServletContext();
	  String msg = "�L�T��";
	  if (context.getAttribute("msg")  != null) {
		  msg = context.getAttribute("msg").toString();
	  }
	  out.println("ShowMsg:"+msg);
	}
}
