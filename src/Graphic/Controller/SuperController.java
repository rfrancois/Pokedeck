package Graphic.Controller;

import java.awt.event.ActionEvent;

import Graphic.View.Card.AllCards;
import Graphic.View.Card.FoundCards;
import Graphic.View.Card.SaveCard;
import Graphic.View.Card.SearchCard;
import Graphic.View.Home.Home;

public class SuperController {

	/**
	 * Don't go to the home page, but to the list or the search result
	 * @param e Action command
	 * @param v Current view
	 */
	public boolean returnToList(ActionEvent e, SaveCard v) {
		if(e.getActionCommand() == "leave") {
			v.leave();
			// Make visible previous view
			if(v.getPrevView() instanceof AllCards) {
				v.getPrevView().leave();
				new AllCards();
			}
			else if(v.getPrevView() instanceof FoundCards) {
				v.getPrevView().leave();
				new SearchCard(v.getPrevView().getTextSearch().getText());
			}
			// Return Home
			else {
				v.leave();
				new Home();
			}
			return true;
		}
		return false;
	}
}
