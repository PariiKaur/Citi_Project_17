package electronic.bondtrader.ejb;

import java.util.List;

import javax.ejb.Remote;

import electronic.bondtrader.jpa.Bond;

@Remote
public interface BondTraderBeanRemote {
	
	public List<Bond> getAllBonds();
}
