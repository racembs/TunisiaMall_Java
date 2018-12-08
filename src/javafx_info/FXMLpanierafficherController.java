/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_info;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import tn.pidev.tm.entite.LigneCommande;
import tn.pidev.tm.service.AdminService;
import tn.pidev.tm.service.CommandeService;

import tn.pidev.tm.service.LigneCommandeservice;
import tn.pidev.tm.service.ProduitService;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLpanierafficherController implements Initializable {

    @FXML
    private TableView<LigneCommande> tabpanier;
    @FXML
    private TableColumn<LigneCommande, String> article;
    @FXML
    private TableColumn<LigneCommande, Integer> quantite;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        

        // TODO
    }    

    
    @FXML
    private void afficherpanie(MouseEvent event) {
           try {   
            LigneCommandeservice P = new LigneCommandeservice();
        CommandeService cs= new CommandeService();
      AdminService adminservice =new   AdminService();


      

   int  idclient= adminservice.idclient(FXMLloginvideoController.usernameautho);
 int idcommande =cs.getidc(idclient);
               
tabpanier.setItems(P.getAll(FXMLProduitController.commande11));
           
        
   quantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
 
    article.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<LigneCommande,String>,ObservableValue<String>>(){

                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<LigneCommande, String> param) {
                    return new SimpleStringProperty(param.getValue().getProduit().getNom());
                }
            });
       
      
        
          } catch (SQLException ex) {
            Logger.getLogger(FXMLpanierafficherController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
