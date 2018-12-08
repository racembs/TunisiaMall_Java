/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_info;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.pidev.tm.entite.Client;
import tn.pidev.tm.service.ClientService;

/**
 * FXML Controller class
 *
 * @author HP-PC
 */
public class ModifierByAdminController implements Initializable {

    @FXML
    private TabPane admintabpane;
    @FXML
    private Tab home;
    @FXML
    private PasswordField cpassword;
    @FXML
    private PasswordField password;
    @FXML
    private Button validermodification;
    @FXML
    private TextField cin;
    @FXML
    private TextField email;
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

     private int id_ens ;
  

    public int getId() {
        return id_ens;
    }

    public void setId(int id) {
        this.id_ens = id;
    }
   
    private TextField id;
     ClientService cs=new ClientService();
     Client c=new Client();
     
/**
     * Initializes the controller class.
     */
  @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
         c=cs.chercherId(FXMLGestionCilentController.idstatique);
        
         nom.setText(c.getNom());
         prenom.setText(c.getPrenom());
         email.setText(c.getMail());
         cin.setText(c.getCin());
         login.setText(c.getUsername());
         password.setText(c.getPassword());
         cpassword.setText(c.getPassword());
    }    

    @FXML
    private void onvalidermodificationclicked(ActionEvent event) throws SQLException, IOException {
      
        boolean b=true;
        
     
      
       String etat=cs.chercherId(FXMLGestionCilentController.idstatique).getEtatBlocage();
        Client c=new Client(FXMLGestionCilentController.idstatique,nom.getText(),prenom.getText(),email.getText()
                    ,cin.getText(),login.getText(),password.getText(),"client",etat);
      cs.modifier(c);
      
       
       Parent root = FXMLLoader.load(getClass().getResource("GererClients.fxml"));
          
    Scene newScene= new Scene(root);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(newScene);
       window.show();
    }

    

    @FXML
    private void onstatistiqueselected(ActionEvent event) {
    }

    @FXML
    private void onhomeclicked(ActionEvent event) {
    }

    @FXML
    private void ongerercompteelected(ActionEvent event) {
    }

    @FXML
    private void onptsfideliteselected(ActionEvent event) {
    }

    @FXML
    private void onpromotionselected(ActionEvent event) {
    }

    @FXML
    private void onparkingselected(ActionEvent event) {
    }
    
}
