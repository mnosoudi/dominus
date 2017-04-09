package com.dominus.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.transaction.Transaction;

import com.dominus.dominus.User;

public class UserJPAController {

	EntityManagerFactory emf;
	
	public UserJPAController(EntityManagerFactory emf){
		this.emf = emf;
	}
	public void create(User user){
		EntityManager em = this.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try{
		tx.begin();
		//WRIT
		tx.commit();
		}catch(.){
			
		}
	}
	public User findUserUsingId(String id){
		EntityManager em = this.getEntityManager();
		//error handling
		return em.find(User.class, id);
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
