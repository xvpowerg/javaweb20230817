package tw.com.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.ejb.MyUserBeanLocal;
import tw.com.jpa.MyUser;

@WebServlet("/page1")
public class Page1Servlet extends HttpServlet{
//	@Inject
//	private EntityManager em;
	@EJB
	private MyUserBeanLocal myUserBean;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Java實現ORM(Object Relational Mapping) 使用 JPA (Java Persistence API)
		MyUser myUser = new MyUser();
//		myUser.setAccount("Vivin");
//		myUser.setPassword("12345");
//		em.persist(myUser);
		myUser.setAccount("Vivin");
		myUser.setPassword("12345");
		boolean b1 = myUserBean.regisrter(myUser);
		

		System.out.println(b1);
//		MyUser myaUser2 =  myUserBean.findUserByAccount("Vivin");
//		System.out.println(myaUser2);
		
	}
}
