package playwright.test.com;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Page;

import playwrigh.baseclass.ScriptBase;

public class ClickFillOptions extends ScriptBase {
	
	
	
	@Test
	public void clickOptionsCount() {
		
		page.navigate(home);
		page.click("#clap-image", new Page.ClickOptions().setClickCount(2));
		
		Assertions.assertTrue(page.isVisible("text = you can only clap one, but thanks for your enthusiam"));
		
	}

}
