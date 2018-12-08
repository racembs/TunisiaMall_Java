/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_info;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import static javafx_info.FXMLGestionCilentController.idstatique;
import tn.pidev.tm.entite.Client;
import tn.pidev.tm.service.ClientService;

/**
 * FXML Controller class
 *
 * @author HP-PC
 */
public class GererClientsController implements Initializable {

    @FXML
    private TabPane admintabpane;
    @FXML
    private Tab home;
    @FXML
    private MediaView mediaTM;
    @FXML
    private Tab TabGererClient;
    @FXML
    private Tab tabgererpersonnel;
    @FXML
    private Tab taboffreemploi;
    @FXML
    private Tab tabopromotion;
    @FXML
    private Tab tabgererenseigne;
    @FXML
    private JFXButton btngerercompte;
    @FXML
    private JFXButton ptsfidelite;
    @FXML
    private JFXButton btnpromotion;
    @FXML
    private JFXButton btnparking;
    @FXML
    private Button btnBloquer;
    @FXML
    private Button actualiser;
    @FXML
    private Button btnModifier;
    @FXML
    private TextField chercherbyid;
    @FXML
    private TableView<Client> tableclient;
    @FXML
    private TableColumn<Client, String> tnom;
    @FXML
    private TableColumn<Client, String> tprenom;
    @FXML
    private TableColumn<Client, String> tcin;
    @FXML
    private TableColumn<Client, String> temail;
    @FXML
    private TableColumn<Client, String> tlogin;
    @FXML
    private TableColumn<Client, String> tmdp;
    @FXML
    private TableColumn<Client, String> tEtat;
    @FXML
    private Button btndebloquer;
     ClientService cs =new ClientService();
   Client c= new Client();
ObservableList<Client> clients; 
    @FXML
    private JFXButton btnStatistique;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       admintabpane.getSelectionModel().select(TabGererClient);
        tableclient.setItems(cs.getAllClient());
         
        
        tnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        tcin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        temail.setCellValueFactory(new PropertyValueFactory<>("mail"));
        tlogin.setCellValueFactory(new PropertyValueFactory<>("username"));
        tmdp.setCellValueFactory(new PropertyValueFactory<>("password"));
        tEtat.setCellValueFactory(new PropertyValueFactory<>("EtatBlocage"));
    }    


        
    

    

    @FXML
    private void onchercher_dans_table_clicked(KeyEvent event) {
        ClientService cs=new ClientService();
        if(cs.getListeByString(chercherbyid.getText()).size()!=0){
           tableclient.setItems(cs.getListeByString(chercherbyid.getText()));
        
        }
        else{
            
         this.clients = cs.getAllClient();
        tableclient.setItems(this.clients);
        tableclient.refresh();
        
      
        }
       
        
    }

    @FXML
    private void on_update_client_from_table_clicked(ActionEvent event) throws IOException {
        c=tableclient.getSelectionModel().getSelectedItem();
            idstatique=c.getId();
    Parent root = FXMLLoader.load(getClass().getResource("ModifierByAdmin.fxml"));
          
    Scene newScene= new Scene(root);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(newScene);
       window.show();
         
        
    }

    @FXML
    private void itemselected(MouseEvent event) {
        btnModifier.setDisable(false);
        btnBloquer.setDisable(false);
        btnBloquer.setDisable(false);
        btndebloquer.setDisable(false);
        
    }

    @FXML
    private void btnActualiserClicked(ActionEvent event) {
         this.clients = cs.getAllClient();
         tableclient.setItems(this.clients);
        tableclient.refresh();
           btnModifier.setDisable(true);
           btnBloquer.setDisable(true);
           btndebloquer.setDisable(true);
    }


    @FXML
    private void onbtnBloquerClicked(ActionEvent event) throws SQLException {
        
        c=tableclient.getSelectionModel().getSelectedItem();
        c.setEtatBlocage("bloque");
        cs.modifier(c);
         tableclient.setItems(cs.getAllClient());
        tableclient.refresh();
         btnModifier.setDisable(true);
         btnBloquer.setDisable(true);
           btndebloquer.setDisable(true);
        
    }

    @FXML
    private void onDeBloquerClicked(ActionEvent event) throws SQLException {
        c=tableclient.getSelectionModel().getSelectedItem();
        c.setEtatBlocage("nonbloque");
        cs.modifier(c);
         tableclient.setItems(cs.getAllClient());
        tableclient.refresh();
         btnModifier.setDisable(true);
         btnBloquer.setDisable(true);
           btndebloquer.setDisable(true);
    }

    @FXML
    private void onGererClientByAdminClicked(ActionEvent event) {
    }

    @FXML
    private void onHomeFromAdminclicked(ActionEvent event) {
    }

    @FXML
    private void onGererPersonnelClicked(ActionEvent event) {
    }

    @FXML
    private void onOfffreEmploiClicked(ActionEvent event) {
    }

    @FXML
    private void onPromotionAdminClicked(ActionEvent event) {
    }

    @FXML
    private void onGererEnseigneClicked(ActionEvent event) {
    }

    @FXML
    private void onStatistiqueClicked(ActionEvent event) {
    }

    
    
}
