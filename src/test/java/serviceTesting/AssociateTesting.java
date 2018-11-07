package serviceTesting;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

import model.Associate;
import service.AssociateService;


public class AssociateTesting {
	
  private static List<Associate> associates = new ArrayList<Associate>();
	

  @Test(dataProvider = "dp", priority =1)
  public void createAssociate(Associate a) {
	  
	  if (AssociateService.createAssociate(a) == null) 
		  Assert.fail();
	  
	  associates.add(a);
  }
  
  @Test(priority =2)
  public void allAssociates() {
	  
	  List<Associate> actual = AssociateService.getAllAssociates();
	  Assert.assertEquals(actual.size(), associates.size());
	  
	  associates.clear();
	  associates.addAll(actual);
  }
  
  @Test(priority = 3)
  public void updateAssociate() {
	  
	  for(Associate a : associates) {
	  a.setPoints( (int) (Math.random()*1000000));
	  a.setName(String.valueOf((int) (Math.random()*1000000)));
	  
	  if (AssociateService.updateAssociate(a) == false) 
		  Assert.fail();
	  
	  Assert.assertEquals(a, AssociateService.getAssociate(a.getId()));
	  }
	  
  }
  
  @Test(priority = 4)
  public void getAssociate(){
	  
	  for(Associate a : associates) {	  			  
		  Assert.assertEquals(a, AssociateService.getAssociate(a.getId()));
	  }
  }

  @Test(priority = 5)
  public void deleteAssociate() {
	  
	  for(Associate a : associates) {
	  if(AssociateService.deleteAssociate(a) == false)
		  Assert.fail();
	  }
	  
  }
  
  
  @DataProvider
  public Object[][] dp() {
	  
  	Associate alex = new Associate("Alex", 1000);
  	Associate david = new Associate("David", 5000);
  	Associate jaxon = new Associate("Jaxon", 400);

    return new Object[][] {
    	
    new Object[] {alex},
    new Object[] {david},
    new Object[] {jaxon}
     
    };
  }
  
}
