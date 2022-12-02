package exceldata;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriteAL {

	public static void main(String[] args) throws IOException {

		XSSFWorkbook book = new XSSFWorkbook();
		XSSFSheet sheet = book.createSheet("Info Sheet");

		ArrayList<Object[]> al = new ArrayList<Object[]>();

		al.add(new Object[] { "S.No", "FN", "LN", "isTrue" });
		al.add(new Object[] { 1, "Ashok", "Peta", "true" });
		al.add(new Object[] { 2, "Bannu", "Peta", "false" });
		al.add(new Object[] { 3, "Vimala", "Peta", "true" });
		al.add(new Object[] { 4, "Ashok", "Chapala", "true" });

		int rows = 0;

		for (Object[] obj : al) {
			XSSFRow row = sheet.createRow(rows++);
			int cells = 0;

			for (Object val : obj) {
				XSSFCell cell = row.createCell(cells++);

				if (val instanceof String) {
					cell.setCellValue((String) val);
				}
				if (val instanceof Integer) {
					cell.setCellValue((Integer) val);
				}
				if (val instanceof Boolean) {
					cell.setCellValue((Boolean) val);
				}
			}
		}
		FileOutputStream out = new FileOutputStream(
				"C:\\Users\\ashok\\eclipse-workspace\\SeleniumPractice\\Data_AL.xlsx");
		book.write(out);
		out.close();
		book.close();
	}

}
