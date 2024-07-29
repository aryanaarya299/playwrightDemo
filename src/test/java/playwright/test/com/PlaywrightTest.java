package playwright.test.com;

import java.security.PublicKey;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightTest {
	
	
	@Test
	public void firstTest() {
		
		
	try( Playwright playwright = Playwright.create()) {
		
	 BrowserType browserType = playwright.chromium();
	             
	 Browser browser =  browserType.launch();
	   
	   
	 Page page =   browser.newPage();
	 
	 page.navigate("https://playwright.dev/java/docs/next/intro");
	 
	 System.out.println(page.title());	
		
	}
	 
		
	}
	
	
	@Test
	  public void firstTestRefactored() {
		 
		try( Playwright playwright = Playwright.create()) {
			
		Page pages=	playwright.chromium().launch().newPage();
		
		 pages.navigate("https://playwright.dev/java/docs/next/intro");
		 
		 System.out.println(pages.title());

			
		}
		
	 }
	 

}
