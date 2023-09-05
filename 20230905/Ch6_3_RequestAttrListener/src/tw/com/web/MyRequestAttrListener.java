package tw.com.web;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyRequestAttrListener implements ServletRequestAttributeListener{
		@Override
		public void attributeAdded(ServletRequestAttributeEvent srae) {
			// TODO Auto-generated method stub
			String name = srae.getName();
			System.out.println("add name:"+name);
			Object obj =   srae.getValue();
			System.out.println("add Value:"+obj);
			
			ServletRequest s = srae.getServletRequest();
			if (name.equals("value1")) {
				s.setAttribute(name, "Vivin");
			}
		}
		
		@Override
		public void attributeReplaced(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
			String name = srae.getName();
			System.out.println("Replaced name:"+name);
			Object obj =   srae.getValue();
			System.out.println("Replaced Value:"+obj);
		}
		
		@Override
		public void attributeRemoved(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
			String name = srae.getName();
			System.out.println("Removed name:"+name);
			Object obj =   srae.getValue();
			System.out.println("Removed Value:"+obj);
		}

}
