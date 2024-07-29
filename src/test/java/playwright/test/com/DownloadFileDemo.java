package playwright.test.com;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Download;

import playwrigh.baseclass.ScriptBase;

public class DownloadFileDemo extends ScriptBase {
	
	
	@BeforeEach
	@Override
	protected void createContextAndPage() {
		
	 context = browser.newContext(new Browser.NewContextOptions().setAcceptDownloads(true));
	 
	 page =context.newPage();
	 page.setViewportSize(1920, 1080);
		
		
		
		
	}
	
	
	@Test
	public void downloadTestWithHandler() {
		
		page.navigate(home);
		
		page.onDownload(download -> {
			
			System.out.println(download.path());
			download.saveAs(Paths.get(new File("c:\\Users\\Anas\\").toURI()));
		});
		
		page.click("text=Download ZIP");
	}
	
	@Test
	public void downloadTestWithWaitForEvent() {
		
		page.navigate(home);
		
		 Download download =  page.waitForDownload(()  -> {
			
			page.click("text=Download ZIP");
		});
		 
		 Path path = download.path();
		 System.out.println(path);
	}
	

}
