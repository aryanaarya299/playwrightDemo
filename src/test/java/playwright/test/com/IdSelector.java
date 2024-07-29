package playwright.test.com;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class IdSelector {
	
	
	@Test
	public void idselectorsTest() {
		
		try(Playwright playwright = Playwright.create()) {
			
			BrowserType browserType = playwright.chromium();
			
			Browser browser =browserType.launch( new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(3000));
			
			Page page = browser.newPage();
			page.navigate("https://magento.softwaretestingboard.com/customer/account/create/");
			page.click("id=firstname");
			page.fill("id=firstname",  "John");
			page.click("id=lastname");
			page.fill("id=lastname", "Mark");
			
			
			
		}
		
		
		
	}

}
