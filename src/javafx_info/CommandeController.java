/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_info;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SortEvent;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import static javafx.scene.input.KeyCode.C;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

import javafx.scene.layout.VBox;

import javafx.stage.Stage;
import javafx.util.Callback;
import static javafx_info.FXMLProduitController.commande11;
import tn.pidev.tm.entite.Commande;

import tn.pidev.tm.entite.Produit;
import tn.pidev.tm.service.AdminService;
import tn.pidev.tm.service.CommandeService;



import tn.pidev.tm.service.LigneCommandeservice;
import tn.pidev.tm.service.ProduitService;

/**
 * FXML Controller class
 *
 * @author HP-PC
 */
public class CommandeController implements Initializable  {
     @FXML
    private TableView <Produit> pd;
    @FXML
    private TableColumn<Produit, Integer> reference;
    @FXML
    private TableColumn<Produit, String> nom;
    @FXML
    private TableColumn<Produit, String> idenseigne;
    @FXML
    private TableColumn<Produit, String> categorie;
    @FXML
    private TableColumn<Produit, Double> prix;
    @FXML
    private TableColumn<Produit, String> description;
    @FXML
    private TableColumn<Produit, Float> promotion;
    @FXML
    private TableColumn<Produit, String> image;
    
    @FXML
    private JFXTextField qt;
   
  static int commande11 ;
   static int commande12 ;
   CommandeService cs= new CommandeService();
      AdminService adminservice =new   AdminService();


    @FXML
    private JFXDrawer PANIERDRAW;
    @FXML
    private JFXTextField commandeactuelle;
    @FXML
    private Button commandeajout;
    @FXML
    private TableView<Commande> tabcommande;
    @FXML
    private TableColumn<Commande, String> cmd;
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
     * @throws java.sql.SQLException
     */
  
   @Override
    public void initialize(URL location, ResourceBundle resources) {
  
        
              
          ObservableList<Produit> data;
  ProduitService PS;
        PS = new ProduitService();

           
        data = FXCollections.observableArrayList();
         pd.setItems( PS.getAll1());

        reference.setCellValueFactory(new PropertyValueFactory<>("reference"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
       idenseigne.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Produit,String>,ObservableValue<String>>(){
           
        @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<Produit, String> param) {
                    return new SimpleStringProperty(param.getValue().getEnseigne().getNom());
                }
            });
       categorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        promotion.setCellValueFactory(new PropertyValueFactory<>("promo"));
        image.setCellValueFactory(new PropertyValueFactory<>("image"));
    }
 
         
 



    @FXML
    private boolean onajouterpanierclick(ActionEvent event) throws SQLException{

      
   int  idclient= adminservice.idclient(FXMLloginvideoController.usernameautho);

 
   if (cs.verifCommande(idclient)==0)
   {
     cs.insererC(idclient);
    
   }

   
    
        

if (pd.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alert de controle");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez selectionner un produit !");
            alert.showAndWait();
        } else if (qt.getText().equals(""))
        {   Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alert de controle");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir la quantitie !");
         alert.showAndWait();}
        else    
        {
          

        

                                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                    alert.setTitle("Confirmation");
                                    alert.setHeaderText("Confirmation");
                                    alert.setContentText("voulez vous qjouter ce produit ?");

                                    Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
        
        LigneCommandeservice l=new LigneCommandeservice();
        double prixi=pd.getSelectionModel().getSelectedItem().getPrix();
        double promo=pd.getSelectionModel().getSelectedItem().getPromo();
         int quantit = Integer.parseInt(qt.getText());
         double total=(prixi*quantit)-prixi*quantit*promo;
         int idproduit =pd.getSelectionModel().getSelectedItem().getId();
         
         int idcom =Integer.parseInt(commandeactuelle.getText());
        
            l.insererp(idproduit,idcom,quantit,total,prixi,promo);
            pd.getSelectionModel().clearSelection();
qt.setText("");
        return true;
        }
        else {
              pd.getSelectionModel().clearSelection();
            }
}

         

   return false;

   }

    @FXML
    private void consulterclick(ActionEvent event) throws IOException {
     
         Parent root = FXMLLoader.load(getClass().getResource("Panier.fxml"));
    Scene newScene= new Scene(root);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(newScene);
       window.show();
    }



    @FXML
    private void PANIEREXITED(MouseEvent event) {
        
        
        
        if(PANIERDRAW.isShown())
            {
                PANIERDRAW.close();
            }
    }

    @FXML
    private void PANIERENTRED(MouseEvent event) {
         VBox box;
        try {
            box = FXMLLoader.load(getClass().getResource("FXMLpanierafficher.fxml"));
               PANIERDRAW.setSidePane(box);
        } catch (IOException ex) {
            Logger.getLogger(FXMLadminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        PANIERDRAW.open();
        
        
    }
    
    void PANIERAFFICHE(ActionEvent event) {
     

    }

    @FXML
    private void oncommandeclick(ActionEvent event) throws SQLException {
            
   int  idclient= adminservice.idclient(FXMLloginvideoController.usernameautho);
   int idcommande =cs.getidc(idclient);
   cs.insererC(idclient);
  
 
            ObservableList<Commande> data1;
 Commande ps;
        ps = new Commande();
CommandeService C=new CommandeService();
         
        data1 = FXCollections.observableArrayList();
         tabcommande.setItems(C.getAllcommande(idclient));

        cmd.setCellValueFactory(new PropertyValueFactory<>("id"));

       
    }

  

   


    


    @FXML
    private void jjjjjj(MouseEvent event) {
         int id= tabcommande.getSelectionModel().getSelectedItem().getId();
       String t=Integer.toString(id);
commandeactuelle.setText(t);
commande11=tabcommande.getSelectionModel().getSelectedItem().getId();

    }
 @FXML
    private void onhomeclicked(ActionEvent event) {
        admintabpane.getSelectionModel().select(home);
    }

    @FXML
    private void onstatistiqueselected(ActionEvent event) {
        admintabpane.getSelectionModel().select(statistique);
    }

    @FXML
    private void ongerercompteelected(ActionEvent event) throws IOException {
        admintabpane.getSelectionModel().select(tabgerercompte);
    Parent root = FXMLLoader.load(getClass().getResource("GererCompte.fxml"));
          
    Scene newScene= new Scene(root);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(newScene);
       window.show();
        
    }

    @FXML
    private void onptsfideliteselected(ActionEvent event) throws IOException {
        admintabpane.getSelectionModel().select(tabptsfidelite);
        
            Parent root = FXMLLoader.load(getClass().getResource("PointsFid.fxml"));
          
    Scene newScene= new Scene(root);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(newScene);
       window.show();
        
    }

    @FXML
    private void onpromotionselected(ActionEvent event) throws IOException {
         admintabpane.getSelectionModel().select(tabpromotion);
                   Parent root = FXMLLoader.load(getClass().getResource("Interface1.fxml"));
          
    Scene newScene= new Scene(root);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(newScene);
       window.show();
         
         
    }

    @FXML
    private void onparkingselected(ActionEvent event) throws IOException {
         admintabpane.getSelectionModel().select(tabparking);
         
   Parent root = FXMLLoader.load(getClass().getResource("Parking.fxml"));
          
    Scene newScene= new Scene(root);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(newScene);
       window.show();
    }

    @FXML
    private void voir(ActionEvent event) throws IOException {
        
           Parent root = FXMLLoader.load(getClass().getResource("Commande.fxml"));
          
    Scene newScene= new Scene(root);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(newScene);
       window.show();
        
    }

  
 
    
}
