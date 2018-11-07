package dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import model.Associate;
import util.HibernateUtil;

public class AssociateDAO implements IAssociate{
	
	private static SessionFactory sf = HibernateUtil.getSessionFactory();
	private static AssociateDAO AD = new AssociateDAO();
	
	private AssociateDAO() {}
	
	public static AssociateDAO getAssociateDAO() {
		return AD;	
	}

	public Associate createAssociate(Associate associate) {
		
		Session sess = sf.openSession();
		try {	
			
		sess.beginTransaction();		
		sess.save(associate);		
		sess.getTransaction().commit();

			return associate;
		}catch(HibernateException h) {
			h.printStackTrace();
			return null;
		}finally {
			sess.close();
		}
		
	}

	public Associate getAssociate(int id) {
		
		Session sess = sf.openSession();
		
		try {			
		return sess.get(Associate.class, id);	
			
		}catch(HibernateException h) {			
			h.printStackTrace();
			return null;			
		}finally {
			sess.close();
		}
		
	}

	public List<Associate> getAllAssociates() {
		
		Session sess = sf.openSession();
		try {	
			
			String hql = "from Associate";		
			Query q = sess.createQuery(hql);
			return q.getResultList();
			
		}catch(HibernateException h) {
			h.printStackTrace();
			return null;
		}finally {
			sess.close();
		}
	}

	public boolean updateAssociate(Associate associate) {
		
		Session sess = sf.openSession();
		try {	
			
		sess.beginTransaction();		
		sess.update(associate);		
		sess.getTransaction().commit();
			
			return true;
		}catch(HibernateException h) {
			h.printStackTrace();
			return false;
		}finally {
			sess.close();
		}
		
	}

	public boolean deleteAssociate(Associate associate) {
		
		Session sess = sf.openSession();
		try {			
		sess.beginTransaction();		
		sess.delete(associate);		
		sess.getTransaction().commit();
			
			return true;
		}catch(HibernateException h) {
			h.printStackTrace();
			return false;
		}finally {
			sess.close();
		}
		
	}
	
	

}
