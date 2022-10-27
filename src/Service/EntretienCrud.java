/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Entretien;
import utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class EntretienCrud {
    Connection cnx2;
    public EntretienCrud(){
        cnx2 = MyConnection.getInstance().getCnx();
    }
 
    
    public void ajouterEntretien(Entretien E){
        
        try {
            String req = "INSERT INTO `entretien`(`firstname_candidat`, `name_candidat`, `heure`, `person_present`, `date_entretien`) VALUES (?,?,?,?,?)";
            //String req2 = "INSERT INTO `evaluation` (`id_evaluation`,`avis`) VALUES (?,?)";
            PreparedStatement pst = cnx2.prepareStatement(req);
            //PreparedStatement pst2 = cnx2.prepareStatement(req2);
            pst.setString(1, E.getFirstname_candidat());
            pst.setString(2, E.getName_candidat());
            pst.setString(3, E.getHeure());
            pst.setString(4, E.getPerson_present());
            pst.setDate(5,E.getDate_entretien());
            //pst2.setInt(1, E.getId_entretien());
            //pst2.setString(2, "");

            pst.executeUpdate();
            //pst2.executeUpdate();
            
            System.out.println("Entretien ajoutée avec succès !");
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void modifierEntretien(int id,Entretien E){
        String req="UPDATE `entretien` SET `id_candidat`=?,`firstname_candidat`=?,`name_candidat`=?,`heure`=?,`person_present`=?,`date_entretien`=? WHERE `id_entretien`=?";
        try{
            PreparedStatement pst;
            pst = cnx2.prepareStatement(req);
            pst.setInt(1, E.getId_candidat());
            pst.setString(2, E.getFirstname_candidat());
            pst.setString(3, E.getName_candidat());
            pst.setString(4, E.getHeure());
            pst.setString(5, E.getPerson_present());
            pst.setDate(6,E.getDate_entretien());
            pst.setInt(7,id);
            pst.executeUpdate();
            System.out.println("updated successfully");
            
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
    
     public void supprimerEntretien(int id){
        String req="DELETE FROM `entretien` WHERE `id_entretien`=?";
        try{
            PreparedStatement pst;
            pst = cnx2.prepareStatement(req);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("deleted successfully");
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
     
     public List<Entretien> afficherEntretien(){
        List<Entretien> myList = new ArrayList<>();
        try {
            
            String req="SELECT * FROM `entretien`";
            Statement st=cnx2.createStatement();
            ResultSet rs=st.executeQuery(req);
            while(rs.next()){
                Entretien E = new Entretien();
                E.setId_entretien(rs.getInt("id_entretien"));
                E.setId_candidat(rs.getInt("id_candidat"));
                E.setFirstname_candidat(rs.getString("firstname_candidat"));
                E.setName_candidat(rs.getString("name_candidat"));
                E.setHeure(rs.getString("heure"));
                E.setPerson_present(rs.getString("person_present"));
                E.setDate_entretien(rs.getDate("date_entretien"));
                myList.add(E);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
}
