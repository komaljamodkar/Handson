package Utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] readExcel(String fileName, String sheetName) throws IOException{
		FileInputStream fis = new FileInputStream(fileName); // Read data file
		XSSFWorkbook wb = new XSSFWorkbook(fis); // Create workbook corresponding to the input file
		XSSFSheet sheet = wb.getSheet(sheetName); // Get the sheet from the workbook
		Row row0 = sheet.getRow(0); 
		
		int rowNum = sheet.getPhysicalNumberOfRows(); //Count number of rows
		int colNum = row0.getLastCellNum();
		
		String[][] data = new String[rowNum - 1][colNum]; //2X3 matrix or 2D array of Strings
		//data will have 2 rows
		//each row will have 3 columns
		//each column will have a string
		
		//System.out.println("num rows :: " + rowNum);
		
		for(int i = 0; i < rowNum - 1; i++) {
			Row row = sheet.getRow(i+1);
			for(int j = 0; j < colNum; j++) {
				if(row == null)
					data[i][j] = "";
				else {
					Cell cell = row.getCell(j);
					if(cell == null)
						data[i][j] = "";
					else {
						  if(j<colNum-1)
						   data[i][j] = cell.getStringCellValue();
						  else 
							  
							  data[i][j] = Long.toString((long)cell.getNumericCellValue());
						  //cell1.setCellType(Cell.CELL_TYPE_STRING);
					}
				}
			}
		}
		wb.close();
		return data;
	}
}


/*for(int i=0;i<rowcount+1;i++)
{
    Row row= sh.getRow(i);

    // create a loop to print cell values

    for(int j=0;j<row.getLastCellNum();j++)
    {
        Cell cell= row.getCell(j);
        switch (cell.getCellType()) {
        case Cell.CELL_TYPE_STRING:
                System.out.print(row.getCell(j).getStringCellValue() + " ");
                break;

        case Cell.CELL_TYPE_NUMERIC:
                System.out.print(row.getCell(j).getNumericCellValue() + " ");
                break;
        }
        System.out.print(row.getCell(j).getStringCellValue()+"||");

    }


System.out.println();
}*/

