/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_info;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
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
 * @author Asus
 */
public class FXMLclientController implements Initializable {
CartefideliteService carteservice=new CartefideliteService();
    @FXML
    private Button transformer;
    @FXML
    private Tab c;
    @FXML
    private TableView<CarteFidelite> tabfidelite;
    @FXML
    private TableColumn<CarteFidelite, String> tnom;
    @FXML
    private TableColumn<CarteFidelite,Integer > tnbrpts;
    @FXML
    private TableColumn<CarteFidelite, String> tbenifice;
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
// Connexion conn=new Connexion();
//        ConnexionService connexionservice=new ConnexionService();
    
    @FXML
    private TableColumn<CarteFidelite, String> tidcarte;
    @FXML
    private Tab gerercompte_client;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handledeconnexionclient(ActionEvent event) throws IOException, SQLException {
        
         
//        connexionservice.supprimer(conn);
          Parent root = FXMLLoader.load(getClass().getResource("FXMLlogin.fxml"));
          
    Scene newScene= new Scene(root);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(newScene);
       window.show();
       
        
    }

    @FXML
    private void ontransformerclicked(ActionEvent event) throws SQLException {
      
        Alert alert = new Alert(Alert.AlertType.WARNING);
     alert.setTitle("Confirmation");
       alert.setHeaderText("Confirmation");
       alert.setContentText("voulez vous reellement transformer ces points ?");
      Optional<ButtonType> result = alert.showAndWait();
     if (result.get() == ButtonType.OK) {
       CartefideliteService cfs=new CartefideliteService();
      
       CarteFidelite carte=new CarteFidelite();
       carte=tabfidelite.getSelectionModel().getSelectedItem();
       
         carte.setNombreDePoints(0);
        cfs.resetcarte(carte);
        
         Client c=new Client();
 CartefideliteService cs=new CartefideliteService();
    ClientService clientservice =new ClientService();
     
        c=clientservice.chercherclientbylogin(FXMLloginvideoController.usernameautho);
        
         
       tabfidelite.setItems(cs.getAll(c.getId()));
     
        tidcarte.setCellValueFactory(new PropertyValueFactory<>("id"));
         
        tnbrpts.setCellValueFactory(new PropertyValueFactory<>("nombreDePoints"));
       
    }
    }
 
    @FXML
    private void onCarteFideliteselected(Event event) throws SQLException {
                Client c=new Client();
 CartefideliteService cs=new CartefideliteService();
    ClientService clientservice =new ClientService();
      
           
        c=clientservice.chercherclientbylogin(FXMLloginvideoController.usernameautho);
       CarteFidelite carte=new CarteFidelite();
           

      
        
        
      tabfidelite.setItems(cs.getAll(c.getId()));
        tidcarte.setCellValueFactory(new PropertyValueFactory<>("id"));
     
       tnom.setCellValueFactory(new Callback<CellDataFeatures<CarteFidelite,String>,ObservableValue<String>>(){

                @Override
                public ObservableValue<String> call(CellDataFeatures<CarteFidelite, String> param) {
                    return new SimpleStringProperty(param.getValue().getEnseigne().getNom());
                }
            });
               
          tnbrpts.setCellValueFactory(new PropertyValueFactory<>("nombreDePoints"));
          
          tbenifice.setCellValueFactory(new Callback<CellDataFeatures<CarteFidelite,String>,ObservableValue<String>>(){

                @Override
                public ObservableValue<String> call(CellDataFeatures<CarteFidelite, String> param) {
                    return new SimpleStringProperty(param.getValue().getEnseigne().getbon_achat(param.getValue().getId(),param.getValue().getEnseigne().getId()));
                }
            });
          
       
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
                    ,cin.getText(),login.getText(),password.getText(),"client");
       
       
        
         cs.modifier(c);
    }

    

    @FXML
    private void on_gerercompte_client_selected(Event event) throws SQLException {
//          conn= connexionservice.getAll();
           Client c=new Client();
           ClientService clientservice =new ClientService();
        c=clientservice.chercherclientbylogin(FXMLloginvideoController.usernameautho);
        nom.setText(c.getNom());
         prenom.setText(c.getPrenom());
         email.setText(c.getMail());
         cin.setText(c.getCin());
         login.setText(c.getUsername());
         password.setText(c.getPassword());
         
    }

    @FXML
    void click(ActionEvent event) throws IOException {
 Parent root = FXMLLoader.load(getClass().getResource("FXMLProduit.fxml"));
    Scene newScene= new Scene(root);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(newScene);
       window.show();
    }
    
}
