package a15.dao;

import java.util.*;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import a15.models.*;

public class SystemDAO implements ISystemDAO {

	SessionFactory factory = null;
	
	// constructor
	public SystemDAO() {
		// connect DB by Hibernate
		factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}

	@Override
	public Set<Client> getClients(Integer banqueId) {
		Transaction transaction = null;
		Set<Client> clients = null;
		try {
			factory.openSession();
			Session session = factory.getCurrentSession();
			transaction = session.beginTransaction();
			clients = new HashSet<>(session.createQuery("from Client", Client.class).list());
			transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(transaction != null) {
				transaction.rollback();
			}
		}
		return clients;
	}

	@Override
	public Set<Compte> getComptes(Integer clientId)  {
		
		Set<Compte> comptes = new HashSet<>();
		
		Transaction transaction = null;
		try {
			factory.openSession();
			Session session = factory.getCurrentSession();
			transaction = session.beginTransaction();
			comptes = new HashSet<>(session.createQuery("from Compte", Compte.class).list());
			transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(transaction != null) {
				transaction.rollback();
			}
		}
		return comptes;
	}

	@Override
	public Set<Client> getClients() {
		Transaction transaction = null;
		Set<Client> clients = null;
		try {
			factory.openSession();
			Session session = factory.getCurrentSession();
			transaction = session.beginTransaction();
			clients = new HashSet<>(session.createQuery("from Client", Client.class).list());
			transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
			if(transaction != null) {
				transaction.rollback();
			}
		}
		return clients;
	}
	
	// doing
	@Override
	public String manipulerSoldCompte(String operation, Integer id, float montant) {
		Transaction transaction = null;

		String resultat = "Operation ANNULLE !";

		try {
			factory.openSession();
			Session session = factory.getCurrentSession();
			transaction = session.beginTransaction();
			Compte compte = session.get(Compte.class, id);
			if(operation.equals("retrait")) {
				compte.setSolde(compte.getSolde() - montant);
				session.update(compte);

				resultat = "retait success!  " + "Solde de compte est: " + compte.getSolde();
			}else if(operation.equals("depot")) {
				compte.setSolde(compte.getSolde() + montant);
				session.update(compte);

				resultat = "depot success!  " + "Solde de compte est: " + compte.getSolde();
			}
			transaction.commit();

		}catch(Exception e) {
			e.printStackTrace();
			if(transaction != null) {
				transaction.rollback();
			}
		}	
		
		return resultat;
	}
	
}
