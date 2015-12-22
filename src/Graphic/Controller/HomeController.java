package Graphic.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Graphic.View.Card.SaveCard;
import Graphic.View.Home.Home;

public class HomeController implements ActionListener {
	
	private SaveCard v;

	public HomeController(SaveCard v) {
		this.v = v;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		switch(evt.getActionCommand()) {
			case "add":
				v.add();
				break;
			case "update":
				v.update();
				break;
			case "search":
				v.search();
				break;
			case "leave":
				// Nothing
				break;
			default:
				System.out.println("Une erreur est survenue.");
				return ;
		}
		v.leave();
	}
}
