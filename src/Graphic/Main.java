package Graphic;

import Graphic.View.Home.Home;
import Model.Card;

public class Main {

	public static void main(String[] args) {
		Card.deserialize();
		new Home();
	}

}
