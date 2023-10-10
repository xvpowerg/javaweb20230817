package tw.com.ws;

import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("test")
@Produces(MediaType.APPLICATION_JSON)
public class TestResful {
	@GET
	public String testHello() {
		return "{\"value\":\"Hello\"}";
	}
	
	@POST
	public String testPost(@FormParam("name") String name,@FormParam("pass") String pass) {
		
		return String.format("{\"name\":\"%s\",\"pass\":\"%s\"}", name,pass);
	}
	
	@POST
	@Path("post2")
	public String testPost2(@FormParam("msg") String msg) {
		return String.format("{\"msg\":\"%s\"}", msg) ;
	}
	
	@DELETE
	public String delete(@QueryParam("id") Long id) {
		return "{\"id\":\""+id+"\"}";
	}
	
	@GET
	@Path("/id/{myId:\\S+}")
	public String  createDate(@PathParam("myId") String id) {
		return "\"id\":\""+id+"\"";
	}
	
	@PATCH
	public String update(@QueryParam("id") Long id,
			@DefaultValue("empty") @QueryParam("name") String name,
			@DefaultValue("-1") @QueryParam("age") int age) {
		
		String json = String.format("{\"id\":\"%d\",\"name\":\"%s\",\"age\":\"%s\"}", id,name,age);
		return json;
		
	}
	
	
	
	
	
}
