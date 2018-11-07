package dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Batch;
import model.Trainer;
import util.HibernateUtil;

public class TrainerDAO implements ITrainer{
	
	
	private static SessionFactory sf = HibernateUtil.getSessionFactory();
	private static TrainerDAO TD = new TrainerDAO();
	
	private TrainerDAO() {}
	
	public static TrainerDAO getTrainerDAO() {
		return TD;	
	}

	public Trainer createTrainer(Trainer trainer) {
		
		Session sess = sf.openSession();
		try {	
			
		sess.beginTransaction();		
		sess.save(trainer);		
		sess.getTransaction().commit();
		
			return trainer;
		}catch(HibernateException h) {
			h.printStackTrace();
			return null;
		}finally {
			sess.close();
		}
	}

	public Trainer getTrainer(int id) {
		
		Session sess = sf.openSession();
		
		try {			
		return sess.get(Trainer.class, id);	
			
		}catch(HibernateException h) {			
			h.printStackTrace();
			return null;			
		}finally {
			sess.close();
		}
	}

	public List<Trainer> getAllTrainers() {
		
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

	public boolean updateTrainer(Trainer trainer) {
		
		Session sess = sf.openSession();
		try {	
			
		sess.beginTransaction();		
		sess.update(trainer);		
		sess.getTransaction().commit();
			
			return true;
		}catch(HibernateException h) {
			h.printStackTrace();
			return false;
		}finally {
			sess.close();
		}
	}

	public boolean deleteTrainer(Trainer trainer) {
		
		Session sess = sf.openSession();
		try {			
		sess.beginTransaction();		
		sess.delete(trainer);		
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
