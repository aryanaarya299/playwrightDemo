package playwright.test.com;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import playwrigh.baseclass.ScriptBase;

public class CustomJsExpressions extends ScriptBase {
	
	
	@Test
	public void localStroage() {
		
		page.navigate(home);
		Object obj = page.evaluate(" () => window.localStroge.getIteam('clapped)");
		Assertions.assertNull(obj);

		
		page.click("#clap-image");
		String obj2 = (String) page.evaluate(" () => window.localStroge.getIteam('clapped)");
		assertTrue(Boolean.parseBoolean(obj2));

		
	}
	
	
	@Test
	public void evalOnSelector() {
		
		page.navigate(home);
		page.evalOnSelector("#hero-banner", "e => e.remove()");
		assertFalse(page.isVisible("#hero-banner"));
	}

}
