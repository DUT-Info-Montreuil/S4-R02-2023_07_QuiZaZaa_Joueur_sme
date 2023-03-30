package fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.exceptions;

@SuppressWarnings("serial")
public class StatsIncorrecte extends Exception{
	
	public StatsIncorrecte() {
		super("Stats mal construite");
	}

}
