package dao;

import java.util.List;

import model.Batch;

public interface IBatch {
	
	public Batch createBatch(Batch batch);
	public Batch getBatch(int id);
	public List<Batch> getAllBatches();
	public boolean updateBatch(Batch batch);
	public boolean deleteBatch(Batch batch);
	
}
