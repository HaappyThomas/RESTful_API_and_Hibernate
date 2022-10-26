package a15.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Compte")
public class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="type")
	private String type;
	
	@Column(name="solde")
	private float solde;
	
	// relation compte(n) et client(1)
	@ManyToOne
	@JoinColumn(name = "clientId",
				referencedColumnName = "id")
	private Client client;

	// constructor
	public Compte() {
	}

	public Compte(Integer id, String type, float solde, Client client) {
		this.id = id;
		this.type = type;
		this.solde = solde;
		this.client = client;
	}

	// setter and getter
	public Integer getId() {
		return id;
	}

//	public void setId(Integer id) {
//		this.id = id;
//	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
	
	
	
	
}
