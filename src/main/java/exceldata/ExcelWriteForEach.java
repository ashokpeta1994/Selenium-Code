package exceldata;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriteForEach {

	public static void main(String[] args) throws IOException {

		XSSFWorkbook book = new XSSFWorkbook();
		XSSFSheet sheet = book.createSheet("My Data");

		Object info[][] = { { "S.No", "First Name", "Last Name", "Mobile Number" },
				{ 1, "Ashok", "Peta", "9550670881" }, { 2, "Ashok", "Chapala", "7702482119" },
				{ 3, "Nithya", "Guntupalli", "9959889225" }, { 4, "Devi", "Thammisetti", "8897316852" },
				{ 5, "Manga Raju", "Peravali", "9951578106" } };

		int rowNum = 0;

		for (Object data[] : info) {
			XSSFRow row = sheet.createRow(rowNum++);
			int cellNum = 0;

			for (Object value : data) {
				XSSFCell cell = row.createCell(cellNum++);

				if (value instanceof String) {
					cell.setCellValue((String) value);
				}
				if (value instanceof Integer) {
					cell.setCellValue((Integer) value);
				}
				if (value instanceof Boolean) {
					cell.setCellValue((Boolean) value);
				}

			}
		}
		FileOutputStream output = new FileOutputStream(
				"C:\\Users\\ashok\\eclipse-workspace\\SeleniumPractice\\Data_For_Each.xlsx");
		book.write(output);
		output.close();
		book.close();
	}
}
