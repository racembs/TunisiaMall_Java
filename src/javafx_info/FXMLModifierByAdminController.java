/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_info;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import tn.pidev.tm.entite.Client;
import tn.pidev.tm.service.ClientService;

/**
 * FXML Controller class
 *
 * @author RBS
 */
public class FXMLModifierByAdminController implements Initializable {
    private int id_ens ;
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

    public int getId() {
        return id_ens;
    }

    public void setId(int id) {
        this.id_ens = id;
    }
    @FXML
    private TextField login;
    @FXML
    private TextField prenom;
    @FXML
    private TextField nom;
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
    private void onvalidermodificationclicked(ActionEvent event) throws SQLException {
      
        boolean b=true;
        
     
      
       String etat=cs.chercherId(FXMLGestionCilentController.idstatique).getEtatBlocage();
        Client c=new Client(FXMLGestionCilentController.idstatique,nom.getText(),prenom.getText(),email.getText()
                    ,cin.getText(),login.getText(),password.getText(),"client",etat);
      cs.modifier(c);
       
      Stage stage = (Stage) validermodification.getScene().getWindow();
    stage.close();
    }

    
}
