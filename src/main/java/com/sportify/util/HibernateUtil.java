package com.sportify.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory SESSIONFACTORY = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		} catch (Exception e) {
			throw new RuntimeException("Erro na configuração do Hibernate");
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return SESSIONFACTORY;
	}
}