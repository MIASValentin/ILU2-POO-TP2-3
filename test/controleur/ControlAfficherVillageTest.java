package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	
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
	void testControlAfficherVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage, "Constructeur ne renvoie pas null");
	}

	@Test
	void testDonnerNomsVillageois() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		controlAfficherVillage.donnerNomsVillageois();
		Gaulois Bonemine = new Gaulois("Bonemine", 3);
		village.ajouterHabitant(Bonemine);
		controlAfficherVillage.donnerNomsVillageois();
		Druide Panoramix = new Druide("Panoramix", 3, 5, 10);
		village.ajouterHabitant(Panoramix);
		controlAfficherVillage.donnerNomsVillageois();
	}
	
	@Test
	void testDonnerNomVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		Assertions.assertEquals("Le village des irréductibles", controlAfficherVillage.donnerNomVillage());
	}
	
	@Test
	void testDonnerNbEtals() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		Assertions.assertEquals(5, controlAfficherVillage.donnerNbEtals());
	}

}
