package DAL;

import java.sql.*;

public class ErrorHandler {
	
	public String handleException(Exception ex) {
		String errorMessage;
		//ex.printStackTrace();
		
		if (ex instanceof NullPointerException) {
			errorMessage = "This object doesn't exist";
		}

		else if (ex instanceof IndexOutOfBoundsException) {
			errorMessage = "Coudn't find what you are looking for";
		}
		else if (ex instanceof NumberFormatException) {
			errorMessage = "Wrong format on input value";
		}

		else if (ex instanceof SQLException) {
			int errorCode = ((SQLException) ex).getErrorCode();
			switch (errorCode) {

			case 2627:
				errorMessage = "The object you are trying to add already exists";
				break;

			case 17:
				errorMessage = "Problem with the connection to the database";
				break;

			case 0:
				errorMessage = "Anslutningen misslyckades, tidsgräns uppnåd";
				break;
			default:
				errorMessage = "An unexpected error has occured";
				break;
			}
		} else {
			errorMessage = "An unexpected error has occured";
		}
		
		return errorMessage; 
	}
	
	public String errorMessageEmptyFields() {
		String errorMessage = "Fill in all the fields";
		return errorMessage;
	}
	
	public String creditsError () {
		String errorMessage = "Student can't read more than 45 credits per semester";
		return errorMessage; 
	}
	
	public String wrongInputName () {
		String errorMessage = "Wrong format on input value";
		return errorMessage;
	}

}
