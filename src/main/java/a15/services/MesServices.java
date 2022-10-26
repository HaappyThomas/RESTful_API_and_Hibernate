package a15.services;

import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import a15.dao.*;
import a15.models.*;

@Path("/services")
public class MesServices {
	
	private SystemDAO dao = null;
	
	// constructor
	public MesServices() {
		dao = new SystemDAO();
	}
	
	// get  les clients d’une banque donnée
	@GET
	@Path("banque/{id}/clients")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Client> trouverClientsParBanque(@PathParam("id") Integer id){

		List<Client> clientsUnBanque = new ArrayList<>();

		Set<Client> clients = dao.getClients(id);

		for(Client client: clients) {
			if(client.getBanque().getId() == id) {
				clientsUnBanque.add(client);
			}
		}
		
		return clientsUnBanque;
	}
	
	// get  les clients d’une client donnée
	@GET
	@Path("client/{id}/comptes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Compte> trouverComptesParClient(@PathParam("id") Integer id){

		List<Compte> comptesUnClient = new ArrayList<>();

		Set<Compte> comptes = dao.getComptes(id);
		
		for(Compte compte: comptes) {
			if(compte.getClient().getId() == id) {
				comptesUnClient.add(compte);
			}
		}
		
		return comptesUnClient;
	}
	
	// get  les clients par critère
	@GET
	@Path("clients/{critere}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Client> trouverClientsParCritere(@PathParam("critere") String critere){

		List<Client> clientsParCritere= new ArrayList<>();

		Set<Client> clients = dao.getClients();
	
		for(Client client: clients) {
			if(critere.equals("montreal")) {
				if(client.getTelephone().startsWith("514") || client.getTelephone().startsWith("438")) {
					clientsParCritere.add(client);
				}
				
			}else if(critere.equals("monteregie")) {
				if(client.getTelephone().startsWith("450")) {
					clientsParCritere.add(client);
				}
			}
		}
		
		return clientsParCritere;
	}
	
	// doing
	@PUT
	@Path("compte/{operation}/{id}/{montant}")
	@Produces(MediaType.TEXT_PLAIN)
	public String modifierSoldeCompte(@PathParam("operation") String operation,
									  @PathParam("id") Integer id,
									  @PathParam("montant") float montant) {
		
		return dao.manipulerSoldCompte(operation, id, montant);
	}
	

	// test Web service
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String getTest(){

		return "acces succes!";
	}
	

}
