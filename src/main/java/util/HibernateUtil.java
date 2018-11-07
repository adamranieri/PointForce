package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sessionfactory; 
	
	private HibernateUtil() {};
	
	public static SessionFactory getSessionFactory() {
		
		if(sessionfactory == null) {		
			Configuration cfg = new Configuration();
			sessionfactory = cfg.configure().buildSessionFactory();					
		}			
		return sessionfactory;
	}
	
	
	
	

}
