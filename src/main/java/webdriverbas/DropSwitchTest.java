package webdriverbas;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropSwitchTest {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://register.rediff.com/register/register.php?FormName=user_details");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		By day = By.xpath("//*[@id='tblcrtac']/tbody/tr[22]/td[3]/select[1]");

		By month = By.cssSelector("#tblcrtac > tbody > tr:nth-child(23) > td:nth-child(3) > select:nth-child(2)");

		By year = By.xpath("//*[@id='tblcrtac']/tbody/tr[22]/td[3]/select[3]");

		DropDownUtil dd = new DropDownUtil(driver);

		dd.switchForSelect(day, DropTypes.index, "08");
		dd.switchForSelect(month, DropTypes.visibletext, "JUN");
		dd.switchForSelect(year, DropTypes.value, "1994");

		driver.quit();

	}

}
