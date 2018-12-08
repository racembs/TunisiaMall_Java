/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_info;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import tn.pidev.tm.entite.Client;
import tn.pidev.tm.entite.Commande;
import tn.pidev.tm.entite.Enseigne;
import tn.pidev.tm.entite.Livraison;
import tn.pidev.tm.entite.Produit;
import tn.pidev.tm.service.ClientService;
import tn.pidev.tm.service.CommandeService;
import tn.pidev.tm.service.LivraisonService;
import tn.pidev.tm.service.ProduitService;
import tn.pidev.tm.service.ServiceEnseigne;

/**
 * FXML Controller class
 *
 * @author HP-PC
 */
public class FXMLLivraisonController implements Initializable {

    @FXML
    private TableView<Livraison> pdLiv;
    @FXML
    private TableColumn<Livraison, String> idCltLiv;
    @FXML
    private TableColumn<Livraison, Double> idtot;
    @FXML
    private TableColumn<Livraison, Integer> idpaiement;
    @FXML
    private TableColumn<Livraison, Integer> idLiv;
    @FXML
    private TableColumn<Livraison, String> idadresse;
    @FXML
    private TableColumn<Livraison, String> idDateLiv;
    @FXML
    private TableColumn<Livraison, String> idEtat;
    @FXML
    private TableColumn<Livraison, Integer> idC;
    @FXML
    private TextField idCltLivUp;
    @FXML
    private TextField idtotUp;
    @FXML
    private TextField idpaiementUp;
    @FXML
    private TextField idLivUp;
    @FXML
    private TextField idadresseUp;
    @FXML
    private TextField idEtatUp;
     
    @FXML
    private TextField idDateLivUp;
    @FXML
    private Button btnvalider;
    @FXML
    private Button btndevis;
    @FXML
    private Button btnafficher;
    @FXML
    private Button btngerer;
  java.util.Date d= new java.util.Date();
    
    @FXML
    private ComboBox<String> idCombo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        LivraisonService P = new LivraisonService();
                
        List <String> list = P.getAllEtat();

        ObservableList obList = FXCollections.observableList(list);
        idCombo.getItems().clear();
        idCombo.setItems(obList);
         pdLiv.setItems( P.getAll());
       

       // idCltLiv.setCellValueFactory(new PropertyValueFactory<>("idClient"));
        
