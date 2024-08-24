package fr.diginamic.entites.Comptes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;



@Entity
@Table(name = "ASSURANCE_VIE")
public class AssuranceVie extends Compte {

    @Column(name = "DATE_FIN", nullable = false)
    private LocalDate dateFin;

    @Column(name = "TAUX", nullable = false)
    private Double taux;

    // Constructeur sans arguments requis par JPA
    public AssuranceVie() {
        super(); // Appel du constructeur de la classe parente (Compte)
    }

    // Constructeur avec arguments
    public AssuranceVie(String numero, Double solde, LocalDate dateFin, Double taux) {
        super(numero, solde);
        this.dateFin = dateFin;
        this.taux = taux;
    }

}