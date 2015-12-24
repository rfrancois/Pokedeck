package Graphic.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Graphic.View.Trainer.SaveTrainer;
import Graphic.View.Trainer.UpdateTrainer;
import Model.Trainer;
import Model.Trainer.TrainerTypes;

public class TrainerController extends SuperController implements ActionListener {

	private SaveTrainer v;
	private Trainer trainer;

	public TrainerController(SaveTrainer v) {
		this.v = v;
	}

	public TrainerController(SaveTrainer v, Trainer t) {
		this.v = v;
		trainer = t;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(returnPrevPage(e, v)) return ;
		String name = v.getTextName().getText();
		if(name.isEmpty()) {
			v.getLabelInfoMessage().setText("Le nom est obligatoire");
			return ;
		}
		String text = v.getTextText().getText();
		if(text.isEmpty()) {
			v.getLabelInfoMessage().setText("La description est obligatoire");
			return ;
		}
		String rule = v.getTextRule().getText();
		if(rule.isEmpty()) {
			v.getLabelInfoMessage().setText("La règle est obligatoire");
			return ;
		}
		TrainerTypes type = v.getListTypes().getSelectedValue();
		if(type == null) {
			v.getLabelInfoMessage().setText("Il faut sélectionner un type d'entraineur");
			return ;
		}
		switch(e.getActionCommand()) {
		case "addTrainer":
			v.leave();
			new UpdateTrainer(new Trainer(name, text, rule,  type), v);
			break;
		case "updateTrainer":
			trainer.changeName(name);
			trainer.changeText(text);
			trainer.changeRule(rule);
			trainer.changeType(type);
			v.getLabelInfoMessage().setText("L'entraineur a été modifié");
			break;
		case "deleteTrainer":
			v.leave();
			v.delete(trainer);
			afterDelete(v);
			break;
		default:
			v.leave();
			System.out.println("Une erreur est survenue dans Graphic.Controller.TrainerController.");
			break;
		}
	}

	public Trainer getTrainer() {
		return trainer;
	}
}
