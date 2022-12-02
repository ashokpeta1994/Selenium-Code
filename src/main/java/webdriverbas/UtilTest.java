package webdriverbas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UtilTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://app.hubspot.com");
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		GenericUtil gu = new GenericUtil(driver);
		ScreenShotUtil ss = new ScreenShotUtil(driver);

		By email = By.id("username");
		By pwd = By.id("password");
		By lb = By.id("loginBtn");

		gu.putWaitToElement(email, 7);

		String s = driver.getTitle();
		System.out.println(s);

		gu.putWaitToTitle("HubSpot", 6);

		gu.doSendKeys(email, "ashok.peta@fnb.co.za");
		gu.doSendKeys(pwd, "ashok@peta");
		gu.doClick(lb);

		By text = By.xpath("//*[@id='hs-login']/div[6]/div/h5");

		gu.putWaitToElement(text, 3);

		String str = gu.getText(text);
		ss.takePageScreenShot("HubSpot2");
		System.out.println(str);

		driver.quit();

	}

}
