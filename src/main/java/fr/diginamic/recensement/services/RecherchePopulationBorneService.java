package fr.diginamic.recensement.services;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import fr.diginamic.errors.RecherchePopErrors;
import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;

/**
 * Recherche et affichage de toutes les villes d'un département dont la
 * population est comprise entre une valeur min et une valeur max renseignées
 * par l'utilisateur.
 * 
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationBorneService extends MenuService {

	
	@Override
	public void traiter (Recensement rec, Scanner scanner) throws RecherchePopErrors {
	
		
			System.out.println("Quel est le code du département recherché ? ");
			String choix = scanner.nextLine();
			
			
		
		System.out.println("Choississez une population minimum (en milliers d'habitants): ");	
		String saisieMin = scanner.nextLine();			
		int min =Integer.parseInt(saisieMin) * 1000;	
		
		if (min < 0) {
			throw new RecherchePopErrors("le nombre doit etre un nombre entier positif ou nul");  		
		}      
  
	
			    
		System.out.println("Choississez une population maximum (en milliers d'habitants): ");
		String saisieMax = scanner.nextLine();	    
		int max = Integer.parseInt(saisieMax) * 1000;	
		if (max<0 || min>max) {		
			throw new RecherchePopErrors("le nombre doit etre un nombre entier positif ou nul ou inferieur au maximum"  );
		}
		
		
		
		
		List<Ville> villes = rec.getVilles();
		boolean depTrouve =false;
		for (Ville ville : villes) {
			if (ville.getCodeDepartement().equalsIgnoreCase(choix)) {
				depTrouve=true;
				if (ville.getPopulation() >= min && ville.getPopulation() <= max) {
					System.out.println(ville);
				}
			}
		}
		
		if (!depTrouve) {
			
			throw new RecherchePopErrors("le code departement existe plus");
		}
		
		
		
	}

}
