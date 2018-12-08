/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_info;


import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import tn.pidev.tm.entite.Client;
import tn.pidev.tm.entite.Commande;
import tn.pidev.tm.entite.LigneCommande;
import tn.pidev.tm.entite.Produit;

import tn.pidev.tm.service.AdminService;
import tn.pidev.tm.service.ClientService;
import tn.pidev.tm.service.CommandeService;

import tn.pidev.tm.service.LigneCommandeservice;
import javafx_info.FXMLProduitController;
import static javafx_info.FXMLProduitController.commande11;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author HP-PC
 */
public class PanierController implements Initializable {

    @FXML
    private TabPane admintabpane;
    @FXML
    private Tab home;
    @FXML
    private Button buttvalider;
    @FXML
    private Button butsup;
    @FXML
    
    

  
    private TableColumn<LigneCommande,String> tbaricle;
    @FXML
    private TableColumn<LigneCommande, String> tbprix;
    @FXML
    private TableColumn<LigneCommande, Integer> tbquantite;
    @FXML
    private TableColumn<LigneCommande, String> tbprixtotal;
    @FXML
    private TableView<LigneCommande> pd;
    @FXML
    private JFXTextField Total;
     LigneCommandeservice P = new LigneCommandeservice();
       
        CommandeService cs= new CommandeService();
      AdminService adminservice =new   AdminService();

    @FXML
    private JFXCheckBox livraisonok;
    @FXML
    private JFXTextField montantlivrason;
    @FXML
    private Label txtmontantliv;
    @FXML
    private JFXTextField txtmontanttotal;
    @FXML
    private Label txttotal;
    @FXML
    private JFXCheckBox sanslivraison;
    @FXML
    private Button modifier;
    @FXML
    private JFXTextField quantite;
    @FXML
    private Button btnvaliderquant;
    @FXML
    private Label txtqauantite;
    @FXML
    private Button btnannulerquantite;
    
    @FXML
    private Button butsupcommande;
    @FXML
    private JFXTextField find;
    @FXML
    private TableView<Commande> tabcommande;
    @FXML
    private TableColumn<Commande, String> cmd;
    @FXML
    private Label commandeactuelle;


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
        
          txtmontantliv.setVisible(false);
        montantlivrason.setVisible(false);
        txtmontanttotal.setVisible(false);
        txttotal.setVisible(false);
         /////////////////modifier
            txtqauantite.setVisible(false);
        btnvaliderquant.setVisible(false);
        btnannulerquantite.setVisible(false);
        quantite.setVisible(false);
         


