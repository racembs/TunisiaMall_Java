/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javafx_info;

//import com.jfoenix.controls.JFXButton.ButtonType;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import tn.pidev.tm.entite.Enseigne;
import tn.pidev.tm.entite.Produit;
import tn.pidev.tm.service.LivraisonService;
import tn.pidev.tm.service.ProduitService;
import tn.pidev.tm.service.ServiceEnseigne;


/**
 * FXML Controller class
 *
 * @author HP-PC
 */
public class FXMLProduit1Controller implements Initializable {

    
    
        @FXML
    private TableColumn<Produit, Integer> idreference;
    @FXML
    private TableColumn<Produit, String> idnom;
    @FXML
    private TableColumn<Produit, String> idenseigne;
    @FXML
    private TableColumn<Produit, String> idcategorie;
    @FXML
    private TableColumn<Produit, Double> idprix;
    @FXML
    private TableColumn<Produit, String> iddescription;
    @FXML
    private TableColumn<Produit, Float> idpromotion;
    @FXML
    private TableColumn<Produit, String> idimage;
    @FXML
    
       
   
    
    private TableView<Produit> idpd;
    private ObservableList<Produit> data;
    private ProduitService PS;
    @FXML
    private Button btnafficher;
    @FXML
    private Button btnajouter;
    @FXML
    private Button btnmodifier;
    @FXML
    private Button btnsupprimer;
    @FXML
    private TextField idreferenceUp;
    @FXML
    private TextField idnomUp;
    private TextField idenseigneUp;
    @FXML
    private TextField idcategorieUp;
    @FXML
    private TextField idprixUp;
    @FXML
    private TextField iddescriptionUp;
    @FXML
    private TextField idpromotionUp;
    @FXML
    private TextField idimageUp;
    @FXML
    private Button btnimage;
    @FXML
    private Button btnvalider;
    @FXML
    private JFXTextField rech;
    @FXML
    private Label lbl;
    @FXML
    private ImageView image;
    @FXML
    private JFXComboBox<String> idCombo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
                 // ProduitService ps = new ProduitService();
                  ServiceEnseigne es =new ServiceEnseigne();
        List<String> list = es.getAllNomEnseigne();

        ObservableList obList = FXCollections.observableList(list);
        idCombo.getItems().clear();
        idCombo.setItems(obList);
       

        
        
        
           PS = new ProduitService();

           
        data = FXCollections.observableArrayList();
         idpd.setItems( PS.getAll());

