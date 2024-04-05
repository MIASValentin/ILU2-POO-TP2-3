package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
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
	void testControlAfficherMarche() {
		ControlAfficherMarche controlAfficherMarche = new ControlAfficherMarche(village);
		assertNotNull(controlAfficherMarche, "Constructeur ne renvoie pas null");
	}
	
	@Test
	void testDonnerInfoMarche() {
		ControlAfficherMarche controlAfficherMarche = new ControlAfficherMarche(village);
		controlAfficherMarche.donnerInfoMarche();
		Gaulois Bonemine = new Gaulois("Bonemine",3);
		village.ajouterHabitant(Bonemine);
		village.installerVendeur(Bonemine, "fleurs", 10);
		controlAfficherMarche.donnerInfoMarche();
		village.partirVendeur(Bonemine);
		controlAfficherMarche.donnerInfoMarche();
	}

}
