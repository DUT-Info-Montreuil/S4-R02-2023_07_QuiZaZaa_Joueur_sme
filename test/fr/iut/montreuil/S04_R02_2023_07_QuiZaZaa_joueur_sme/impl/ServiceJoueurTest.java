package fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.impl;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.dto.Langues;
import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.dto.StatsDTO;
import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.exceptions.JoueurExistant;
import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.exceptions.StatsIncorrecte;
import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.impl.ServiceJoueurImpl;
import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.impl.ServiceJoueurMockOk;
import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.impl.ServiceJoueurMockPasOk;
import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.modeles.IServiceJoueur;

class ServiceJoueurTest {


	ServiceJoueurMockOk serviceJoueurMockOk;
	ServiceJoueurMockPasOk serviceJoueurMockPasOk;
	private ServiceJoueurImpl sji;

	@BeforeEach
	void setUp(TestInfo testInfo) {
		this.serviceJoueurMockOk = new ServiceJoueurMockOk();
		this.serviceJoueurMockPasOk = new ServiceJoueurMockPasOk();
		this.sji = new ServiceJoueurImpl();

	}

	@Test
	void ajouterJoueur() {
		assertTrue(this.serviceJoueurMockOk.ajouterJoueur("Jonas","WFS",2003,Langues.ANGLAIS,"mangas"),"Cas normal");
		assertFalse(this.serviceJoueurMockPasOk.ajouterJoueur("Cyril","WFS", 2003, Langues.FRANCAIS,"cinema"), "Cas pseudo déjà existant");

		try {
			assertTrue(this.sji.ajouterJoueur("Jonas","WFS",2003,Langues.ANGLAIS,"mangas"));
		} catch (JoueurExistant e) {
			e.printStackTrace();
		}
		try {
			assertFalse(this.sji.ajouterJoueur("Cyril","WFS", 2003, Langues.FRANCAIS,"cinema"), "Cas pseudo déjà existant");
		} catch (JoueurExistant e) {
			e.printStackTrace();
		}


		//Cette partie concerne l'exception dans ServiceJoueurMockPasOk, l'explication y est indiquée
		/*
	       assertThrows(JoueurAvecUnStringVideException.class(), -> {
	       this.serviceJoueurMockPasOk.ajouterJoueur("","Mcdo",2000,Langues.ANGLAIS,"Manger")},"Cas nom, pseudo ou centre d'intérêts étant vide");
	       assertThrows(JoueurAvecUnStringAvecEspacesException.class(), -> {
	       this.serviceJoueurMockPasOk.ajouterJoueur("   ","Mcdo",2000,Langues.ANGLAIS,"Manger")} "Cas nom, pseudo ou centre d'intérêts contenant que des espaces"); 
		 */
	}


	@Test
	void supprimerJoueur() {
		this.serviceJoueurMockOk.ajouterJoueur("Karim", "AYLO", 2001,Langues.ITALIEN,"jeux vidéos");
		assertTrue(this.serviceJoueurMockOk.supprimerJoueur("AYLO"),"Cas normal");
		assertFalse(this.serviceJoueurMockPasOk.supprimerJoueur("WeedForSpeed"), "Cas pseudo inéxistant");

		try { 
			this.sji.ajouterJoueur("Karim", "AYLO", 2001,Langues.ITALIEN,"jeux vidéos");
		} catch (JoueurExistant e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		assertTrue(this.sji.supprimerJoueur("AYLO"),"Cas normal");
		assertFalse(this.sji.supprimerJoueur("WeedForSpeed"), "Cas pseudo inéxistant");
	}


//	//test statistiques joueur

	@Test
	void StatsIncorrecteException(){
		try {
			this.sji.ajouterJoueur("ouioui", "OUI", 2001,Langues.ITALIEN,"jeux vidéos");
		} catch (JoueurExistant e) {
			e.printStackTrace();
		}
		Throwable exception = assertThrows(StatsIncorrecte.class, () -> {
			this.sji.ajouterStats("OUI", 10, 50, -99, 100);
		});
		assertEquals("Stats mal construite", exception.getMessage());
	}
	
	@Test
	void ajouterStats() {
		try {
			this.sji.ajouterJoueur("ouioui", "OUI", 2001,Langues.ITALIEN,"jeux vidéos");
		} catch (JoueurExistant e) {
			e.printStackTrace();
		}
		StatsDTO stat;
		try {
			stat = new StatsDTO(10, 50, 99, 100);
			assertEquals(this.sji.ajouterStats("OUI", 10, 50, 99, 100).getNbrBonneReponse(), 50);
			assertEquals(this.sji.ajouterStats("OUI", 10, 50, 99, 100).getNbrQuestions(), 100);
			assertEquals(this.sji.ajouterStats("OUI", 10, 50, 99, 100).getQuestionnaireId(), 99);
			assertEquals(this.sji.ajouterStats("OUI", 10, 50, 99, 100).getDuree(), 10);
		} catch (StatsIncorrecte e) {
			e.printStackTrace();
		}
	}
}


