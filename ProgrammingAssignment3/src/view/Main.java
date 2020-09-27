package view;

import java.awt.EventQueue;

import controller.Controller;
import dal.DataAccessLayer;

public class Main {

	public static void main(String[] args) {
		DataAccessLayer dal = new DataAccessLayer(); 
		Menu menu = new Menu(); 
		Controller controller = new Controller(menu, dal);
		menu.setController(controller);
		menu.getFrmCronusSverigeab().setVisible(true);

	}

	
}
