package controllers;

import main.Main;
import models.Departement;
import services.DB;
import services.DepartementServices;
import services.EnseignantServices;

public class DepartementsController {

    public static void showMenu(){
        System.out.println("-------------------------[ Départements ]---------------------------");

        System.out.println("1: Pour ajouter un département");
        System.out.println("2: Pour afficher les départements");
        System.out.println("3: Pour modifier un département");
        System.out.println("4: Pour supprimer un département");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createDepartement();
                break;
            case 2:
                showDepartements();
                break;
            case 3:
                editDepartement();
                break;
            case 4:
                destroyDepartement();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }
//    public static void showDepartements(){
//        for (Departement departement : DB.departements) {
//            System.out.print("Id : " + departement.getId());
//            System.out.print(" | Intitulé : " + departement.getIntitule());
//            if (! Main.isNull(departement.getChef())) {
//                System.out.print(" | Chef : " + departement.getChef().getNom() + " " + departement.getChef().getPrenom());
//            }
//            System.out.println("");
//        }
//
//    }
        public static void showDepartements() {
            if (!DB.departements.isEmpty()) {
                System.out.println("\nLes Departements sont : \n");
            for (Departement departement : DB.departements) {

                System.out.println("Id: " + departement.getId());
                System.out.println("Intitulé: " + departement.getIntitule());
                if (Main.isNull(departement.getChef())){
                    System.out.println("Chef: " + departement.getChef().getNom() + " " + departement.getChef().getPrenom());
                }
                System.out.println();  // Ajout d'une ligne vide pour séparer les départements
            }
        }else{
                System.out.println("vous avez supprimer tout les departements dans la base de donnees. ");
                showMenu();
            }

        }
    public static void createDepartement(){
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        EnseignantsController.showEnseignants();
        int id = Main.getIntInput("Sélecionnez un enseignant par id :");
        DepartementServices.addDept(intitule, EnseignantServices.getEnsById(id));
        showDepartements();
        showMenu();
    }
    public static void editDepartement(){
        showDepartements();
        int id = Main.getIntInput("Sélecionnez une departement par id :");
        String intitule = Main.getStringInput("Entrez Nouveau l'intitulé : ");
        EnseignantsController.showEnseignants();
        int idEns = Main.getIntInput("Sélecionnez un enseignant par id : ");
        DepartementServices.updateDept(id, intitule, EnseignantServices.getEnsById(idEns));
        showDepartements();
        showMenu();
    }
    public static void destroyDepartement(){
        showDepartements();
        int id = Main.getIntInput("Sélecionnez une departement par id :");
        DepartementServices.deleteDeptById(id);
        System.out.println("suppression avec succees. ");
        showDepartements();
        showMenu();
    }
}
