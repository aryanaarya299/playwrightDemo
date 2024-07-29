package playwright.test.com;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class InspectorDemo {
	
	Playwright pw;
	Browser browser;
	
	
	@Test
	public void inspectorDemo() {
		
		browser =Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		page.navigate("https://playwright.dev/java/");
		
		page.pause();
		
		page.click("text = get Started");
		
		
	}
	
    @AfterEach
    public void cleanup() {
    	
    	pw.close();
    }
    
}
