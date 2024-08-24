package fr.diginamic.entites.Operations;

import fr.diginamic.entites.Comptes.Compte;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "OPERATION")
public abstract class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DATE_OPERATION", nullable = false)
    private LocalDateTime dateOperation;

    @Column(name = "MONTANT", nullable = false)
    private Double montant;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "COMPTE_ID")
    private Compte compte;

    public Operation() {
    }

    public Operation(LocalDateTime dateOperation, Double montant, String description) {
        this.dateOperation = dateOperation;
        this.montant = montant;
        this.description = description;
    }

}