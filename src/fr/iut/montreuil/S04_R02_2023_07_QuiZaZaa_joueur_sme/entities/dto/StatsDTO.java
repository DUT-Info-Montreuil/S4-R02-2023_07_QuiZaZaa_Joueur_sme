package fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.dto;

import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.exceptions.StatsIncorrecte;

public class StatsDTO {

	private int questionnaireId;
	private int nbrBonneReponse;
	private int nbrQuestions;
	private int duree;
	private double moyenneBonneReponseSur10;
	
	public StatsDTO(int duree, int nbrBonneReponse, int questionnaireId,  int nbrQuestions)  throws StatsIncorrecte{
		
		if(duree < 0 || nbrBonneReponse < 0 || questionnaireId < 0 || nbrQuestions < 0)
			throw new StatsIncorrecte();
	
		this.duree = duree;
		this.nbrBonneReponse = nbrBonneReponse;
		this.questionnaireId = questionnaireId;
		this.nbrQuestions = nbrQuestions;
	}

	public int getQuestionnaireId() {
		return questionnaireId;
	}

	public int getNbrBonneReponse() {
		return nbrBonneReponse;
	}

	public int getNbrQuestions() {
		return nbrQuestions;
	}

	public int getDuree() {
		return duree;
	}
	
	public void setMoyenneBonneReponseSur10(double moyenneBonneReponseSur10) {
		this.moyenneBonneReponseSur10 = moyenneBonneReponseSur10;
	}
	
	public double getMoyenneBonneReponseSur10() {
		return this.moyenneBonneReponseSur10;
	}
	
	
}