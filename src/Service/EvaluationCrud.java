/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Evaluation;
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
public class EvaluationCrud {
    Connection cnx2;
    public EvaluationCrud(){
        cnx2 = MyConnection.getInstance().getCnx();
    }
    
    public void ajouterEvaluation(int id,Evaluation E){
        try {
            String req = "INSERT INTO `evaluation` (`id_entretien`,`note`,`avis`) VALUES (?,?,?)";
            
            PreparedStatement pst = cnx2.prepareStatement(req);
            //pst.setInt(1, E.getId_evaluation());
            pst.setInt(2, E.getNote());
            pst.setString(3, E.getAvis());
            pst.setInt(1,id);
            
            

            pst.executeUpdate();
            System.out.println("Evaluation ajoutée avec succès !");
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public void ajouterAvis(int id ,String a){
        try {
            String req = "UPDATE `evaluation` SET (`avis`) VALUES (?) WHERE `id_evntretien=?`";
            
            PreparedStatement pst = cnx2.prepareStatement(req);
            //pst.setInt(1, E.getId_evaluation());
            pst.setString(1, a);
            pst.setInt(2, id);
            pst.executeUpdate();
            System.out.println("Avis ajoutée avec succès !");
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void modifierEvaluation(int id,Evaluation E){
        String req="UPDATE `evaluation` SET `note`=?,`avis`=? WHERE `id_entretien`=?";
        try{
            PreparedStatement pst;
            pst = cnx2.prepareStatement(req);
            pst.setInt(1, E.getNote());
            pst.setString(2, E.getAvis());
            pst.setInt(3, id);
            
            pst.executeUpdate();
            System.out.println("updated successfully");
            
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public void modifierEvaluation1(int id,Evaluation E){
        String req="UPDATE `evaluation` SET `id_evaluation`=?,`avis`=? WHERE `id_evaluation`=?";
        try{
            PreparedStatement pst;
            pst = cnx2.prepareStatement(req);
            pst.setInt(1, E.getId_evaluation());
            pst.setString(2, E.getAvis());
            pst.setInt(3, id);
            
            pst.executeUpdate();
            System.out.println("updated successfully");
            
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public void supprimerEvaluation(int id){
        String req="DELETE FROM `evaluation` WHERE `id_entretien`=?";
        try{
            PreparedStatement pst;
            pst = cnx2.prepareStatement(req);
            pst.setInt(1,id);
            pst.executeUpdate();
            System.out.println("deleted successfully");
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
     
     public List<Evaluation> afficherEvaluation(){
        List<Evaluation> myList = new ArrayList<>();
        try {
            
            String req="SELECT `note`,`avis` FROM `evaluation`";
            Statement st=cnx2.createStatement();
            ResultSet rs=st.executeQuery(req);
            while(rs.next()){
                Evaluation E=new Evaluation();
              
                E.setNote(rs.getInt("note"));
                E.setAvis(rs.getString("avis"));
                myList.add(E);
                System.out.println(myList);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
}
