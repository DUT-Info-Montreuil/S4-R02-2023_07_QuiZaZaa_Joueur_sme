package fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.exceptions;

@SuppressWarnings("serial")
public class JoueurExistant extends Exception {

	public JoueurExistant() {
		super("Joueur déjà existant");
	}
}
