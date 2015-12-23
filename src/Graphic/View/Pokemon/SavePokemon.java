package Graphic.View.Pokemon;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Graphic.Controller.PokemonController;
import Graphic.View.Card.SaveCard;
import Model.Energy;
import Model.Energy.EnergyTypes;
import javafx.scene.layout.PaneBuilder;

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
	protected ArrayList<JButton> buttons = new ArrayList<JButton>();

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

		// To horizontally and vertically center panel
		setLayout(new GridBagLayout());
		
		// Action Listener
		for(JButton button : buttons) {
			button.addActionListener(controller);
		}

		// Panel
		JPanel panel = new JPanel();
		GridBagLayout gridLayout = new GridBagLayout();
		panel.setLayout(gridLayout);

		// Panel for form fields
		JPanel panelFields = new JPanel();
		panelFields.setLayout(gridLayout);
		GridBagConstraints c = new GridBagConstraints();
		
		JPanel panelButtons = new JPanel();
		panelButtons.setLayout(gridLayout);

		c.fill = GridBagConstraints.HORIZONTAL;
		// Margins
		c.insets = new Insets(5,5,5,5);

		// Build form
		for(int y=0; y<texts.length; y++) {
			for(int x=0; x<2; x++) {
				c.gridx = x;
				c.gridy = y;
				if(x==0) {
					panelFields.add(labels[y], c);
				}
				else {
					panelFields.add(texts[y], c);
				}
			}
		}

		// Build form
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(panelFields, c);
		
		// Build buttons
		c.fill = GridBagConstraints.HORIZONTAL;
		for(int i=0; i<buttons.size(); i++) {
			c.gridx = i;
			c.gridy = 0;
			panelButtons.add(buttons.get(i), c);
		}
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(panelButtons, c);
		
		// Build info message
		c.gridx = 0;
		c.gridy = 2;
		panel.add(labelInfoMessage, c);

		add(panel);
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
