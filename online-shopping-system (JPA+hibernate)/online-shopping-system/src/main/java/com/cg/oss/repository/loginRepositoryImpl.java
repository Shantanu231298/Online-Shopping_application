package com.cg.oss.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.cg.oss.entities.User;
import com.cg.oss.exception.OSSException;
import com.cg.oss.util.FactoryConnect;
import com.sun.xml.bind.Util;

import net.bytebuddy.asm.Advice.ArgumentHandler.Factory;

public class loginRepositoryImpl implements IloginRepository {

public final FactoryConnect util=new FactoryConnect();
EntityManagerFactory emf =util.getConnection();
EntityManager em=emf.createEntityManager();
EntityTransaction txn=em.getTransaction();
	public User addUser(User user) throws OSSException {
		// TODO Auto-generated method stub
		
		txn.begin();
		em.persist(user);
		txn.commit();
		return user;
	}

	
	public User removeUser(User user) throws OSSException {
		em.remove(user);
		return user;
	}


	public User validateUser(User user) throws OSSException {
		// TODO Auto-generated method stub
		
		 User found= em.find(User.class, user.getUserId());
		 return found;
	}


	public User signOut(User user) throws OSSException {
		// TODO Auto-generated method stub
		return null;
	}

}
