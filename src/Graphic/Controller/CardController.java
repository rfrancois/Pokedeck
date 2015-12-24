package Graphic.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JTextField;

import Graphic.View.Card.AllCards;
import Graphic.View.Card.FoundCards;
import Graphic.View.Card.SaveCard;
import Graphic.View.Card.SearchCard;
import Graphic.View.Energy.AddEnergy;
import Graphic.View.Home.Home;
import Graphic.View.Pokemon.AddPokemon;
import Graphic.View.Pokemon.UpdatePokemon;
import Graphic.View.Trainer.AddTrainer;
import Model.Card;
import Model.Pokemon;

public class CardController extends SuperController implements ActionListener {

	SaveCard v;
	ArrayList<Card> cards;

	public CardController(SaveCard v) {
		this.v = v;
		cards = Card.getCards();
	}
	
	public CardController(SaveCard v, ArrayList<Card> cards) {
		this.v = v;
		this.cards = cards;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if(returnToList(evt, v)) return ;
		switch(evt.getActionCommand()) {
			case "leave":
				v.leave();
				new Home();
				break;
			/*case "returnSearch":
				v.leave();
				new SearchCard();
				return ;*/
			case "addPokemon":
				v.leave();
				new AddPokemon();
				return ;
			case "addTrainer":
				v.leave();
				new AddTrainer();
				return ;
			case "addEnergy":
				v.leave();
				new AddEnergy();
				return ;
			case "selectCard":
				int index = v.getSelectedCardIndex();
				if(index < 0) return ;
				v.setVisible(false);
				v.update(cards.get(index));
				break;
			case "searchCard":
				String search = v.getTextSearch().getText();
				if(search == null) return ;
				v.leave();
				new FoundCards(Card.search(search));
				break;
			default:
				System.out.println("Une erreur est survenue.");
				return ;
		}
	}
	
	public SaveCard getV() {
		return v;
	}
	
	public ArrayList<Card> getCards() {
		return cards;
	}
}
