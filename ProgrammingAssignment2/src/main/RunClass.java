package main;

import view.*;

import dal.*;
import controller.*;

public class RunClass {

	public static void main(String[] args) throws Exception {
		ApplicationWindow aw = new ApplicationWindow();
		DataAccessLayer dal = new DataAccessLayer();
		Controller controller = new Controller (aw, dal);
		aw.run();
	}

}
