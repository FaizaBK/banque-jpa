package fr.diginamic.entites.Client;



import fr.diginamic.entites.Comptes.AssuranceVie;
import fr.diginamic.entites.Comptes.LivretA;
import fr.diginamic.entites.Generic.Adresse;
import fr.diginamic.entites.Generic.Banque;
import fr.diginamic.entites.Comptes.Compte;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CLIENT")
public class Client {

    // clé primaire de l'entité
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOM", nullable = false)
    private String nom;

    //colonne 'PRENOM' de la table, avec une contrainte de non-nullité
    @Column(name = "PRENOM", nullable = false)
    private String prenom;

    @Column(name = "DATE_NAISSANCE", nullable = false)
    private LocalDate dateNaissance;

    @Embedded  // Indique que ce champ est un objet intégré dans cette entité (pas une entité distincte)
    private Adresse adresse;

    @ManyToOne  // Indique une relation Many-to-One avec une autre entité, ici 'Banque'
    @JoinColumn(name = "BANQUE_ID")  // Spécifie la colonne de jointure dans la table 'CLIENT' qui fait référence à la clé primaire de la table 'BANQUE'
    private Banque banque;

    // Indique une relation Many-to-Many avec une autre entité, ici 'Compte'
    @ManyToMany
    @JoinTable(name = "CLIENT_COMPTE",
            joinColumns = @JoinColumn(name = "CLIENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "COMPTE_ID"))
    private Set<Compte> comptes = new HashSet<>();

    // Constructeur par défaut requis par JPA
    public Client() {
    }

    // Constructeur surchargé pour initialiser le client avec des informations spécifiques
    public Client(String nom, String prenom, LocalDate dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    // Méthode pour ajouter un compte d'assurance vie au client
    public void addCompte(AssuranceVie livret1) {
    }

    // Méthode pour définir la banque associée au client
    public void setBanque(Banque lcl) {
        this.banque = lcl;
    }

    // Méthode pour définir l'adresse du client
    public void setAdresse(Adresse adresse1) {
        this.adresse = adresse1;
    }

    // Méthode pour ajouter un compte Livret A au client
    public void addCompte(LivretA livret1) {
    }
}