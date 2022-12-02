package exceldata;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadFor {

	public static void main(String[] args) throws IOException {

		FileInputStream file = new FileInputStream(
				"C:\\Users\\ashok\\eclipse-workspace\\SeleniumPractice\\Credentials.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(file);
		XSSFSheet sheet = book.getSheet("Data");

		int rows = sheet.getLastRowNum();
		int cells = sheet.getRow(0).getLastCellNum();

		for (int i = 0; i <= rows; i++) {
			XSSFRow row = sheet.getRow(i);

			for (int j = 0; j < cells; j++) {
				XSSFCell cell = row.getCell(j);
				switch (cell.getCellType()) {
				case STRING:
					System.out.print(cell.getStringCellValue());
					break;
				case NUMERIC:
					System.out.print(cell.getNumericCellValue());
					break;
				case BOOLEAN:
					System.out.print(cell.getBooleanCellValue());
					break;
				case FORMULA:
					System.out.print(cell.getNumericCellValue());
					break;
				default:
					break;
				}
				System.out.print("   ||   ");
			}
			System.out.println();
		}
		book.close();

	}

}
