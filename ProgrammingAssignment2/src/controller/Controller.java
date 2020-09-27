package controller;

import view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import dal.*;

public class Controller {
	
	private ApplicationWindow aw; 
	private DataAccessLayer dal;
	
	public Controller() {
		declareEvents();	
	}

	public Controller(ApplicationWindow aw, DataAccessLayer dal) {
		this.aw = aw;
		this.dal = dal;
		declareEvents();
	}
	
	public void declareEvents() {
		
//		aw.getBtnAllKeys().addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				aw.getTextPaneOutput().setText(dal.showAllContent());
//			}
//		});
		
		aw.getBtnAllEmployeeFacts().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = "";
				aw.getTextPaneOutput().setText("");
				
				try {
					for (String s: dal.viewAllEmployeeInfo()) {
						temp += s;
						aw.getTextPaneOutput().setText(temp);
					}
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		aw.getBtnAllKeys().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = "";
				aw.getTextPaneOutput().setText("");
				
				try {
					for (String s: dal.viewAllKeys()) {
						temp += s;
						aw.getTextPaneOutput().setText(temp);
					}
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		aw.getBtnAllConstraints().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = "";
				aw.getTextPaneOutput().setText("");
				
				try {
					for (String s: dal.viewAllTableConstraints()) {
						temp += s;
						aw.getTextPaneOutput().setText(temp);
					}
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});

		
		aw.getBtnAllTables().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = "";
				aw.getTextPaneOutput().setText("");
				
				try {
					for (String s: dal.viewAllTables()) {
						temp += s;
						aw.getTextPaneOutput().setText(temp);
					}
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		
		aw.getBtnMetaForEmployee().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = "";
				aw.getTextPaneOutput().setText("");
				
				try {
					for (String s: dal.viewMetaForEmployee()) {
						temp += s;
						aw.getTextPaneOutput().setText(temp);
					}
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		aw.getBtnLargestTable().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = "";
				aw.getTextPaneOutput().setText("");
				
				try {
					for (String s: dal.viewLargestTable()) {
						temp += s;
						aw.getTextPaneOutput().setText(temp);
					}
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
    }

}
