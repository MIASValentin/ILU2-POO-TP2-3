package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if(!controlAcheterProduit.VerifierIdentite(nomAcheteur)) {
			System.out.println("Je suis d�sol�, " + nomAcheteur + " mais il faut �tre un habitant du village pour commercer ici.");
		}
		else {
			System.out.println("Quel produit voulez-vous achetez ?");
			String produit = scan.next();
			if(!ControlAcheterProduit.VerifierProduit(produit)) {
				System.out.println("D�sol�, personne ne vend ce produit au march�.");
			}
			else {
				
			}
		}
	}
}
