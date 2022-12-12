/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import service.FicheDePaieCRUD;
import Model.*;
import Service.PrimeCRUD;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import Entities.Entretien;
import Entities.Evaluation;
import GUI_Client.MailServiceImpl;
import Model.fiche_de_paie;
import Model.prime;
import Service.EntretienCrud;
import Service.EvaluationCrud;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Congé;
import models.Application;
import models.OffreEmploi;
import service.CongeCrud;
import utils.MyConnection;
import Mailing.Mailing;
import entities.formateur;
import entities.formation;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import service.formateurCRUD;
import service.formationCRUD;
/**
 * FXML Controller class
 *
 * @author radhw
 */
public class BackOfficeController implements Initializable {

    @FXML
    private HBox searchbox;
    @FXML
    private TextField champ_recherche;
    @FXML
    private ImageView searchicon;
    @FXML
    private TableView<Application> table_view;
    @FXML
    private TableColumn<Application, Integer> col_ida;
    @FXML
    private TableColumn<Application, String> col_candidat;
    @FXML
    private TableColumn<Application, String> col_offre;
    @FXML
    private TableColumn<Application, String> col_cv;
    @FXML
    private TableColumn<Application, String> col_etat;
    @FXML
    private AnchorPane left_main;
    @FXML
    private TextField idlaba;
    @FXML
    private TextField candlab;
    @FXML
    private TextField offlab;
    @FXML
    private ComboBox<?> etat;
    @FXML
    private ImageView image_viewa;
    @FXML
    private Button insert_image;
    @FXML
    private Label file_path;
    @FXML
    private Button addbtn;
    @FXML
    private Button updatebtn;
    @FXML
    private Button deletebtn;

