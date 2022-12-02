package testcom;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PracticeTest {

	WebDriver driver;
	WebDriverWait wait;
	By footer = By.xpath("//*[@id='navFooter']/div[6]/ul/li[1]/a");
	WebElement ele;
	SoftAssert soft = new SoftAssert();
	

	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://amazon.in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Test
	public void titleTest() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String title = driver.getTitle();
		System.out.println(title);
		soft.assertTrue(title.contains("Online"));
	}

	@Test
	public void footerTest() {
		ele = driver.findElement(footer);
		String str = ele.getText();
		System.out.println(str);
		soft.assertEquals(str, "Conditions of Use & Sale");

	}

	@Test
	public void getScreenShot() {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./target/file1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
