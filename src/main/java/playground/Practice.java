package playground;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Associate;
import service.AssociateService;
import util.HibernateUtil;

public class Practice {

	
	public static void main(String[] args) {
		
		Associate a = new Associate();
		a.setName("David");
		a.setPoints(10000);
		AssociateService.createAssociate(a);
		
		
	}
}
