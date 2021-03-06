package org.formacio.component;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ServeiAlumnat {

	@Autowired
	RepositoriAlumnes alumnes = new RepositoriAlumnesMemoria();

	/**
	 * ha de donar d'alta a la base de dades d'alumnes l'alumne indicat amb 
	 * el corresponent codi.
	 * Si el nom de l'alumne es null, no l'ha de donar d'alta
	 * Retorna true si l'alumne s'ha inserit, false si no.
	 */
	public boolean matricula (int id, String alumne) {
		if (alumne == null) {
			return false;
		} else {
			alumnes.altaAlumne(id, alumne);
		}
		return true;
	}
	
	@PostConstruct
	public void init() {
		alumnes.altaAlumne(1, "Antonia");
		alumnes.altaAlumne(2, "Joan");
	}

	public int size() {
		return alumnes.llistaAlumnes().size();
	}

}



