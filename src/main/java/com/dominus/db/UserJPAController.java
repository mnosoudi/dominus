package com.dominus.db;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

import com.dominus.dominus.Tenant;
//import com.dominus.dominus.User;

public class UserJPAController {

	EntityManagerFactory emf;
	public UserJPAController(EntityManagerFactory emf){
		this.emf = emf;
		EntityManager em = emf.createEntityManager();
		//Tenant tnt = new Tenant(em);
		
	}
	public void create(Tenant tnt) throws IOException{
		EntityManager em = this.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();	
		em.persist(tnt);
		
		//WRIT
		tx.commit();
	}
	public Tenant findUserUsingId(int id){
		EntityManager em = this.getEntityManager();
		//error handling
		return em.find(Tenant.class, id);
	}
	private EntityManager getEntityManager(){
		if(this.emf == null){
			//ERROR HANDLE
			return null;
		}else{
		return this.emf.createEntityManager();
		}
	}
	
	  public static void main(String[] args) {
		  Tenant tnt;
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("dominus");
		  UserJPAController test = new UserJPAController(emf);
		  tnt = test.findUserUsingId(1);
		  System.out.println(tnt.getFirstName());
		  
		  
		  
		  
		  
		  
	  }
	
	
}
