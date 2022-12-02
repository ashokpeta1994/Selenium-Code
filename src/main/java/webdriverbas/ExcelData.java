package webdriverbas;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData {

	public static final String path = "./src/test/resources/defaultpack/TestData.xlsx";
	public static Workbook book;
	public static Sheet sheet;

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		Object data[][] = null;

		FileInputStream ip = new FileInputStream(path);
		book = WorkbookFactory.create(ip);
		sheet = book.getSheet("Register");

		data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
				System.out.println(data[i][j]);
			}
		}

		System.out.println();
	}

}
