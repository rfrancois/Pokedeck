package Graphic.View.Pokemon;

import java.util.ArrayList;

import javax.swing.JButton;

import Graphic.Controller.PokemonController;
import Model.Energy;
import Model.Energy.EnergyTypes;
import Model.Pokemon;

public class UpdatePokemon extends SavePokemon {
	
	private JButton buttonUpdate = new JButton("Modifier");
	private JButton buttonDelete = new JButton("Supprimer");
	private JButton buttonLeave = new JButton("Retour");
	
	public UpdatePokemon(Pokemon pokemon) {
		controller = new PokemonController(this, pokemon);
		constructGUI();
	}
	
	public void constructGUI() {
		setTitle("Modifier le Pokemon");
		buttonUpdate.setActionCommand("updatePokemon");
		buttonDelete.setActionCommand("deletePokemon");
		buttonLeave.setActionCommand("leave");
		buttons.add(buttonUpdate);
		buttons.add(buttonDelete);
		buttons.add(buttonLeave);
		super.constructGUI();
		
		Pokemon pokemon = controller.getPokemon();
		// Field inputs
		labelInfoMessage.setText("Le Pokemon a correctement été ajouté");
		textName.setText(pokemon.getName());
		textCollectorCardNumber.setText(String.valueOf(pokemon.getCollectorCardNumber()));
		textHealth.setText(String.valueOf(pokemon.getHealth()));
		textAttackName1.setText(pokemon.getAttacks()[0].getName());
		textAttackName2.setText(pokemon.getAttacks()[1].getName());
		textAttackDamage1.setText(String.valueOf(pokemon.getAttacks()[0].getDamage()));
		textAttackDamage2.setText(String.valueOf(pokemon.getAttacks()[1].getDamage()));
		// Auto select energies
		int[] indexes = new int[pokemon.getEnergiesTypes().size()];
		for(int i=0; i<pokemon.getEnergiesTypes().size(); i++) {
			indexes[i] = listModel.indexOf(pokemon.getEnergiesTypes().get(i));
		}
		listEnergies.setSelectedIndices(indexes);
	}

}
