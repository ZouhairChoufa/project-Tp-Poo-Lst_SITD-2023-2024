package main;

import controllers.*;
import models.Departement;
import models.Enseignant;
import services.DB;

import java.util.Scanner;

import static services.DB.getEnsId;


public class Main {
    public static boolean isNull(Object ob) {
        return ob != null;
    }

    public static int getIntInput(String... msg) {
        Scanner scan = new Scanner(System.in);
        String message = "Entrez un nombre entier : ";
        if (msg.length > 0)
            message = msg[0];
        System.out.print(message);

        // This method reads the number provided using keyboard
        int num = scan.nextInt();

        // Closing Scanner after the 1

//        scan.close();
        return num;
    }

    public static String getStringInput(String... msg) {
        Scanner scan = new Scanner(System.in);
        String message = "Entrez un texte : ";
        if (msg.length > 0)
            message = msg[0];
        System.out.print(message);

        // This method reads the String provided using keyboard
        String str = scan.nextLine();

        // Closing Scanner after the use
//          scan.close();
        return str;
    }

    public static void showPrincipalMenu() {
        System.out.println("-------------------------[ Bienvenu ]---------------------------");


        System.out.println("1: Pour gérer les départements");
        System.out.println("2: Pour gérer les filières");
        System.out.println("3: Pour gérer les enseignants");
        System.out.println("4: Pour gérer les modules");
        System.out.println("5: Pour gérer les étudiants");
        System.out.println("0: Pour sortir");

        //"Veuillez sélectionner une option : ")
        int option = getIntInput("Veuillez sélectionner une option : ");
        switch (option) {
            case 1:
                DepartementsController.showMenu();
                break;
            case 2:
                FilieresController.showMenu();
                break;
            case 3:
                EnseignantsController.showMenu();
                break;
            case 4:
                ModulesController.showMenu();
                break;
            case 5:
                EtudiantsController.showMenu();
                break;
            default:
                // code block
        }
    }

    public static void main(String[] args) {

        Enseignant enseignant = new Enseignant();
        enseignant.setNom("Amine");
        enseignant.setPrenom("Ben Charif");
        enseignant.setEmail("test@gmail.com");
        enseignant.setGrade("PES");
        enseignant.setId(getEnsId());
        DB.enseignants.add(enseignant);

        Enseignant enseignant1 = new Enseignant();
        enseignant1.setNom("ait said");
        enseignant1.setPrenom("Mehdi");
        enseignant1.setEmail("Mehdi.Aitsait@gmail.com");
        enseignant1.setGrade("Pof");
        enseignant1.setId(getEnsId());
        DB.enseignants.add(enseignant1);

        Departement departement = new Departement();
        departement.setChef(enseignant);
        departement.setIntitule("Parcoure MIP");
        departement.setId(DB.getDeptId());
        DB.departements.add(departement);

        showPrincipalMenu();
    }
}