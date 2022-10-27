/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Entretien;
import Entities.Evaluation;
import Service.EntretienCrud;
import Service.EvaluationCrud;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class HomeController implements Initializable {

    @FXML
    private TableView<Entretien> home;

    @FXML
    private TableColumn<Entretien, Integer> id_col;
    @FXML
    private TableColumn<Entretien, Integer> id_candidat_col;
    @FXML
    private TableColumn<Entretien, String> name_col;
    @FXML
    private TableColumn<Entretien, String> firstname_col;
    @FXML
    private TableColumn<Entretien, String> date_col;
    @FXML
    private TableColumn<Entretien, String> hour_col;
    @FXML
    private TableColumn<Entretien, String> participant_col;
    @FXML
    private Button add_btn;
    @FXML
    private Button delete_btn;
    @FXML
    private Button modifier_btn;
    @FXML
    private TextField name_label;
    @FXML
    private TextField firstname_label;
    @FXML
    private TextField year_label;
    @FXML
    private TextField hour_label;
    @FXML
    private TextField month_label;
    @FXML
    private TextField day_label;
    @FXML
    private TextField participant_label;
    @FXML
    private TableColumn<Evaluation, String> avis_col;
    @FXML
    private TableView<Evaluation> home2;
    @FXML
    private Button evaluer_btn;
    @FXML
    private TableColumn<Evaluation, String> note_col;
    @FXML
    private TextField id_entretien_tf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadTableEntretien();
        loadTableEvaluation();
    }
    ObservableList<Entretien> oblistz = FXCollections.observableArrayList();
    ObservableList<Evaluation> oblista = FXCollections.observableArrayList();

    EntretienCrud enc = new EntretienCrud();
    EvaluationCrud ec = new EvaluationCrud();

    private void loadTableEvaluation() {
        List<Evaluation> lev = ec.afficherEvaluation();
        lev.forEach(e -> oblista.add(e));
        note_col.setCellValueFactory(new PropertyValueFactory<>("note"));
        avis_col.setCellValueFactory(new PropertyValueFactory<>("avis"));
        home2.setItems(oblista);
    }

    private void loadTableEntretien() {
        List<Entretien> len = enc.afficherEntretien();
        len.forEach(e -> oblistz.add(e));
        id_col.setCellValueFactory(new PropertyValueFactory<>("id_entretien"));
        id_candidat_col.setCellValueFactory(new PropertyValueFactory<>("id_candidat"));
        name_col.setCellValueFactory(new PropertyValueFactory<>("name_candidat"));
        firstname_col.setCellValueFactory(new PropertyValueFactory<>("firstname_candidat"));
        date_col.setCellValueFactory(new PropertyValueFactory<>("date_entretien"));
        hour_col.setCellValueFactory(new PropertyValueFactory<>("heure"));
        participant_col.setCellValueFactory(new PropertyValueFactory<>("person_present"));

        home.setItems(oblistz);
    }

    public void clear() {

        name_label.setText("");
        firstname_label.setText("");
        hour_label.setText("");
        year_label.setText("");
        month_label.setText("");
        day_label.setText("");
        participant_label.setText("");

    }

    @FXML
    private void add_entretien(ActionEvent event) {

        String name = name_label.getText();
        String firstname = firstname_label.getText();
        String heure = hour_label.getText();
        int year = Integer.parseInt(year_label.getText());
        int month = Integer.parseInt(month_label.getText());
        int day = Integer.parseInt(day_label.getText());
        String participant = participant_label.getText();

        if (1900 < year && year < 2022 && 0 < month && 13 > month && 32 > day && 0 < day) {
            year = year - 1900;
            month = month - 1;
        }
        //Evaluation ev = new Evaluation("");
        Entretien e = new Entretien(name, firstname, heure, participant, new Date(year, month, day));
        EntretienCrud enc = new EntretienCrud();
        //EvaluationCrud ec = new EvaluationCrud();

        enc.ajouterEntretien(e);
        //loadTableEntretien();
        //loadTableEvaluation();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
            Parent root = loader.load();
            add_btn.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }
        
    }

    @FXML
    private void delete_entretien(ActionEvent event) {
        Entretien en = home.getSelectionModel().getSelectedItem();
        Evaluation ev = home2.getSelectionModel().getSelectedItem();
        String sql = "DELETE FROM `entretien` WHERE `id_entretien` = '" + en.getId_entretien() + "'";
        String req="DELETE FROM `evaluation` WHERE `id_entretien`= '"+en.getId_entretien()+"'";
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("confirmer la suppression?");

        Optional<ButtonType> buttonType = alert.showAndWait();

        if (buttonType.get() == ButtonType.OK) {

            try {
                EntretienCrud enc = new EntretienCrud();
                enc.supprimerEntretien(en.getId_entretien());
                EvaluationCrud evc = new EvaluationCrud();
                evc.supprimerEvaluation(en.getId_entretien());
                clear();
                loadTableEntretien();
                loadTableEvaluation();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
                Parent root = loader.load();
                delete_btn.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }

    }

    Connection cnx2;

    @FXML
    private void modify_entretien(ActionEvent event) {
        Entretien en = home.getSelectionModel().getSelectedItem();
        String name = name_label.getText();
        String firstname = firstname_label.getText();
        String heure = hour_label.getText();
        int year = Integer.parseInt(year_label.getText());
        int month = Integer.parseInt(month_label.getText());
        int day = Integer.parseInt(day_label.getText());
        String participant = participant_label.getText();

        if (1900 < year && year < 2022 && 0 < month && 13 > month && 32 > day && 0 < day) {
            year = year - 1900;
            month = month - 1;
        }

        Entretien e = new Entretien(name, firstname, heure, participant, new Date(year, month, day));
        EntretienCrud ec = new EntretienCrud();
        ec.modifierEntretien(en.getId_entretien(), e);
        clear();
        //showData();
        loadTableEntretien();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
            Parent root = loader.load();
            modifier_btn.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }

    }
    String id;
    @FXML
    private void selectApp(MouseEvent event) {
        Entretien app = home.getSelectionModel().getSelectedItem();
        DateFormat dfYear = new SimpleDateFormat("yyyy");
        DateFormat dfMonth = new SimpleDateFormat("MM");
        DateFormat dfDay = new SimpleDateFormat("dd");
        String sy = dfYear.format(app.getDate_entretien());
        String sm = dfMonth.format(app.getDate_entretien());
        String sd = dfDay.format(app.getDate_entretien());
        int index = home.getSelectionModel().getSelectedIndex();
        
        id_entretien_tf.setText(id_col.getCellData(index).toString());
        id =id_col.getCellData(index).toString();
        name_label.setText(name_col.getCellData(index));
        firstname_label.setText(firstname_col.getCellData(index));
        hour_label.setText(hour_col.getCellData(index));
        year_label.setText(sy);
        month_label.setText(sm);
        day_label.setText(sd);
        participant_label.setText(participant_col.getCellData(index));

    }

  

    @FXML
    public void evaluer(ActionEvent event) {
        Entretien app = home.getSelectionModel().getSelectedItem();

        //int toEvaluer = Integer.parseInt(String.valueOf(app.getId_entretien()));
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Evaluation.fxml"));
            Parent root = loader.load();
            EvaluationController evc = loader.getController();
            evc.setid(id);
            evaluer_btn.getScene().setRoot(root);
            //EvaluationCrud ec = new EvaluationCrud();
            //Evaluation e = new Evaluation(toEvaluer);
            //ec.ajouterEvaluation(e);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
