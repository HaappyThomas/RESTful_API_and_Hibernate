package a15.dao;

import java.util.*;

import a15.models.*;

public interface ISystemDAO {

	Set<Client> getClients();
	
	Set<Client> getClients(Integer banqueId);
	
	Set<Compte> getComptes(Integer idClient) ;
	
	String manipulerSoldCompte(String operation, Integer id, float montant) ;

}