        idreference.setCellValueFactory(new PropertyValueFactory<>("reference"));
        idnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
       idenseigne.setCellValueFactory(new Callback<CellDataFeatures<Produit,String>,ObservableValue<String>>(){
           
        @Override
                public ObservableValue<String> call(CellDataFeatures<Produit, String> param) {
                    return new SimpleStringProperty(param.getValue().getEnseigne().getNom());
                }
            });
        idcategorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        idprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        iddescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        idpromotion.setCellValueFactory(new PropertyValueFactory<>("promo"));
        
        
        idimage.setCellValueFactory(new PropertyValueFactory<>("image"));
        
    }    

    @FXML
    private void afficher(Event event) {
      
        idpd.getItems().clear();
                 // ProduitService ps = new ProduitService();
                  ServiceEnseigne es =new ServiceEnseigne();
        List<String> list = es.getAllNomEnseigne();

        ObservableList obList = FXCollections.observableList(list);
        idCombo.getItems().clear();
        idCombo.setItems(obList);
       

        
        
        
           PS = new ProduitService();

           
        data = FXCollections.observableArrayList();
         idpd.setItems( PS.getAll());

        idreference.setCellValueFactory(new PropertyValueFactory<>("reference"));
        idnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
       idenseigne.setCellValueFactory(new Callback<CellDataFeatures<Produit,String>,ObservableValue<String>>(){
           
        @Override
                public ObservableValue<String> call(CellDataFeatures<Produit, String> param) {
                    return new SimpleStringProperty(param.getValue().getEnseigne().getNom());
                }
            });
        idcategorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        idprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        iddescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        idpromotion.setCellValueFactory(new PropertyValueFactory<>("promo"));
        
        
        idimage.setCellValueFactory(new PropertyValueFactory<>("image"));
    }

    @FXML
    private void ajouter(ActionEvent event) throws SQLException {
        
        
        
        Enseigne ens=new Enseigne();
        ServiceEnseigne e =new ServiceEnseigne();
        
         int idreference1= Integer.parseInt(idreferenceUp.getText());
         //  int idenseigne1= Integer.parseInt(idenseigneUp.getText());
         String nom= idCombo.getValue().toString();
                Double idprix1 =Double.parseDouble(idprixUp.getText());
        Float idpromotion1= Float.parseFloat(idpromotionUp.getText());
        
        ens= e.cherchernom(nom);
        
        Produit p=new Produit(idreference1,idnomUp.getText(),ens
                    ,idcategorieUp.getText(),idprix1,iddescriptionUp.getText(),idpromotion1,idimageUp.getText()  );
        
        System.out.println(p);
        ProduitService ps = new ProduitService();
       
       
       
           ps.inserer(p);
           
           
              PS = new ProduitService();

           
       
         idpd.setItems( PS.getAll());

        idreference.setCellValueFactory(new PropertyValueFactory<>("reference"));
        idnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
         idenseigne.setCellValueFactory(new Callback<CellDataFeatures<Produit,String>,ObservableValue<String>>(){

                @Override
                public ObservableValue<String> call(CellDataFeatures<Produit, String> param) {
                    return new SimpleStringProperty(param.getValue().getEnseigne().getNom());
                }
            });
        idcategorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        idprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        iddescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        idpromotion.setCellValueFactory(new PropertyValueFactory<>("promo"));
        idimage.setCellValueFactory(new PropertyValueFactory<>("image"));
           
    }

    @FXML
    private void modifier(ActionEvent event)throws SQLException {
        




    if (!idpd.getSelectionModel().isEmpty()) {

            idreferenceUp.setText(Integer.toString(idpd.getSelectionModel().getSelectedItem().getReference()));
                        
            idnomUp.setText(idpd.getSelectionModel().getSelectedItem().getNom());
          
          ServiceEnseigne es=new ServiceEnseigne();
          
         idCombo.setValue(idpd.getSelectionModel().getSelectedItem().getEnseigne().getNom());
           
            
            idcategorieUp.setText(idpd.getSelectionModel().getSelectedItem().getCategorie());
            
            idprixUp.setText(Double.toString(idpd.getSelectionModel().getSelectedItem().getPrix()));
            
             idpromotionUp.setText(Float.toString(idpd.getSelectionModel().getSelectedItem().getPromo()));
             
            iddescriptionUp.setText(idpd.getSelectionModel().getSelectedItem().getDescription());

             idimageUp.setText(idpd.getSelectionModel().getSelectedItem().getImage());
             
            
               //  Image img = new Image("/ressources/a.jpg") ;
            Image img = new Image("/ressources/"+ idpd.getSelectionModel().getSelectedItem().getImage());
      //Image img = new Image("/ressources/"+E.getImage()) ;
      //System.out.println("file:///C:/Users/sarrour/Desktop/image/"+E.getImage());
  image.setImage(img);
             
            ///  Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        }


         
    }
        
    

        
    

    @FXML
    private void supprimer(ActionEvent event)throws SQLException {

        ProduitService ps= new ProduitService();
        if(!idpd.getSelectionModel().isEmpty()){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("delete");
        alert.setHeaderText("do you wanna delete "+idpd.getSelectionModel().getSelectedItem().getReference());
        alert.setContentText("Are you ok with this?");
       // Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

       Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
           // System.out.println("hello");
        ProduitService dao =new ProduitService();
        dao.supprimerRef(idpd.getSelectionModel().getSelectedItem());
        dao.getAll();
//        data.remove(idpd.getSelectionModel().getFocusedIndex());
//        idpd.setItems(data);
        } 
         
     }
//        
//           PS = new ProduitService();
//
//           
//        data = FXCollections.observableArrayList();
//         idpd.setItems( PS.getAll());
//
//        idreference.setCellValueFactory(new PropertyValueFactory<>("reference"));
//        idnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
//        idenseigne.setCellValueFactory(new PropertyValueFactory<>("idEnseigne"));
//        idcategorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
//        idprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
//        iddescription.setCellValueFactory(new PropertyValueFactory<>("description"));
//        idpromotion.setCellValueFactory(new PropertyValueFactory<>("promo"));
//        idimage.setCellValueFactory(new PropertyValueFactory<>("image"));



  PS = new ProduitService();

           
       
         idpd.setItems( PS.getAll());

        idreference.setCellValueFactory(new PropertyValueFactory<>("reference"));
        idnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
         idenseigne.setCellValueFactory(new Callback<CellDataFeatures<Produit,String>,ObservableValue<String>>(){

                @Override
                public ObservableValue<String> call(CellDataFeatures<Produit, String> param) {
                    return new SimpleStringProperty(param.getValue().getEnseigne().getNom());
                }
            });
        idcategorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        idprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        iddescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        idpromotion.setCellValueFactory(new PropertyValueFactory<>("promo"));
        idimage.setCellValueFactory(new PropertyValueFactory<>("image"));





    }

    @FXML
    private void statistiques(ActionEvent event) {
    }

    @FXML
    private void image(ActionEvent event) {
    }

    @FXML
    private void valider(ActionEvent event) throws SQLException {
        
          
        int idreference1= Integer.parseInt(idreferenceUp.getText());
         String nom= idCombo.getValue().toString();
        Double idprix1 =Double.parseDouble(idprixUp.getText());
        Float idpromotion1= Float.parseFloat(idpromotionUp.getText()); 

//        int idPromo = idpd.getSelectionModel().getSelectedItem().getId();
//        String dateCrea = idpd.getSelectionModel().getSelectedItem().getDate_creation();

          Enseigne ens=new Enseigne();
        ServiceEnseigne e =new ServiceEnseigne();
       ens= e.cherchernom(nom);
        
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.CONFIRMATION);
        alert.setTitle("inserer les nouveaux données");
        alert.setHeaderText("vous voulez modifier cet element??" );
           
        Produit p=new Produit(idreference1,idnomUp.getText(),ens,idcategorieUp.getText(),idprix1,iddescriptionUp.getText(),idpromotion1,idimageUp.getText()  );

        alert.setContentText("Etes vous d'accord?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            //System.out.println("hello");
              ProduitService P = new ProduitService();
          //LivraisonService dao = new LivraisonService();
            P.modifierRef(p);
         // System.out.println("hello");
                        
         idpd.getItems().clear();
  PS = new ProduitService();

           
       
         idpd.setItems( PS.getAll());

        idreference.setCellValueFactory(new PropertyValueFactory<>("reference"));
        idnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
         idenseigne.setCellValueFactory(new Callback<CellDataFeatures<Produit,String>,ObservableValue<String>>(){

                @Override
                public ObservableValue<String> call(CellDataFeatures<Produit, String> param) {
                    return new SimpleStringProperty(param.getValue().getEnseigne().getNom());
                }
            });
        idcategorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        idprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        iddescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        idpromotion.setCellValueFactory(new PropertyValueFactory<>("promo"));
        idimage.setCellValueFactory(new PropertyValueFactory<>("image"));
           
  
            
        }

 idpd.getItems().clear();
  PS = new ProduitService();

           
       
         idpd.setItems( PS.getAll());

        idreference.setCellValueFactory(new PropertyValueFactory<>("reference"));
        idnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
         idenseigne.setCellValueFactory(new Callback<CellDataFeatures<Produit,String>,ObservableValue<String>>(){

                @Override
                public ObservableValue<String> call(CellDataFeatures<Produit, String> param) {
                    return new SimpleStringProperty(param.getValue().getEnseigne().getNom());
                }
            });
        idcategorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        idprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        iddescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        idpromotion.setCellValueFactory(new PropertyValueFactory<>("promo"));
        idimage.setCellValueFactory(new PropertyValueFactory<>("image"));
           
   
    }

    @FXML
    private void RechercheControl(MouseEvent event) {
       idpd.getSelectionModel().clearSelection();
       lbl.setText("");
    }

    @FXML
    private void KeyControl(KeyEvent event) {
         if (event.getCode().equals(KeyCode.ENTER)) {
            if (rech.getText().equals("")) {
                lbl.setText("Il faut remplir la case");
            } else {
                if (!test()) {
                    lbl.setText("Enseigne inexistante");
                    rech.setText("");
                    load();
                }

            }

        }
    }

      public void load() {

       
           PS = new ProduitService();

           
        data = FXCollections.observableArrayList();
         idpd.setItems( PS.getAll());

        idreference.setCellValueFactory(new PropertyValueFactory<>("reference"));
        idnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        idenseigne.setCellValueFactory(new PropertyValueFactory<>("idEnseigne"));
        idcategorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        idprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        iddescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        idpromotion.setCellValueFactory(new PropertyValueFactory<>("promo"));
        idimage.setCellValueFactory(new PropertyValueFactory<>("image"));
        
    }
      
       public boolean test() {
        data = FXCollections.observableArrayList();
        data.clear();
        for (Produit v : PS.getAll()) {
            if (rech.getText().equals(v.getEnseigne().getNom())) {
                data.add(v);
            }
        }
        if (data.isEmpty()) {
            return false;

        } else {
            idpd.setItems(data);
            return true;
        }
    }

    @FXML
    private void Combo(ActionEvent event) {
        
        
        System.out.println(idCombo.getValue());
    }
}


