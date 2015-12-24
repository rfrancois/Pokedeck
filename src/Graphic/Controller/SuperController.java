package Graphic.Controller;

import java.awt.event.ActionEvent;

import Graphic.View.Card.AllCards;
import Graphic.View.Card.FoundCards;
import Graphic.View.Card.SaveCard;
import Graphic.View.Card.SearchCard;
import Graphic.View.Home.Home;

public class SuperController {

	/**
	 * Don't go to the home page, but to the previous page
	 * @param e Action command
	 * @param v Current view
	 * @return true if an action has been done
	 */
	public boolean returnPrevPage(ActionEvent e, SaveCard v) {
		if(e.getActionCommand() == "leave") {
			v.leave();
			// Make visible previous view
			if(v.getPrevView() instanceof AllCards) {
				v.getPrevView().leave();
				new AllCards();
			}
			else if(v.getPrevView() instanceof SearchCard) {
				//System.out.println(v.prev);
				new SearchCard(v.getPrevView().getTextSearch().getText());
			}
			else if(v.getPrevView() instanceof FoundCards) {
				v.getPrevView().leave();
				new FoundCards(v.getPrevView().getData());
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
	
	/**
	 * Call this function after a delete to open home page or a previous page like a search list
	 * @param v Current view
	 */
	public void afterDelete(SaveCard v) {
		// Make visible previous view
		if(v.getPrevView() instanceof AllCards) {
			v.getPrevView().leave();
			new AllCards();
		}
		else if(v.getPrevView() instanceof FoundCards) {
			v.getPrevView().leave();
			new FoundCards(v.getPrevView().getData());
		}
		// Return Home
		else {
			v.leave();
			new Home();
		}
	}
}
