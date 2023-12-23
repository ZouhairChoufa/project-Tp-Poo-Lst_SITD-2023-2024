package controllers;

//public class ModulesController {
//}
import main.Main;
import models.Enseignant;
import models.Filiere;
import models.Module;
import services.DB;
import services.FiliereServices;
import services.ModuleServices;
import services.EnseignantServices;

public class ModulesController {

    public static void showMenu() {
        System.out.println("-------------------------[ Modules ]---------------------------");

        System.out.println("1: Pour ajouter un module");
        System.out.println("2: Pour afficher les modules");
        System.out.println("3: Pour modifier un module");
        System.out.println("4: Pour supprimer un module");
        System.out.println("0: Pour retourner au menu principal");

        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch (option) {
            case 1:
                createModule();
                break;
            case 2:
                showModules();
                break;
            case 3:
                editModule();
                break;
            case 4:
                destroyModule();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }

    public static void showModules() {
        for (Module module : DB.modules) {
            System.out.print("Id : " + module.getId());
            System.out.print(" | Intitulé : " + module.getIntitule());
            if (Main.isNull(module.getChef())) {
                System.out.print(" | Enseignant : " + module.getChef().getNom() + " " + module.getChef().getPrenom());
            }
            System.out.println("");
        }
    }

    public static void createModule() {
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        EnseignantsController.showEnseignants();
        int idens = Main.getIntInput("Sélectionnez un enseignant par id :");
        Enseignant enseg = EnseignantServices.getEnsById(idens);
        FilieresController.showFilieres();
        int filierID = Main.getIntInput("selectionner filiere de l'etudiant par Id:");
        Filiere filier = FiliereServices.getFiliereById(filierID);
        ModuleServices.addModule(intitule, enseg, filier);
        showModules();
        showMenu();
    }
    public static void editModule() {
        showModules();
        int id = Main.getIntInput("Sélectionnez un module par id :");
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        EnseignantsController.showEnseignants();
        int idEns = Main.getIntInput("Sélectionnez un enseignant par id :");
        Enseignant enseignant = EnseignantServices.getEnsById(idEns);
        FilieresController.showFilieres();
        int filierID = Main.getIntInput("selectionner filiere de l'etudiant par Id:");
        Filiere filier = FiliereServices.getFiliereById(filierID);
        ModuleServices.updateModule(id, intitule, enseignant, filier);
        showModules();
        showMenu();
    }

    public static void destroyModule() {
        showModules();
        int id = Main.getIntInput("Sélectionnez un module par id :");
        ModuleServices.deleteModuleById(id);
        showModules();
    }
}

