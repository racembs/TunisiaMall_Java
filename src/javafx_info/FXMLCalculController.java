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
import javafx.scene.control.Label;
import tn.pidev.tm.service.ClientService;
import tn.pidev.tm.service.CommandeService;
import tn.pidev.tm.service.ProduitService;
import tn.pidev.tm.service.ServiceEnseigne;

/**
 * FXML Controller class
 *
 * @author HP-PC
 */
public class FXMLCalculController implements Initializable {

    @FXML
    private Label NbPL;
    @FXML
    private Label NbCltL;
    @FXML
    private Label NbCL;
    @FXML
    private Label NbE;
    @FXML
    private Button NbBE;
    @FXML
    private Button NbBP;
    @FXML
    private Button NbBClt;
    @FXML
    private Button NbBC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void Nbproduits(ActionEvent event)throws SQLException {
        
        
        ProduitService dao =new ProduitService();
        
        

        int y=dao.CalculP();
        String y1 = Integer.toString(y);
        NbPL.setText(y1);
    }

    @FXML
    private void Nbclients(ActionEvent event) throws SQLException {
        
             
        ClientService dao =new ClientService();
        
        

        int y=dao.CalculP();
        String y1 = Integer.toString(y);
        NbCltL.setText(y1);
    }

    @FXML
    private void Nbenseignes(ActionEvent event) throws SQLException {
                  
        ServiceEnseigne dao =new ServiceEnseigne();
        
        

        int y=dao.CalculP();
        String y1 = Integer.toString(y);
        NbE.setText(y1);
    }

    @FXML
    private void Nbcommandes(ActionEvent event) throws SQLException {

        CommandeService dao =new CommandeService();
        
        

        int y=dao.CalculP();
        String y1 = Integer.toString(y);
        NbCL.setText(y1);
    }
    }
    

