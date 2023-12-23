package services;

import models.Departement;
import models.Enseignant;

import java.util.ArrayList;

public class EnseignantServices {


    public static Enseignant addEns(String nom, String prenom, String email, String grade, Departement dept){
        Enseignant enseignant = new Enseignant();
        enseignant.setNom(nom);
        enseignant.setPrenom(prenom);
        enseignant.setEmail(email);
        enseignant.setGrade(grade);
        enseignant.setDept(dept);
        DB.enseignants.add(enseignant);
        return  new Enseignant();
    }

    public static Enseignant updateEns(int id, String nom, String prenom, String email, String grade, Departement dept){
        for (Enseignant enseignant : DB.enseignants) {
            if (enseignant.getId() == id) {
                // Mettez à jour les attributs de l'enseignant avec les nouvelles valeurs
                enseignant.setNom(nom);
                enseignant.setPrenom(prenom);
                enseignant.setEmail(email);
                enseignant.setGrade(grade);
                enseignant.setDept(dept);
                // Vous pouvez retourner l'enseignant mis à jour ou void selon vos besoins
                return enseignant;
            }
        }
        // Si l'ID n'est pas trouvé, vous pouvez choisir de lancer une exception, de retourner null, etc.
        return  new Enseignant();
    }
    public static ArrayList<Enseignant> deleteEnsById(int id){
        DB.enseignants.remove(getEnsById(id));
        return  DB.enseignants;
    }

    public static Enseignant getEnsById(int id){
        for (Enseignant enseignant : DB.enseignants) {
            if (enseignant.getId() == id) return  enseignant;
        }
        return  new Enseignant();
    }

    public static ArrayList<Enseignant> getAllEns(){

        return  DB.enseignants;
    }
}
