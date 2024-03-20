package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarches = controlAfficherMarche.donnerInfoMarche();
		if(infosMarches.length == 0) {
			System.out.println("Le marché est vide, revenez plus tard.");
		}
		else {
			StringBuilder chaine = new StringBuilder();
			System.out.println(nomAcheteur + ", vous trouverez au marché :");
			for(int i = 0;i < infosMarches.length; i++) {
				chaine.append("-");
				chaine.append(infosMarches[i]);
				i++;
				chaine.append(" qui vend ");
				chaine.append(infosMarches[i]);
				chaine.append(" ");
				i++;
				chaine.append(infosMarches[i]);
			}
			System.out.println(chaine);
		}
	}
}
