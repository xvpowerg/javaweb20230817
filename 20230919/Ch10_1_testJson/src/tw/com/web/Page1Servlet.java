package tw.com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/page1")
public class Page1Servlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String json = "{\r\n" + 
				"     \"firstName\": \"John\",\r\n" + 
				"     \"lastName\": \"Smith\",\r\n" + 
				"     \"sex\": \"male\",\r\n" + 
				"     \"age\": 25,\r\n" + 
				"     \"address\": \r\n" + 
				"     {\r\n" + 
				"         \"streetAddress\": \"21 2nd Street\",\r\n" + 
				"         \"city\": \"New York\",\r\n" + 
				"         \"state\": \"NY\",\r\n" + 
				"         \"postalCode\": \"10021\"\r\n" + 
				"     },\r\n" + 
				"     \"phoneNumber\": \r\n" + 
				"     [\r\n" + 
				"         {\r\n" + 
				"           \"type\": \"home\",\r\n" + 
				"           \"number\": \"212 555-1234\"\r\n" + 
				"         },\r\n" + 
				"         {\r\n" + 
				"           \"type\": \"fax\",\r\n" + 
				"           \"number\": \"646 555-4567\"\r\n" + 
				"         }\r\n" + 
				"     ]\r\n" + 
				" }";
		ObjectMapper objMap = new ObjectMapper();
		Map<String,Object> jsonObjMap =  objMap.readValue(json, Map.class);
	 	PrintWriter out =   resp.getWriter();
	 	out.println(jsonObjMap.get("firstName"));
		out.println(jsonObjMap.get("lastName"));
		//System.out.println(json);
		List<Map<String,String>> jsonList = (List)jsonObjMap.get("phoneNumber");
		for (Map<String,String> v : jsonList) {
			out.println(v.get("type"));
			out.println(v.get("number"));
		}
		
		Map<String,String> addrMap = (Map)jsonObjMap.get("address");
		out.println(addrMap.get("streetAddress"));
		out.println(addrMap.get("city"));
	}
}
