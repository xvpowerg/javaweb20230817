package tw.com.web;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class MySessionAttrListener implements HttpSessionAttributeListener{
	
		
		@Override
		public void attributeAdded(HttpSessionBindingEvent event) {
			// TODO Auto-generated method stub
			String name = event.getName();
			Object value = event.getValue();
			System.out.println("add name:"+name);
			System.out.println("add value:"+value);
			HttpSession session =  event.getSession();
			if (name.equals("value1")) {
				session.setAttribute("value1", "Lucy");
			}
			
		}
		@Override
		public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
			String name = event.getName();
			Object value = event.getValue();
			System.out.println("Replaced name:"+name);
			System.out.println("Replaced value:"+value);
		}
		@Override
		public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
			String name = event.getName();
			Object value = event.getValue();
			System.out.println("Removed name:"+name);
			System.out.println("Removed value:"+value);
		
		}
}
