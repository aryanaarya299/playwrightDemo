package playwright.test.com;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import playwrigh.baseclass.ScriptBase;

public class ChannelDemo extends ScriptBase {
	
	Playwright pw;
	Browser browser;
	
	@ParameterizedTest
	@ValueSource(strings =  { 
			
			"chrome",
			"msedge"
			
	})

	public void channelDemo(String channel) {
		
		pw = Playwright.create();
		browser = pw.chromium().launch( new BrowserType.LaunchOptions()
				
				  .setChannel(channel)
				  .setHeadless(false)
				  .setSlowMo(2000)
				
				);
		
		Page page = browser.newContext().newPage();
		page.navigate(home);
	}
}
