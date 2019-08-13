package UTILITIES;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	public  String[][] readExcel(){
		
	String [][] str= new String[2][3];
	
	try {
		File f=new File("C:\\Users\\akash.tripathi1\\Desktop\\Extra\\Authent.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh=wb.getSheet("Sheet1");
		for(int i=0;i<2;i++) {
			XSSFRow r=sh.getRow(i+1);
			
			XSSFCell c=r.getCell(0);
			
			str[i][0]=c.getStringCellValue();
			str[i][1]=r.getCell(1).getStringCellValue();
			str[i][2]=r.getCell(2).getStringCellValue();
		}
		
	}
	catch(FileNotFoundException e) {
		e.printStackTrace();
	}
	catch(IOException e) {
		e.printStackTrace();
	}
	return str;

}
}
