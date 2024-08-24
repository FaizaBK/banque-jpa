package fr.diginamic.entites.Generic;

import fr.diginamic.entites.Client.Client;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "BANQUE")
public class Banque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOM", nullable = false)
    private String nom;

    @OneToMany(mappedBy = "banque", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Client> clients = new HashSet<>();

    public Banque() {
    }

    public Banque(String nom) {
        this.nom = nom;
    }


}