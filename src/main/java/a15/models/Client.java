package a15.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="nomDeFamille")
	private String nomDeFamille;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="telephone")
	private String telephone;
	
	// relation client(n) et banque(1)
	@ManyToOne
	@JoinColumn(name = "banqueId",
				referencedColumnName = "id")
	private Banque banque;
	
	// relation client(1) et compte(n)
	@OneToMany(mappedBy = "client",
			   fetch = FetchType.EAGER,
			   cascade = CascadeType.ALL)
	private Set<Compte> comptes;

	// constructor
	public Client() {
		this.comptes = new HashSet<>();
	}

	public Client(Integer id, String nomDeFamille, String prenom, String telephone, Banque banque) {
		this.id = id;
		this.nomDeFamille = nomDeFamille;
		this.prenom = prenom;
		this.telephone = telephone;
		this.banque = banque;
		this.comptes = new HashSet<>();
	}

	// setter and getter
	public Integer getId() {
		return id;
	}

//	public void setId(Integer id) {
//		this.id = id;
//	}

	public String getNomDeFamille() {
		return nomDeFamille;
	}

	public void setNomDeFamille(String nomDeFamille) {
		this.nomDeFamille = nomDeFamille;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	public Set<Compte> getComptes() {
		return comptes;
	}

//	public void setComptes(Set<Compte> comptes) {
//		this.comptes = comptes;
//	}
//	
	
	
	
}
