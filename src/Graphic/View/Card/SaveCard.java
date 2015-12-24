package Graphic.View.Card;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Graphic.Controller.CardController;
import Graphic.View.Energy.UpdateEnergy;
import Graphic.View.Pokemon.UpdatePokemon;
import Graphic.View.Trainer.UpdateTrainer;
import Model.Card;
import Model.Energy;
import Model.Pokemon;
import Model.Trainer;

public class SaveCard extends JFrame {
	
	protected CardController controller;
	protected int textFieldSize = 25;
	protected SaveCard prevView;
	
	/**
	 * Use this method when don't know if update is from Pokemon or Trainer or Energy type 
	 * @param card A card
	 */
	public void update(Card card) {
		if(card instanceof Pokemon) {
			new UpdatePokemon((Pokemon) card, this);
		}
		else if(card instanceof Trainer) {
			new UpdateTrainer((Trainer) card, this);
		}
		else if(card instanceof Energy) {
			new UpdateEnergy((Energy) card, this);
		}
	}
	
	/**
	 * Delete a card from the deck
	 * @param card Card to delete
	 */
	public void delete(Card card) {
		Card.getCards().remove(card);
	}
	
	/**
	 * Leave the program
	 */
	public void leave() {
		setVisible(false);
		dispose();
	}
	
	/**
	 * Construct fields, buttons which have to be shown to the user
	 */
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
	
	/**
	 * Return nothing to warn of an error
	 * @return An error
	 */
	public JTextField getTextSearch() {
		return null;
	}
	
	/**
	 * View before current view
	 * @return The previous view
	 */
	public SaveCard getPrevView() {
		return prevView;
	}
	
	/**
	 * Get list of cards used by controller
	 * @return List of cards
	 */
	public ArrayList<Card> getData() {
		return controller.getCards();
	}
}
