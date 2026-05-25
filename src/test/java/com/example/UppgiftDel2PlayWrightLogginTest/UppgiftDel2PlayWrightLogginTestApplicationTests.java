package com.example.UppgiftDel2PlayWrightLogginTest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class UppgiftDel2PlayWrightLogginTestApplicationTests {

	@Test
	void testLoginPage() {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch();
			Page page = browser.newPage();

			page.navigate("https://www.saucedemo.com/");

			page.fill("#user-name", "standard_user");
			page.fill("#password", "secret_sauce");

			page.click("#login-button");

			page.waitForLoadState(LoadState.NETWORKIDLE);

			assertTrue(page.url().contains("inventory.html"),
					"Should be in the page after the login");

			assertEquals("Swag Labs", page.title());
		}
	}
}
