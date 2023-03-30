package fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.impl;

import java.util.ArrayList;
import java.util.List;

import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.dto.Langues;
import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.dto.StatsDTO;
import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.exceptions.JoueurExistant;
import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.exceptions.StatsIncorrecte;
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
	
	
	// TO DO : REMETTRE EN CAUSE L'UTILISATION D'UN BOOLEAN
	@Override
	public boolean ajouterJoueur(String prenom, String pseudo, int annee_naissance, Langues langue_preferee, String centre_interets) throws JoueurExistant {
		
		//  Vérifie si le joueur existe déjà
		for (JoueurDTO j : this.joueurs) {
			if (pseudo.equals(j.getPseudo())) {
				throw new JoueurExistant();
			}
		}
		
		// Vérifie que le joueur a un nom conforme
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


	@Override
	public int nbrPartieJouee(String pseudoJoueur) {
		return getJoueurAvecPseudo(pseudoJoueur).getStats().size();
	}

	@Override
	public int nbrBonneReponsesTotal(String pseudoJoueur) {
		int nbrBonneReponseTotal = 0;
		for (StatsDTO stats : getJoueurAvecPseudo(pseudoJoueur).getStats()) {
			nbrBonneReponseTotal += stats.getNbrBonneReponse();
		}
		return nbrBonneReponseTotal;
	}

	@Override
	public int nbrQuestionsRepondusTotal(String pseudoJoueur) {
		int nbrQuestionsRepondusTotal = 0;
		for (StatsDTO stats : getJoueurAvecPseudo(pseudoJoueur).getStats()) {
			nbrQuestionsRepondusTotal += stats.getNbrBonneReponse();
		}
		return nbrQuestionsRepondusTotal;
	}

	@Override
	public double moyenneGeneraleSur10(String pseudoJoueur) {
		double moyenneGeneraleSur10 = 0;
		for (StatsDTO stats : getJoueurAvecPseudo(pseudoJoueur).getStats()) {
			moyenneGeneraleSur10 += stats.getMoyenneBonneReponseSur10();
		}
		return moyenneGeneraleSur10 / nbrPartieJouee(pseudoJoueur);
	}

	@Override
	public double dureeMoyenneGenerale(String pseudoJoueur) {
		double dureeMoyenneGenerale = 0;
		for (StatsDTO stats : getJoueurAvecPseudo(pseudoJoueur).getStats()) {
			dureeMoyenneGenerale += stats.getDuree();
		}
		return dureeMoyenneGenerale / nbrPartieJouee(pseudoJoueur);
	}

	@Override
	public StatsDTO ajouterStats(String pseudoJoueur, int duree, int nbrBonneReponse, int questionnaireId, int nbrQuestions) {
		StatsDTO s = null;
		try {
			s = new StatsDTO(duree, nbrBonneReponse, questionnaireId, nbrQuestions);
		} catch (StatsIncorrecte e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getJoueurAvecPseudo(pseudoJoueur).ajouterStats(s);
		return s;
	}

	//TO DO comment organiser le donnée ? Sortedset d'un objet couple de valeur ?
//	public void dernieresPartiesJouees(String pseudoJoueur, int nombreDeParties){
//	
//	}
}
