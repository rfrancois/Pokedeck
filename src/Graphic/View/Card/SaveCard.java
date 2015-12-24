package Graphic.View.Card;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import Graphic.Controller.CardController;
import Graphic.Controller.HomeController;
import Graphic.View.Pokemon.UpdatePokemon;
import Model.Card;
import Model.Pokemon;

public class SaveCard extends JFrame {
	
	protected CardController controller;
	protected int textFieldSize = 15;
	
	/**
	 * Use this method when don't know if update is from Pokemon or Trainer or Energy type 
	 * @param card A card
	 */
	public void update(Card card) {
		switch(card.getClass().getName()) {
			case "Model.Pokemon":
				new UpdatePokemon((Pokemon) card);
				break;
			case "Model.Trainer":
				System.out.println("SaveCard");
				break;
			case "Model.Energy":
				System.out.println("SaveCard");
				break;
			default:
				System.out.println("Une erreur est survenue dans Graphic.View.Card.SaveCard");
				break;
		}
	}
	
	/**
	 * Leave the program
	 */
	public void leave() {
		setVisible(false);
		dispose();
	}
	
	public void constructGUI() {
		setSize(750,550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Center at the middle of the screen
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	/**
	 * Returns id of selected card
	 * @return -1 : an error
	 */
	public int getSelectedCardIndex() {
		return -1;
	}
	
	public JTextField getTextSearch() {
		return null;
	}

}
