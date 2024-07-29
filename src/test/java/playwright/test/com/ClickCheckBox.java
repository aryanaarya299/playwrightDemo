package playwright.test.com;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import playwrigh.baseclass.ScriptBase;

public class ClickCheckBox extends ScriptBase {
	
	
	@Test
	public void checkBoxScenario() {
		
		page.navigate(home);
		
		
		page.fill("#exampleFormControlInput", "my@email.com");
		page.fill("#exampleMessage", "Not sure how to say this...");
		
		//Checked Option
		page.check("#sendCopy");
		
		//Unchecked Option
		page.uncheck("#sendCopy");
		
		page.click("#Submit-contact");
		Assertions.assertTrue(page.isVisible("text=we sent you a copy of your message : Not sure how to say this..."));
		
		
		
	}

}
