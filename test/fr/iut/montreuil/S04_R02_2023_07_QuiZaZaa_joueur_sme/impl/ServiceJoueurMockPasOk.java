package fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.impl;
import java.util.List;

import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.entities.dto.Langues;
import fr.iut.montreuil.S04_R02_2023_07_QuiZaZaa_joueur_sme.modeles.IServiceJoueur;

public class ServiceJoueurMockPasOk implements IServiceJoueur{

	public ServiceJoueurMockPasOk(){

	}

	

	public boolean ajouterJoueur(String prenom, String pseudo, int annee_naissance, Langues langue_preferee, String centre_interets){
		return false;
	}
	/*Par manque de temps et de coordination, j'ai mis ici un cas avec une exception en commentaires 
	ayant pas le droit de modifier le code du developpeur.Je n'ai pas créer les classes et les mocks correspondant
	pour éviter toute confusion lorsque vous allez revoir le code :
	*/
	/*
 	public boolean ajouterJoueur(String prenom, String pseudo, int annee_naissance, Langues langue_preferee, String centre_interets) throws JoueurAvecUnStringVideException{
 		if(!prenom.isEmpty() && !pseudo.isEmpty() && !centre_interets.isEmpty()){
 			return true;
		}
		else{
			throw new JoueurAvecUnStringVideException("Exception String vide");
			
	}
	 
	 */
	
	//Version avec les espaces : 
	/*
 	public boolean ajouterJoueur(String prenom, String pseudo, int annee_naissance, Langues langue_preferee, String centre_interets) throws JoueurAvecUnStringAvecEspacesException{
 		if(!prenom.isBlank() && !pseudo.isBlank() && !centre_interets.isBlank()){
 			return true;
		}
		else{
			throw new JoueurAvecUnStringAvecEspacesException("Exception String contenant uniquement des espaces");
			
	}
	 
	 */



	public boolean supprimerJoueur(String pseudo){
		return false;
	}

 
	public List<JoueurDTO> listerJoueur(){
		return null;

	}
}

