package playwright.test.com;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import playwrigh.baseclass.ScriptBase;

public class FirstPwWithContext extends ScriptBase {

	@Test
	public void firstPlayWrightTestWithContext() {

		page.navigate("https://magento.softwaretestingboard.com/");
		Assertions.assertEquals(page.title(), "Home Page");

	}

	@Test
	public void secondPlayWrightTestWithContext() {

		page.navigate("https://magento.softwaretestingboard.com/");

		String content = page.content();
		Assertions.assertTrue(content.contains("Get fit and look fab in new seasonal styles"));

	}

}
