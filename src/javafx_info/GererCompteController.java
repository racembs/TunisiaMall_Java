/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_info;

import com.jfoenix.controls.JFXButton;
import com.sun.deploy.util.SessionState;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import tn.pidev.tm.entite.CarteFidelite;
import tn.pidev.tm.entite.Client;

import tn.pidev.tm.entite.Enseigne;
import tn.pidev.tm.service.CartefideliteService;
import tn.pidev.tm.service.ClientService;

/**
 * FXML Controller class
 *
 * @author HP-PC
 */
public class GererCompteController implements Initializable {

    @FXML
    private TabPane admintabpane;
    @FXML
    private Tab home;
    @FXML
    private Button validermodification;
    @FXML
    private TextField cin;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private TextField login;
    @FXML
    private TextField prenom;
    @FXML
    private TextField nom;
    @FXML
    private Tab statistique;
    @FXML
    private Tab tabgerercompte;
    @FXML
    private Tab tabptsfidelite;
    @FXML
    private Tab tabpromotion;
    @FXML
    private Tab tabparking;
    @FXML
    private JFXButton btngerercompte;
    @FXML
    private JFXButton ptsfidelite;
    @FXML
    private JFXButton btnpromotion;
    @FXML
    private JFXButton btnparking;
    ClientService cs=new ClientService();
    Client c=new Client();
    @FXML
    private PasswordField cpassword;

    
//     Connexion conn=new Connexion();
//        ConnexionService connexionservice=new ConnexionService();
//    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            c=cs.chercherclientbylogin(FXMLloginvideoController.usernameautho);
        } catch (SQLException ex) {
            Logger.getLogger(GererCompteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         nom.setText(c.getNom());
         prenom.setText(c.getPrenom());
         email.setText(c.getMail());
         cin.setText(c.getCin());
         login.setText(c.getUsername());
         password.setText(c.getPassword());
         cpassword.setText(c.getPassword());
    }    

    @FXML
    private void onvalidermodificationclicked(ActionEvent event) throws SQLException {
        
       
        
                ClientService cs=new ClientService();
        //ancien donnee
        Client ancienclient=new Client();
           ClientService clientservice =new ClientService();
        ancienclient=clientservice.chercherclientbylogin(FXMLloginvideoController.usernameautho);
        
        //nv donnee 
        //id ne doit pas etre changer 

       Client c=new Client(ancienclient.getId(),nom.getText(),prenom.getText(),email.getText()
                    ,cin.getText(),login.getText(),password.getText(),"client",ancienclient.getEtatBlocage());
       
       
        
         cs.modifier(c);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("information");
        alert.setHeaderText(null);
        alert.setContentText("modification effectué");
        alert.show();
    }

    @FXML
    private void onhomeclicked(ActionEvent event) throws IOException {
      Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
          
    Scene newScene= new Scene(root);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(newScene);
       window.show();
    }

    @FXML
    private void onstatistiqueselected(ActionEvent event) {
        admintabpane.getSelectionModel().select(statistique);
    }

    @FXML
    private void ongerercompteelected(ActionEvent event) throws IOException {
        admintabpane.getSelectionModel().select(tabgerercompte);
    Parent root = FXMLLoader.load(getClass().getResource("GererCompte.fxml"));
          
    Scene newScene= new Scene(root);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(newScene);
       window.show();
        
    }

    @FXML
    private void onptsfideliteselected(ActionEvent event) throws IOException {
        admintabpane.getSelectionModel().select(tabptsfidelite);
        
            Parent root = FXMLLoader.load(getClass().getResource("PointsFid.fxml"));
          
    Scene newScene= new Scene(root);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(newScene);
       window.show();
        
    }

    @FXML
    private void onpromotionselected(ActionEvent event) throws IOException {
         admintabpane.getSelectionModel().select(tabpromotion);
                   Parent root = FXMLLoader.load(getClass().getResource("Interface1.fxml"));
          
    Scene newScene= new Scene(root);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(newScene);
       window.show();
         
         
    }

    @FXML
    private void onparkingselected(ActionEvent event) throws IOException {
         admintabpane.getSelectionModel().select(tabparking);
         
   Parent root = FXMLLoader.load(getClass().getResource("Parking.fxml"));
          
    Scene newScene= new Scene(root);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(newScene);
       window.show();
    }

    private void voir(ActionEvent event) throws IOException {
        
           Parent root = FXMLLoader.load(getClass().getResource("Commande.fxml"));
          
    Scene newScene= new Scene(root);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(newScene);
       window.show();
        
    }
    
}
