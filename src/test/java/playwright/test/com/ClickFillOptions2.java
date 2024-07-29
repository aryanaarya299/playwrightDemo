package playwright.test.com;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Page;

import playwrigh.baseclass.ScriptBase;

public class ClickFillOptions2 extends ScriptBase {
	
	
	
	
	@Test
	public void fillOptions() {
		
	     page.navigate(home);
	     page.fill("id=exampleMessage", "So I Was thinking the other day...",
	     		new Page.FillOptions().setForce(true));
	     
	     
	     
	     
	}

}
