package exceldata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		File file = new File("");

		FileInputStream input = new FileInputStream(file);

		XSSFWorkbook workBook = new XSSFWorkbook(input);

		XSSFSheet sheet = workBook.getSheet("EMIs");

		Iterator<?> it = sheet.rowIterator();
		while (it.hasNext()) {
			XSSFRow r = (XSSFRow) it.next();

			Iterator<?> cellIt = r.cellIterator();

			while (cellIt.hasNext()) {
				XSSFCell c = (XSSFCell) cellIt.next();
				switch (c.getCellType()) {
				case STRING:
					System.out.print(c.getStringCellValue());
				case NUMERIC:
					System.out.print(c.getNumericCellValue());
				case BOOLEAN:
					System.out.print(c.getBooleanCellValue());
				default:
					break;
				}
				System.out.print("   ||   ");
			}
			System.out.println();
		}

	}

}
