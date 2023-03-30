package fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.modeles;

import java.util.List;

import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.dto.Langues;
import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.exceptions.JoueurExistant;

public interface IServiceJoueur {
	
	public boolean ajouterJoueur(String prenom, String pseudo, int annee_naissance, Langues langue_preferee, String centre_interets) throws JoueurExistant;
	
	public boolean supprimerJoueur(String pseudo);
	
	public List<JoueurDTO> listerJoueur();
	
	public int nbrPartieJouee(String pseudoJoueur);
	
	public int nbrBonneReponsesTotal(String pseudoJoueur);
	
	public int nbrQuestionsRepondusTotal(String pseudoJoueur);
	
	public double moyenneGeneraleSur10(String pseudoJoueur);
	
	public double dureeMoyenneGenerale(String pseudoJoueur);

	//public void dernieresPartiesJouees(String pseudoJoueur, int nombreDeParties);
}
