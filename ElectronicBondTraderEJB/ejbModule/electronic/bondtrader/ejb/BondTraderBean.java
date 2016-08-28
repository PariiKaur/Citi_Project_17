package electronic.bondtrader.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import electronic.bondtrader.jpa.Bond;


/**
 * Session Bean implementation class BondTraderBean
 */
@Stateless
@Remote (BondTraderBeanRemote.class)
@Local (BondTraderBeanLocal.class)
public class BondTraderBean implements BondTraderBeanRemote, BondTraderBeanLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName = "ElectronicBondTraderJPA-PU")
	EntityManager em;
    public BondTraderBean() {
        // TODO Auto-generated constructor stub
    	
    }
    
    public List<Bond> getAllBonds(){
    	Query query = em.createQuery("select b from Bond as b");
		List<Bond> bondList = query.getResultList();
		return bondList;
    }

}

