package exceldata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataRead {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws IOException {

		File f = new File("C:\\Users\\ashok\\eclipse-workspace\\SeleniumPractice\\Practice.xlsx");
		FileInputStream input = new FileInputStream(f);
		@SuppressWarnings("resource")
		XSSFWorkbook book = new XSSFWorkbook(input);
		XSSFSheet sheet = book.getSheet("Sheet1");

		Iterator it = sheet.rowIterator();

		while (it.hasNext()) {
			XSSFRow row = (XSSFRow) it.next();
			Iterator it1 = row.cellIterator();
			while (it1.hasNext()) {
				XSSFCell cell = (XSSFCell) it1.next();
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
				default:
					break;

				}
				System.out.print("   ||   ");
			}
			System.out.println();
		}

	}

}
