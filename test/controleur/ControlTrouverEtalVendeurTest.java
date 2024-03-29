package controleur;


import static org.junit.jupiter.api.Assertions.*;

import villagegaulois.Etal;
import villagegaulois.Village;
import personnages.Chef;
import personnages.Gaulois;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControlTrouverEtalVendeurTest {
	private Village village;
	private Chef Abraracourcix;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("Le village des irréductibles", 10, 5);
		Abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(Abraracourcix);
	}
	
	@Test
	void testControlTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		assertNotNull(controlTrouverEtalVendeur, "Constructeur ne renvoie pas null");
	}
	
	@Test
	void testTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		assert controlTrouverEtalVendeur.trouverEtalVendeur("N'existe pas") == null;
		Gaulois Bonemine = new Gaulois("Bonemine", 10);
		village.ajouterHabitant(Bonemine);
		assert controlTrouverEtalVendeur.trouverEtalVendeur("Bonemine") == null;
		village.installerVendeur(Bonemine, "fleurs", 10);
	}

}
