package utils;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilsDemo {

	public static void main(String[] args) {
		String filePath=System.getProperty("user.dir");
		
		ExcelUtils excel=new ExcelUtils(filePath+"/testData/data1.xlsx","Sheet1");
		excel.getRowcount();
		//excel.getColcount();
		
		

	}

}
