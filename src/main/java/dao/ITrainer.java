package dao;

import java.util.List;

import model.Trainer;

public interface ITrainer {
	
	public Trainer createTrainer(Trainer trainer);
	public Trainer getTrainer(int id);
	public List<Trainer> getAllTrainers();
	public boolean updateTrainer(Trainer trainer);
	public boolean deleteTrainer(Trainer trainer);

}
