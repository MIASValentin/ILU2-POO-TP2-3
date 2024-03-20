package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		StringBuilder reponse = new StringBuilder();
		if(!nomVendeurConnu) {
			reponse.append("Je suis d�sol�e ");
			reponse.append(nomVendeur);
			reponse.append(" mais il faut �tre un habitant de notre village pour commercer ici.");
			System.out.println(reponse);
		}
		else {
			reponse.append("Bonjour ");
			reponse.append(nomVendeur);
			reponse.append(" ,je vais regarder si je peux vous trouver un �tal.");
			boolean etalDisponible = controlPrendreEtal.resteEtals();
			StringBuilder reponse2 = new StringBuilder();
			if(!etalDisponible) {
				reponse2.append("D�sol�e ");
				reponse2.append(nomVendeur);
				reponse2.append(" ,je n'ai plus d'�tal qui ne soit pas d�j� occup�.");
				System.out.println(reponse2);
			}
			else {
				reponse2.append("C'est parfait, il me reste un �tal pour vous !\n");
				reponse2.append("il me faudrait quelques renseignements :\n");
				reponse2.append("Quel produit souhaitez-vous vendre ?");
				System.out.println(reponse2);
				String produit = scan.next();
				int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?");
				int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
				if(numeroEtal != -1) {
					StringBuilder reponse3 = new StringBuilder();
					reponse3.append("Le vendeur ");
					reponse3.append(nomVendeur);
					reponse3.append(" s'est install� � l'�tal n�");
					reponse3.append(numeroEtal + 1);
					System.out.println(reponse3);
				}
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
	}
}
