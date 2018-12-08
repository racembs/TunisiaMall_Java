/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_info;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.media.MediaView;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author RBS
 */
public class AdminController implements Initializable {

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
        // TODO
    }    

    @FXML
    private void onGererClientByAdminClicked(ActionEvent event) throws IOException {
        
        
                
//System.out.println("client");
        
          Parent root = FXMLLoader.load(getClass().getResource("GererClients.fxml"));
    Scene newScene= new Scene(root);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(newScene);
       window.show();}

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
    private void onPromotionAdminClicked(ActionEvent event) throws IOException {


  
               

        
          Parent root = FXMLLoader.load(getClass().getResource("PromoAdmin.fxml"));
    Scene newScene= new Scene(root);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(newScene);
       window.show();}    

    @FXML
    private void onGererEnseigneClicked(ActionEvent event) {
    }

    @FXML
    private void onStatistiqueClicked(ActionEvent event) throws IOException {
        
        
        
        
    
  
                admintabpane.getSelectionModel().select(tabStatistique);

        
          Parent root = FXMLLoader.load(getClass().getResource("Statistiques.fxml"));
    Scene newScene= new Scene(root);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(newScene);
       window.show();}   

    }

