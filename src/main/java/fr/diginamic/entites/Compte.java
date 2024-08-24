package fr.diginamic.entites;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "COMPTE")
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NUMERO", nullable = false, unique = true)
    private String numero;

    @Column(name = "SOLDE", nullable = false)
    private Double solde;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENT")
    private Client client;

    // Getters et Setters
}