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
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static javafx_info.FXMLloginvideoController.usernameautho;
import tn.pidev.tm.entite.Client;
import tn.pidev.tm.service.ClientService;

/**
 * FXML Controller class
 *
 * @author RBS
 */
public class VerifiercodeController implements Initializable {

    ClientService clientService=new ClientService();
    Client c=new Client();
   
    private TextField txtcode;
    @FXML
    private Label invnom1;
    @FXML
    private Label invcin1;
    @FXML
    private Label invemail1;
    @FXML
    private Label invmdp1;
    @FXML
    private Label invlogin1;
    @FXML
    private Label invprenom1;
    @FXML
    private JFXButton validercode1;
    @FXML
    private TextField txtcode1;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onvalidercodeclicked(ActionEvent event) throws SQLException, IOException {
          c=clientService.chercherclientbylogin(usernameautho);
          
          if(c.getCode().equals(txtcode1.getText())){ 
              c.setCode("0");
              clientService.modifiercode(c);
    Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
    Scene newScene= new Scene(root);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(newScene);
 window.show();
          }
    }
    
}
