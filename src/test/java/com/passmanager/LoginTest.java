package com.passmanager;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LoginTest {

	@LocalServerPort
	private int port;
	private LoginForm login;
	private WebDriver driver;

	@BeforeAll
	static void beforeAll() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeEach
	public void beforeEach() {
		this.driver = new ChromeDriver();
		login 		= new LoginForm(driver);
	}

	@AfterEach
	public void afterEach() {
		if (this.driver != null)
			driver.quit();
	}

	private boolean tryLogin(String username, String password) {
		driver.get("http://127.0.0.1:" + port + "/login");

		login.setUsername(username);
		login.setPassword(password);
		login.submit();

		return login.success();
	}

	@Test
	public void nonexistentUserLoginFailure() {
		Assertions.assertFalse(tryLogin("harry.potter", "gryffindor"));
	}

	@Test
	public void loginWithSuccess() {
		 Assertions.assertTrue(tryLogin("default", "abc123456"));
		 Assertions.assertEquals("http://127.0.0.1:" + port + "/home", driver.getCurrentUrl());
	}
}
