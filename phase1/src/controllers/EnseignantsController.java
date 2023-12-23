package controllers;

import main.Main;
import models.Departement;
import models.Enseignant;
import services.DB;
import services.DepartementServices;
import services.EnseignantServices;

public class EnseignantsController {
    public static void showMenu(){
        System.out.println("-------------------------[ Enseignants ]---------------------------");

        System.out.println("1: Pour ajouter un Enseignant");
        System.out.println("2: Pour afficher les Enseignant");
        System.out.println("3: Pour modifier un Enseignant");
        System.out.println("4: Pour supprimer un Enseignant");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createEnseignant();
                break;
            case 2:
                showEnseignants();
                break;
            case 3:
                editEnseignant();
                break;
            case 4:
                destroyEnseignant();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }
    public static void showEnseignants(){
        for (Enseignant enseignant : DB.enseignants) {
            System.out.print("Id : " + enseignant.getId());
            System.out.print(" | Nom : " + enseignant.getNom() + " | Prenom : " + enseignant.getPrenom());
            System.out.print(" | Email : " + enseignant.getEmail() );
//            if (! main.Main.isNull(departement.getChef())) {
//                System.out.print(" | Chef : " + departement.getChef().getNom() + " " + departement.getChef().getPrenom());
//            }
            System.out.println("");
        }
//        showMenu();
    }
    public static void createEnseignant(){
        // Demander à l'utilisateur les informations nécessaires pour créer un enseignant
        String nom = Main.getStringInput("Entrez le nom de l'enseignant :");
        String prenom = Main.getStringInput("Entrez le prénom de l'enseignant :");
        String email = Main.getStringInput("Entrez l'email de l'enseignant :");
        String grade = Main.getStringInput("Entrez le grade de l'enseignant :");
        DepartementsController.showDepartements();
        int deptID = Main.getIntInput("Entrez departement de l'enseignant :");
        Departement dept = DepartementServices.getDeptById(deptID);
        // Créer une instance d'Enseignant avec les informations fournies
        EnseignantServices.addEns(nom, prenom, email, grade, dept);
        showEnseignants();
        showMenu();
    }
    public static void editEnseignant(){
        showEnseignants();
        int id = Main.getIntInput("Sélecionnez un enseignant par id :");
        String nom = Main.getStringInput("Entrez le nom de l'enseignant :");
        String prenom = Main.getStringInput("Entrez le prénom de l'enseignant :");
        String email = Main.getStringInput("Entrez l'email de l'enseignant :");
        String grade = Main.getStringInput("Entrez le grade de l'enseignant :");
        DepartementsController.showDepartements();
        int deptID = Main.getIntInput("Entrez departement de l'enseignant par id :");
        Departement dept = DepartementServices.getDeptById(deptID);
        EnseignantServices.updateEns(id , nom , prenom, email, grade, dept);
        showEnseignants();
        showMenu();
    }
    public static void destroyEnseignant(){
        showEnseignants();
        int id = Main.getIntInput("Sélecionnez un enseignant par id :");
        EnseignantServices.deleteEnsById(id);
        System.out.println("suppression avec succees.");
        showEnseignants();
        showMenu();
    }
}
