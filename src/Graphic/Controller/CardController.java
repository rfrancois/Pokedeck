package Graphic.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.smartcardio.Card;

import Graphic.View.Card.SaveCard;
import Graphic.View.Pokemon.AddPokemon;

public class CardController implements ActionListener {

	SaveCard v;

	public CardController(SaveCard v) {
		this.v = v;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		switch(evt.getActionCommand()) {
			case "addPokemon":
				v.leave();
				new AddPokemon();
				return ;
			case "addTrainer":
				System.out.println("Controller.CardController");
				return ;
			case "addEnergy":
				System.out.println("Controller.CardController");
				return ;
			default:
				System.out.println("Une erreur est survenue.");
				return ;
		}
	}
	
	public SaveCard getV() {
		return v;
	}
}