        try {
                

             int  idclient= adminservice.idclient(FXMLloginvideoController.usernameautho);
 int idcommande =cs.getidc(idclient);
            
            pd.setItems(P.getAll(FXMLProduitController.commande11));
            double TotalX=     P.calculerTotal(FXMLProduitController.commande11);
            Total.setText(Float.toString((float)TotalX)); 

            ObservableList<Commande> data1;
 Commande ps;
        ps = new Commande();
CommandeService C=new CommandeService();
        
        data1 = FXCollections.observableArrayList();
         tabcommande.setItems(C.getAllcommande(idclient));

        cmd.setCellValueFactory(new PropertyValueFactory<>("id"));
       
   
        
    tbquantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
 
    tbaricle.setCellValueFactory(new Callback<CellDataFeatures<LigneCommande,String>,ObservableValue<String>>(){

                @Override
                public ObservableValue<String> call(CellDataFeatures<LigneCommande, String> param) {
                    return new SimpleStringProperty(String.valueOf(param.getValue().getProduit().getReference()));
                }
            });
        tbprixtotal.setCellValueFactory(new Callback<CellDataFeatures<LigneCommande,String>,ObservableValue<String>>(){

                @Override
                public ObservableValue<String> call(CellDataFeatures<LigneCommande, String> param) {
                    return new SimpleStringProperty(String.valueOf((float)param.getValue().getTotal()));
                }
            });
     tbprix.setCellValueFactory(new Callback<CellDataFeatures<LigneCommande,String>,ObservableValue<String>>(){

                @Override
                public ObservableValue<String> call(CellDataFeatures<LigneCommande, String> param) {
                    return new SimpleStringProperty(String.valueOf((float)(param.getValue().getPrix())));
                }
            });
        
      
         } catch (SQLException ex) {
            Logger.getLogger(FXMLpanierController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }    


    

    @FXML
    private void onsupprimeclik(ActionEvent event) throws SQLException {
        
        if (pd.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alert de controle");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez selectionner un produit !");
            alert.showAndWait();}
        else
        {  Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
     alert.setTitle("Confirmation");
       alert.setHeaderText("Confirmation");
       alert.setContentText("voulez vous supprimer cette article ?");
      Optional<ButtonType> result = alert.showAndWait();
     if (result.get() == ButtonType.OK) {
       LigneCommandeservice c=new LigneCommandeservice();
        c.supprimerP(pd.getSelectionModel().getSelectedItem().getId());}
           
        ///affichage
        
      


   int  idclient= adminservice.idclient(FXMLloginvideoController.usernameautho);
 int idcommande =cs.getidc(idclient);


            pd.setItems(P.getAll(FXMLProduitController.commande11));
          
        
   tbquantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
 
    tbaricle.setCellValueFactory(new Callback<CellDataFeatures<LigneCommande,String>,ObservableValue<String>>(){

                @Override
                public ObservableValue<String> call(CellDataFeatures<LigneCommande, String> param) {
                    return new SimpleStringProperty(String.valueOf(param.getValue().getProduit().getReference()));
                }
            });
        tbprixtotal.setCellValueFactory(new Callback<CellDataFeatures<LigneCommande,String>,ObservableValue<String>>(){

                @Override
                public ObservableValue<String> call(CellDataFeatures<LigneCommande, String> param) {
                    return new SimpleStringProperty(String.valueOf((float)param.getValue().getTotal()));
                }
            });
     tbprix.setCellValueFactory(new Callback<CellDataFeatures<LigneCommande,String>,ObservableValue<String>>(){

                @Override
                public ObservableValue<String> call(CellDataFeatures<LigneCommande, String> param) {
                    return new SimpleStringProperty(String.valueOf((float)(param.getValue().getPrix())));
                }
            });
        
        
      //////////////////////////////////
      
      
      
        
    }


             int  idclient= adminservice.idclient(FXMLloginvideoController.usernameautho);
 int idcommande =cs.getidc(idclient);


            pd.setItems(P.getAll(FXMLProduitController.commande11));
       double TotalX=     P.calculerTotal(FXMLProduitController.commande11);
     double TotalY=TotalX+20.0;
       
       Total.setText(Float.toString((float)TotalX)); 
       txtmontanttotal.setText(Float.toString((float)TotalX)); 
   
    }
    @FXML
    private void onexitcliqued(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("FXMLproduit.fxml"));
    Scene newScene= new Scene(root);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(newScene);
       window.show();
        
        
        
        
        
        
    }

    private void onafficherclick(ActionEvent event) throws SQLException {
      



   int  idclient= adminservice.idclient(FXMLloginvideoController.usernameautho);
 int idcommande =cs.getidc(idclient);


            pd.setItems(P.getAll(FXMLProduitController.commande11));
          
        
  tbquantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
 
    tbaricle.setCellValueFactory(new Callback<CellDataFeatures<LigneCommande,String>,ObservableValue<String>>(){

                @Override
                public ObservableValue<String> call(CellDataFeatures<LigneCommande, String> param) {
                    return new SimpleStringProperty(String.valueOf(param.getValue().getProduit().getReference()));
                }
            });
        tbprixtotal.setCellValueFactory(new Callback<CellDataFeatures<LigneCommande,String>,ObservableValue<String>>(){

                @Override
                public ObservableValue<String> call(CellDataFeatures<LigneCommande, String> param) {
                    return new SimpleStringProperty(String.valueOf((float)param.getValue().getTotal()));
                }
            });
     tbprix.setCellValueFactory(new Callback<CellDataFeatures<LigneCommande,String>,ObservableValue<String>>(){

                @Override
                public ObservableValue<String> call(CellDataFeatures<LigneCommande, String> param) {
                    return new SimpleStringProperty(String.valueOf((float)(param.getValue().getPrix())));
                }
            });
        
        
      
      
        
    }

    @FXML
    private void onsupprimercommande(ActionEvent event) throws SQLException {
             if (tabcommande.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alert de controle");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez selectionner un commande !");
            alert.showAndWait();}
        else
        {  Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
     alert.setTitle("Confirmation");
       alert.setHeaderText("Confirmation");
       alert.setContentText("voulez vous supprimer cette commande?");  
        
      Optional<ButtonType> result = alert.showAndWait();
     if (result.get() == ButtonType.OK) {
      CommandeService c=new CommandeService();
        LigneCommandeservice css=new LigneCommandeservice();
   


   int  idclient= adminservice.idclient(FXMLloginvideoController.usernameautho);
 int idcommande =c.getidc(idclient);
        css.supprimerC(FXMLProduitController.commande11);
           
        ///affichage
        
     
  


            pd.setItems(P.getAll(FXMLProduitController.commande11));
          
   tbquantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
 
    tbaricle.setCellValueFactory(new Callback<CellDataFeatures<LigneCommande,String>,ObservableValue<String>>(){

                @Override
                public ObservableValue<String> call(CellDataFeatures<LigneCommande, String> param) {
                    return new SimpleStringProperty(String.valueOf(param.getValue().getProduit().getReference()));
                }
            });
        tbprixtotal.setCellValueFactory(new Callback<CellDataFeatures<LigneCommande,String>,ObservableValue<String>>(){

                @Override
                public ObservableValue<String> call(CellDataFeatures<LigneCommande, String> param) {
                    return new SimpleStringProperty(String.valueOf((float)param.getValue().getTotal()));
                }
            });
     tbprix.setCellValueFactory(new Callback<CellDataFeatures<LigneCommande,String>,ObservableValue<String>>(){

                @Override
                public ObservableValue<String> call(CellDataFeatures<LigneCommande, String> param) {
                    return new SimpleStringProperty(String.valueOf((float)(param.getValue().getPrix())));
                }
            });
        
        
     }
    }
      Total.setText("");
      txtmontanttotal.setText("");
      montantlivrason.setText("");
}

    @FXML
    private void onlivraisonok(ActionEvent event) throws SQLException {
        livraisonok.setSelected(true);
        txtmontantliv.setVisible(true);
        montantlivrason.setVisible(true);
                txtmontanttotal.setVisible(true);
                txttotal.setVisible(true);
 sanslivraison.setSelected(false);
 montantlivrason.setText("20.0");
 //////

             int  idclient= adminservice.idclient(FXMLloginvideoController.usernameautho);
 int idcommande =cs.getidc(idclient);
  double TotalX=     P.calculerTotal(FXMLProduitController.commande11);
  TotalX=TotalX+20.0;
txtmontanttotal.setText(Float.toString((float)TotalX)); 

 
    }

    @FXML
    private void sanslivraisonclicked(ActionEvent event) {
         livraisonok.setSelected(false);
        txtmontantliv.setVisible(false);
        montantlivrason.setVisible(false);
                txtmontanttotal.setVisible(false);
                txttotal.setVisible(false);
                sanslivraison.setVisible(true);
                
    }
