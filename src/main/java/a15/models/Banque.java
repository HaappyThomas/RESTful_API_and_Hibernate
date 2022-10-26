package a15.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Banque")
public class Banque {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="ville")
	private String ville;
	
	// relation banque(1) et client(n)
	@OneToMany(mappedBy = "banque",
			   fetch = FetchType.EAGER,
			   cascade = CascadeType.ALL)
	private Set<Client> clients;

	// constructor
	public Banque() {
		this.clients = new HashSet<>();
	}

	public Banque(Integer id, String nom, String ville) {
		this.id = id;
		this.nom = nom;
		this.ville = ville;
		this.clients = new HashSet<>();
	}

	// setter and getter
	public Integer getId() {
		return id;
	}

//	public void setId(Integer id) {
//		this.id = id;
//	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Set<Client> getClients() {
		return clients;
	}

//	public void setClients(Set<Client> clients) {
//		this.clients = clients;
//	}
	
	
	
	
	
}
