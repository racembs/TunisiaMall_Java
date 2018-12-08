/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_info;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
//import tn.pidev.tn.gui.FXMLloginController;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.MediaView;
import javafx.util.Callback;
import tn.pidev.tm.entite.Enseigne;
import tn.pidev.tm.entite.Produit;
import tn.pidev.tm.entite.Promotion;
import tn.pidev.tm.service.ProduitService;
import tn.pidev.tm.service.PromotionService;
import tn.pidev.tm.service.ServiceEnseigne;



/**
 * FXML Controller class
 *
 * @author HP-PC
 */
public class PromoAdminController implements Initializable {

    @FXML
    private TabPane admintabpane;
    @FXML
    private Tab home;
    @FXML
    private MediaView mediaTM;
    private TableColumn<Promotion, Float> c3tauxRed;
    @FXML
    private JFXButton btngerercompte;
    @FXML
    private JFXButton ptsfidelite;
    @FXML
    private JFXButton btnpromotion;
    @FXML
    private JFXButton btnparking;
    @FXML
    private Tab TabGererClient;
    @FXML
    private Tab tabgererpersonnel;
    @FXML
    private Tab taboffreemploi;
    @FXML
    private Tab tabopromotion;
    @FXML
    private TextField nomPromo;
    @FXML
    private TextField descripPromo;
    @FXML
    private TextField prixpromo;
    @FXML
    private TextField quantitePromo;
    @FXML
    private TextField dateExp;
    @FXML
    private TextField imagePromo;
    @FXML
    private TableView<?> tablePromo;
    @FXML
    private TableColumn<?, ?> c1nomPromo;
    @FXML
    private TableColumn<?, ?> c2descPromo;
    @FXML
    private TableColumn<?, ?> c3prix;
    @FXML
    private TableColumn<?, ?> c4dateRedPromo;
    @FXML
    private TableColumn<?, ?> c6quantitePromo;
    @FXML
    private TableColumn<?, ?> c5dateCreaPromo;
    @FXML
    private TableColumn<?, ?> idProduit;
    @FXML
    private Button afficherPromo;
    @FXML
    private Button insererPromo;
    @FXML
    private Button supprimerPromo;
    @FXML
    private Button modifierPromo;
    @FXML
    private Button validerModifPromo;
    @FXML
    private JFXTextField rechercher;
    @FXML
    private JFXComboBox<?> produitCombo;
    @FXML
    private Tab tabgererenseigne;
    @FXML
    private Tab tabgererenseigne1;
    @FXML
    private Tab tabStatistique;
    @FXML
    private JFXButton btnStatistique;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         admintabpane.getSelectionModel().select(tabopromotion);
    }    

    @FXML
    private void afficherPromoClicked(ActionEvent event) {
    }

    @FXML
    private void insertPromo(ActionEvent event) {
    }

    @FXML
    private void supprimerPromoSelected(ActionEvent event) {
    }

    @FXML
    private void modifierPromoClicked(ActionEvent event) {
    }

    @FXML
    private void validerModifPromoOnclicked(ActionEvent event) {
    }


    
}
