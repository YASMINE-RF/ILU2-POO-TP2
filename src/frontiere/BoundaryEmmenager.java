package frontiere;

import controleur.ControlEmmenager;
import personnages.Druide;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					//TODO a completer
					int force;
					System.out.println("Bienvenu Vilageois"+nomVisiteur);
					force=Clavier.entrerEntier("Quelle est votre force?");
					controlEmmenager.ajouterGaulois(nomVisiteur, force);
					
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		//completed
		int effetPotionMax,effetPotionMin,forceDruide;
		System.out.println("Bienvenu Druide"+nomVisiteur);
		forceDruide=Clavier.entrerEntier("Quelle est votre force?");
		
		do {
			effetPotionMin=Clavier.entrerEntier("Quelle est la force de potion la plus faible que vous produisez ?");
		    effetPotionMax=Clavier.entrerEntier("Quelle est la force de potion la plus forte que vous produisez ?");
			
			if (effetPotionMax< effetPotionMin) {
				System.out.println("Attention Druide, vous vous etes trompe entre le min et le max");
			}
			
		}while(effetPotionMax < effetPotionMin);
		
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);
		}
	
	}

