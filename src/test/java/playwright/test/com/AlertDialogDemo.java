package playwright.test.com;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import playwrigh.baseclass.ScriptBase;

public class AlertDialogDemo extends ScriptBase {
	
	
	@Test
	public void alertTest() {
		
		
		page.navigate(home);
		page.fill("#donation", "50");
		
		
		page.onDialog(dialog -> {
			
			try {
			Thread.sleep(2000);
			}
			catch (InterruptedException e) {
			}
		
		dialog.accept();
	});
		
		page.click("#submit-donation");
		Assertions.assertTrue(page.isVisible("text=Thank you!"));

}

      @Test
      public void confirmTestAccept() {
    	  
    	page.navigate(home);
  		page.fill("#donation", "50");
  		
  		
		page.onDialog(dialog -> dialog.accept());

  		
  		
  		page.click("#submit-donation");
		Assertions.assertTrue(page.isVisible("text=Thank you!"));

  		
  		
    	  
      }
      
      
      @Test
      public void confirmTestDismiss() {
    	  
    	page.navigate(home);
  		page.fill("#donation", "50");
  		
  		
		page.onDialog(dialog -> dialog.dismiss());

  		
  		
  		page.click("#submit-donation");
		Assertions.assertTrue(page.isVisible("text=Thank you!"));

  		
  		
    	  
      }
      
      @Test
      public void prompTest() {
    	  
    	page.navigate(home);
  		page.fill("#donation", "2000");
  		
  		
		page.onDialog(dialog -> dialog.accept("Yes"));

  		
  		
  		page.click("#submit-donation");
		Assertions.assertTrue(page.isVisible("text=Thank you!"));

  		
      }
    	  
      
      
      

}