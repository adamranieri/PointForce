package service;

import java.util.List;

import dao.BatchDAO;
import model.Batch;

public class BatchService {
	
	private static BatchDAO BD = BatchDAO.getBatchDAO();
	
	public static Batch createBatch(Batch batch) {
		return BD.createBatch(batch);
	}
	
	public static Batch getBatch(int id) {
		return BD.getBatch(id);
	}
	
	public static List<Batch> getAllBatches(){
		return BD.getAllBatches();
	}
	
	public static boolean updateBatch(Batch batch) {
		return BD.updateBatch(batch);
	}
	
	public static boolean deleteBatch(Batch batch) {
		return BD.deleteBatch(batch);
	}
	

}
