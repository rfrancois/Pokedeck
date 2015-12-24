package Graphic;

import javax.swing.JFrame;

import Graphic.View.Home.Home;
import Model.Card;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Card.deserialize();
		new Home();
	}

}
