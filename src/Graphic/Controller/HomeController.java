package Graphic.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Graphic.View.Card.AllCards;
import Graphic.View.Card.AskType;
import Graphic.View.Card.DisplayCards;
import Graphic.View.Card.SaveCard;
import Graphic.View.Card.SearchCard;
import Graphic.View.Home.Home;
import Model.Card;

public class HomeController implements ActionListener {
	
	private SaveCard v;

	public HomeController(SaveCard v) {
		this.v = v;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		switch(evt.getActionCommand()) {
			case "add":
				new AskType();
				break;
			case "display":
				new AllCards();
				break;
			case "search":
				new SearchCard();
				break;
			case "leave":
				Card.serialize();
				break;
			default:
				System.out.println("Une erreur est survenue.");
				return ;
		}
		v.leave();
	}
}
