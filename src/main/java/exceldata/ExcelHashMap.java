package exceldata;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelHashMap {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://app.hubspot.com/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		login(driver, getData(), "Ashok");

		driver.quit();

	}

	public static Map<String, String> getData() throws IOException {

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\ashok\\eclipse-workspace\\SeleniumPractice\\Credentials.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheet("Data");

		int rows = sheet.getLastRowNum();

		Map<String, String> credData = new HashMap<String, String>();

		for (int i = 0; i <= rows; i++) {

			XSSFRow row = sheet.getRow(i);

			String key = row.getCell(0).getStringCellValue();

			int cells = row.getLastCellNum();

			for (int j = 1; j < cells; j++) {

				String value = row.getCell(j).getStringCellValue();

				credData.put(key, value);
			}

		}

		book.close();

		return credData;
	}

	public static void login(WebDriver driver, Map<String, String> credData, String userKey) {

		driver.findElement(By.id("username")).sendKeys(credData.get(userKey).split("_")[0]);
		driver.findElement(By.id("password")).sendKeys(credData.get(userKey).split("_")[1]);

	}

}
