package electronic.bondtrader.web;

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
import javax.ws.rs.core.Response;

import electronic.bondtrader.ejb.BondCalculationBeanLocal;
import electronic.bondtrader.ejb.BondTraderBeanLocal;

@RequestScoped
@Path("/order")
@Produces({ "*/*", "application/json", "application/xml" })
@Consumes({ "*/*", "application/json", "application/xml" })
public class OrderResource {
	
	private BondCalculationBeanLocal calculatorBean;
	
	public OrderResource() {
		Context context = null;
		try {
			context = new InitialContext();
			
			calculatorBean = (BondCalculationBeanLocal) context.lookup(
					"java:global/ElectronicBondTrader/ElectronicBondTraderEJB/BondCalculationBean!electronic.bondtrader.ejb.BondCalculationBeanLocal");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@GET
	@Produces("text/plain")
	public String getText(@FormParam("isin") String name, @FormParam("quantity") String quantity,
			@FormParam("trade_date") String trade_date, @FormParam("yield") String yield,
			@FormParam("client_id") String client_id){
		return name+quantity+trade_date+yield+client_id;
	}
	
	@POST
	@Path("/compute_trade")
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public Response computeBond(@FormParam("isin") String name, @FormParam("quantity") String quantity,
			@FormParam("trade_date") String trade_date, @FormParam("yield") String yield,
			@FormParam("client_id") String client_id) {

		try {
			// TODO: calculation stuff!
			
			// int isin = Integer.parseInt(name);
			//Bond bond = bean.getBondsById(name);
			
			List<Double> calculations = 
					calculatorBean.bookTrade(name, quantity, trade_date, yield, client_id);
			return Response.status(200).entity(calculations).build();
			// return Response.status(200).entity(calculations).build();
		} catch (Exception e) {
			System.out.println("API error...");
			return Response.ok(false).entity("API Error").build();
		}

	}

}
