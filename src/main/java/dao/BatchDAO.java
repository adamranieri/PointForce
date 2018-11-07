package dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Associate;
import model.Batch;
import util.HibernateUtil;

public class BatchDAO implements IBatch {

	private static SessionFactory sf = HibernateUtil.getSessionFactory();
	private static BatchDAO BD = new BatchDAO();
	
	private BatchDAO() {}
	
	public static BatchDAO getBatchDAO() {
		return BD;	
	}
	
	public Batch createBatch(Batch batch) {
		
		Session sess = sf.openSession();
		try {	
			
		sess.beginTransaction();		
		sess.save(batch);		
		sess.getTransaction().commit();
		
			return batch;
		}catch(HibernateException h) {
			h.printStackTrace();
			return null;
		}finally {
			sess.close();
		}
	}

	public Batch getBatch(int id) {
		
		Session sess = sf.openSession();
		
		try {			
		return sess.get(Batch.class, id);	
			
		}catch(HibernateException h) {			
			h.printStackTrace();
			return null;			
		}finally {
			sess.close();
		}
		
	}

	public List<Batch> getAllBatches() {
		
		Session sess = sf.openSession();
		try {	
			
			String hql = "from Batch";		
			Query q = sess.createQuery(hql);
			return q.getResultList();
			
		}catch(HibernateException h) {
			h.printStackTrace();
			return null;
		}finally {
			sess.close();
		}
	}

	public boolean updateBatch(Batch batch) {
	
		Session sess = sf.openSession();
		try {	
			
		sess.beginTransaction();		
		sess.update(batch);		
		sess.getTransaction().commit();
			
			return true;
		}catch(HibernateException h) {
			h.printStackTrace();
			return false;
		}finally {
			sess.close();
		}
		
	}

	public boolean deleteBatch(Batch batch) {
				
		Session sess = sf.openSession();
		try {			
		sess.beginTransaction();		
		sess.delete(batch);		
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


