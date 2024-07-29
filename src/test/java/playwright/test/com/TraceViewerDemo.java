package playwright.test.com;

import java.nio.file.Paths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

import playwrigh.baseclass.ScriptBase;

public class TraceViewerDemo extends ScriptBase {
	
	Playwright pw;
	Browser browser;
	
	@Test
	public void traceViewerDemo() {
		
		pw = Playwright.create();
		
		browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(3000));
		
		BrowserContext context = browser.newContext();
		context.tracing().start(new Tracing.StartOptions()
				
				.setScreenshots(true)
				.setSnapshots(true)
				
				);
		
		
		  Page page = context.newPage();
		  page.setDefaultNavigationTimeout(2000);
		  page.navigate("https://playwright.dev/java/");
		  page.click("text=Get started");
		  page.click("text=Guides");
		  page.click("text=Trace viewer");
		  Assertions.assertTrue(page.isVisible("text=Recording a trace"));
		  
		  context.tracing().stop(new Tracing.StopOptions()
				    
				  
				  .setPath(Paths.get("trace.zip")));
		
	}

}
