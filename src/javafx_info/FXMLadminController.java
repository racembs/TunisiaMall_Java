/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_info;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLadminController implements Initializable {

    @FXML
    private Button deconnexion;
    @FXML
    private Label welcomelabel;

    @FXML
    private JFXDrawer menuadmin;
    @FXML
    private Button btngestionclient;
    @FXML
    private Button btngestionpersonnel;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        VBox box;
        try {
            box = FXMLLoader.load(getClass().getResource("FXMLmenu.fxml"));
               menuadmin.setSidePane(box);
        } catch (IOException ex) {
            Logger.getLogger(FXMLadminController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        // TODO
    }    

    @FXML
    private void handledeconnexionAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLlogin.fxml"));
    Scene newScene= new Scene(root);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(newScene);
       window.show();
    }
     @FXML
       void startmenuadmin(MouseEvent event) {
            menuadmin.open();

    }
  @FXML
    void exitmenuadmin(MouseEvent event) {
         if(menuadmin.isShown())
            {
                menuadmin.close();
            }

    }

    @FXML
    private void ongestionclientclicked(ActionEvent event) throws IOException {
        
          Parent root = FXMLLoader.load(getClass().getResource("FXMLGestionCilent.fxml"));
    Scene newScene= new Scene(root);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(newScene);
       window.show();
        
    }

    @FXML
    private void ongestionpersonnel(ActionEvent event) {
      /*   Parent root = FXMLLoader.load(getClass().getResource("*******.fxml"));
    Scene newScene= new Scene(root);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(newScene);
       window.show();*/
    }

   
}
