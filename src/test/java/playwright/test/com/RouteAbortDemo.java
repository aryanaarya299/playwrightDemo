package playwright.test.com;

import java.nio.file.Paths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class RouteAbortDemo {
	
	
	Playwright pw;
	Browser browser;
	
	@Test
	public void imageBlockDemo() {
		
		pw = Playwright.create();
		browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		
		page.route("**/*.{png,jpg,svg}", route ->route.abort());
		
		page.navigate("https://playwright.dev/");
		Assertions.assertTrue(page.isVisible("text=Playwright logo"));
		
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("blockedImage.png")));
	}

}
