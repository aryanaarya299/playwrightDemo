package playwrigh.baseclass;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ScriptBase {
	
   protected String home = "https://magento.softwaretestingboard.com/";
   
   protected static Playwright playwright;
   protected static Browser browser;
	
   protected BrowserContext context;
   protected Page page;
	
	@BeforeAll
	static void launchBrowser() {
		
		playwright = Playwright.create();
		browser = playwright.chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
		
	}
	
	@BeforeEach
	protected void createContextAndPage() {
	 
		context = browser.newContext();
		page = context.newPage();
		page.setViewportSize(1920, 1080);
		
	}
	@AfterEach
	void closeConext() {
		
		context.close();
	}
	
	@AfterAll
	static void closeBrowser() {
		
		browser.close();
		playwright.close();
		
	}	
	

}
