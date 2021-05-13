package Utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelpath,String sheetName)
	{
		try {
			workbook = new XSSFWorkbook(excelpath);
			sheet = workbook.getSheet(sheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static int getRowcount() {
		int rowCount=0;
		
	try {
		
		rowCount=sheet.getPhysicalNumberOfRows();
		//System.out.println("row="+rowCount);
	} catch (Exception e) {
		System.out.println(e.getMessage());
		System.out.println(e.getCause());
		e.printStackTrace();
	}
	return rowCount;
}
	
	
	public static int getColcount() {
		int colCount=0;
		try {
			
			colCount=sheet.getRow(0).getPhysicalNumberOfCells();
			
			//System.out.println("col="+colCount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return colCount;
		}
	
	public static String getCellDataString(int rowNum,int colNum) {
		String cellData=null;
		try {
			DataFormatter formatter = new DataFormatter();
			cellData=formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
			
			//System.out.println("row="+cellData);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return cellData;
		}
public static void getCellDataNumber(int rowNum,int colNum) {
		
		try {
			
			
			double cellData=sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			//System.out.println("row="+cellData);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		
		}
	
	

}
