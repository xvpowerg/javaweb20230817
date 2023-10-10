package tw.com.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.beans.Apple;

@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
//Contexts and Dependency Injection
	@Inject
	@Named("redApple")
	private Apple apple1;
	@Inject
	@Named("appleList")
	private List<Apple> appleList;
	
	@Inject
	@Named("myApple")
	private Apple myApple;
	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) 
					throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(apple1);
		System.out.println(appleList);
		System.out.println(myApple);
	}
}
