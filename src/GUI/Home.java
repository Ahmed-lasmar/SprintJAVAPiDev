/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author HP
 */
public class Home extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Parent root= FXMLLoader.load(getClass().getResource("Home.fxml"));
            Scene scene = new Scene(root, 1000, 600);
            primaryStage.setTitle("Hello World!");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
        //MailServiceImpl.mailsent("racem.benamar@esprit.tn","Fixation date et heure entreiten","Bonjour Mr/Mme, \n votre entretien est fixé au date 26/08/2022 à 14h \n cordialement.");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
 