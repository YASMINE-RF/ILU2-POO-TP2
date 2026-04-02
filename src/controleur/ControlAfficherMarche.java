package controleur;

import villagegaulois.Village;

public class ControlAfficherMarche {
	private Village village;

	public ControlAfficherMarche(Village village) {
		this.village = village;
	}

	//DONE
	public String[] donnerInfosMarche(){
		return village.donnerEtatMarche();
	}
}
