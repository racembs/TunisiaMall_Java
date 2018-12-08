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

/**
 * FXML Controller class
 *
 * @author HP-PC
 */
public class LivraisonController implements Initializable {

    @FXML
    private TabPane admintabpane;
    @FXML
    private Tab home;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
