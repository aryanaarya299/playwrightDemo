package playwright.test.com;

import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Request;
import com.microsoft.playwright.Response;

import playwrigh.baseclass.ScriptBase;

public class RequestResponseOverview extends ScriptBase {
	
	
	@Test
	public void responseApiDemo() {
		
		
		Response response = page.navigate(home);
		System.out.println(response.status()); //0
		
		
		Response navigate = page.navigate("https://playwright.dev/");
		System.out.println(navigate.url());
		System.out.println(navigate.status());
		System.out.println(navigate.ok()); //true if in the 200-299 rage
		System.out.println(navigate.headers());
		
		System.out.println(new String(navigate.body(), StandardCharsets.UTF_8));
		System.out.println("PW convenience method");
		System.out.println(navigate.text());
		
	}
	
	
	@Test
	public void requestApiDemo() {
		
		     Response response = page.navigate("https://playwright.dev/");
		     Request request = response.request();
		     
		     System.out.println(request.headers());
		     System.out.println(request.postData());
		     System.out.println(request.method());
	}
	   

}
