package Graphic.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Graphic.View.Energy.SaveEnergy;
import Graphic.View.Energy.UpdateEnergy;
import Model.Energy;
import Model.Energy.EnergyTypes;

public class EnergyController extends SuperController implements ActionListener {
	
	SaveEnergy v;
	Energy energy;
	
	public EnergyController(SaveEnergy v) {
		this.v = v;
	}
	
	public EnergyController(SaveEnergy v, Energy energy) {
		this.v = v;
		this.energy = energy;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(returnPrevPage(e, v)) return ;
		EnergyTypes type = v.getListTypes().getSelectedValue();
		if(type == null) {
			v.getLabelInfoMessage().setText("Il faut sélectionner un type d'energie");
			return ;
		}
		switch(e.getActionCommand()) {
		case "addEnergy":
			v.leave();
			new UpdateEnergy(new Energy(type), v);
			break;
		case "updateEnergy":
			energy.changeEnergy(type);
			v.getLabelInfoMessage().setText("L'energie a été modifiée");
			break;
		case "deleteEnergy":
			v.leave();
			v.delete(energy);
			afterDelete(v);
			break;
		default:
			System.out.println("Une erreur est survenue dans Graphic.Controller.EnergyController.");
			break;
		}
	}

	public Energy getEnergy() {
		return energy;
	}

}