    /**
     * Initializes the controller class.
     */
    private String[] comboetat = {"Accepté(e)", "Refusé(e)"};
    @FXML
    private HBox gestionoffres;
    @FXML
    private HBox gestionapp;
    @FXML
    private TableView<OffreEmploi> table_view1;
    @FXML
    private TableColumn<OffreEmploi, Integer> col_id;
    @FXML
    private TableColumn<OffreEmploi, String> col_nom;
    @FXML
    private TableColumn<OffreEmploi, String> col_desc;
    @FXML
    private TableColumn<OffreEmploi, String> col_skills;
    @FXML
    private TableColumn<OffreEmploi, String> col_picture;
    @FXML
    private AnchorPane left_main1;
    @FXML
    private ComboBox<?> skills;
    @FXML
    private TextField idlab;
    @FXML
    private TextField nomlab;
    @FXML
    private TextField desclab;
    @FXML
    private ImageView image_view;
    @FXML
    private Button insert_image1;
    @FXML
    private Label file_path1;
    @FXML
    private Button butAjout;
    @FXML
    private Button butModif;
    @FXML
    private Button buttSupp;
    @FXML
    private AnchorPane appadmin;
    @FXML
    private AnchorPane offreadmin;
    private String[] comboSkills = {"Java", "Javascript", "Python", "PHP", "C"};
    @FXML
    private HBox GesCon;
    @FXML
    private HBox gestionapp1;
    @FXML
    private AnchorPane HomeC;
    @FXML
    private TableView<Congé> tab;
    @FXML
    private TableColumn<Congé, Integer> c1;
    @FXML
    private TableColumn<Congé, Integer> c2;
    @FXML
    private TableColumn<Congé, Date> c3;
    @FXML
    private TableColumn<Congé, String> c4;
    @FXML
    private TableColumn<Congé, String> c5;
    @FXML
    private TableColumn<Congé, Date> c6;
    @FXML
    private TableColumn<Congé, Date> c7;
    @FXML
    private DatePicker date_textfield;
    @FXML
    private Label id_fp_label;
    @FXML
    private Label id_per_label;
    @FXML
    private Label salaire_init_label;
    @FXML
    private Label id_prime_label;
    @FXML
    private TextField total_textfield;
    @FXML
    private TextField etat_textfield;
    @FXML
    private TextField id_fp_textfield;
    @FXML
    private Label salaire_total_label;
    @FXML
    private Label date_paiement_label;
    @FXML
    private Label etat_paiement_label;
    @FXML
    private TextField id_per_textfield;
    @FXML
    private TextField init_textfield;
    @FXML
    private TextField prime_textfield;
    @FXML
    private Button Statistique;
    @FXML
    private Button ajouter;
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
    @FXML
    private TableView<fiche_de_paie> paiement_tableau;
    @FXML
    private TableColumn<fiche_de_paie, Integer> id_fp_colonne;
    @FXML
    private TableColumn<fiche_de_paie, Integer> id_per_colonne;
    @FXML
    private TableColumn<fiche_de_paie, Integer> salaire_init_colonne;
    @FXML
    private TableColumn<fiche_de_paie, Integer> id_prime_colonne;
    @FXML
    private TableColumn<fiche_de_paie, Integer> salaire_total_colonne;
    @FXML
    private TableColumn<fiche_de_paie, DatePicker> date_paiement_colonne;
    @FXML
    private TableColumn<fiche_de_paie, String> etat_paiement_colonne;
    @FXML
    private ComboBox<String> trie_combobox_1;
    @FXML
    private Button button_croissant;
    @FXML
    private Button button_decroissant;
    @FXML
    private HBox gestionPai;
    @FXML
    private AnchorPane GesPai;
    @FXML
    private Button ajouter_prime_2;
    @FXML
    private Button supprimer_prime_2;
    @FXML
    private Button modifier_prime_2;
    @FXML
    private Label id_prime_label_2;
    @FXML
    private Label type_prime_label_2;
    @FXML
    private Label valeur_prime_label_2;
    @FXML
    private Label date_prime_label_2;
    @FXML
    private TextField id_prime_textfield_2;
    @FXML
    private TextField valeur_prime_textfield_2;
    @FXML
    private TextField type_prime_textfield_2;
    @FXML
    private TableView<prime> tableau_prime_2;
    @FXML
    private TableColumn<prime, Integer> id_prime_colonne_2;
    @FXML
    private TableColumn<prime, String> type_prime_colonne_2;
    @FXML
    private TableColumn<prime, Integer> valeur_prime_colonne_2;
    @FXML
    private TableColumn<prime, DatePicker> date_prime_colonne_2;
    @FXML
    private DatePicker date_prime_textfield_2;
    @FXML
    private Label nombre_heure_2;
    @FXML
    private TextField nombre_heure_textfield_2;
    @FXML
    private HBox gestionPrime;
    @FXML
    private AnchorPane GePrime;
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
    private TextField year_label;
    @FXML
    private TextField firstname_label;
    @FXML
    private TextField hour_label;
    @FXML
    private TextField month_label;
    @FXML
    private TextField day_label;
    @FXML
    private TextField participant_label;
    @FXML
    private Button evaluer_btn;
    @FXML
    private TableView<Evaluation> home2;
    @FXML
    private TableColumn<Evaluation, String> note_col;
    @FXML
    private TableColumn<Evaluation, String> avis_col;
    @FXML
    private TextField id_entretien_tf;
    @FXML
    private HBox gestionentretien;
    @FXML
    private AnchorPane geentretien;
    @FXML
    private HBox gestionformateurs;
    @FXML
    private HBox gestionformations;
    private AnchorPane geformation;
    @FXML
    private Button btnModif;
    @FXML
    private Button btnSup;
    @FXML
    private Button btnAjouter;
    @FXML
    private TableView<formation> Table_Formations;
    @FXML
    private TableColumn<formation, Integer> a_ID;
    @FXML
    private TableColumn<formation, Integer> a_IDF;
    @FXML
    private TableColumn<formation, String> a_Nom;
    @FXML
    private TableColumn<formation, DatePicker> a_Date;
    @FXML
    private TableColumn<formation, Integer> a_NC;
    @FXML
    private Button btn_stat;
    @FXML
    private DatePicker dpDate;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfNum;
    @FXML
    private TextField tfIDF;
    @FXML
    private TextField tfID;
    @FXML
    private Button btn_RechercheID;
    @FXML
    private TextField Id_Recherchetf;
    @FXML
    private AnchorPane geformateur;
    @FXML
    private TextField nomA;
    @FXML
    private TextField prenomA;
    @FXML
    private TextField adresseA;
    @FXML
    private TextField emailA;
    @FXML
    private TextField telA;
    @FXML
    private TextField CPA;
    @FXML
    private TextField VilleA;
    @FXML
    private TextField payA;
    @FXML
    private TextField statusA;
    @FXML
    private TextField tarifA;
    @FXML
    private TextField tvaA;
    @FXML
    private TextField bioA;
    @FXML
    private TextField diplomeA;
    @FXML
    private TableView<formateur> Table_Formateur;
     @FXML
    private TableColumn<formateur, Integer> idCA;
    @FXML
    private TableColumn<formateur, String> nomCA;
    @FXML
    private TableColumn<formateur, String> prenomCA;
    @FXML
    private TableColumn<formateur, String> adresseCA;
    @FXML
    private TableColumn<formateur, String> emailCA;
    @FXML
    private TableColumn<formateur, Integer> telCA;
    @FXML
    private TableColumn<formateur, Integer> codePCA;
    @FXML
    private TableColumn<formateur, String> villeCA;
    @FXML
    private TableColumn<formateur, String> payCA;
    @FXML
    private TableColumn<formateur, String> statusCA;
    @FXML
    private TableColumn<formateur, Integer> terifCA;
    @FXML
    private TableColumn<formateur, Integer> tvaCA;
    @FXML
    private TableColumn<formateur, String> bioCA;
    @FXML
    private TableColumn<formateur, String> diplomeCA;
    @FXML
    private AnchorPane geformation1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboboxa();
        showData();
        comboBox();
        showDatao();
        loadTableConge();
        /*yessin*/
        loadTablefichedepaie();
        loadTableprime();
        trie_combobox_1.setItems(FXCollections.observableArrayList("Salaire_init","Salaire_total"));
        loadTableEntretien();
        loadTableEvaluation();
        /*yessin */
        loadTableFormation();//formation
        // loadTableFormation();// formation affiche all 
         loadTableFormateur();
    }

    @FXML
    private void switchForm(MouseEvent event) {
        if (event.getSource() == gestionoffres) {
            offreadmin.setVisible(true);
            appadmin.setVisible(false);
            searchbox.setVisible(true);
            searchicon.setVisible(true);
            HomeC.setVisible(false);
            GesPai.setVisible(false);
            GePrime.setVisible(false);
            geentretien.setVisible(false);
            geformation1.setVisible(false);
            geformateur.setVisible(false);

            gestionoffres.setStyle("-fx-background-color:#666666");
            GesCon.setStyle("-fx-background-color:#fff");
            gestionapp.setStyle("-fx-background-color:#fff");
            gestionPai.setStyle("-fx-background-color:#fff");
            gestionPrime.setStyle("-fx-background-color:#fff");
            gestionentretien.setStyle("-fx-background-color:#fff");
            gestionformations.setStyle("-fx-background-color:#fff");
            gestionformateurs.setStyle("-fx-background-color:#fff");

            showData();

        } else if (event.getSource() == gestionapp) {
            offreadmin.setVisible(false);
            appadmin.setVisible(true);
            searchbox.setVisible(true);
            searchicon.setVisible(true);
            HomeC.setVisible(false);
            GesPai.setVisible(false);
            GePrime.setVisible(false);
            geentretien.setVisible(false);
            geformation1.setVisible(false);
            geformateur.setVisible(false);

            gestionoffres.setStyle("-fx-background-color:#fff");
            GesCon.setStyle("-fx-background-color:#fff");
            gestionapp.setStyle("-fx-background-color:#666666");
            gestionPai.setStyle("-fx-background-color:#fff");
            gestionPrime.setStyle("-fx-background-color:#fff");
            gestionentretien.setStyle("-fx-background-color:#fff");
            gestionformations.setStyle("-fx-background-color:#fff");
            gestionformateurs.setStyle("-fx-background-color:#fff");

        } else if (event.getSource() == GesCon) {
            offreadmin.setVisible(false);
            appadmin.setVisible(false);
            searchbox.setVisible(true);
            searchicon.setVisible(true);
            HomeC.setVisible(true);
            GesPai.setVisible(false);
            GePrime.setVisible(false);
            geentretien.setVisible(false);
            geformation1.setVisible(false);
            geformateur.setVisible(false);

            gestionoffres.setStyle("-fx-background-color:#fff");
            GesCon.setStyle("-fx-background-color:#666666");
            gestionapp.setStyle("-fx-background-color:#fff");
            gestionPai.setStyle("-fx-background-color:#fff");
            gestionPrime.setStyle("-fx-background-color:#fff");
            gestionentretien.setStyle("-fx-background-color:#fff");
            gestionformations.setStyle("-fx-background-color:#fff");
            gestionformateurs.setStyle("-fx-background-color:#fff");
        }
        else if (event.getSource() == gestionPai) {
            offreadmin.setVisible(false);
            appadmin.setVisible(false);
            searchbox.setVisible(true);
            searchicon.setVisible(true);
            HomeC.setVisible(false);
            GesPai.setVisible(true);
            GePrime.setVisible(false);
            geentretien.setVisible(false);
            geformation1.setVisible(false);
            geformateur.setVisible(false);
            
            gestionoffres.setStyle("-fx-background-color:#fff");
            GesCon.setStyle("-fx-background-color:#fff");
            gestionapp.setStyle("-fx-background-color:#fff");
            gestionPai.setStyle("-fx-background-color:#666666");
            gestionPrime.setStyle("-fx-background-color:#fff");
            gestionentretien.setStyle("-fx-background-color:#fff");
            gestionformations.setStyle("-fx-background-color:#fff");
            gestionformateurs.setStyle("-fx-background-color:#fff");
        }
        else if (event.getSource() == gestionPrime) {
            offreadmin.setVisible(false);
            appadmin.setVisible(false);
            searchbox.setVisible(true);
            searchicon.setVisible(true);
            HomeC.setVisible(false);
            GesPai.setVisible(false);
            GePrime.setVisible(true);
            geentretien.setVisible(false);
            geformation1.setVisible(false);
            geformateur.setVisible(false);
            

            gestionoffres.setStyle("-fx-background-color:#fff");
            GesCon.setStyle("-fx-background-color:#fff");
            gestionapp.setStyle("-fx-background-color:#fff");
            gestionPai.setStyle("-fx-background-color:#fff");
            gestionPrime.setStyle("-fx-background-color:#666666");
            gestionentretien.setStyle("-fx-background-color:#fff");
            gestionformations.setStyle("-fx-background-color:#fff");
            gestionformateurs.setStyle("-fx-background-color:#fff");
            
        }
        else if (event.getSource() == gestionentretien) {
            offreadmin.setVisible(false);
            appadmin.setVisible(false);
            searchbox.setVisible(true);
            searchicon.setVisible(true);
            HomeC.setVisible(false);
            GesPai.setVisible(false);
            GePrime.setVisible(false);
            geentretien.setVisible(true);
            geformation1.setVisible(false);
            geformateur.setVisible(false);

            gestionoffres.setStyle("-fx-background-color:#fff");
            GesCon.setStyle("-fx-background-color:#fff");
            gestionapp.setStyle("-fx-background-color:#fff");
            gestionPai.setStyle("-fx-background-color:#fff");
            gestionPrime.setStyle("-fx-background-color:#fff");
            gestionentretien.setStyle("-fx-background-color:#666666");
            gestionformations.setStyle("-fx-background-color:#fff");
            gestionformateurs.setStyle("-fx-background-color:#fff");
            
        }
        else if (event.getSource() == gestionformations) {
            offreadmin.setVisible(false);
            appadmin.setVisible(false);
            searchbox.setVisible(true);
            searchicon.setVisible(true);
            HomeC.setVisible(false);
            GesPai.setVisible(false);
            GePrime.setVisible(false);
            geentretien.setVisible(false);
            geformation1.setVisible(true);
            geformateur.setVisible(false);

            gestionoffres.setStyle("-fx-background-color:#fff");
            GesCon.setStyle("-fx-background-color:#fff");
            gestionapp.setStyle("-fx-background-color:#fff");
            gestionPai.setStyle("-fx-background-color:#fff");
            gestionPrime.setStyle("-fx-background-color:#fff");
            gestionentretien.setStyle("-fx-background-color:#fff");
            gestionformations.setStyle("-fx-background-color:#666666");
            gestionformateurs.setStyle("-fx-background-color:#fff");
            
        }
        else if (event.getSource() == gestionformateurs) {
            offreadmin.setVisible(false);
            appadmin.setVisible(false);
            searchbox.setVisible(true);
            searchicon.setVisible(true);
            HomeC.setVisible(false);
            GesPai.setVisible(false);
            GePrime.setVisible(false);
            geentretien.setVisible(false);
            geformation1.setVisible(false);
            geformateur.setVisible(true);

            gestionoffres.setStyle("-fx-background-color:#fff");
            GesCon.setStyle("-fx-background-color:#fff");
            gestionapp.setStyle("-fx-background-color:#fff");
            gestionPai.setStyle("-fx-background-color:#fff");
            gestionPrime.setStyle("-fx-background-color:#fff");
            gestionentretien.setStyle("-fx-background-color:#fff");
            gestionformations.setStyle("-fx-background-color:#fff");
            gestionformateurs.setStyle("-fx-background-color:#666666");
            
        }
    }

    @FXML
    public void comboboxa() {
        List<String> list = new ArrayList<>();

        for (String data : comboetat) {

            list.add(data);

        }

        ObservableList dataList = FXCollections.observableArrayList(list);

        etat.setItems(dataList);
    }

    @FXML
    private void insertimage(ActionEvent event) {
        FileChooser open = new FileChooser();

        Stage stage = (Stage) left_main.getScene().getWindow();

        File file = open.showOpenDialog(stage);

        if (file != null) {

            String path = file.getAbsolutePath();

            path = path.replace("\\", "\\\\");

            file_path.setText(path);

            Image image = new Image(file.toURI().toString(), 110, 110, false, true);

            image_viewa.setImage(image);

        } else {

            System.out.println("aucune image detectée!");

        }
    }
    Connection cnx2;

    public BackOfficeController() {
        cnx2 = MyConnection.getInstance().getCnx();
    }

    @FXML
    private void ajouterApp(ActionEvent event) {
        String sql = "INSERT INTO application( `candidat`, `offre`, `cv`, `etat`) VALUES (?,?,?,?)";

        try {

            if (candlab.getText().isEmpty()
                    | offlab.getText().isEmpty()
                    | etat.getSelectionModel().isEmpty()
                    | image_viewa.getImage() == null) {

                Alert alert = new Alert(Alert.AlertType.ERROR);

                alert.setTitle("message d'erreur");
                alert.setHeaderText(null);
                alert.setContentText("entrer tous les données");
                alert.showAndWait();

            } else {
                PreparedStatement pst;
                pst = cnx2.prepareStatement(sql);
                pst.setString(1, candlab.getText());
                pst.setString(2, offlab.getText());
                pst.setString(3, (String) etat.getSelectionModel().getSelectedItem());
                pst.setString(4, file_path.getText());
                pst.executeUpdate();
                System.out.println("item ajouté avec succés");

                showData();
                clear();
            }
        } catch (Exception e) {
        }
    }

    @FXML
    private void modifierApp(ActionEvent event) {
        String path = file_path.getText();

        path = path.replace("\\", "\\\\");

        String sql = "UPDATE application SET `candidat` = '"
                + candlab.getText() + "', `offre` = '"
                + offlab.getText()
                + "', `etat` = '" + etat.getSelectionModel().getSelectedItem()
                + "', `date` = '" + Date.valueOf(LocalDate.now())
                + "' WHERE id_app = '" + Integer.parseInt(idlaba.getText()) + "'";

        try {

            if (idlaba.getText().isEmpty() | offlab.getText().isEmpty()
                    | candlab.getText().isEmpty()) {

                Alert alert = new Alert(Alert.AlertType.ERROR);

                alert.setTitle("message d'erreur");
                alert.setHeaderText(null);
                alert.setContentText("Entrer tous les champs!");
                alert.showAndWait();

            } else {
                MailServiceImpl.mailsent("radhwen.rmili@esprit.tn", candlab.getText(), etat.getSelectionModel().getSelectedItem().toString());
                PreparedStatement pst;
                pst = cnx2.prepareStatement(sql);
                pst.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);

                alert.setTitle("Succés");
                alert.setHeaderText(null);
                alert.setContentText("l'item est modifié avec succés");
                alert.showAndWait();

                showData();
                clear();

            }
        } catch (Exception e) {
        }

    }

    @FXML
    private void supprimerApp(ActionEvent event) {
        String sql = "DELETE from application WHERE `id_app` = '" + Integer.parseInt(idlaba.getText()) + "'";
        try {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("confirmer la suppression?");

            Optional<ButtonType> buttonType = alert.showAndWait();

            if (buttonType.get() == ButtonType.OK) {

                PreparedStatement pst;
                pst = cnx2.prepareStatement(sql);
                pst.executeUpdate();

            } else {

                return;

            }

            showData();
            clear();

        } catch (Exception e) {
        }
    }

    public ObservableList<Application> dataList() {

        ObservableList<Application> dataList = FXCollections.observableArrayList();

        String sql = "SELECT * FROM application";

        try {
            PreparedStatement pst;
            pst = cnx2.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            Application data;

            while (rs.next()) {

                data = new Application(rs.getInt("id_app"), rs.getString("candidat"),
                        rs.getString("offre"), rs.getString("cv"),
                        rs.getString("etat"));

                dataList.add(data);

            }

        } catch (Exception e) {
        }
        return dataList;

    }

    public void clear() {

        idlaba.setText("");
        candlab.setText("");
        offlab.setText("");
        etat.getSelectionModel().clearSelection();
        image_viewa.setImage(null);

    }

    public void showData() {
        ObservableList<Application> showList = dataList();

        col_ida.setCellValueFactory(new PropertyValueFactory<>("id_app"));
        col_offre.setCellValueFactory(new PropertyValueFactory<>("offre"));
        col_candidat.setCellValueFactory(new PropertyValueFactory<>("candidat"));
        col_etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        col_cv.setCellValueFactory(new PropertyValueFactory<>("CV"));
        table_view.setItems(showList);

    }

    @FXML
    public void comboBox() {
        List<String> list = new ArrayList<>();

        for (String data : comboSkills) {

            list.add(data);

        }

        ObservableList dataList = FXCollections.observableArrayList(list);

        skills.setItems(dataList);
    }

    @FXML
    private void insertImage(ActionEvent event) {
        FileChooser open = new FileChooser();

        Stage stage = (Stage) left_main1.getScene().getWindow();

        File file = open.showOpenDialog(stage);

        if (file != null) {

            String path = file.getAbsolutePath();

            path = path.replace("\\", "\\\\");

            file_path1.setText(path);

            Image image = new Image(file.toURI().toString(), 110, 110, false, true);

            image_view.setImage(image);

        } else {

            System.out.println("aucune image detectée!");

        }
    }

    @FXML
    private void ajouterOffre(ActionEvent event) {
        String sql = "INSERT INTO offreemploi VALUES (?,?,?,?)";

        try {

            if (nomlab.getText().isEmpty()
                    | desclab.getText().isEmpty()
                    | skills.getSelectionModel().isEmpty()
                    | image_view.getImage() == null) {

                Alert alert = new Alert(Alert.AlertType.ERROR);

                alert.setTitle("message d'erreur");
                alert.setHeaderText(null);
                alert.setContentText("entrer tous les données");
                alert.showAndWait();

            } else {
                PreparedStatement pst;
                pst = cnx2.prepareStatement(sql);

                pst.setString(1, nomlab.getText());
                pst.setString(2, desclab.getText());
                pst.setString(4, (String) skills.getSelectionModel().getSelectedItem());
                pst.setString(3, file_path1.getText());
                pst.executeUpdate();
                System.out.println("item ajouté avec succés");

                showDatao();
                clearo();
            }
        } catch (Exception e) {
        }
    }

    public void clearo() {

        idlab.setText("");
        nomlab.setText("");
        desclab.setText("");
        skills.getSelectionModel().clearSelection();
        image_view.setImage(null);

    }

    @FXML
    private void modifierOffre(ActionEvent event) {
        String path = file_path.getText();

        path = path.replace("\\", "\\\\");

        String sql = "UPDATE offreemploi SET `nomOffre` = '"
                + nomlab.getText() + "', `description` = '"
                + desclab.getText() + "', `skills` = '"
                + skills.getSelectionModel().getSelectedItem()
                + "', `picture` = '" + path
                + "' WHERE id_offre = '" + Integer.parseInt(idlab.getText()) + "'";

        try {

            if (idlab.getText().isEmpty() | nomlab.getText().isEmpty()
                    | desclab.getText().isEmpty()
                    | skills.getSelectionModel().isEmpty()) {

                Alert alert = new Alert(Alert.AlertType.ERROR);

                alert.setTitle("message d'erreur");
                alert.setHeaderText(null);
                alert.setContentText("Entrer tous les champs!");
                alert.showAndWait();

            } else {

                PreparedStatement pst;
                pst = cnx2.prepareStatement(sql);
                pst.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);

                alert.setTitle("Succés");
                alert.setHeaderText(null);
                alert.setContentText("l'item est modifié avec succés");
                alert.showAndWait();

                showDatao();
                clearo();

            }
        } catch (Exception e) {
        }

    }
    ObservableList<Congé> oblist = FXCollections.observableArrayList();
    CongeCrud us = new CongeCrud();

    private void loadTableConge() {//affiche foramtion
        List<Congé> fs = us.afficherDemande();
        fs.forEach(e -> oblist.add(e));
        System.out.println(oblist);
        c1.setCellValueFactory(new PropertyValueFactory<>("idCon"));

        c2.setCellValueFactory(new PropertyValueFactory<>("idPer"));
        c3.setCellValueFactory(new PropertyValueFactory<>("dDepot"));
        c4.setCellValueFactory(new PropertyValueFactory<>("typeDemande"));
        c5.setCellValueFactory(new PropertyValueFactory<>("etatDemande"));
        c6.setCellValueFactory(new PropertyValueFactory<>("dDepart"));
        c7.setCellValueFactory(new PropertyValueFactory<>("dRetour"));

        tab.setItems(oblist);
    }

    public ObservableList<OffreEmploi> dataListo() {

        ObservableList<OffreEmploi> dataListo = FXCollections.observableArrayList();

        String sql = "SELECT * FROM offreemploi";

        try {

            PreparedStatement pst;
            pst = cnx2.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            OffreEmploi data;

            while (rs.next()) {

                data = new OffreEmploi(rs.getInt("id_offre"), rs.getString("nomOffre"),
                        rs.getString("description"), rs.getString("skills"),
                        rs.getString("picture"));

                dataListo.add(data);

            }

        } catch (Exception e) {
        }

        return dataListo;

    }

    public void showDatao() {
        ObservableList<OffreEmploi> showList = dataListo();

        col_id.setCellValueFactory(new PropertyValueFactory<>("id_offre"));
        col_nom.setCellValueFactory(new PropertyValueFactory<>("nomOffre"));
        col_desc.setCellValueFactory(new PropertyValueFactory<>("description"));
        col_skills.setCellValueFactory(new PropertyValueFactory<>("skills"));
        col_picture.setCellValueFactory(new PropertyValueFactory<>("picture"));

        table_view1.setItems(showList);

    }

    @FXML
    private void supprimerOffre(ActionEvent event) {
        String sql = "DELETE from offreemploi WHERE `id_offre` = '" + Integer.parseInt(idlab.getText()) + "'";
        try {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("confirmer la suppression?");

            Optional<ButtonType> buttonType = alert.showAndWait();

            if (buttonType.get() == ButtonType.OK) {

                PreparedStatement pst;
                pst = cnx2.prepareStatement(sql);
                pst.executeUpdate();

            } else {

                return;

            }

            showDatao();
            clearo();

        } catch (Exception e) {
        }
    }

    @FXML
    private void selectItem(MouseEvent event) {
        int index = table_view1.getSelectionModel().getSelectedIndex();
        OffreEmploi offre = table_view1.getSelectionModel().getSelectedItem();
        idlab.setText(col_id.getCellData(index).toString());
        nomlab.setText(col_nom.getCellData(index).toString());
        desclab.setText(col_desc.getCellData(index).toString());
    }

    @FXML
    private void selectApp(MouseEvent event) {
        int index = table_view.getSelectionModel().getSelectedIndex();
        Application app = table_view.getSelectionModel().getSelectedItem();
        idlaba.setText(col_ida.getCellData(index).toString());
        candlab.setText(col_candidat.getCellData(index).toString());
        offlab.setText(col_offre.getCellData(index).toString());
        //file_path.setText(col_cv.getCellData(index).toString());
        //etat.get44444.setText(col_etat.getCellData(index).toString())     
    }
    Congé co = new Congé();

    @FXML
    private void getConData(MouseEvent event) {
        int index = tab.getSelectionModel().getSelectedIndex();
        Congé app = tab.getSelectionModel().getSelectedItem();
        co.setIdCon(c1.getCellData(index));
        System.out.println(co.getIdCon());
    }

    @FXML
    private void SuppCon(ActionEvent event) {
        CongeCrud uc = new CongeCrud();
        System.out.println(co.getIdCon());
        //uc.supprimerConge(co.getIdCon());

        tab.getItems().clear();
        loadTableConge();
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

    public void clear1() {

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
                clear1();
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

    Connection cnx22;

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
        clear1();
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
    private void selectApp1(MouseEvent event) {
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
    @FXML
    private void envoyer(ActionEvent event) {
        Entretien app = home.getSelectionModel().getSelectedItem();
        String text="Bonjour Mr/Mme ";
        String firstname=app.getFirstname_candidat()+" ";
        String name=app.getName_candidat()+",\n";
        String a ="Votre entretien sera fixé au date ";
        String date = app.getDate_entretien().toString() +" à ";
        String h = app.getHeure()+".\n";
        String cor= "Cordialement.";
        String all=text + firstname+name+a+date+h+cor;
        try {
            //MailServiceImpl.mailsent("racem.benamar@esprit.tn","Fixation date et heure entreiten",text,firstname,name,a,date,h,cor);
            GUI.MailServiceImpl.mailsent("racem.benamar@esprit.tn","Fixation date et heure entreiten",all);
        } catch (Exception ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    

    
    @FXML
    private void ajouter_fiche_de_paiement(ActionEvent event) {
       
        java.sql.Date date_paiement = Date.valueOf(date_textfield.getValue());
        int id_fp = Integer.parseInt(id_fp_textfield.getText());
        int id_per = Integer.parseInt(id_per_textfield.getText());
        int salaire_init = Integer.parseInt(init_textfield.getText());
        int prime = Integer.parseInt(prime_textfield.getText());
        int salaire_total = Integer.parseInt(total_textfield.getText());
        String etat_paiement = etat_textfield.getText();
        
        fiche_de_paie fp = new fiche_de_paie(id_per, salaire_init, prime, salaire_total, date_paiement, etat_paiement);
        if ((id_per == 0)||(salaire_init>salaire_total)){
            System.out.println("controle de saisie ajout!");
        }
        else{
                FicheDePaieCRUD fpcrud = new FicheDePaieCRUD();
        fpcrud.ajouterFicheDePaie(fp);   
        paiement_tableau.getItems().clear();
        loadTablefichedepaie();
                }
    }
    
    
    
        ObservableList<fiche_de_paie> oblist4 = FXCollections.observableArrayList();
        FicheDePaieCRUD fpcrud= new FicheDePaieCRUD();
        
        
       
        
        
        
    private void loadTablefichedepaie(){//affiche  
        
        List <fiche_de_paie> ls =fpcrud.afficherFicheDePaie();
        ls.forEach(e->oblist4.add(e));
        System.out.println(oblist4);
        id_fp_colonne.setCellValueFactory(new PropertyValueFactory<>("ID_FP"));
        id_per_colonne.setCellValueFactory(new PropertyValueFactory<>("ID_Per"));
        salaire_init_colonne.setCellValueFactory(new PropertyValueFactory<>("Salaire_init"));
        id_prime_colonne.setCellValueFactory(new PropertyValueFactory<>("ID_Prime"));
        salaire_total_colonne.setCellValueFactory(new PropertyValueFactory<>("Salaire_total"));
        date_paiement_colonne.setCellValueFactory(new PropertyValueFactory<>("Date_paiement"));
        etat_paiement_colonne.setCellValueFactory(new PropertyValueFactory<>("Etat_paiement"));
        
        paiement_tableau.setItems(oblist4);
    }
        
        ObservableList<prime> oblist1 = FXCollections.observableArrayList();
        PrimeCRUD fpcrud1 = new PrimeCRUD();
    private void loadTableprime(){//affiche  
        
        List <prime> ls =fpcrud1.afficherPrime();
        ls.forEach(e->oblist1.add(e));
        System.out.println(oblist1);
        id_prime_colonne_2.setCellValueFactory(new PropertyValueFactory<>("ID_Prime"));
        type_prime_colonne_2.setCellValueFactory(new PropertyValueFactory<>("Type_Prime"));
        valeur_prime_colonne_2.setCellValueFactory(new PropertyValueFactory<>("Valeur_Prime"));
        date_prime_colonne_2.setCellValueFactory(new PropertyValueFactory<>("Date_Prime"));
        
        
        tableau_prime_2.setItems(oblist1);
    }
    
    
    @FXML
    private void supprimer_fiche_de_paie(ActionEvent event) {
    fiche_de_paie fp = paiement_tableau.getSelectionModel().getSelectedItem();
    FicheDePaieCRUD fpcrud = new FicheDePaieCRUD();
    fpcrud.supprimerFicheDePaie(fp);
    paiement_tableau.getItems().clear();
     
    loadTablefichedepaie();
    
    }

    @FXML
    private void modifier_fiche_de_paie(ActionEvent event) {
        fiche_de_paie a = paiement_tableau.getSelectionModel().getSelectedItem();
        FicheDePaieCRUD fpcrud = new FicheDePaieCRUD();
        
        int nbr1=Integer.parseInt(id_fp_textfield.getText());
        int nbr2=Integer.parseInt(id_per_textfield.getText());  
        int nbr3=Integer.parseInt(init_textfield.getText());  
        int nbr4=Integer.parseInt(prime_textfield.getText());
        int nbr5=Integer.parseInt(total_textfield.getText());
         a.setID_FP(nbr1);
         a.setID_Per(nbr2);
         a.setSalaire_init(nbr3);
         a.setPrime(nbr4);
         a.setSalaire_total(nbr5);
         a.setEtat_paiement(etat_textfield.getText());
        
         if ((nbr2 == 0)||(nbr3>nbr5)){
          System.out.println("controlle de saisie modification !");   
         }
         else{
             
             fpcrud.modifierFicheDePaie(a);
             
       
         
         }
          paiement_tableau.getItems().clear();
        loadTablefichedepaie();
        
    }

    @FXML
    private void fiche_de_paie_selected(MouseEvent event) {
        int index = paiement_tableau.getSelectionModel().getSelectedIndex();
        fiche_de_paie h = paiement_tableau.getSelectionModel().getSelectedItem();
        id_fp_textfield.setText(id_fp_colonne.getCellData(index).toString());
        id_per_textfield.setText(id_per_colonne.getCellData(index).toString());
        init_textfield.setText(salaire_init_colonne.getCellData(index).toString());
        prime_textfield.setText(id_prime_colonne.getCellData(index).toString());
        total_textfield.setText(salaire_total_colonne.getCellData(index).toString());
        etat_textfield.setText(etat_paiement_colonne.getCellData(index));
        
    }

    @FXML
    private void ajouter_prime(ActionEvent event) {
        
        int nbrh = Integer.parseInt(nombre_heure_textfield_2.getText());
        java.sql.Date date_paiement = Date.valueOf(date_prime_textfield_2.getValue());
        int id_prime = Integer.parseInt(id_prime_textfield_2.getText());
        String type_prime = type_prime_textfield_2.getText();
        int valeur_prime = Integer.parseInt(valeur_prime_textfield_2.getText());
       if (nbrh>50){ valeur_prime = valeur_prime +(nbrh-50)*15;}
        
        prime fp = new prime(id_prime, type_prime, valeur_prime, date_paiement);
        
        if((type_prime=="")||(valeur_prime<0)){
            System.out.println("controle de saisie ajout prime !"); 
        }
        else{
            PrimeCRUD fpcrud = new PrimeCRUD();
            fpcrud.ajouterPrime(fp);
            tableau_prime_2.getItems().clear();
            loadTableprime();
        }
        
    }
     
    

    @FXML
    private void supprimer_prime(ActionEvent event) {
    prime fp = tableau_prime_2.getSelectionModel().getSelectedItem();
    PrimeCRUD fpcrud1 = new PrimeCRUD();    
    fpcrud1.supprimerPrime(fp);
    tableau_prime_2.getItems().clear();
    loadTableprime();
    }

    @FXML
    private void modifier_prime(ActionEvent event) {
        
        int nbrh = Integer.parseInt(nombre_heure_textfield_2.getText());
        prime a = tableau_prime_2.getSelectionModel().getSelectedItem();
        PrimeCRUD fpcrud = new PrimeCRUD();
        java.sql.Date date_paiement = Date.valueOf(date_prime_textfield_2.getValue());
        int nbr1=Integer.parseInt(id_prime_textfield_2.getText());
        String nbr2=type_prime_textfield_2.getText();  
        int nbr3=Integer.parseInt(valeur_prime_textfield_2.getText());  
        if (nbrh>50){ nbr3 = nbr3 +(nbrh-50)*15;}
         a.setID_Prime(nbr1);
         a.setType_Prime(type_prime_textfield_2.getText());
         a.setValeur_Prime(nbr3);
         a.setDate_Prime(date_paiement);
        
         if((nbr2=="")||(nbr3<0)){
             System.out.println("controle de saisie modification prime !");
         }
         else{
             fpcrud1.modifierPrime(a);
        
        tableau_prime_2.getItems().clear();
        loadTableprime();
         }
         
    
        
    }

    @FXML
    private void prime_selected(MouseEvent event) {
        
        int index = tableau_prime_2.getSelectionModel().getSelectedIndex();
        prime h = tableau_prime_2.getSelectionModel().getSelectedItem();
        id_prime_textfield_2.setText(id_prime_colonne_2.getCellData(index).toString());
        type_prime_textfield_2.setText(type_prime_colonne_2.getCellData(index));
        valeur_prime_textfield_2.setText(valeur_prime_colonne_2.getCellData(index).toString());
        
    }
    /*
    @FXML
    private void calcul_nombre_heure(){
        
        int nbrh = Integer.parseInt(nombre_heure_textfield_2.getText());
        FicheDePaieCRUD fp = new FicheDePaieCRUD();
        fp.calculer_Salaire(p, nbrh);
    }
    */
/*
    @FXML
    private void statistique(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("statistique1.fxml"));
            Parent root =loader.load();
            Statistique1Controller e = loader.getController();
            
        } catch (IOException ex) {
            System.out.println("echec statistique ");
        }
    }*/
    @FXML
    private void statistique(ActionEvent event) {
        try {
                   
            Parent parent =  FXMLLoader.load(getClass().getResource("statistique1.fxml"));
            Scene scene = new Scene(parent);
            
            Stage stage = new Stage();
            
          
            stage.setScene(scene);
          
            stage.initStyle(StageStyle.UTILITY);
          
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage()); 
        }
    }

    ObservableList<formation> oblistr = FXCollections.observableArrayList();
      ObservableList<formateur> oblist1r = FXCollections.observableArrayList();
     formationCRUD fcd= new formationCRUD();
     formateurCRUD ffcd = new formateurCRUD();
     
     
     
   
     private void loadTableFormation(){//affiche foramtion
        List <formation> fs =fcd.afficherForamtion();
        fs.forEach(e->oblistr.add(e));
        System.out.println(oblistr);
        a_ID.setCellValueFactory(new PropertyValueFactory<>("Id_For"));
        a_IDF.setCellValueFactory(new PropertyValueFactory<>("Id_Formateur"));
        a_Nom.setCellValueFactory(new PropertyValueFactory<>("Nom_For"));
        a_Date.setCellValueFactory(new PropertyValueFactory<>("Date_For"));
        a_NC.setCellValueFactory(new PropertyValueFactory<>("Numbr_Max_Per"));
     Table_Formations.setItems(oblistr);
    }
    
     private void loadTableFormateur(){//affiche foramtion
        List <formateur> fs =ffcd.afficherFormateur();
        fs.forEach(e->oblist1r.add(e));
        System.out.println(oblist1r);
        idCA.setCellValueFactory(new PropertyValueFactory<>("Id_formateur"));
        nomCA.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomCA.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        adresseCA.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        emailCA.setCellValueFactory(new PropertyValueFactory<>("email"));
        telCA.setCellValueFactory(new PropertyValueFactory<>("tel"));
        codePCA.setCellValueFactory(new PropertyValueFactory<>("codeP"));
        villeCA.setCellValueFactory(new PropertyValueFactory<>("ville"));
        payCA.setCellValueFactory(new PropertyValueFactory<>("pays"));
        statusCA.setCellValueFactory(new PropertyValueFactory<>("status"));
        terifCA.setCellValueFactory(new PropertyValueFactory<>("tarif"));
        tvaCA.setCellValueFactory(new PropertyValueFactory<>("tva"));
        bioCA.setCellValueFactory(new PropertyValueFactory<>("bio"));
        diplomeCA.setCellValueFactory(new PropertyValueFactory<>("diplome"));
        
     Table_Formateur.setItems(oblist1r);
    }
         @FXML
    private void addFormation(ActionEvent event) {
        java.sql.Date date =Date.valueOf(dpDate.getValue());
        int id;
        id = Integer.parseInt(tfID.getText());
         int idF;
        idF = Integer.parseInt(tfIDF.getText());
         int tfNu;
        tfNu = Integer.parseInt(tfNum.getText());
        
  if((tfID.getText().equals("")) ||
                (tfIDF.getText().equals(""))||
                (tfNom.getText().equals(""))||
                (tfNum.getText().equals(""))||
                (date.equals(""))
                ){ 
            JOptionPane.showMessageDialog(null, "veuillez remplir tous les champs ");
        }
        else {
     formation f= new formation(idF, idF, date, tfNom.getText(), tfNu); 
     formationCRUD fcd= new formationCRUD();
     String path =fcd.QR(tfNom.getText()+" , ET DE numero "+tfNum.getText());
     
        fcd.ajouterFormation(f);
            try {
                fcd.sendEmail(path);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        JOptionPane.showMessageDialog(null, "Formation Crée");
        loadTableFormation();
        
    }
    }
        @FXML
    private void addFormateur(ActionEvent event) {
        
        int N1 ;
        N1 =  Integer.parseInt(telA.getText());
        int N2;
        N2 = Integer.parseInt(CPA.getText());
        int N3;
        N3 =Integer.parseInt(tarifA.getText());
        int N4;
        N4 =Integer.parseInt(tvaA.getText());
        
        
        
        
        
  if( (nomA.getText().equals("")) || (prenomA.getText().equals("")) || (adresseA.getText().equals("")) || (emailA.getText().equals("")) || (telA.getText().equals("")) || (CPA.getText().equals("")) ||(VilleA.getText().equals("")) ||(payA.getText().equals("")) ||(statusA.getText().equals("")) ||(tarifA.getText().equals("")) ||(tvaCA.getText().equals("")) ||(bioCA.getText().equals("")) ||(diplomeCA.getText().equals("")) ){ 
            JOptionPane.showMessageDialog(null, "veuillez remplir tous les champs ");
        }
        else {
     formateur f= new formateur(nomA.getText(),prenomA.getText(),adresseA.getText(),emailCA.getText(),N1,N2,VilleA.getText(),payA.getText(),statusA.getText(),N3,N4,bioCA.getText(),diplomeCA.getText());
              
     
        ffcd.ajouterFormateur(f);
        JOptionPane.showMessageDialog(null, "Formateur Créée");
        loadTableFormateur();
    }
    }  

    @FXML
    private void formation_select(MouseEvent event) {
       
        int index = Table_Formations.getSelectionModel().getSelectedIndex();
        formation f = Table_Formations.getSelectionModel().getSelectedItem();
        tfID.setText(a_ID.getCellData(index).toString());
        tfIDF.setText(a_IDF.getCellData(index).toString());
        tfNum.setText(a_NC.getCellData(index).toString());
        tfNom.setText(a_Nom.getCellData(index));
    }
        @FXML
    private void select_formateur(MouseEvent event) {
        int index = Table_Formateur.getSelectionModel().getSelectedIndex();
        formateur f = Table_Formateur.getSelectionModel().getSelectedItem();
        nomA.setText(nomCA.getCellData(index));
        prenomA.setText(prenomCA.getCellData(index));
        adresseA.setText(adresseCA.getCellData(index));
        emailA.setText(emailCA.getCellData(index));
        telA.setText(telCA.getCellData(index).toString());
        CPA.setText(codePCA.getCellData(index).toString());
        VilleA.setText(villeCA.getCellData(index));
        payA.setText(payCA.getCellData(index));
        statusA.setText(statusCA.getCellData(index));
        tarifA.setText(terifCA.getCellData(index).toString());
        tvaA.setText(tvaCA.getCellData(index).toString());
        bioA.setText(bioCA.getCellData(index));
        diplomeA.setText(diplomeCA.getCellData(index));
    }
        @FXML
    private void deleteFormation(MouseEvent event) {
        formation f=  Table_Formations.getSelectionModel().getSelectedItem();
        fcd.supprimer(f);
        Table_Formations.getItems().clear();
        loadTableFormation();
    }
        @FXML
    private void deleteFormateur(MouseEvent event) {
        formateur f=  Table_Formateur.getSelectionModel().getSelectedItem();
        ffcd.supprimer(f);
        Table_Formateur.getItems().clear();
        loadTableFormateur();
    }
    
        @FXML
    private void updateFormation(MouseEvent event) {
        formation f =  Table_Formations.getSelectionModel().getSelectedItem();
        int nbr1=Integer.parseInt(tfID.getText());
            int nbr2=Integer.parseInt(tfIDF.getText());  
            int nbr3=Integer.parseInt(tfNum.getText());  
            f.setId_For(nbr1);
            f.setId_Formateur(nbr2);
            f.setNumbr_Max_Per(nbr3);
            
        f.setNom_For(tfNom.getText());
        fcd.modifier(f);
        Table_Formations.getItems().clear();
        loadTableFormation();
    }
        @FXML
    private void updateFormateur(MouseEvent event) {
      formateur f =  Table_Formateur.getSelectionModel().getSelectedItem();
       
      
      f.setNom(nomA.getText());
      f.setPrenom(prenomA.getText());
      f.setAdresse(adresseA.getText());
      f.setEmail(emailA.getText());
      int nb=Integer.parseInt(telA.getText());
      int nb1=Integer.parseInt(CPA.getText());
      f.setVille(VilleA.getText());
      f.setPays(payA.getText());
      f.setStatus(statusA.getText());
      int nb2=Integer.parseInt(tarifA.getText());
      int nb3=Integer.parseInt(tvaA.getText());
      f.setBio(bioA.getText());
      f.setDiplome(diplomeA.getText());
      ffcd.modifier(f);
      Table_Formateur.getItems().clear();
      loadTableFormateur();
    }
    
        @FXML
    private void Statistique(MouseEvent event) {
        try {
                   
            Parent parent =  FXMLLoader.load(getClass().getResource("/gui2/statistique.fxml"));
            Scene scene = new Scene(parent);
            
            Stage stage = new Stage();
            
          
            stage.setScene(scene);
          
            stage.initStyle(StageStyle.UTILITY);
          
            stage.show();
        } catch (IOException ex) {
           ex.getMessage();
        }
    }

    @FXML
    private void ChercherIDAM(MouseEvent event) {
        int id ;
        id = Integer.parseInt(Id_Recherchetf.getText());
        List <formation> fs =fcd.rechercherForamtion(id);
        fs.forEach(e->oblistr.add(e));
        System.out.println(oblistr);
        a_ID.setCellValueFactory(new PropertyValueFactory<>("Id_For"));
        a_IDF.setCellValueFactory(new PropertyValueFactory<>("Id_Formateur"));
        a_Nom.setCellValueFactory(new PropertyValueFactory<>("Nom_For"));
        a_Date.setCellValueFactory(new PropertyValueFactory<>("Date_For"));
        a_NC.setCellValueFactory(new PropertyValueFactory<>("Numbr_Max_Per")); 
        Table_Formations.setItems(oblistr);  
    }
    
}
