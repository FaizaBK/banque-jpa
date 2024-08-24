package fr.diginamic.entites.Generic;

import jakarta.persistence.Embeddable;

@Embeddable
public class Adresse {

    private int numero;
    private String rue;
    private int codePostal;
    private String ville;

    public Adresse() {
    }

    public Adresse(int numero, String rue, int codePostal, String ville) {
        this.numero = numero;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }
}