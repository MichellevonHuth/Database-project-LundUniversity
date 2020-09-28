package view;

import java.awt.EventQueue;

import controller.Controller;
import dal.DataAccessLayer;

public class Main {

	public static void main(String[] args) {
		DataAccessLayer dal = new DataAccessLayer(); 
		Frame frame = new Frame(); 
		Controller controller = new Controller(frame, dal);
		frame.setController(controller);
		frame.getFrmCronusSverigeab().setVisible(true);
		frame.run();

	}
}
