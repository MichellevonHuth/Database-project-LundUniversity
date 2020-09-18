package View;

import View.ApplicationWindow;
import DAL.DataAccessLayer;
import Controller.Controller;

public class Application {

	public static void main(String[] args) {
		DataAccessLayer dal = new DataAccessLayer();
		ApplicationWindow applicationWindow = new ApplicationWindow();
		Controller controller = new Controller (dal, applicationWindow);
		applicationWindow.setController(controller);		
		applicationWindow.getFrame().setVisible(true);	
		
	}
}

