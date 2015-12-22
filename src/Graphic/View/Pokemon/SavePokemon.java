package Graphic.View.Pokemon;

import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Graphic.Controller.PokemonController;
import Graphic.View.Card.SaveCard;
import Model.Energy;
import Model.Energy.EnergyTypes;

public class SavePokemon extends SaveCard {

	protected PokemonController controller;
	
	protected JLabel labelInfoMessage = new JLabel();
	protected JLabel labelName = new JLabel("Nom");
	protected JTextField textName = new JTextField(textFieldSize);
	protected JLabel labelHealth = new JLabel("Santé");
	protected JTextField textHealth = new JTextField(textFieldSize);
	protected JLabel labelAttackName1 = new JLabel("Nom de la première attaque");
	protected JTextField textAttackName1 = new JTextField(textFieldSize);
	protected JLabel labelAttackDamage1 = new JLabel("Dommage de la première attaque");
	protected JTextField textAttackDamage1 = new JTextField(textFieldSize);
	protected JLabel labelAttackName2 = new JLabel("Nom de la deuxème attaque");
	protected JTextField textAttackName2 = new JTextField(textFieldSize);
	protected JLabel labelAttackDamage2 = new JLabel("Dommage de la deuxième attaque");
	protected JTextField textAttackDamage2 = new JTextField(textFieldSize);
	protected JLabel labelCollectorCardNumber = new JLabel("Numéro de la carte");
	protected JTextField textCollectorCardNumber = new JTextField(textFieldSize);
	protected JLabel labelEnergies = new JLabel("Energie");
	protected DefaultListModel<EnergyTypes> listModel = new DefaultListModel<EnergyTypes>();
	protected JList<EnergyTypes> listEnergies = new JList<EnergyTypes>(listModel);
	protected JScrollPane selectEnergies = new JScrollPane(listEnergies);
	protected JComboBox prevEvolve = new JComboBox();
	protected JLabel[] labels = new JLabel[]{
		labelName, 
		labelCollectorCardNumber,
		labelHealth,
		labelEnergies,
		labelAttackName1, 
		labelAttackDamage1,
		labelAttackName2,
		labelAttackDamage2
	};
	protected JComponent[] texts = new JComponent[]{
		textName,
		textCollectorCardNumber,
		textHealth,
		selectEnergies,
		textAttackName1,
		textAttackDamage1,
		textAttackName2,
		textAttackDamage2
	};
	
	public void constructGUI() {
		super.constructGUI();
		// Label alignment
		for(JLabel label : labels) {
			label.setHorizontalAlignment(JLabel.RIGHT);
		}
		for(EnergyTypes energy : EnergyTypes.values()) {	
			listModel.addElement(energy);
		}
		// Visible rows
		listEnergies.setVisibleRowCount(4);
	}

	public JTextField getTextName() {
		return textName;
	}

	public JTextField getTextHealth() {
		return textHealth;
	}

	public JTextField getTextAttackName1() {
		return textAttackName1;
	}

	public JTextField getTextAttackDamage1() {
		return textAttackDamage1;
	}

	public JTextField getTextAttackName2() {
		return textAttackName2;
	}

	public JTextField getTextAttackDamage2() {
		return textAttackDamage2;
	}

	public JTextField getTextCollectorCardNumber() {
		return textCollectorCardNumber;
	}

	public JList<EnergyTypes> getListEnergies() {
		return listEnergies;
	}

	public JLabel getLabelInfoMessage() {
		return labelInfoMessage;
	}
	
}
