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
    
    public List<Bond> getBondsByType(String typeName){
    	Query query = em.createQuery("select b from Bond as b"
    			+ " where b.bond_Type  = :search");
    	query.setParameter("search", typeName);
		List<Bond> bondList = query.getResultList();
		return bondList;
    }
    
    public List<Bond> getBondsByRating (String rating){
    	Query query = em.createQuery("select b from Bond as b"
    			+ " where b.credit_Rating  = :rate");
    	query.setParameter("rate", rating);
		List<Bond> bondList = query.getResultList();
		return bondList;
    }
    
    public List<Bond> getBondsByCurrency (String curr){
    	Query query = em.createQuery("select b from Bond as b"
    			+ " where b.bond_Currency  = :curr");
    	query.setParameter("curr", curr);
		List<Bond> bondList = query.getResultList();
		return bondList;
    }
    
    public List<Bond> getBondsByCriteria (String rating, String typeName){
    	Query query = em.createQuery("select b from Bond as b"
    			+ " where b.credit_Rating  = :rate AND b.bond_Type  = :search");
    	query.setParameter("rate", rating);
    	query.setParameter("search", typeName);
    	
    	List<Bond> bondList = query.getResultList();
		return bondList;
    }

	   

}

