package playwright.test.com;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Keyboard;

import playwrigh.baseclass.ScriptBase;

public class PressOptions extends ScriptBase {
	
	
	@Test
	public void pressOptions() {
		
		
		page.navigate(home);
		page.fill("exampleFormControlInput", "myEmail@inbox.con");
		
		Keyboard kb = page.keyboard();
		kb.press("Backsapce");
		kb.press("m");
		
		page.focus("#contactReason");
		
		kb.press("ArrowDown");
		kb.press("ArrowDown");

		Assertions.assertTrue(page.isVisible("text=ok, but please make it interseting"));
		
	}
	

}
