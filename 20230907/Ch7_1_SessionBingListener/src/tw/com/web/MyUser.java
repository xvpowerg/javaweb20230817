package tw.com.web;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.time.LocalDateTime;

public class MyUser implements HttpSessionBindingListener {
	private String name;

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		LocalDateTime time = LocalDateTime.now();
		System.out.println("Login:"+time);
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		LocalDateTime time = LocalDateTime.now();
		System.out.println("Out:"+time);
	}
	
	public MyUser(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MyUser [name=" + name + "]";
	}
	
	
	
}
