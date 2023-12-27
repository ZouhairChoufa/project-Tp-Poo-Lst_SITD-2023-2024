package main;

import models.Departement;
import models.Enseignant;

import java.sql.*;
import java.util.ArrayList;

public class GestionDeBaseDeDonnees {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/bdd-poo";
        String user = "root";
        String pwd = "";
        try {
            Connection cx = DriverManager.getConnection(url, user, pwd);
            System.out.println("Good connection");
/*==================  Creation du tableau ========================= */
//            createTableDept(cx);
//            createTableEns(cx);
/* =====================  Selection des donnees from les tableau << dept >>  ============================*/
           /*
            ArrayList<Departement> departements = selectdepartement(cx);
            System.out.println("\nles donner de departements sont suivant : \n");
            for (Departement departement : departements) {
                System.out.println(departement.toString()+"\t");
            }
            */
/* ========================  Selection des donnees from les tableau << enseignant >>  ============================*/
           /*
            ArrayList<Enseignant> enseignants = selectenseignat(cx);
            System.out.println("\nles donner de l'enseignant sont suivant : \n");
            for (Enseignant enseignant2 : enseignants) {
                System.out.println(enseignant2.toString());
            }
            */

/* ==========================  insertion des donnees dans tableau << dept val1>>  methode 1 ============================*/

              /*
              models.Departement departement = new models.Departement();

              departement.setId(departement.getId());
              departement.setIntitule("Informatique");

              models.Enseignant chefDepartement = new models.Enseignant();
              chefDepartement.setId(chefDepartement.getId());
              departement.setChef(chefDepartement);

              insertDept(departement, cx);
              */

/* ==========================  insertion des donnees dans tableau << dept val2>> methode 2 ============================*/

           /*
           .Departement departement = new models.Departement();
            departement.setId(departement.getId());
            departement.setIntitule("ELECTRIQUE");

            models.Enseignant chefDepartement = new models.Enseignant();
            chefDepartement.setId(chefDepartement.getId());
            departement.setChef(chefDepartement);

            insertDept(departement, cx);
            */
/* ==========================  insertion des donnees dans tableau << dept val3>> methode 3  ============================*/

            /*
            models.Departement departement = new models.Departement();
            departement.setId(departement.getId());
            departement.setIntitule("Mathematique Physique");

            models.Enseignant chefDepartement = new models.Enseignant();
            chefDepartement.setId(2);
            departement.setChef(chefDepartement);

            insertDept(departement, cx);
            */


/* ==========================  insertion des donnees dans tableau << Ens  val1>> methode 1  ============================*/

            /*
            models.Enseignant enseignant = new models.Enseignant();
            enseignant.setId(enseignant.getId());
            enseignant.setNom("Karim");
            enseignant.setPrenom("Ahmed");
            enseignant.setEmail("john.doe@example.com");
            enseignant.setGrade("Professeur");

            models.Departement departement = new models.Departement();
            departement.setId(1);
            enseignant.setDept(departement);

            insertEns(enseignant, cx);
            */

/* ==========================  insertion des donnees dans tableau << Ens val2 >> methode 2 ============================*/

            /*
            models.Enseignant enseignant = new models.Enseignant();
            enseignant.setId(enseignant.getId());
            enseignant.setNom("sami");
            enseignant.setPrenom("abdellah");
            enseignant.setEmail("hamdi.jiji@example.com");
            enseignant.setGrade("Stagere");

            models.Departement departement = new models.Departement();
            departement.setId(3);
            enseignant.setDept(departement);

            insertEns(enseignant, cx);
            */

//  ================================================== Update Ens from tab Enseignant ==================================================

            /*
            Enseignant enseignant = new Enseignant();
            enseignant.setId(4);
            enseignant.setNom("Moataz");
            enseignant.setPrenom("Ahmed");
            enseignant.setEmail("ahmed.moataz@example.com");
            enseignant.setGrade("Etudiant");
            updateEnseignant(enseignant, cx);
            */

            // affiche les donner pour verifier si les donner sont modifier ou non.

            /*
            ArrayList<Enseignant> enseignants1 = selectenseignat(cx);
            System.out.println("\nles donner de l'enseignant sont suivant : \n");
            for (Enseignant enseignant1 : enseignants1) {
                System.out.println(enseignant1.toString());
            }
            */

//  ================================================== Update Dept from tab Departement ==================================================

            /*
            Enseignant enseignant = new Enseignant();
            enseignant.setId(12);

            Departement departement = new Departement();
            departement.setId(5);
            departement.setIntitule("Marketing");
            departement.setChef(enseignant);
            updateDepartement(departement, cx);

            // affiche les donner pour verifier si les donner sont modifier ou non.

            ArrayList<Departement> departements1 = selectdepartement(cx);
            System.out.println("\nles donner de departements sont suivant : \n");
            for (Departement departement1 : departements1) {
                System.out.println(departement1.toString());
            }
             */

/* ==========================  delete un enseignant  par id from tableau enseignant  ============================*/

            /*
            deleteEnseignant(5, cx);
            */

/* ==========================  delete une departement par id from tableau departement  ============================*/

            /*
            deletedepartement(1, cx);
             */

        } catch (SQLException e) {
            System.out.println("Bad connection");
            e.printStackTrace();//Affiche le nom ou bien quelle errore que vous avez .
        }
    }

    public static void createTableDept(Connection cx) throws SQLException {
        String req = "create table IF NOT EXISTS Departement \n" +
                "(IdDept int auto_increment primary key, \n" +
                "intitulé varchar(50) charset utf8 null,\n" +
                "IdEns int,\n" +
                "foreign key (IdEns) references Enseignant (IdEns)\n" +
                ");";
        Statement stmt = cx.createStatement();
        stmt.execute(req);
        System.out.println("Tableau departement a été créé avec succès.");

    }
    public static void createTableEns(Connection cx) throws SQLException{
        String req1 = "create table IF NOT EXISTS Enseignant \n" +
                "(IdEns int auto_increment primary key, \n" +
                "nom varchar(50) charset utf8 null ,\n " +
                "prenom varchar(50) charset utf8 null ,\n" +
                "email varchar(50) charset utf8 null ,\n" +
                "grade varchar(50) charset utf8 null,\n" +
                "IdDept int,\n" +
                "foreign key (IdDept) references Departement (IdDept)\n" +
                ");";
        Statement smt = cx.createStatement();
        smt.execute(req1);
        System.out.println("Tableau enseignant a été créé avec succès.");
    }


    public static void insertDept(models.Departement depart, Connection cx) throws SQLException {
        String rep = "insert into Departement (IdDept, intitulé, IdEns) values(?,?,?)";
        PreparedStatement stmt = cx.prepareStatement(rep);
        stmt.setInt(1, depart.getId());
        stmt.setString(2, depart.getIntitule());
        stmt.setInt(3, depart.getChef().getId());
        stmt.execute();
        System.out.println("L'insertion est fait avec sucees . ");
    }

    public static void insertEns(models.Enseignant enseignant, Connection cx) throws SQLException {
        String rep1 = "insert into Enseignant (IdEns, nom, prenom, email, grade, IdDept) values (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = cx.prepareStatement(rep1);
        statement.setInt(1, enseignant.getId());
        statement.setString(2, enseignant.getNom());
        statement.setString(3, enseignant.getPrenom());
        statement.setString(4, enseignant.getEmail());
        statement.setString(5, enseignant.getGrade());
        statement.setInt(6, enseignant.getDept().getId());
        statement.execute();
        System.out.println("L'insertion est fait avec sucees . ");
    }


    public static ArrayList<Departement> selectdepartement(Connection cx) throws SQLException {
        String sql = "SELECT * FROM Departement";
        ArrayList<Departement> departement = new ArrayList<>();
        Statement statement = cx.createStatement();
        ResultSet rslt = statement.executeQuery(sql);
        while (rslt.next()) {
            Departement departement1 = new Departement();
            departement1.setId(rslt.getInt("IdDept"));
            departement1.setIntitule(rslt.getString("intitulé"));
            Enseignant chef = new Enseignant();
            chef.setId(rslt.getInt("IdEns"));
            departement1.setChef(chef);
            departement.add(departement1);
        }
        return departement;
    }

    public static ArrayList<Enseignant> selectenseignat(Connection cx) throws SQLException {
        String sql = "SELECT * FROM Enseignant";
        ArrayList<Enseignant> enseignants = new ArrayList<>();
        Statement statement = cx.createStatement();
        ResultSet rslt = statement.executeQuery(sql);
        while (rslt.next()) {
            Enseignant enseignant = new Enseignant();
            enseignant.setId(rslt.getInt("IdEns"));
            enseignant.setNom(rslt.getString("nom"));
            enseignant.setPrenom(rslt.getString("prenom"));
            enseignant.setEmail(rslt.getString("email"));
            enseignant.setGrade(rslt.getString("grade"));
            Departement dept = new Departement();
            dept.setId(rslt.getInt("IdDept"));
            enseignant.setDept(dept);
            enseignants.add(enseignant);
        }
        return enseignants;
    }

    public static void updateDepartement(Departement depart, Connection cx) throws SQLException {
        String rep = "UPDATE Departement SET intitulé = ?, IdEns = ? WHERE IdDept = ?";
        try (PreparedStatement stmt = cx.prepareStatement(rep)) {
            stmt.setString(1, depart.getIntitule());
            stmt.setInt(2, depart.getChef().getId());
            stmt.setInt(3, depart.getId());
            stmt.executeUpdate();
            System.out.println("Département modifié avec succès");
        }
    }

    public static void updateEnseignant(Enseignant enseignant, Connection cx) throws SQLException {
        String rep1 = "UPDATE Enseignant SET nom = ?, prenom = ?, email = ?, grade = ?, IdDept = ? WHERE IdEns = ?";
        try (PreparedStatement stmt = cx.prepareStatement(rep1)) {
            stmt.setString(1, enseignant.getNom());
            stmt.setString(2, enseignant.getPrenom());
            stmt.setString(3, enseignant.getEmail());
            stmt.setString(4, enseignant.getGrade());
            stmt.setInt(5, enseignant.getId());
            stmt.setInt(6, enseignant.getId());
            stmt.executeUpdate();
            System.out.println("Enseignant modifié avec succès");
        }
    }

    public static void deletedepartement(int id, Connection cx) throws SQLException {
        String query = "DELETE FROM Departement WHERE IdDept = ?";
        PreparedStatement ps = cx.prepareStatement(query);
        ps.setInt(1, id);
        ps.execute();
        System.out.println("delete de Departement de l'id : " + id + " ,est fait avec success.");
    }
    public static void deleteEnseignant(int id, Connection cx) throws SQLException {
        String query = "DELETE FROM Enseignant WHERE IdEns = ?";
        PreparedStatement ps = cx.prepareStatement(query);
            ps.setInt(1, id);
            ps.execute();
        System.out.println("delete de Enseignant de l'id : " + id + " est fait avec success.");
    }
}

