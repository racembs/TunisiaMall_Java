package javafx_info;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.pidev.tm.entite.CarteFidelite;
import tn.pidev.tm.entite.Client;
import tn.pidev.tm.entite.Paiement;
import tn.pidev.tm.service.AdminService;
import tn.pidev.tm.service.ClientService;
import tn.pidev.tm.service.CommandeService;

import tn.pidev.tm.service.PaiementService;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLpaiementController implements Initializable {

    @FXML
    private TextField codecarte;
    @FXML
    private TextField mdpcarte;
    @FXML
    private TextField user;
    @FXML
    private Button btnvalider;
    @FXML
    private Button btnexit;
    @FXML
    private Button btnannuler;
    @FXML
    private Label txtuser;
    @FXML
    private Label ttxtpswd;
    @FXML
    private Label txtcarte;
    @FXML
    private Label txtmdpcarte;
 
    @FXML
    private JFXTextField Total;
    @FXML
    private CheckBox edinar;
    @FXML
    private CheckBox cartebancaire;
    @FXML
    private Label montantvalide;
    @FXML
    private Label txtTotal;
    @FXML
    private Label txtverifusermdp;
    @FXML
    private Label txtverifcarte;
    @FXML
    private Label typepaiement;
    @FXML
    private TextField mdp1;

    @FXML
    private Button imprimer;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        typepaiement.setVisible(false);
        txtverifcarte.setVisible(false);
        txtverifusermdp.setVisible(false);
        mdpcarte.setVisible(false);
        montantvalide.setVisible(false);
          codecarte.setVisible(false);
          txtTotal.setVisible(false);     
              txtcarte.setVisible(false);   
                   txtmdpcarte.setVisible(false);
                       Total.setVisible(false);

                                            cartebancaire.setVisible(false);
                                             edinar.setVisible(false);
    }    

    @FXML
    private void validerlepaiement(ActionEvent event) throws SQLException {
                                              typepaiement.setVisible(false);
                                            cartebancaire.setVisible(false);
                                             edinar.setVisible(false);
                                            txtverifusermdp.setVisible(true);
                                            txtverifcarte.setVisible(true);
                                            txtverifusermdp.setText("");
                                            txtverifcarte.setText("");
                                            String login=user.getText();
                                            String pwd =mdp1.getText();
//                                             String usrname=co.getAll().getLogin();
//                                               String pwd1=co.getAll().getMdp();
                                if(/*(pwd1.equals(pwd))&&*/(FXMLloginvideoController.usernameautho.equals(login)))
                                        {cartebancaire.setVisible(true);
                                        edinar.setVisible(true);
                                        typepaiement.setVisible(true);
                                            txtverifusermdp.setText(" le pwd et le username verifier");
                     if(edinar.isSelected())
                             {
                                   Total.setVisible(true);                          ////setdate commande
                               AdminService adminservice = new AdminService();
                               int  idclient = adminservice.idclient(login);
                                CommandeService cs= new CommandeService();
                                int idcommande =cs.getidc(idclient);
                                Total.setText(Double.toString(cs.fgetTotal(idcommande)));
                                 ////////////////////
                                 Paiement p =new Paiement();
                                 PaiementService ps=new PaiementService();
                           p = ps.verifierAdmin(codecarte.getText(), mdpcarte.getText());
                             montantvalide.setVisible(true);
                                montantvalide.setText("");
            if((codecarte.getText().equals(p.getCarte()))&&(mdpcarte.getText().equals(p.getMdp())))
                    { txtverifcarte.setText("carte valider ");
        
                     }
            else
                     { txtverifcarte.setText("Veillez verifier votre carte ");
        
                        }
           
           
           
            }
                     else{codecarte.setText("");
                         mdpcarte.setText("");
                     }
  
       }
                                 else
                            {txtverifusermdp.setText("veuillez verifier le pwd ou le username");
                              /*  ClientService cs =new ClientService();
                                Client c=new Client();
                                CarteFidelite cf=new CarteFidelite();
                                cf.setNombreDePoints(100);
                                
                                cf.setNombreDePoints(0);
                                cs.modifier(c);*/
      
                               }               
    }
        
        
    

    @FXML
    private void onExitclicked(ActionEvent event) throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("FXMLlogin.fxml"));
    Scene newScene= new Scene(root);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(newScene);
       window.show();
    }

    @FXML
    private void onannulerclick(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("FXMLpanier.fxml"));
    Scene newScene= new Scene(root);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(newScene);
       window.show();
    }

    @FXML
    private void onedinarclicked(ActionEvent event) {
          edinar.setSelected(true);
            cartebancaire.setSelected(false);
          codecarte.setVisible(true);
           mdpcarte.setVisible(true);     
              txtcarte.setVisible(true);   
                   txtmdpcarte.setVisible(true);
                           mdp1.setVisible(true);
                           Total.setVisible(true);
                           txtTotal.setVisible(true);
                                 
    }

    @FXML
    private void oncartebancaireclick(ActionEvent event) {
        cartebancaire.setSelected(true);
           edinar.setSelected(false);
          codecarte.setVisible(true);
           mdpcarte.setVisible(true);     
              txtcarte.setVisible(true);   
                   txtmdpcarte.setVisible(true);
                           mdp1.setVisible(true);
                           Total.setVisible(true);
        
        
        
    }

    @FXML
    private void onimprimerclick(ActionEvent event) {
    }
    
}
