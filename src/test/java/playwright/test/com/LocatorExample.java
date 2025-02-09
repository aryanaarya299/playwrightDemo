package playwright.test.com;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Locator;

import playwrigh.baseclass.ScriptBase;

public class LocatorExample extends ScriptBase {
	
	@Test
	public void locatorExample() {
		
		page.navigate(home);
		Locator input = page.locator(".form-control");
		
		System.out.println(input.count());
		
		input.first().fill("first");
		input.last().fill("last");
		input.nth(1).fill("second");  // 2nd element at index 1
		
		
		
		
		
	}

}
