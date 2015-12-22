package Graphic.View.Card;

import javax.swing.JFrame;

import Graphic.Controller.CardController;
import Graphic.Controller.HomeController;

public class SaveCard extends JFrame {
	
	protected CardController controller;
	
	/**
	 * Add a new card
	 */
	public void add() {
		AskType askType = new AskType();
	}
	
	public void update() {
		System.out.println("SaveCard.update()");
	}
	
	/**
	 * Search a card in the deck
	 */
	public void search() {
		System.out.println("SaveCard.search()");
	}
	
	/**
	 * Leave the program
	 */
	public void leave() {
		setVisible(false);
		dispose();
	}
	
	public void init() {
		setSize(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Center at the middle of the screen
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
