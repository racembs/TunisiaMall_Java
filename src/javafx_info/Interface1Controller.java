/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_info;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import tn.pidev.tm.entite.Promotion;
import tn.pidev.tm.service.PromotionService;


/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class Interface1Controller implements Initializable {

    @FXML
    private TableView<Promotion> tablePromoClient;
    @FXML
    private TableColumn<Promotion, String> nomPromo;
    @FXML
    private TableColumn<Promotion, String> descripPromo;
    @FXML
    private TableColumn<Promotion, String> dateExpiration;
    @FXML
    private TableColumn<Promotion, Double> prixPromo;
    @FXML
    private TableColumn<Promotion, Integer> quantiteDispo;
    @FXML
    private TableColumn<Promotion, String> enseignePromo;
    @FXML
    private Button acheterPromo;
    @FXML
    private ImageView imagePromo;
    private TextField qtiteSouhite;
    @FXML
    private JFXComboBox<String> qtiteSouhaiteCombo;
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
           PromotionService cs = new PromotionService();
       
        nomPromo.setCellValueFactory(new PropertyValueFactory<>("nom"));
        descripPromo.setCellValueFactory(new PropertyValueFactory<>("description"));
        prixPromo.setCellValueFactory(new PropertyValueFactory<>("prix"));
        dateExpiration.setCellValueFactory(new PropertyValueFactory<>("date_expiration"));
        //c5dateCreaPromo.setCellValueFactory(new PropertyValueFactory<>("date_creation"));
        quantiteDispo.setCellValueFactory(new PropertyValueFactory<>("quantite"));
         enseignePromo.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Promotion,String>,ObservableValue<String>>(){

                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<Promotion, String> param) {
                    return new SimpleStringProperty(param.getValue().getProd().getNom()+" "+"description de l'enseigne:"+param.getValue().getProd().getDescription());
                }
            });
        
 tablePromoClient.setItems(cs.getAll());
        // ProduitService ps = new ProduitService();
       //List<Integer> list = ;

      //ObservableList obList = FXCollections.observableList(list);
       qtiteSouhaiteCombo.getItems().clear();
    qtiteSouhaiteCombo.getItems().addAll("1","2","3");
        
        // TODO
    }    

    @FXML
    private void onacheterPromo(ActionEvent event) throws SQLException {
          if (!tablePromoClient.getSelectionModel().isEmpty()) {
        if(tablePromoClient.getSelectionModel().getSelectedItem().getQuantite()< Integer.parseInt(qtiteSouhaiteCombo.getValue()))
             
        {Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ACHETER PROMO");
            alert.setHeaderText("Quantite saisie depasse quantite disponible :(!");
            alert.setContentText("");
            ///  Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

            Optional<ButtonType> result = alert.showAndWait();
        }
        else 
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ACHETER PROMO");
            alert.setHeaderText("achat validÃ© , veuillez verifier votre boite email");
            alert.setContentText("");
            int diff=(tablePromoClient.getSelectionModel().getSelectedItem().getQuantite())-Integer.parseInt(qtiteSouhaiteCombo.getValue());

 
      PromotionService cs = new PromotionService();
      cs.modifierQuantite(diff,tablePromoClient.getSelectionModel().getSelectedItem().getId());
        tablePromoClient.getItems().clear();
        nomPromo.setCellValueFactory(new PropertyValueFactory<>("nom"));
        descripPromo.setCellValueFactory(new PropertyValueFactory<>("description"));
        prixPromo.setCellValueFactory(new PropertyValueFactory<>("prix"));
        dateExpiration.setCellValueFactory(new PropertyValueFactory<>("date_expiration"));
        //c5dateCreaPromo.setCellValueFactory(new PropertyValueFactory<>("date_creation"));
        quantiteDispo.setCellValueFactory(new PropertyValueFactory<>("quantite"));
         enseignePromo.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Promotion,String>,ObservableValue<String>>(){

                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<Promotion, String> param) {
                    return new SimpleStringProperty(param.getValue().getProd().getNom()+" "+"description de l'enseigne:"+param.getValue().getProd().getDescription());
                }
            });
        
 tablePromoClient.setItems(cs.getAll());
        }
        }    }

    @FXML
    private void clickItemPromo(MouseEvent event) {
         if (event.getClickCount() == 2) //Checking double click
    {
             Image img = new Image("/ressources/"+ tablePromoClient.getSelectionModel().getSelectedItem().getImage());
imagePromo.setImage(img);
        System.out.println(tablePromoClient.getSelectionModel().getSelectedItem().getNom());
     
    }
        
    }

     @FXML
    private void onhomeclicked(ActionEvent event) throws IOException {
     
    Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
          
    Scene newScene= new Scene(root);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(newScene);
       window.show();
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

  
    
    