////////////////////////modifier la quantite
    @FXML
    private void onmodifierclicked(ActionEvent event) {
        
if (pd.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alert de controle");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez selectionner un produit !");
            alert.showAndWait();
            
         }else
{   txtqauantite.setVisible(true);
        btnvaliderquant.setVisible(true);
        btnannulerquantite.setVisible(true);
        quantite.setVisible(true);
    butsupcommande.setVisible(false);
          buttvalider.setVisible(false); 
            butsup.setVisible(false);
            int qt =pd.getSelectionModel().getSelectedItem().getQuantite();
            quantite.setText(Integer.toString(qt));}
            
            
    }

    @FXML
    private void onvaliderquantiteclicked(ActionEvent event) throws SQLException {
        
 if (quantite.getText().equals(""))
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
       int qt=Integer.valueOf(quantite.getText());
          int id =pd.getSelectionModel().getSelectedItem().getId();
           int idcommande =pd.getSelectionModel().getSelectedItem().getIdcommande();
            Produit produit=pd.getSelectionModel().getSelectedItem().getProduit();
             
            double total=pd.getSelectionModel().getSelectedItem().getTotal();
             double prix =pd.getSelectionModel().getSelectedItem().getPrix();
                    double total2=prix*qt;
                            LigneCommande lC = new LigneCommande(id,FXMLProduitController.commande11,produit,qt,total2, prix);
                    
            
             l.modifier(lC);
                  pd.setItems(P.getAll(FXMLProduitController.commande11));
       double TotalX=     P.calculerTotal(FXMLProduitController.commande11);
     
       
       Total.setText(Float.toString((float)TotalX));  
       
       
        butsupcommande.setVisible(true);
          buttvalider.setVisible(true); 
            butsup.setVisible(true);
               txtqauantite.setVisible(false);
        btnvaliderquant.setVisible(false);
        btnannulerquantite.setVisible(false);
        quantite.setVisible(false);
 }}
       
             /////////////////////////affichage
        



    

  
  tbquantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
 
    tbaricle.setCellValueFactory(new Callback<CellDataFeatures<LigneCommande,String>,ObservableValue<String>>(){

                @Override
                public ObservableValue<String> call(CellDataFeatures<LigneCommande, String> param) {
                    return new SimpleStringProperty(String.valueOf(param.getValue().getProduit().getReference()));
                }
            });
        tbprixtotal.setCellValueFactory(new Callback<CellDataFeatures<LigneCommande,String>,ObservableValue<String>>(){

                @Override
                public ObservableValue<String> call(CellDataFeatures<LigneCommande, String> param) {
                    return new SimpleStringProperty(String.valueOf((float)param.getValue().getTotal()));
                }
            });
     tbprix.setCellValueFactory(new Callback<CellDataFeatures<LigneCommande,String>,ObservableValue<String>>(){

                @Override
                public ObservableValue<String> call(CellDataFeatures<LigneCommande, String> param) {
                    return new SimpleStringProperty(String.valueOf((float)(param.getValue().getPrix())));
                }
            });
        
        
      quantite.setText("");
        
        
        }
    
        
    

    @FXML
    private void onannulermodifqaunatiteclicked(ActionEvent event) {
        
        
        
    butsupcommande.setVisible(true);
          buttvalider.setVisible(true); 
            butsup.setVisible(true);
               txtqauantite.setVisible(false);
        btnvaliderquant.setVisible(false);
        btnannulerquantite.setVisible(false);
        quantite.setVisible(false);
        
    }
    
    
    
    @FXML
    private void onvaliderclick(ActionEvent event) throws IOException, SQLException {
  ClientService cleintservice=new ClientService();
     CommandeService commande=new CommandeService();
       Client c =new Client();
      
    
         int  idclient= adminservice.idclient(FXMLloginvideoController.usernameautho);
 c.setId(idclient);
int idcom=commande.getidc(idclient);
   
  if(livraisonok.isSelected()==sanslivraison.isSelected())
  {
  
     Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Alert de controle");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez faire votre choix !");
            alert.showAndWait();
  
  
  
  }

 else
  {
   
   if (livraisonok.isSelected())
  {                  Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                    alert.setTitle("Confirmation");
                                    alert.setHeaderText("Confirmation");
                                    alert.setContentText("voulez vous valider le panier ?");

                                    Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
        
   double total=Double.parseDouble(txtmontanttotal.getText());
    Commande p=new Commande(FXMLProduitController.commande11,total,c,0,1);
    commande.modifier(p);
          Parent root = FXMLLoader.load(getClass().getResource("Paiement.fxml"));
    Scene newScene= new Scene(root);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(newScene);
        }
    



    }
  else
      
  {Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                    alert.setTitle("Confirmation");
                                    alert.setHeaderText("Confirmation");
                                    alert.setContentText("voulez vous valider le panier ?");

                                    Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            double total=Double.parseDouble(Total.getText());
            Commande p=new Commande(FXMLProduitController.commande11,total,c,0,0);
        commande.modifier(p);        
                        Parent root = FXMLLoader.load(getClass().getResource("Paiement.fxml"));
    Scene newScene= new Scene(root);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(newScene);}
   

    

}
    }}

    @FXML
    private void onfindput(KeyEvent event) throws SQLException {
        LigneCommandeservice l=new LigneCommandeservice();
 pd.setItems(l.findResponsable(find.getText()));
       pd.refresh();
        
        
        
        
    }

    @FXML
    private void jjjjjj(MouseEvent event) {
        
         int id= tabcommande.getSelectionModel().getSelectedItem().getId();
       String t=Integer.toString(id);
commandeactuelle.setText(t);
FXMLProduitController.commande11=tabcommande.getSelectionModel().getSelectedItem().getId();
        pd.setItems(P.getAll(FXMLProduitController.commande11));
          
        
   tbquantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
 
    tbaricle.setCellValueFactory(new Callback<CellDataFeatures<LigneCommande,String>,ObservableValue<String>>(){

                @Override
                public ObservableValue<String> call(CellDataFeatures<LigneCommande, String> param) {
                    return new SimpleStringProperty(String.valueOf(param.getValue().getProduit().getReference()));
                }
            });
        tbprixtotal.setCellValueFactory(new Callback<CellDataFeatures<LigneCommande,String>,ObservableValue<String>>(){

                @Override
                public ObservableValue<String> call(CellDataFeatures<LigneCommande, String> param) {
                    return new SimpleStringProperty(String.valueOf((float)param.getValue().getTotal()));
                }
            });
     tbprix.setCellValueFactory(new Callback<CellDataFeatures<LigneCommande,String>,ObservableValue<String>>(){

                @Override
                public ObservableValue<String> call(CellDataFeatures<LigneCommande, String> param) {
                    return new SimpleStringProperty(String.valueOf((float)(param.getValue().getPrix())));
                }
            });
        
        
        
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
