package fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.impl;
import java.util.ArrayList;
import java.util.List;

import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.dto.Langues;
import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.dto.StatsDTO;
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


	//STATISTIQUES
	public double getMoyenneBonneReponseSur10() {
		return 5;
	}



	@Override
	public int nbrPartieJouee(String pseudoJoueur) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int nbrBonneReponsesTotal(String pseudoJoueur) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int nbrQuestionsRepondusTotal(String pseudoJoueur) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public double moyenneGeneraleSur10(String pseudoJoueur) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public double dureeMoyenneGenerale(String pseudoJoueur) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public StatsDTO ajouterStats(String pseudoJoueur, int duree, int nbrBonneReponse, int questionnaireId,
			int nbrQuestions) {
		// TODO Auto-generated method stub
		return null;
	}



}

