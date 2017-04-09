package com.dominus.db;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.transaction.Transaction;

import com.dominus.dominus.Tenant;
//import com.dominus.dominus.User;

public class UserJPAController {

	EntityManagerFactory emf;
	
	public UserJPAController(EntityManagerFactory emf){
		this.emf = emf;
	}
	public void create(Tenant user) throws IOException{
		EntityManager em = this.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//WRIT
		tx.commit();
	}
	public Tenant findUserUsingId(String id){
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
}
