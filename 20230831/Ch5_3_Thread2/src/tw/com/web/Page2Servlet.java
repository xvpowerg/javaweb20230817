package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/page2"},asyncSupported = true)
public class Page2Servlet extends HttpServlet{
	private ExecutorService es;	
	//WebServlet 建立時執行一次
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		es = Executors.newCachedThreadPool();
	}
	private void testWork( AsyncContext ctx) {
		System.out.println("testWork:"+Thread.currentThread().getName());
		for (int i = 1; i<=10;i++) {
			System.out.println("Thread Start:"+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				
			}
		}
		System.out.println("Thread Finish");
		try {
			PrintWriter out =  ctx.getResponse().getWriter();
			out.println("Thread Finish");
			ctx.complete();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out =  resp.getWriter();
		AsyncContext ctx =   req.startAsync();
		System.out.println("doGet:"+Thread.currentThread().getName());
		out.println("Page1 Start");
		es.execute(()->testWork(ctx));
		out.println("Page1 End");
	}
}
