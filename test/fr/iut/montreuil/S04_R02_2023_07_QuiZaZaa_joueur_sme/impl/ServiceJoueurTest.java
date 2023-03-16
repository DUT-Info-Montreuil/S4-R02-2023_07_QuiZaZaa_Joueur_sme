package fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.dto.Langues;
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
		   //this.sji = new ServiceJoueurImpl();

	   }

	   @Test
	   void ajouterJoueur() {
	       assertTrue(this.serviceJoueurMockOk.ajouterJoueur("Jonas","WFS",2003,Langues.ANGLAIS,"mangas"),"Cas normal");
	       assertFalse(this.serviceJoueurMockPasOk.ajouterJoueur("Cyril","WFS", 2003, Langues.FRANCAIS,"cinema"), "Cas pseudo déjà existant");
	       //assertTrue(this.sji.ajouterJoueur("Jonas","WFS",2003,Langues.ANGLAIS,"mangas"));
	       //assertFalse(this.sji.ajouterJoueur("Cyril","WFS", 2003, Langues.FRANCAIS,"cinema"), "Cas pseudo déjà existant");
	       
	       
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
		   //this.sji.ajouterJoueur("Karim", "AYLO", 2001,Langues.ITALIEN,"jeux vidéos");
		   //assertTrue(this.sji.supprimerJoueur("AYLO"),"Cas normal");
	       //assertFalse(this.sji.supprimerJoueur("WeedForSpeed"), "Cas pseudo inéxistant");
	       
	   }

	   @Test 
	   void listerJoueurs(){
		   ArrayList<JoueurDTO> liste = new ArrayList<JoueurDTO>();
		   JoueurDTO j1 = new JoueurDTO("Ronald","Mcdo",2000,Langues.ANGLAIS,"Manger");
		   liste.add(j1);
		   assertEquals(liste, this.serviceJoueurMockOk.listerJoueur(),"Cas normal");
		   
		   //ArrayList<JoueurDTO> liste = new ArrayList<JoueurDTO>();
		   //JoueurDTO j1 = new JoueurDTO("Ronald","Mcdo",2000,Langues.ANGLAIS,"Manger");
		   //liste.add(j1);
		   //assertEquals(liste, this.sji.listerJoueur());
	   }
}


