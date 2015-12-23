package Graphic.View.Card;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Graphic.Controller.CardController;
import Graphic.Controller.HomeController;

public class SaveCard extends JFrame {
	
	protected CardController controller;
	protected int textFieldSize = 15;
	
	/**
	 * Leave the program
	 */
	public void leave() {
		setVisible(false);
		dispose();
	}
	
	public void constructGUI() {
		setSize(650,450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Center at the middle of the screen
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
