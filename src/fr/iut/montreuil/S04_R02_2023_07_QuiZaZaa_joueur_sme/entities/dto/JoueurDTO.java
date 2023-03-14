package fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.dto;

import java.util.ArrayList;
import java.util.List;

public class JoueurDTO {
	
	private String prenom, pseudo;
	private int annee_naissance;
	private String centre_interets;
	private Langues langue_preferee;

	public JoueurDTO(String prenom, String pseudo, int annee_naissance, Langues langue_preferee, String centre_interets) {
		super();
		this.prenom = prenom;
		this.pseudo = pseudo;
		this.annee_naissance = annee_naissance;
		this.langue_preferee = langue_preferee;
		this.centre_interets = centre_interets;
	}

	@Override
	public String toString() {
		return "JoueurDTO [prenom=" + prenom + ", pseudo=" + pseudo + ", annee_naissance=" + annee_naissance
				+ ", langue_preferee=" + langue_preferee + ", centre_interets=" + centre_interets + "]";
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public int getAnnee_naissance() {
		return annee_naissance;
	}

	public void setAnnee_naissance(int annee_naissance) {
		this.annee_naissance = annee_naissance;
	}

	public int getLangue_preferee() {
		return langue_preferee;
	}

	public void setLangue_preferee(int langue_preferee) {
		this.langue_preferee = langue_preferee;
	}

	public List<String> getCentre_interets() {
		return centre_interets;
	}

	public void setCentre_interets(List<String> centre_interets) {
		this.centre_interets = centre_interets;
	}
}
