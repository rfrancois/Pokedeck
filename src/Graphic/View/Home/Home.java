package Graphic.View.Home;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Graphic.Controller.HomeController;
import Graphic.View.Card.SaveCard;

public class Home extends SaveCard {

	private HomeController controller;
	private JButton buttonAdd = new JButton("Ajouter");
	private JButton buttonDisplay = new JButton("Afficher le jeu");
	private JButton buttonSearch = new JButton("Rechercher une carte");
	private JButton buttonLeave = new JButton("Quitter le programme");
	
	public Home() {
		controller = new HomeController(this);
		super.constructGUI();
		setTitle("Accueil");
		// To horizontally and vertically center panel
		setLayout(new GridBagLayout());
		
		// Panel
		JPanel panel = new JPanel();
		GridLayout gridLayout = new GridLayout(4, 1);
		// Horizontal space between buttons
		gridLayout.setVgap(10);
		panel.setLayout(gridLayout);
		panel.add(buttonAdd);
		panel.add(buttonDisplay);
		panel.add(buttonSearch);
		panel.add(buttonLeave);
		add(panel);
		
		// Action to call
		buttonAdd.setActionCommand("add");
		buttonDisplay.setActionCommand("display");
		buttonSearch.setActionCommand("search");
		buttonLeave.setActionCommand("leave");
		
		// Event Listener
		buttonAdd.addActionListener(controller);
		buttonDisplay.addActionListener(controller);
		buttonSearch.addActionListener(controller);
		buttonLeave.addActionListener(controller);
		
		//panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		//buttonAdd.setMaximumSize(new Dimension(200,200));
		//buttonAdd.setMargin(new Insets());
	}
}
