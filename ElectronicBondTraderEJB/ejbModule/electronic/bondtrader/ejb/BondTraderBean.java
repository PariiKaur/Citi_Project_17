package electronic.bondtrader.ejb;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

//import electronic.bondcalculator.BondPriceCalculator;
import electronic.bondtrader.jpa.Bond;
import electronic.bondtrader.jpa.Client;

/**
 * Session Bean implementation class BondTraderBean
 */
@Stateless
@Remote(BondTraderBeanRemote.class)
@Local(BondTraderBeanLocal.class)
public class BondTraderBean implements BondTraderBeanRemote, BondTraderBeanLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext(unitName = "ElectronicBondTraderJPA-PU")
	EntityManager em;

	public BondTraderBean() {
		// TODO Auto-generated constructor stub

	}

	public List<Bond> getAllBonds() {
		Query query = em.createQuery("select b from Bond as b");
		List<Bond> bondList = query.getResultList();
		return bondList;
	}

	public List<Bond> getBondsByType(String typeName) {
		Query query = em.createQuery("select b from Bond as b" + " where b.bond_Type  = :search");
		query.setParameter("search", typeName);
		List<Bond> bondList = query.getResultList();
		return bondList;
	}

	public List<Bond> getBondsByRating(String rating) {
		Query query = em.createQuery("select b from Bond as b" + " where b.credit_Rating  = :rate");
		query.setParameter("rate", rating);
		List<Bond> bondList = query.getResultList();
		return bondList;
	}

	public List<Bond> getBondsByCurrency(String curr) {
		Query query = em.createQuery("select b from Bond as b" + " where b.bond_Currency  = :curr");
		query.setParameter("curr", curr);
		List<Bond> bondList = query.getResultList();
		return bondList;
	}

	public List<Bond> getBondsByCriteria(String rating, String typeName) {
		Query query = em
				.createQuery("select b from Bond as b" + " where b.credit_Rating  = :rate AND b.bond_Type  = :search");
		query.setParameter("rate", rating);
		query.setParameter("search", typeName);

		List<Bond> bondList = query.getResultList();
		return bondList;
	}
	
	public Bond getBondsById(String id) {
		Query query = em.createQuery("select b from Bond as b" + " where b.bond_ID  = :search");
		query.setParameter("search", id);
		Bond bond_data =  (Bond) query.getSingleResult();
		return bond_data;
	}
	
	
	public List<Client> allClients()
	{
//		ListOfEmailDomains = entityManager.createQuery("SELECT e FROM EmailDomainTrust e").getResultList();
		//TODO: client table to be structured with name and other details
		Query query = em.createQuery("select c from Client as c");
		List<Client> client_info = query.getResultList();
		return client_info;
	}
	
	public List<Client> getClientById( String Id )
	{
		Query query = em.createQuery("select c from Client as c" + " where c.client_Id = :Id");
		query.setParameter("Id", Integer.parseInt(Id));
		List<Client> client_info = query.getResultList();
		return client_info;
	}

//	@Override
//	public void bookTrade(String isin, int quantity) {
//		// TODO Auto-generated method stub
//		
//	}

}
