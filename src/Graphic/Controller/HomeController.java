package Graphic.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Graphic.View.Card.AskType;
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
				new AskType();
				break;
			case "update":
				System.out.println("Controller.HomeController");
				break;
			case "search":
				System.out.println("Controller.HomeController");
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
