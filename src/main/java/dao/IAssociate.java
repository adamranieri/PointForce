package dao;

import java.util.List;

import model.Associate;

public interface IAssociate {
	
	public Associate createAssociate(Associate associate);
	public Associate getAssociate(int id);
	public List<Associate> getAllAssociates();
	public boolean updateAssociate(Associate associate);
	public boolean deleteAssociate(Associate associate);
	
}
