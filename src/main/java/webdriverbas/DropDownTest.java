package webdriverbas;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://register.rediff.com/register/register.php?FormName=user_details");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		WebElement day = driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[22]/td[3]/select[1]"));

		WebElement month = driver.findElement(
				By.cssSelector("#tblcrtac > tbody > tr:nth-child(23) > td:nth-child(3) > select:nth-child(2)"));

		WebElement year = driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[22]/td[3]/select[3]"));

//		DropDownUtil.selectByVisibleText(day, "09");
//		DropDownUtil.selectByIndex(month, 5);
//		DropDownUtil.selectByValue(year, "1994");

		System.out.println("================================");

//		DropDownUtil.getAllOptions(year);
//		DropDownUtil.getAllOptions(month);
//		DropDownUtil.getAllOptions(day);

		String date = "08-JUN-1994";
		String sp[] = date.split("-");

		DropDownUtil.selectByVisibleText(day, sp[0]);
		DropDownUtil.selectByVisibleText(month, sp[1]);
		DropDownUtil.selectByVisibleText(year, sp[2]);

		Thread.sleep(3000);

		ArrayList<String> dayList = DropDownUtil.getAllOptions(day);
		System.out.println(dayList);

		ArrayList<String> monthList = DropDownUtil.getAllOptions(month);
		System.out.println(monthList);

		ArrayList<String> yearList = DropDownUtil.getAllOptions(year);
		System.out.println(yearList);

		driver.quit();

	}

}
