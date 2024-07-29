package playwright.test.com;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LocalConfigDemo {
	
	
	Playwright pw = Playwright.create();
	Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
	
	
	@Test
	public void localConfigDemo() {
		
		
		BrowserContext context = browser.newContext( new Browser.NewContextOptions()
				
				.setLocale("de-DE")
				);
		
		
		Page page = context.newPage();
		page.navigate("https://www.google.com/");
		
		page.click("text=Ich stimme zu");
				
	}
	
	@ParameterizedTest
	@CsvSource({"de-DE, Ich stimme zu",
		       "es-ES, Accepto"
	
	
	})
	public void localeConfigDemoParametrized(String locale, String buttonText) {
		
		
		BrowserContext context = browser.newContext( new Browser.NewContextOptions()
				
				.setLocale(locale)
				);
		
		
		      Page page = context.newPage();
			  page.navigate("https://www.google.com/");
			  
			  page.click("text=" +buttonText);
	}
	
	
	
	@AfterEach
	public void cleanup() {
		
		pw.close();
	}

}
