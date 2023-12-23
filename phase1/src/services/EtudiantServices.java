package services;

import models.Etudiant;
import models.Filiere;

import java.util.ArrayList;

public class EtudiantServices {
    public static Etudiant addEtd(String nom, String prenom, String email, int apogee, Filiere filiere){
        Etudiant etudiant = new Etudiant();
        etudiant.setNom(nom);
        etudiant.setPrenom(prenom);
        etudiant.setEmail(email);
        etudiant.setApogee(apogee);
        etudiant.setFiliere(filiere);
        return  etudiant;
    }

    public static Etudiant updateEtd(int id, String nom, String prenom, String email, int apogee, Filiere filiere){
        for (Etudiant etudiant : DB.etudiants) {
            if (etudiant.getId() == id) {
                // Mettez à jour les attributs de l'enseignant avec les nouvelles valeurs
                etudiant.setNom(nom);
                etudiant.setPrenom(prenom);
                etudiant.setEmail(email);
                etudiant.setApogee(apogee);
                etudiant.setFiliere(filiere);
                // Vous pouvez retourner l'enseignant mis à jour ou void selon vos besoins
                return etudiant;
            }
        }
        return  new Etudiant();
    }
    public static ArrayList<Etudiant> deleteEtdById(int id){
        DB.etudiants.remove(getEtdById(id));
        return  DB.etudiants;
    }

    public static Etudiant getEtdById(int id){
        for (Etudiant etudient : DB.etudiants) {
            if (etudient.getId() == id) return  etudient;
        }
        return  new Etudiant();
    }

    public static ArrayList<Etudiant> getAllEtd(){
        return  DB.etudiants;
    }
}
