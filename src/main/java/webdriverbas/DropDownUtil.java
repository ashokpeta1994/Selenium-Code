package webdriverbas;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownUtil {

	WebDriver driver;

	/**
	 * This method is the default constructor of this class
	 *
	 * @param driver
	 */
	public DropDownUtil(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This method is used to get an element using the locator
	 */
	public WebElement getElement(By locator) {
		WebElement element = driver.findElement(locator);
		return element;
	}

	/**
	 * This method is used to select a value from drop down using index,value and
	 * visible text
	 *
	 * @param locator
	 * @param type
	 * @param value
	 * @param type
	 */
	public void switchForSelect(By locator, DropTypes type,String value) {
		Select s = new Select(getElement(locator));
		switch (type) {
		case index:
			s.selectByIndex(Integer.parseInt(value));
			break;
		case value:
			s.selectByValue(value);
			break;
		case visibletext:
			s.selectByVisibleText(value);
			break;

		default:
			System.out.println("Please pass the correct argument");
			break;
		}

	}

	/**
	 * This method is used to enter the desired value
	 *
	 * @param e
	 * @param value
	 */
	public static void selectByVisibleText(WebElement e, String value) {
		Select s = new Select(e);
		s.selectByVisibleText(value);

	}

	/**
	 * This method is used to select the desired value by index
	 *
	 * @param e
	 * @param index
	 */
	public static void selectByIndex(WebElement e, int index) {
		Select s = new Select(e);
		s.selectByIndex(index);
	}

	/**
	 * This method is used to select the value
	 *
	 * @param e
	 * @param value
	 */
	public static void selectByValue(WebElement e, String value) {
		Select s = new Select(e);
		s.selectByValue(value);
	}

	/**
	 * This method is used to get all the options available in the drop down
	 *
	 * @param e
	 * @return
	 */
	public static ArrayList<String> getAllOptions(WebElement e) {
		System.out.println("=====================================");
		Select s = new Select(e);
		List<WebElement> l = s.getOptions();
		System.out.println("The total number of values in dropdown is " + l.size());
		ArrayList<String> al = new ArrayList<String>();
		for (WebElement element : l) {
			String str = element.getText();
			al.add(str);
		}
		return al;

	}

}
