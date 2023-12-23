package controllers;

//public class FilieresController {
//}
import main.Main;
import models.Departement;
import models.Enseignant;
import models.Filiere;
import services.DB;
import services.DepartementServices;
import services.FiliereServices;
import services.EnseignantServices;

public class FilieresController {

    public static void showMenu() {
        System.out.println("-------------------------[ Filieres ]---------------------------");

        System.out.println("1: Pour ajouter une filiere");
        System.out.println("2: Pour afficher les filieres");
        System.out.println("3: Pour modifier une filiere");
        System.out.println("4: Pour supprimer une filiere");
        System.out.println("0: Pour retourner au menu principal");

        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch (option) {
            case 1:
                createFiliere();
                break;
            case 2:
                showFilieres();
                break;
            case 3:
                editFiliere();
                break;
            case 4:
                destroyFiliere();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }

    public static void showFilieres() {
        for (Filiere filiere : DB.filieres) {
            System.out.print("Id : " + filiere.getId());
            System.out.print(" | Intitulé : " + filiere.getIntitule());
            if (Main.isNull(filiere.getChef())) {
                System.out.print(" | Chef : " + filiere.getChef().getNom() + " " + filiere.getChef().getPrenom());
            }
            System.out.println("");
        }
    }

    public static void createFiliere() {
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        EnseignantsController.showEnseignants();
        int id = Main.getIntInput("Sélectionnez un enseignant chef de filier par id :");
        Enseignant ensen = EnseignantServices.getEnsById(id);
        DepartementsController.showDepartements();
        int deptID = Main.getIntInput("Entrez departement de l'enseignant :");
        Departement dept = DepartementServices.getDeptById(deptID);
        // Créer une instance d'Enseignant avec les informations fournies
        FiliereServices.addFiliere(intitule, ensen, dept);
        showFilieres();
        showMenu();
    }

    public static void editFiliere() {
        showFilieres();
        int id = Main.getIntInput("Sélectionnez une filiere par id :");
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        EnseignantsController.showEnseignants();
        int idEns = Main.getIntInput("Sélectionnez un enseignant par id :");
        Enseignant ensen = EnseignantServices.getEnsById(idEns);
        DepartementsController.showDepartements();
        int deptID = Main.getIntInput("Entrez departement de l'enseignant :");
        Departement dept = DepartementServices.getDeptById(deptID);

        FiliereServices.updateFiliere(id, intitule, ensen,dept);

        showFilieres();
        showMenu();
    }

    public static void destroyFiliere() {
        showFilieres();
        int id = Main.getIntInput("Sélectionnez une filiere par id :");
        FiliereServices.deleteFiliereById(id);
        showFilieres();
    }
}
