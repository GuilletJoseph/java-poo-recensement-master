package fr.diginamic.errors;

public class RecherchePopErrors extends Exception{

	public RecherchePopErrors() {
	}
	
	
	public String getPetitZero() {
		return "chiffre < 0 ou minimum grand maximum ou lettres";
	}
}
