package service;

import java.util.List;

import dao.AssociateDAO;
import model.Associate;

public class AssociateService {
	
	private static AssociateDAO AD = AssociateDAO.getAssociateDAO();
	
	public static Associate createAssociate(Associate associate) {	
		return  AD.createAssociate(associate);	
	}
	
	public static Associate getAssociate(int id) {
		return AD.getAssociate(id);
	}
	
	public static List<Associate> getAllAssociates(){
		return AD.getAllAssociates();
	}
	
	public static boolean updateAssociate(Associate associate) {
		return AD.updateAssociate(associate);
	}
	
	public static boolean deleteAssociate(Associate associate) {
		return AD.deleteAssociate(associate);
	}

}
