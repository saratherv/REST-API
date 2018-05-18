package test;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@Path("/hello")
public class Hello {
@GET
@Produces(MediaType.TEXT_XML)
public String sayHello() {
	String res="<?xml version='1.0'?>"
			+"<hello>This is Rajeev inside XML</hello>";
	return res;
}

@GET
@Produces(MediaType.APPLICATION_JSON)
public String sayHelloJson() {
	String res=null;
	return res;
}
@GET
@Produces(MediaType.TEXT_HTML)
public String sayHelloHtml(@QueryParam("name") String name,@QueryParam("cardno") String cardno,@QueryParam("amount") int amount) {
	System.out.println("Name is "+name);
	System.out.println("card no is"+cardno);
	String res;
	if(amount>100000) {
		System.out.println("Amount is greater than one lakh");
		res="Credit card is not approved";
	}
	else {
		System.out.println("Amount is less than 1 lakhs");
		res="credit card approved";
	}
	return "<html>"+"<title>"+"credit card authorization"+"name"+"</title>"+
	"<body>"+"<h1>"+res+"</h1>"+"</body>"+"</html>";
}


}
