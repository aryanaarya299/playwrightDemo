package playwright.test.com;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Text;

import playwrigh.baseclass.ScriptBase;

public class ConsoleVerificationDemo extends ScriptBase {
	
	
	@Test
	public void handlingConsoleMessage() {
		
		
		page.onConsoleMessage(msg -> {
			System.out.println("Console message found: \n" + msg.type() + " : " + msg.text());
			
			
		});
		
		page.onConsoleMessage(msg  -> { 
			
			if("error" .equals(msg.type())) {
				
				System.out.println("Error text: " + msg.text());
				
				Assertions.fail("Error found. failing the test");
			}
			
			
		});
		
		
		page.navigate("https://github.com/andrejs-pass");
		
	}

}
