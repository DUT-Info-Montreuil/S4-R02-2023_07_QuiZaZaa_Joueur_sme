package fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.impl;
import java.util.ArrayList;
import java.util.List;

import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.dto.Langues;
import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.modeles.IServiceJoueur;

public class ServiceJoueurMockOk implements IServiceJoueur{

	public ServiceJoueurMockOk(){

	}

	

	public boolean ajouterJoueur(String prenom, String pseudo, int annee_naissance, Langues langue_preferee, String centre_interets){
		return true;
	}



	public boolean supprimerJoueur(String pseudo){
		return true;
	}


	public List<JoueurDTO> listerJoueur(){
		ArrayList<JoueurDTO> liste = new ArrayList<JoueurDTO>();
		JoueurDTO j1 = new JoueurDTO("Ronald","Mcdo",2000,Langues.ANGLAIS,"Manger");
		liste.add(j1);
		return liste;
	}





}

