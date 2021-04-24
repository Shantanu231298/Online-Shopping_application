package com.cg.oss.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FactoryConnect {
	public static EntityManagerFactory emf;

	public EntityManagerFactory getConnection() {
		emf = Persistence.createEntityManagerFactory("oracle-pu");
		return emf;
	}

	public void shutDown() {
		emf.close();
	}

}
