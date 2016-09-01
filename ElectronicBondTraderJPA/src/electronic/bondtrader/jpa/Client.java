package electronic.bondtrader.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the client_info database table.
 * 
 */
@Entity
@Table(name="client_info")
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int client_Id;

	private String email;

	private String first_Name;

	private String last_Name;

	private int phone;
	
//	private List<Trade> tradesOfClient= null;
	public Client() {
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getClient_Id() {
		return this.client_Id;
	}

	public void setClient_Id(int client_Id) {
		this.client_Id = client_Id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirst_Name() {
		return this.first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLast_Name() {
		return this.last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	public int getPhone() {
		return this.phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
	
//	@OneToMany(mappedBy="client", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
//	@JsonManagedReference (value="user-client")
//	public List<Trade> getTradesOfClient() {
//		return tradesOfClient;
//	}
//
//	public void setTradesOfClient(List<Trade> tradesOfClient) {
//		this.tradesOfClient = tradesOfClient;
//	}

}