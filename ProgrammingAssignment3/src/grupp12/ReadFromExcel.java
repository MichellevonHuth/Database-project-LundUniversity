package grupp12;

import java.io.File;  
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.awt.Desktop;
import java.awt.desktop.*;


	public class ReadFromExcel 
	{  

		public static void getExcel(String excel) throws IOException {
			if(excel.equals("How much is 100 NOK?")) { 
				Desktop.getDesktop().open(new File("C:\\Users\\Administrator\\Documents\\IsProjekt\\HowMuchIs100NOK.xlsx"));
				
			}
			
			else if(excel.equals("What value is traded for the most amount of SEK?")) {
				Desktop.getDesktop().open(new File("C:\\Users\\Administrator\\Documents\\IsProjekt\\WhatValueIsTradedForTheMostAmountOfSEK.xlsx"));
			}
			
			else if(excel.equals("At which address and in what city is Fotograferna AB located?") ) {
				Desktop.getDesktop().open(new File("C:\\Users\\Administrator\\Documents\\IsProjekt\\AtWhichAddressAndInWhatCityIsFotografernaABLocated.xlsx"));
			} 
			
			else if(excel.equals("Names of all employees who have been ill/sick")) {
				Desktop.getDesktop().open(new File("C:\\Users\\Administrator\\Documents\\IsProjekt\\NamesOfAllEmployeesWhoHaveBeenIllSick.xlsx" ));
			}
			
			else if(excel.equals("Name and family relation for all employees' relatives")) {
				Desktop.getDesktop().open(new File("C:\\Users\\Administrator\\Documents\\IsProjekt\\NameAndFamilyRelationForAllEmployeesRelatives.xlsx"));
			}
			
			else if(excel.equals("What customers are handled by employee Andreas Berglund")) {
				Desktop.getDesktop().open(new File ("C:\\Users\\Administrator\\Documents\\IsProjekt\\WhatCustomersAreHandledByEmployeeAndreasBerglund.xlsx));"
						
			}
			
			else if(excel.equals("")))
			
			else {
				System.out.println("No excel file found!"); 
			}
			
		}
	}



	
	
	
	
	/*/try  
{  
File file = new File("C:\\Users\\Administrator\\Documents\\AllEmployees.xlsx");   //creating a new file instance  
FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file  
//creating Workbook instance that refers to .xlsx file  
XSSFWorkbook wb = new XSSFWorkbook(fis);   
XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
while (itr.hasNext())                 
{  
Row row = itr.next();  
Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
while (cellIterator.hasNext())   
{  
Cell cell = cellIterator.next();  
switch (cell.getCellType())               
{  
 case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
System.out.print(cell.getStringCellValue() + "\t\t\t");  
break;  
case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type  
System.out.print(cell.getNumericCellValue() + "\t\t\t");  
break;  
default:  
}  
}  
System.out.println("");  
}  
}  
catch(Exception e)  
{  
e.printStackTrace();  
}  
}  
}/*/
	
