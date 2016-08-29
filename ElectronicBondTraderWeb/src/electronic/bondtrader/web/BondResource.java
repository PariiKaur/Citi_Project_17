package electronic.bondtrader.web;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import electronic.bondtrader.ejb.BondTraderBeanLocal;
import electronic.bondtrader.jpa.Bond;

@RequestScoped
@Path("/bond")
@Produces({ "*/*", "application/json", "application/xml" })
@Consumes({ "*/*", "application/json", "application/xml" })
public class BondResource {

	private BondTraderBeanLocal bean;
	
	public BondResource(){
		Context context = null;
		try {
			context = new InitialContext();
			bean = (BondTraderBeanLocal)context.lookup("java:global/ElectronicBondTrader/ElectronicBondTraderEJB/BondTraderBean!electronic.bondtrader.ejb.BondTraderBeanLocal");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@GET
	@Produces ("application/json")
	public List<Bond> getBonds(/*@QueryParam ("filter") @DefaultValue("")  String filter*/){
		//if(filter.length() ==0)
		 	return bean.getAllBonds();
		//else
			//return null; //bean.getProductsByName(filter);
	}
	
	@POST
	@Path("/post_test")
	@Consumes("application/x-www-form-urlencoded")
	public Response post(@FormParam("name") String name) {
	    // Store the message
		String updated = "Success!";
		return Response.status(200).entity(updated).build();
	}
	
	@POST
	@Path("/post_test")
	@Consumes("application/x-www-form-urlencoded")
	public Response post(MultivaluedMap<String, String> formParams) {
	    // Store the message
		String updated = "";
		try
		{
			Iterator<String> it = formParams.keySet().iterator();
			while(it.next() != null)
			{
				String theKey = (String)it.next();
				System.out.println(formParams.getFirst(theKey));
				
			}
			System.out.println("Successfull Creation");
		}
		catch (Exception e)
		{
			System.out.println("API Error!");
		}
		return Response.status(200).entity(updated).build();
	}
	
	@POST
	@Path("/post_test")
	@Consumes("application/x-www-form-urlencoded")
	public Response AddResource(InputStream incomingData) {
		StringBuilder resourceBuilder = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			while ((line = in.readLine()) != null) {
				resourceBuilder.append(line);
			}
		} catch (Exception e) {
			System.out.println("Error Parsing: - ");
		}
		System.out.println("Data Received: " + resourceBuilder.toString());
 
		// return HTTP response 200 in case of success
		return Response.status(200).entity(resourceBuilder.toString()).build();
	}
}
