package fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.impl;
import java.util.List;

import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.modeles.IServiceJoueur;

public class ServiceJoueurMockPasOk implements IServiceJoueur{

	public ServiceJoueurMockPasOk(){

	}

	

	public boolean ajouterJoueur(JoueurDTO joueur){
		return false;
	}



	public boolean supprimerJoueur(String pseudo){
		return false;
	}

 
	public List<JoueurDTO> listerJoueurs(){
		return null;

	}
}

