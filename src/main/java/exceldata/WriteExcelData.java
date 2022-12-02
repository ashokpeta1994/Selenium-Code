package exceldata;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelData {

	public static void main(String[] args) throws IOException {

		XSSFWorkbook book = new XSSFWorkbook();
		XSSFSheet sheet = book.createSheet("Data");

		Object info[][] = { { "Ashok", "ashokpeta8@gmail.com_ashok@123" }, { "Bannu", "suryapeta@gmail.com_surya@130" },
				{ "Vimala", "vimalapeta@gmail.com_8978259309" }, { "Nithya", "nithya7@gmail.com_nithya123" } };

		int rowNum = info.length;
		int cellNum = info[0].length;

		for (int i = 0; i < rowNum; i++) {
			XSSFRow row = sheet.createRow(i);

			for (int j = 0; j < cellNum; j++) {
				XSSFCell cell = row.createCell(j);
				Object data = info[i][j];

				if (data instanceof String) {
					cell.setCellValue((String) data);
				}
				if (data instanceof Integer) {
					cell.setCellValue((Integer) data);
				}
				if (data instanceof Boolean) {
					cell.setCellValue((Boolean) data);
				}

			}
		}
		FileOutputStream output = new FileOutputStream(
				"C:\\Users\\ashok\\eclipse-workspace\\SeleniumPractice\\Credentials.xlsx");
		book.write(output);
		output.close();
		book.close();
		System.out.println("Data written successfully");
	}

}
