package fr.diginamic.entites;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "OPERATION")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "MONTANT", nullable = false)
    private Double montant;

    @Column(name = "DATE_OPERATION", nullable = false)
    private LocalDateTime dateOperation;

    @ManyToOne
    @JoinColumn(name = "ID_COMPTE")
    private Compte compte;

    // Getters et Setters
}