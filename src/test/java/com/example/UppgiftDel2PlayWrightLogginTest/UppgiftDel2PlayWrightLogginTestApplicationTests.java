package com.example.UppgiftDel2PlayWrightLogginTest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.microsoft.playwright.*;

@SpringBootTest
class UppgiftDel2PlayWrightLogginTestApplicationTests {

	@Test
	void testLoginPage() {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch();
			Page page = browser.newPage();
			page.navigate("https://www.saucedemo.com/");
			System.out.println(page.title());
		}
	}
}
