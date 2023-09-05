package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
@WebServlet(urlPatterns = {"/page1"},asyncSupported = true)
public class Page1Servlet extends HttpServlet{
	
	private ExecutorService es;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		es = Executors.newCachedThreadPool();
	}
	
	private String getNumber() {
		Random random = new Random();
		
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int v = random.nextInt();
		System.out.println(v);
		return v+"";
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  AsyncContext  ctx =    req.startAsync();
	 	 
		es.execute(()->{
			PrintWriter out;
			try {
				out = ctx.getResponse().getWriter();
				String  v = getNumber();
				out.println(v);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				ctx.complete();
			}
			
		});
		
	}
}
