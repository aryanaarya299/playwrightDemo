package playwright.test.com;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import playwrigh.baseclass.ScriptBase;

public class JavaScriptConfigDemo extends ScriptBase {
	
	Playwright pw;
	Browser browser;
	
	
	@Test
	public void javaScriptConfigDemo() {
		
		 pw = Playwright.create();
		 browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
	     BrowserContext context = browser.newContext(new Browser.NewContextOptions());
	     
	     
	     Page page = context.newPage();
	     page.navigate(home);
	     
	     page.click("#clap-image");
	     Assertions.assertTrue(page.isVisible("#thank-you"));
	     Assertions.assertTrue(page.isVisible("#enable-js-msg"));
		
	}
	

}
