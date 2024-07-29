package playwright.test.com;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import playwrigh.baseclass.ScriptBase;

public class SelectDropdown extends ScriptBase {
	
	
	@Test
	public void selectDropdownSceanrio() {
		
		page.navigate(home);
		page.selectOption("id=contatcReason", "Bored");
		
		Assertions.assertTrue(page.isVisible("text=ok, but please make it intersting"));
	}

}
