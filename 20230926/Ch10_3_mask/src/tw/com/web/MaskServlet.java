package tw.com.web;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.JsonMappingException;

import tw.com.json.MaskJsonTools;
import tw.com.net.MaskNetTools;

@WebServlet(urlPatterns = {"/mask"},asyncSupported = true)
public class MaskServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 AsyncContext ctx = req.startAsync();
		MaskNetTools.getMasJson(json->{
			
			
			try {
				MaskJsonTools.maskJsonObj(
						json,list->{
							ServletRequest newReq = ctx.getRequest();
							ServletResponse newResp = ctx.getResponse();
							newReq.setAttribute("maskList", list);	
							try {
								newReq.getRequestDispatcher("/mask.jsp").
								forward(newReq,newResp);
							} catch (ServletException | IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						});
				ctx.complete();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
	}
}
