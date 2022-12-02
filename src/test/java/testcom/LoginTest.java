package testcom;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver;

	By userName = By.name("username");
	By password = By.name("password");
	String login = "//button[@type='submit']";
	String forgotPwd = "p.oxd-text.orangehrm-login-forgot-header";

	WebDriverWait wait;

	@BeforeTest
	@Parameters({ "url" })
	public void setUp(String url) {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.manage().deleteAllCookies();
	}

	@Test(priority = 1)
	public void titleTest() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("Orange"));
		String title = driver.getTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}

	@Test(priority = 2)
	public void loginPageHeaderTest() {
		WebElement ele = driver.findElement(By.cssSelector(forgotPwd));
		String str = ele.getText();
		Assert.assertEquals(str, "Forgot your password?");

	}

	@Test(priority = 3)
	@Parameters({ "un", "pwd" })
	public void loginTest(String uname, String pass) {
		driver.findElement(userName).sendKeys(uname);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(By.xpath(login)).click();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
