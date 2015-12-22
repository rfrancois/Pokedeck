package Graphic.View.Pokemon;

import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import Graphic.Controller.PokemonController;

public class AddPokemon extends SavePokemon {

	private PokemonController controller;
	private JLabel labelName = new JLabel();
	private JTextField textName = new JTextField();
	private JLabel labelHealth = new JLabel();
	private JTextField textHealth = new JTextField();
	private JLabel labelAttackName1 = new JLabel();
	private JTextField textAttackName1 = new JTextField();
	private JLabel labelAttackDamage1 = new JLabel();
	private JTextField textAttackDamage1 = new JTextField();
	private JLabel labelAttackName2 = new JLabel();
	private JTextField textAttackName2 = new JTextField();
	private JLabel labelAttackDamage2 = new JLabel();
	private JTextField textAttackDamage2 = new JTextField();
	private JLabel labelCollectorCardNumber = new JLabel();
	private JTextField textCollectorCardNumber = new JTextField();
	
	public AddPokemon() {
		controller = new PokemonController(this);
		setTitle("Ajouter un Pokemon");
		init();
		
		// To horizontally and vertically center panel
		setLayout(new GridBagLayout());
	
	}
}
