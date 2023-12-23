package controllers;


import main.Main;
import models.Etudiant;
import models.Filiere;
import services.*;

public class EtudiantsController {
    public static void showMenu(){
        System.out.println("-------------------------[ Etudiants ]---------------------------");

        System.out.println("1: Pour ajouter un Etudiants");
        System.out.println("2: Pour afficher les Etudiants");
        System.out.println("3: Pour modifier un Etudiants");
        System.out.println("4: Pour supprimer un Etudiants");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createEtudiants();
                break;
            case 2:
                showEtudiants();
                break;
            case 3:
                editEtudiant();
                break;
            case 4:
                destroyEtudiant();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }
    public static void showEtudiants(){
        for (Etudiant etudiant : DB.etudiants) {
            System.out.print("Id : " + etudiant.getId());
            System.out.print(" | Nom : " + etudiant.getNom() + " | Prenom : " + etudiant.getPrenom());
            System.out.print(" | Email : " + etudiant.getEmail() );

//            if (! Main.isNull(departement.getChef())) {
//                System.out.print(" | Chef : " + departement.getChef().getNom() + " " + departement.getChef().getPrenom());
//            }
            System.out.println("");
        }
    }
    public static void createEtudiants(){
        // Demander à l'utilisateur les informations nécessaires pour créer un enseignant
        String nom = Main.getStringInput("Entrez le nom de l'etudiant :");
        String prenom = Main.getStringInput("Entrez le prénom de l'etudiant :");
        String email = Main.getStringInput("Entrez l'email de l'etudiant :");
        int apogee = Main.getIntInput("Entrez le grade de l'etudiant :");
        FilieresController.showFilieres();
        int filierID = Main.getIntInput("selectionner filiere de l'etudiant par Id:");
        Filiere filier = FiliereServices.getFiliereById(filierID);
        // Créer une instance d'Enseignant avec les informations fournies
        EtudiantServices.addEtd(nom, prenom, email, apogee, filier);

        showEtudiants();
        showMenu();


    }
    public static void editEtudiant(){
        showEtudiants();
        int id = Main.getIntInput("Sélecionnez un enseignant par id :");
        String nom = Main.getStringInput("Entrez le nom de l'etudiant :");
        String prenom = Main.getStringInput("Entrez le prénom de l'etudiant :");
        String email = Main.getStringInput("Entrez l'email de l'etudiant :");
        int apogee = Main.getIntInput("Entrez le grade de l'etudiant :");
        FilieresController.showFilieres();
        int filierID = Main.getIntInput("Entrez filiere de l'etudiant :");
        Filiere filier = FiliereServices.getFiliereById(filierID);

        EtudiantServices.updateEtd(id, nom, prenom, email, apogee, filier);

        showEtudiants();
        showMenu();
    }
    public static void destroyEtudiant(){
        showEtudiants();
        int id = Main.getIntInput("Sélecionnez un etudiant par id :");
        EtudiantServices.deleteEtdById(id);
        showEtudiants();

    }


}
