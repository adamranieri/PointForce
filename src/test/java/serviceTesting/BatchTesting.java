package serviceTesting;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import model.Batch;
import model.Trainer;
import service.BatchService;

public class BatchTesting {
	
  @Test(priority =1)
  public void createBatch() {	 
	  
	  Batch b = new Batch();	 
	  if(BatchService.createBatch(b) == null) 
		  Assert.fail();
	  
  }
  
  @Test(priority =2)
  public void getAllBatches() {
	  
	  List<Batch> batches = BatchService.getAllBatches();	  
	  Assert.assertNotEquals(batches.size(), 0);
	  
  }
  
  @Test(priority = 3)
  public void updateBatch() {
	  
	  Batch b = new Batch();
	  BatchService.createBatch(b);
	  b.setName("Temporary Batch");	  
	  if(BatchService.updateBatch(b)== false)
		  Assert.fail();
	  
  }
  
  
  
  
  
}
