package fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.impl.ServiceJoueurImpl;
import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.impl.ServiceJoueurMockOk;
import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.impl.ServiceJoueurMockPasOk;
import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.modeles.IServiceJoueur;

class ServiceJoueurTest {


	//ServiceJoueurMockOk serviceJoueurMockOk;
	//ServiceJoueurMockPasOk serviceJoueurMockPasOk;
	ArrayList<String> hobbiesJ1 = new ArrayList<String>();
	ArrayList<String> hobbiesJ2 = new ArrayList<String>();
	ArrayList<String> hobbiesJ3 = new ArrayList<String>();




	private JoueurDTO j1 = new JoueurDTO("Jonas", "WFS", 2003,"Anglais",hobbiesJ1);
	private JoueurDTO j2 = new JoueurDTO("Cyril", "WFS", 2003,"Français",hobbiesJ2);
	private JoueurDTO j3 = new JoueurDTO(" ", "AYLO", 2001,"Espagnol",hobbiesJ3);
	private ServiceJoueurImpl sji;

	   @BeforeEach
	   void setUp(TestInfo testInfo) {
	       //this.serviceJoueurMockOk = new ServiceJoueurMockOk();
	       //this.serviceJoueurMockPasOk = new ServiceJoueurMockPasOk();
		   this.sji = new ServiceJoueurImpl();

	   }

	   @Test
	   void ajouterJoueur() {
	       assertTrue(this.sji.ajouterJoueur(j1));
	       assertFalse(this.sji.ajouterJoueur(j2), "Cas pseudo déjà existant");
	       assertFalse(this.sji.ajouterJoueur(j3), "Cas manque d’informations");
	   }


	   @Test
	   void supprimerJoueur() {
		   this.sji.ajouterJoueur(j1);
	       assertTrue(this.sji.supprimerJoueur(j1.getPseudo()));
	       assertFalse(this.sji.supprimerJoueur("WeedForSpeed"), "Cas pseudo inéxistant");
	   }

	   @Test 
	   void listerJoueurs(){
		   ArrayList<JoueurDTO> liste = new ArrayList<JoueurDTO>();
		   liste.add(j1);
		   assertEquals(liste, this.sji.listerJoueurs());
	   }
}


