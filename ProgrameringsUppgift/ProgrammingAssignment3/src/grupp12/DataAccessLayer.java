package grupp12;

import java.io.File;  
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.awt.Desktop;
import java.awt.desktop.*;


	public class DataAccessLayer 
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
				Desktop.getDesktop().open(new File ("C:\\Users\\Administrator\\Documents\\IsProjekt\\WhatCustomersAreHandledByEmployeeAndreasBerglund.xlsx"));
						
			}
			
			else if(excel.equals("What bank accounts belong to the customer with customer number 10 000?"))	{
				Desktop.getDesktop().open(new File("C:\\Users\\Administrator\\Documents\\IsProjekt\\WhatBankAccountsBelongToTheCustomerWithCustomerNumber10000.xlsx"));
			}
			
			else if(excel.equals("All employees")) {
				Desktop.getDesktop().open(new File("C:\\Users\\Administrator\\Documents\\IsProjekt\\AllEmployees.xlsx"));
			}
			
			else if(excel.equals("All customers")) {
				Desktop.getDesktop().open(new File("C:\\Users\\Administrator\\Documents\\IsProjekt\\AllEmployees.xlsx"));
			}
			
			else if(excel.equals("\"C:\\\\Users\\\\Administrator\\\\Documents\\\\IsProjekt\\AllCustomers.xlsx"));
			
			
			else {
				System.out.println("No excel file found!"); 
			}
		
		}
		public static void getAccess(String access) throws IOException {
			if(access.equals("How much is 100 NOK?")) { 
				Desktop.getDesktop().open(new File("C:\\Users\\Administrator\\Documents\\IsProjekt\\accessHowMuchIs100NOK.xlsx"));
			}
			else if(access.equals("What value is traded for the most amount of SEK?")) {
				Desktop.getDesktop().open(new File("C:\\Users\\Administrator\\Documents\\IsProjekt\\accessWhatValueIsTradedForTheMostAmountOfSEK.xlsx"));
			}
			else if(access.equals("At which address and in what city is Fotograferna AB located?") ) {
				Desktop.getDesktop().open(new File("C:\\Users\\Administrator\\Documents\\IsProjekt\\accessAtWhichAddressAndInWhatCityIsFotografernaABLocated.xlsx"));
			} 
			else if(access.equals("Names of all employees who have been ill/sick")) {
				Desktop.getDesktop().open(new File("C:\\Users\\Administrator\\Documents\\IsProjekt\\accessNamesOfAllEmployeesWhoHaveBeenIllSick.xlsx" ));
			}
			else if(access.equals("Name and family relation for all employees' relatives")) {
				Desktop.getDesktop().open(new File("C:\\Users\\Administrator\\Documents\\IsProjekt\\accessNameAndFamilyRelationForAllEmployeesRelatives.xlsx"));
			}
			else if(access.equals("What customers are handled by employee Andreas Berglund")) {
				Desktop.getDesktop().open(new File("C:\\Users\\Administrator\\Documents\\IsProjekt\\accessWhatCustomersAreHandledByEmployeeAndreasBerglund.xlsx"));
			}
			else if(access.equals("")) {
				
			}
			else {
				System.out.println("No excel file found!"); 
			}
		}
	}


	
