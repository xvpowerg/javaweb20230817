package tw.com.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class HelloTag implements Tag{
	private Tag parent;
	private PageContext pageContext;
	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		 JspWriter out =  this.pageContext.getOut();
		 try {
			 out.println("<font size='5' color='blue'>我離開了</font><br>");
		 }catch(IOException ex) {
			 
		 }
		 //EVAL_PAGE 繼續之後的JSP
		 return EVAL_PAGE;
	}
	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		 JspWriter out =  this.pageContext.getOut();
		 try {
			 out.println("<font size='5' color='blue'>我來了!!</font><br>");
		 }catch(IOException ex) {
			 
		 }
		return EVAL_PAGE;
	}

	@Override
	public Tag getParent() {
		// TODO Auto-generated method stub
		return this.parent;
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		// TODO Auto-generated method stub
		this.pageContext = pageContext;
	}

	@Override
	public void setParent(Tag parent) {
		// TODO Auto-generated method stub
		this.parent = parent;
	}

}
