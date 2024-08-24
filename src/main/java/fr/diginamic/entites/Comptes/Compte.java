package fr.diginamic.entites.Comptes;

import fr.diginamic.entites.Client.Client;
import fr.diginamic.entites.Operations.Operation;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)  // Utilisation de la stratégie JOINED pour l'héritage
@Table(name = "COMPTE")
public abstract class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NUMERO", nullable = false)
    private String numero;

    @Column(name = "SOLDE", nullable = false)
    private Double solde;

    @ManyToMany(mappedBy = "comptes", cascade = CascadeType.ALL)
    private Set<Client> clients = new HashSet<>();

    @OneToMany(mappedBy = "compte", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Operation> operations = new HashSet<>();

    public Compte() {
    }

    public Compte(String numero, Double solde) {
        this.numero = numero;
        this.solde = solde;
    }


}
