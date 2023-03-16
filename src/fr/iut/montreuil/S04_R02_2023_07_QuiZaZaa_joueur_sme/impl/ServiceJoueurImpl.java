package fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.impl;

import java.util.ArrayList;
import java.util.List;

import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.dto.Langues;
import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.modeles.IServiceJoueur;

public class ServiceJoueurImpl implements IServiceJoueur{

	private static ServiceJoueurImpl uniqueInstance=null;
	
	private List<JoueurDTO> joueurs;
	
	public ServiceJoueurImpl() {
		this.joueurs = new ArrayList<>();
	}
	
	public static ServiceJoueurImpl getInstatnce() {
		if(uniqueInstance==null) {
			uniqueInstance= new ServiceJoueurImpl();
			}
			return uniqueInstance;
	}
	
	@Override
	public boolean ajouterJoueur(String prenom, String pseudo, int annee_naissance, Langues langue_preferee, String centre_interets) {
		for (JoueurDTO j : this.joueurs) {
			if (pseudo.equals(j.getPseudo())) {
				System.out.println("joueur existant");
				return false;
			}
		}
		if (joueurConforme(prenom)) {
			this.joueurs.add(new JoueurDTO(prenom, pseudo, annee_naissance, langue_preferee, centre_interets));
			return true;
		}
		return false;
	}

	private boolean joueurConforme(String jd) {
		return jd != null;
	}

	@Override
	public boolean supprimerJoueur(String pseudo) {
		if (this.joueurs.contains(getJoueurAvecPseudo(pseudo))){
			this.joueurs.remove(getJoueurAvecPseudo(pseudo));
			return true;
		}
		return false;
	}

	public JoueurDTO getJoueurAvecPseudo(String pseudo) {
		JoueurDTO j = null;
		for(int i = 0; i < this.joueurs.size(); i++) {
			if (this.joueurs.get(i).getPseudo().equals(pseudo)) {
				return this.joueurs.get(i);
			}
		}
		return j;
	}

	@Override
	public List<JoueurDTO> listerJoueur() {
		return this.joueurs;
	}


}
