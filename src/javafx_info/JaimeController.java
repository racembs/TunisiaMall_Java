/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_info;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import tn.pidev.tm.entite.Produit;
import tn.pidev.tm.service.MentionJaimeService;
import tn.pidev.tm.service.ProduitService;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import tn.pidev.tm.entite.Client;
import tn.pidev.tm.entite.Mentionjaime;
import tn.pidev.tm.service.AdminService;
import tn.pidev.tm.service.ClientService;


/**
 * FXML Controller class
 *
 * @author HP-PC
 */
public class JaimeController implements Initializable {

  @FXML
    private Pane pane_pub;
    @FXML
    private Label lb_prenom;
    @FXML
    private Label lb_nom;
    @FXML
    private JFXButton bt_jaime;
    @FXML
    private Label lb_date;
    @FXML
    private JFXTextArea tf_contenuemp;
    @FXML
    private Label lb_jaime;
    @FXML
    private Label lb_commentaire;
    public void initialize(URL url, ResourceBundle rb) {
       
        
        
         
      
      ProduitService ps = new ProduitService();
      MentionJaimeService mjs = new MentionJaimeService();

       // System.out.println(ps.lister_publication());
       for(Produit pub:ps.getAll()){
            
            try {
               Pane panelPub = FXMLLoader.load(getClass().getResource("Jaime.fxml"));
                                    JFXTextArea ta =  (JFXTextArea) panelPub.lookup("#tf_contenuemp");
                                    ta.setText(pub.getNom());
                                    Label lbprenom=(Label) panelPub.lookup("#lb_prenom");
                                    lbprenom.setText(pub.getDescription());
                                     Label lbnom=(Label) panelPub.lookup("#lb_nom");
                                    lbnom.setText(pub.getCategorie());
                                    
                                    
                                    Label lbdate=(Label) panelPub.lookup("#lb_date");
                                    lbdate.setText(pub.getEnseigne().getNom());
                                    
                                    
                                    
                                    List<Mentionjaime> ls=mjs.list_jaimes_publication(pub);
                                    Label lbjaime=(Label) panelPub.lookup("#lb_jaime");
                                    lbjaime.setText(ls.size()+"");
                                    
                                      AdminService as=new AdminService();
                                     ClientService cs=new ClientService();
                                       int idclient=as.idclientfind(FXMLloginvideoController.usernameautho);  
                                        Client c= cs.chercherId(idclient);
                                    
                                   // List<Commentaire> lc = cs.list_commentaires_publication(pub);
                                    //Label lbcom=(Label) panelPub.lookup("#lb_commentaire");
                                    //lbcom.setText(lc.size()+"");
                                    JFXButton bt_jaime=(JFXButton) panelPub.lookup("#bt_jaime");
                                    bt_jaime.setOnMouseClicked(e->{
                                    Mentionjaime mj=new Mentionjaime(c,pub);
                                    mjs.ajouter_jaime(mj);
                                     int nb_jaime= mjs.list_jaimes_publication(pub).size();
                                      lbjaime.setText(nb_jaime+"");
                                    });
                                    
                                    
//                                    JFXButton bt_com=(JFXButton) panelPub.lookup("#bt_commenter");
//                                    bt_com.setOnMouseClicked(e->{

                                      /* try {
                                           Gestion_commentaireController.pub=pub;
                                           Parent root = FXMLLoader.load(getClass().getResource("/graphique/Gestion_commentaire.fxml"));
                                           Scene scene = new Scene(root);
                                           Stage mainWindow; //Here is the magic. We get the reference to main Stage.
                                           mainWindow = new Stage();
                                           mainWindow.setTitle("Commentaires");
                                           mainWindow.setScene(scene);
                                           mainWindow.show();
                                       } catch (IOException ex) {
                                           Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
                                       }*/
//                                   });
                                    
//                                    JFXButton btmodifier= (JFXButton) panelPub.lookup("#bt_modifier");
//                                    btmodifier.setOnMouseClicked(e->{
//                                      
//                                         try {
//                                          Modifier_pubController.pub=pub;
//                                           Parent root = FXMLLoader.load(getClass().getResource("/graphique/modifier_pub.fxml"));
//                                           Scene scene = new Scene(root);
//                                           Stage mainWindow; //Here is the magic. We get the reference to main Stage.
//                                           mainWindow = new Stage();
//                                           mainWindow.setTitle("modifier cette publication");
//                                           mainWindow.setScene(scene);
//                                           mainWindow.show();
//                                           
//                                       } catch (IOException ex) {
//                                           Logger.getLogger(PublicationsController.class.getName()).log(Level.SEVERE, null, ex);
//                                       }
//                                    
//                                    });
//                                    JFXButton btsupp=(JFXButton) panelPub.lookup("#bt_supprimer");
//                                    btsupp.setOnMouseClicked(e->{
//                                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//            alert.setTitle("Confirmation");
//            alert.setHeaderText("Suppression");
//            alert.setContentText("Êtes-vous sûr(e) de vouloir supprimer cette publication ?");
//            Optional<ButtonType> result = alert.showAndWait();
//                                        ps.supprimer_publication(pub.getId_publication());
//                                        
//                                    });
//                                    
                                    
                                    
                                  //  vb_pub.getChildren().add(panelPub);
                                    
            } catch (IOException ex) {
                Logger.getLogger( ex.getMessage());
            } catch (SQLException ex) {
              Logger.getLogger(JaimeController.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
      
      
    }    

    @FXML
    private void OnActionjaime(ActionEvent event) {
    }

    }    



