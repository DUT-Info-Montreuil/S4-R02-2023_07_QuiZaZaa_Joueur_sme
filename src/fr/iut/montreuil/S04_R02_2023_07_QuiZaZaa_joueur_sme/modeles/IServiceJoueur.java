package fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.modeles;

import java.util.List;

import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.dto.Langues;
import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.dto.StatsDTO;
import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.exceptions.JoueurExistant;

public interface IServiceJoueur {
	
	public boolean ajouterJoueur(String prenom, String pseudo, int annee_naissance, Langues langue_preferee, String centre_interets) throws JoueurExistant;
	
	public boolean supprimerJoueur(String pseudo);
	
	public List<JoueurDTO> listerJoueur();
	
	public StatsDTO ajouterStats(String pseudoJoueur,int duree, int nbrBonneReponse, int questionnaireId,  int nbrQuestions);

}
