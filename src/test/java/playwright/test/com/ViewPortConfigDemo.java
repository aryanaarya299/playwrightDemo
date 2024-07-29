package playwright.test.com;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.ViewportSize;

import playwrigh.baseclass.ScriptBase;

public class ViewPortConfigDemo extends ScriptBase {
	
	Playwright pw;
	Browser browser;
	
	@Test
	public void viewPortConfigDemo() {
		
		pw = Playwright.create();
		browser = pw.chromium().launch( new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
		
	              BrowserContext context = browser.newContext(new Browser.NewContextOptions()
	            		  
	            		  .setViewportSize(viewPortSizes.GALAXY_S5)
	            		  );
	              
	              
	             Page page = context.newPage();
	             page.navigate(home);
	             
	             
	             
	             //verify that the UI is still usable
	             page.click("text = Shop New Yoga");
	             Assertions.assertTrue(page.isVisible("Shop By"));
	             
	}
	
	@AfterEach
	public void cleanup() {
		pw.close();
	}
	
	
	static class viewPortSizes {
		
		public static final ViewportSize IPHONE_X = new ViewportSize(375, 812);
		public static final ViewportSize GALAXY_S5 = new ViewportSize(375, 812);

		
		
		
	}
	

}
