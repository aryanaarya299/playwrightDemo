package playwright.test.com;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TextSelector {
	
	
	
	@Test
	public void textSelectorsTest()  {
		
		try(Playwright playwright =Playwright.create()) {
			
			BrowserType browserType = playwright.chromium();
			       
		    Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
			
			
			Page page  = browser.newPage();
			page.navigate("https://magento.softwaretestingboard.com/");
			page.click("text=Shop New Yoga");
			Assertions.assertEquals(page.title(), "New Luma Yoga Collection");
			
		}
	}
	
	@ParameterizedTest
	@ValueSource(strings  = {
		"text =Shop New Yoga",
		"text= shop new yoga",
		"'Shop New Yoga'"})
	
	public void textSelectorTestParameters(String stringSelector) {
		
		try(Playwright playwright = Playwright.create()) {
			
			BrowserType browserType = playwright.chromium();
			Browser browser = browserType.launch( new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
			
			Page page = browser.newPage();
			page.navigate("https://magento.softwaretestingboard.com/");
			
			page.click(stringSelector);
			
			Assertions.assertEquals(page.title(), "New Luma Yoga Collection");
			
			
		}
		
	}
	
	
	
	

}
