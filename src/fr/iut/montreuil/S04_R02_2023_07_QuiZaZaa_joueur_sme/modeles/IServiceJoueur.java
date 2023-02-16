package fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.modeles;

import java.util.List;

import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.dto.JoueurDTO;

public interface IServiceJoueur {
	
	public boolean ajouterJoueur(JoueurDTO jd);
	
	public boolean supprimerJoueur(String pseudo);
	
	public List<JoueurDTO> listerJoueur();

}
