/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Evaluation;
import Service.EvaluationCrud;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class EvaluationController implements Initializable {

    @FXML
    private Button evaluer;
    @FXML
    private TextField connaisance_tf;
    @FXML
    private TextField formation_tf;
    @FXML
    private TextField outil_tf;
    @FXML
    private TextField total_tf;
    @FXML
    private TextField equip_tf;
    @FXML
    private TextField competance_tf;
    @FXML
    private TextField exp_tf;
    @FXML
    private Button retour;
    @FXML
    private TextField id;
    @FXML
    private Button accepte_btn;
    @FXML
    private Button refuse_btn;
    
    public void setid(String message) {
        this.id.setText(message);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
      Connection cnx2;
    @FXML
    private void evaluer(ActionEvent event) throws SQLException {
        int connaisance = Integer.parseInt(connaisance_tf.getText());
        int formation = Integer.parseInt(formation_tf.getText());
        int outil = Integer.parseInt(outil_tf.getText());
        int equipe = Integer.parseInt(equip_tf.getText());
        int comp = Integer.parseInt(competance_tf.getText());
        int exp = Integer.parseInt(exp_tf.getText());
        int totaln = connaisance + formation +outil+equipe+exp+comp;
        String total = String.valueOf(totaln);
        total_tf.setText(total);
        //System.out.println(total);
        
        int ide = Integer.parseInt(id.getText());
        EvaluationCrud ec = new EvaluationCrud();
        Evaluation e = new Evaluation(totaln,"Accepté");
        ;
        ec.ajouterEvaluation(ide,e);
        /*FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        try {
            Parent root = loader.load();
            HomeController hc = loader.getController();
            evaluer.getScene().setRoot(root);
            
            
        } catch (IOException ex) {
            Logger.getLogger(EvaluationController.class.getName()).log(Level.SEVERE, null, ex);
        }*/

        }

    @FXML
    private void retour(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
            Parent root = loader.load();
            retour.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());        }
        
    }

    @FXML
    private void accepte(ActionEvent event) {
        EvaluationCrud evc = new EvaluationCrud();
        
        int ide = Integer.parseInt(id.getText());
        evc.ajouterAvis(ide,"Accepté");
        
    }

    @FXML
    private void refuser(ActionEvent event) {
    }

    @FXML
    private void getID(ActionEvent event) {
    }
    
}
