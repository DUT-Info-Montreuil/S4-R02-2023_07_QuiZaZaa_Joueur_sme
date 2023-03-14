package fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.modeles;

import java.util.List;

import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.dto.Langues;

public interface IServiceJoueur {
	
	public boolean ajouterJoueur(String prenom, String pseudo, int annee_naissance, Langues langue_preferee, String centre_interets);
	
	public boolean supprimerJoueur(String pseudo);
	
	public List<JoueurDTO> listerJoueur();

}
