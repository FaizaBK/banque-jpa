package fr.diginamic;

import fr.diginamic.entites.Generic.Adresse;
import fr.diginamic.entites.Generic.Banque;
import fr.diginamic.entites.Client.Client;
import fr.diginamic.entites.Comptes.AssuranceVie;
import fr.diginamic.entites.Comptes.LivretA;
import fr.diginamic.entites.Operations.Virement;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class ApplicationBanque {
    public static void main(String[] args) {
        // Créer EntityManagerFactory et EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Instancier des classes
        // 1. Adresses
        Adresse adresse1 = new Adresse(12, "Rue de Faubourg", 30100, "Alès");
        Adresse adresse2 = new Adresse(2, "Rue Thiers", 54400, "Longwy");
        Adresse adresse3 = new Adresse(29, "Boumevard de l'Europe", 31700, "Blaganc");

        // 2. Banques
        Banque lcl = new Banque("LCL");
        Banque creditAgricole = new Banque("Crédit Agricole");
        Banque societeGenerale = new Banque("Société Générale");

        // 3. Clients
        Client client1 = new Client("Alex", "Marc", LocalDate.of(1990,01,10));
        Client client2 = new Client("Marine", "Furot", LocalDate.of(1980,02,20));
        Client client3 = new Client("Amir", "Samy", LocalDate.of(1995, 5, 30));;

        // 4. Comptes
        LivretA livret1 = new LivretA("1294338l",10019.12,0.05);
        AssuranceVie assurance1 = new AssuranceVie("x123333", 1000.00, LocalDate.of(2090,10,01),0.01);
        AssuranceVie assurance2 = new AssuranceVie("y123456", 20500.0, LocalDate.of(2081,01,01),0.014);
       
        // Virements
        Virement virement1= new Virement(LocalDateTime.of(2023, 9, 1, 11, 00), 500.0, "Achat en ligne", "Laura Lefebvre");
        Virement virement2 = new Virement(LocalDateTime.of(2023, 9, 3, 13, 30), 2000.0, "Salaire septembre", "Paul Moreau");
        Virement virement3 = new Virement(LocalDateTime.of(2023, 9, 4, 15, 45), 400.0, "Réservation vacances", "Sophie Durant");
        Virement virement4 = new Virement(LocalDateTime.of(2023, 9, 6, 17, 10), 75.0, "Remboursement repas", "Jean Girard");
        Virement virement5 = new Virement(LocalDateTime.of(2023, 9, 7, 10, 20), 250.0, "Don à une association", "Emma Lambert");

        // Set Adresses
        client1.setAdresse(adresse1);
        client2.setAdresse(adresse2);
        client3.setAdresse(adresse3);

        // Lier des banques aux clients
        client1.setBanque(lcl);
        client2.setBanque(creditAgricole);
        client3.setBanque(societeGenerale);

        // un compte peut être attribué à plusieurs clients (look: client 2 et 3)
        // Le client 1 aura 2 comptes
        // un compte associé au 2 clients : accurance 1
        client1.addCompte(livret1);
        client2.addCompte(assurance1);
        client3.addCompte(assurance1);
        client1.addCompte(assurance2);

        // Lier des virements aux comptes; à titre d'exemple seulement
        virement1.setCompte(livret1);
        virement2.setCompte(livret1);
        virement3.setCompte(assurance1);
        virement4.setCompte(livret1);
        virement5.setCompte(assurance1);

        // Persister les entités dans la base de données
        em.persist(lcl);
        em.persist(creditAgricole);
        em.persist(societeGenerale);
        em.persist(client1);
        em.persist(client2);
        em.persist(client3);
        em.persist(livret1);
        em.persist(assurance1);
        em.persist(assurance2);
        em.persist(virement1);
        em.persist(virement2);
        em.persist(virement3);
        em.persist(virement4);
        em.persist(virement5);

        // Valider la transaction
        em.getTransaction().commit();

        // Fermer l'EntityManager and l'EntityManagerFactory
        em.close();
        emf.close();

    }
}