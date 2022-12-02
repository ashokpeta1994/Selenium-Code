package webdriverbas;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextFiller {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://register.rediff.com/register/register.php?FormName=user_details");
		Thread.sleep(3000);
		List<WebElement> list = driver.findElements(By.xpath("//*[@type='text']"));
		driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[3]/td[3]/input")).sendKeys("Ashok");
		String s=driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[3]/td[3]/input")).getAttribute("value");
		System.out.println(s);
		System.out.println(list.size());
//		for (int i = 0; i < list.size(); i++) {
//			list.get(i).sendKeys("Ashok");
//		}

	}

}
