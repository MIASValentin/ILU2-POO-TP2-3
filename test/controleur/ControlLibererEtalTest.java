package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import villagegaulois.Village;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;

class ControlLibererEtalTest {
	private Village village;
	private Chef Abraracourcix;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("Le village des irréductibles", 10, 5);
		Abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(Abraracourcix);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
	}
	
	@Test
	void testControlLibererEtal() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertNotNull(controlLibererEtal, "Constructeur ne renvoie pas null");
	}
	
	@Test
	void testIsVendeur() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		Gaulois Bonemine = new Gaulois("Bonemine", 10);
		assertFalse(controlLibererEtal.isVendeur("N'existe pas"));
		village.ajouterHabitant(Bonemine);
		assertFalse(controlLibererEtal.isVendeur("Bonemine"));
		village.installerVendeur(Bonemine, "fleurs", 10);
		assertTrue(controlLibererEtal.isVendeur("Bonemine"));
	}
	
	@Test
	void testLibererEtal() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		Gaulois Bonemine = new Gaulois("Bonemine", 10);
		village.ajouterHabitant(Bonemine);
		village.installerVendeur(Bonemine, "fleurs", 10);
		controlLibererEtal.libererEtal("Bonemine");
	}

}
