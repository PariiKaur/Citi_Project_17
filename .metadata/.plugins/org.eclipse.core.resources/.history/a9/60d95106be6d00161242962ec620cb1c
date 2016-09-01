package electronic.bondtrader.ejb;

import java.util.List;

import javax.ejb.Remote;

import electronic.bondtrader.jpa.Bond;

@Remote
public interface BondTraderBeanRemote {
	
	public List<Bond> getAllBonds();
	public List<Bond> getBondsByType(String typeName);
	public List<Bond> getBondsByRating (String rating);
	public List<Bond> getBondsByCurrency (String curr);
	public List<Bond> getBondsByCriteria (String rating, String typeName);
}
