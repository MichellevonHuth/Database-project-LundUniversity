package DAL;

import java.sql.*;

public class ErrorHandler {
	
	public String handleException(Exception ex) {
		String errorMessage;
		
		if (ex instanceof NullPointerException) {
			errorMessage = "En instans du försöker komma åt, existerar inte";
		}

		else if (ex instanceof IndexOutOfBoundsException) {
			errorMessage = "Kunde inte hitta det du letar efter";
		}

		else if (ex instanceof NumberFormatException) {
			errorMessage = "Fel format på inmatat värde";
		}
		

		else if (ex instanceof SQLException) {
			int errorCode = ((SQLException) ex).getErrorCode();
			switch (errorCode) {

			case 2627:
				errorMessage = "Objektet du försöker lägga till existerar redan";
				break;

			case 17:
				errorMessage = "Databasen kan ej nås";
				break;

			case 0:
				errorMessage = "Anslutningen misslyckades, tidsgräns uppnåd";
				break;
			default:
				errorMessage = "Ett oväntat fel uppstod";
				break;
			}
		} else {
			errorMessage = "Ett oväntat fel uppstod";
		}
		
		return errorMessage; 
	}
}
