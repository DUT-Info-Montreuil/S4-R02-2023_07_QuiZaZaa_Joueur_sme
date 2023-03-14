package fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.impl;
import java.util.ArrayList;
import java.util.List;

import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.modeles.IServiceJoueur;

public class ServiceJoueurMockOk implements IServiceJoueur{

	public ServiceJoueurMockOk(){

	}

	

	public boolean ajouterJoueur(JoueurDTO joueur){
		return true;
}



	public boolean supprimerJoueur(String pseudo){
		return true;
	}


	public List<JoueurDTO> listerJoueurs(){
		ArrayList<JoueurDTO> liste = new ArrayList<JoueurDTO>();
		return liste;
	}



}

