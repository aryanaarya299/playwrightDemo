package playwright.test.com;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Response;

import playwrigh.baseclass.ScriptBase;


public class MonitorHttpTrafficDemo extends ScriptBase {
	
	
	@Test
	
	public void monitorHttpTrafficDemo() {
		
	// page.onRequest(request -> System.out.println(">> " + request.method() + " " + request.url()));
	// page.onResponse(response -> System.out.println("<< " + response.status()));
	 
	    List<Integer> responses = new ArrayList<Integer>();
		page.onResponse(response -> responses.add(response.status()) );
	 
	 page.navigate("https://playwright.dev/");
	 System.out.println(responses);
	 
	 boolean foundMatch = responses.stream()
	 .anyMatch(i -> i < 200 || i >= 300);
	 
	 Assertions.assertFalse(foundMatch);
		
	}

}
 