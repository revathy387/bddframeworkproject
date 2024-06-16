package utilities;

import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	
	public static Object[][] readFromFile(String filepath, String filename) throws IOException {
		
		XSSFWorkbook workbook = null;
		XSSFSheet sheet;
		Object[][] testdata;
		try {workbook = new XSSFWorkbook(filepath);} catch (IOException e) {}
		sheet = workbook.getSheet(filename);
		int rowcount = sheet.getLastRowNum();
		XSSFRow row = sheet.getRow(0);
		int columncount = row.getLastCellNum();
		
		testdata = new Object[rowcount][columncount];
		
		for(int i=1;i<=rowcount;i++) {
			row = sheet.getRow(i);
			for(int j=0;j<columncount;j++) {
				XSSFCell column = row.getCell(j);
				if(column.getCellType()==CellType.NUMERIC) {
					long value = (long) row.getCell(j).getNumericCellValue();
					testdata[i-1][j] = value;
				}else if(column.getCellType()==CellType.STRING){
					String value = row.getCell(j).getStringCellValue();
					testdata[i-1][j] = value;
				}
				
			}
		}
		
		for(int i=0; i<testdata.length; i++ ) {
			
			for(int j=0; j<testdata[i].length;j++) {
				
				testdata[i][j]=testdata[i][j];
				//System.out.println(testdata[i][j]);
			}
		}
		workbook.close();
	return testdata;
	}
	
	public static void main(String args[]) throws IOException {
		
		ExcelUtility.readFromFile("testdata/Assignment10.xlsx", "Register");
	}

}
