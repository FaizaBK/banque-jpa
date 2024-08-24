package fr.diginamic.entites.Comptes;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "LIVRET_A")
public class LivretA extends Compte {

    @Column(name = "TAUX", nullable = false)
    private Double taux;

    public LivretA() {
    }

    public LivretA(String numero, Double solde, Double taux) {
        super(numero, solde);
        this.taux = taux;
    }

}