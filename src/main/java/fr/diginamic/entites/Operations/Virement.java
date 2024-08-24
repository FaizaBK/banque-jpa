package fr.diginamic.entites.Operations;

import fr.diginamic.entites.Comptes.AssuranceVie;
import fr.diginamic.entites.Comptes.LivretA;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "VIREMENT")
public class Virement extends Operation {

    @Column(name = "BENEFICIAIRE", nullable = false)
    private String beneficiaire;

    public Virement() {
        super();
    }

    public Virement(LocalDateTime dateOperation, Double montant, String description, String beneficiaire) {
        super();
        this.beneficiaire = beneficiaire;
    }

    public void setCompte(LivretA livret1) {
    }

    public void setCompte(AssuranceVie assurance1) {

    }
}