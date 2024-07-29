package playwright.test.com;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class CssSelector {
	
	
	@Test
	public void cssSelectorsTest() {
		
		try(Playwright playwright = Playwright.create()) {
			
			BrowserType browserType = playwright.chromium();
			
			Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
			
			Page page = browser.newPage();
			page.navigate("https://magento.softwaretestingboard.com/customer/account/create/");
			
			//Most generic option
			page.fill("input", "This is cat");
			
			//finds the first element and fills it in
		//	page.fill(".form-control", "First box");
					
			
			
			
		}
		
		
	}

}
