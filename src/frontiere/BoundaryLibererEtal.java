package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);
		if(!vendeurReconnu) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !");
		}
		else {
			String donneesEtal[] = controlLibererEtal.libererEtal(nomVendeur);
			if(donneesEtal[0] == "true") {
				StringBuilder donnees = new StringBuilder();
				donnees.append("Vous avez vendu ");
				donnees.append(donneesEtal[4]);
				donnees.append(" sur ");
				donnees.append(donneesEtal[3]);
				donnees.append(" ");
				donnees.append(donneesEtal[2]);
				donnees.append(".\n");
				donnees.append("Au revoir, ");
				donnees.append(nomVendeur);
				donnees.append(", passez une bonne journée.");
				System.out.println(donnees);
			}
		}
	}

}
