package tw.com.cdi;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

import tw.com.beans.Apple;

public class MyProduces {
	@Produces
	@Named("redApple")
	private Apple getRedApple() {
		Apple apple = new Apple();
		apple.setColor("Red");
		apple.setPrice(100);
		return apple;
	}
	
	
	@Produces
	@Named("myApple")
	private Apple myApple = new Apple("MyApple",280);
	
	
	@Produces
	@Named("appleList")
	private List<Apple> getAppleList(){
		List<Apple> appleList = new ArrayList();
		Apple ap1 = new Apple();
		Apple ap2= new Apple();
		Apple ap3 = new Apple();
		
		ap1.setColor("A1");
		ap1.setPrice(100);
		
		ap2.setColor("A2");
		ap2.setPrice(50);
		
		ap3.setColor("A3");
		ap3.setPrice(60);
		
		appleList.add(ap1);
		appleList.add(ap2);
		appleList.add(ap3);
		return appleList;
	}
	
}