               idCltLiv.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Livraison,String>,ObservableValue<String>>(){
           
        @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<Livraison, String> param) {
                    return new SimpleStringProperty(param.getValue().getClient().getNom());
                }
            });
        
        idtot.setCellValueFactory(new PropertyValueFactory<>("total"));
        idpaiement.setCellValueFactory(new PropertyValueFactory<>("paiment"));
        idLiv.setCellValueFactory(new PropertyValueFactory<>("livraison"));
        idadresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        idDateLiv.setCellValueFactory(new PropertyValueFactory<>("dateLivraison"));
        idEtat.setCellValueFactory(new PropertyValueFactory<>("Etat"));                                                               idEtatUp.setVisible(false);
       // idC.setCellValueFactory(new PropertyValueFactory<>("id"));  
    }    

    @FXML
    private void valider(ActionEvent event) throws SQLException{
        
        
        
//        int idCltLivUp1= Integer.parseInt(idCltLivUp.getText());
          Double idtotUp1= Double.parseDouble(idtotUp.getText());
             int idpaiementUp1 = Integer.parseInt(idpaiementUp.getText());
                  int idLivUp1 = Integer.parseInt(idLivUp.getText()); 
          String nom= idCombo.getValue().toString();
        int x = Integer.parseInt(idEtatUp.getText()); 
     
   
        
       //Date idDateLivUp1 = DatePicker.parseDate(idDateLivUp.getText()); //date.parse(date.format(d))
     
      // int idEtatUp1= Integer.parseInt(idEtatUp);
    // int idUp1 = Integer.parseInt(idC.getText()); 
//        int idC1 = Integer.parseInt(idC.getText());
//        int idPromo = idpd.getSelectionModel().getSelectedItem().getId();
//        String dateCrea = idpd.getSelectionModel().getSelectedItem().getDate_creation();
           LivraisonService P = new LivraisonService();



              Client clt=new Client();
              
        ClientService e =new ClientService();
       clt= e.chercherId(x);
       
          
       
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.CONFIRMATION);
        alert.setTitle("inserer les nouveaux données");
        alert.setHeaderText("vous voulez modifier cet element??" );
      
        
       
        //Livraison L =new Livraison(idtotUp1, clt, idpaiementUp1,idLivUp1,idadresseUp.getText(), idDateLivUp.getText(), nom);
           Livraison L=new Livraison (x,idtotUp1,clt,idpaiementUp1,idLivUp1,idadresseUp.getText(),idDateLivUp.getText(),nom);
 //public Livraison(int idclient, Double total, int paiment, int livraison,String adresse, Date DateLivraison,int Etat) {
       
 alert.setContentText("Etes vous d'accord?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.out.println("hello ons");
            LivraisonService dao = new LivraisonService();
            dao.modifier(L);
          
    }
 // LivraisonService P = new LivraisonService();

            pdLiv.setItems( P.getAll());
       

       // idCltLiv.setCellValueFactory(new PropertyValueFactory<>("idClient"));
        
               idCltLiv.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Livraison,String>,ObservableValue<String>>(){
           
        @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<Livraison, String> param) {
                    return new SimpleStringProperty(param.getValue().getClient().getNom());
                }
            });
        
        idtot.setCellValueFactory(new PropertyValueFactory<>("total"));
        idpaiement.setCellValueFactory(new PropertyValueFactory<>("paiment"));
        idLiv.setCellValueFactory(new PropertyValueFactory<>("livraison"));
        idadresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        idDateLiv.setCellValueFactory(new PropertyValueFactory<>("dateLivraison"));
        idEtat.setCellValueFactory(new PropertyValueFactory<>("Etat"));                                                                                     idEtatUp.setVisible(false);
       // idC.setCellValueFactory(new PropertyValueFactory<>("id"));  
 }
    @FXML
    private void devis(ActionEvent event) {
    }

    @FXML
    private void afficher(ActionEvent event) throws SQLException {
        
           LivraisonService P = new LivraisonService();

            pdLiv.setItems( P.getAll1());
       

                idCltLiv.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Livraison,String>,ObservableValue<String>>(){
           
        @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<Livraison, String> param) {
                    return new SimpleStringProperty(param.getValue().getClient().getNom());
                }
            });
        idtot.setCellValueFactory(new PropertyValueFactory<>("total"));
        idpaiement.setCellValueFactory(new PropertyValueFactory<>("paiment"));
        idLiv.setCellValueFactory(new PropertyValueFactory<>("livraison"));
        idadresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        idDateLiv.setCellValueFactory(new PropertyValueFactory<>("dateLivraison"));
        idEtat.setCellValueFactory(new PropertyValueFactory<>("Etat"));
      //  idC.setCellValueFactory(new PropertyValueFactory<>("etat"));                                                                                                        idEtatUp.setVisible(false);

        
        
    }

    @FXML
    private void gerer(ActionEvent event) {
        
        
        
        
            if (!pdLiv.getSelectionModel().isEmpty()) {

            idCltLivUp.setText(pdLiv.getSelectionModel().getSelectedItem().getClient().getNom());
                        
            idtotUp.setText(Double.toString(pdLiv.getSelectionModel().getSelectedItem().getTotal()));
            
            idpaiementUp.setText(Integer.toString(pdLiv.getSelectionModel().getSelectedItem().getPaiment()));
            
            idLivUp.setText(Integer.toString(pdLiv.getSelectionModel().getSelectedItem().getLivraison()));
            
            idadresseUp.setText(pdLiv.getSelectionModel().getSelectedItem().getAdresse());
            
           idDateLivUp.setText(pdLiv.getSelectionModel().getSelectedItem().getDateLivraison());
             
            idCombo.setValue(pdLiv.getSelectionModel().getSelectedItem().getEtat());
           idEtatUp.setText(Integer.toString(pdLiv.getSelectionModel().getSelectedItem().getId()));                                                                                                   idEtatUp.setVisible(false);



           
            }
    }

    @FXML
    private void Combo(ActionEvent event) {
    }
    
}
