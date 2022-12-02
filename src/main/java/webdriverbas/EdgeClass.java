package webdriverbas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeClass {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		WebDriver driver2 = new EdgeDriver();
		driver2.get("https://the-internet.herokuapp.com/upload");
		Thread.sleep(4000);
		driver2.findElement(By.id("file-upload")).sendKeys("C://Ashok Docs//Bannu Docs//Surya SAQA.pdf");
		Thread.sleep(3000);
		driver2.quit();

	}

}
