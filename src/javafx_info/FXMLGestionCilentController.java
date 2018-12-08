/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_info;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import tn.pidev.tm.entite.Client;
import tn.pidev.tm.service.ClientService;

/**
 * FXML Controller class
 *
 * @author RBS
 */
public class FXMLGestionCilentController implements Initializable {
   
     @FXML
    private TableView<Client> tableclient;
    @FXML
    private TableColumn<Client, String> tnom;
    @FXML
    private TableColumn<Client, String> tprenom;
    @FXML
    private TableColumn<Client, String> tcin;
    @FXML
    private TableColumn<Client, String> temail;
    @FXML
    private TableColumn<Client, String> tlogin;
    @FXML
    private TableColumn<Client, String> tmdp;
     @FXML
    private TableColumn<Client, String> tEtat;
  
   static int idstatique;
    private TextField id;
    private TextField nom;
    private TextField prenom;
    private TextField login;
    private TextField password;
    private TextField email;
    private TextField cin;
    @FXML
    private TextField chercherbyid;
    private TextField com;
    private Label invprenom;
    private Label invlogin;
    private Label invmdp;
    private Label invemail;
    private Label invcin;
    private Label invnom;
    private PasswordField cpassword;
    @FXML
    private Button btnModifier;
   ClientService cs =new ClientService();
   Client c= new Client();
ObservableList<Client> clients;       
    @FXML
    private Button actualiser;
    @FXML
    private Button btnBloquer;
    @FXML
    private Button btndebloquer;
 
   
   
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        tableclient.setItems(cs.getAllClient());
         
        
        tnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        tcin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        temail.setCellValueFactory(new PropertyValueFactory<>("mail"));
        tlogin.setCellValueFactory(new PropertyValueFactory<>("username"));
        tmdp.setCellValueFactory(new PropertyValueFactory<>("password"));
        tEtat.setCellValueFactory(new PropertyValueFactory<>("EtatBlocage"));
     
        
    }    

   
  

    private void onvalidermodificationclicked(ActionEvent event) throws SQLException, IOException {
        
    
        
        
        boolean b=true;
        
        ClientService cs=new ClientService();
        Client c=new Client(Integer.parseInt(id.getText()),nom.getText(),prenom.getText(),email.getText()
                    ,cin.getText(),login.getText(),password.getText(),"client");
        //controlle de saisie
         invmdp.setText("");
        if(nom.getText().equals("")){
            invnom.setText("nom invalide");
            b=false;
        }
        else invnom.setText("");
            
       
        if(prenom.getText().equals("")){
            invprenom.setText("prenom invalide");
            b=false;
        }else invprenom.setText("");
        if(cin.getText().equals("")||(cin.getText().length())!=8){
            invcin.setText("cin invalide");
           b=false;
        }
        else invcin.setText("");
        
        if(( cs.clientexiste(c)==false||login.getText().equals(""))&&(login.getText().equals(cs.chercherclient(id.getText()).getUsername()))==false){
            invlogin.setText("login invalide");
            b=false;
        }else invlogin.setText("") ;
        
         if(password.getText().equals(cpassword.getText())==false||password.getText().equals("")){
             invmdp.setText("password invalide");
            b=false;
        }
         if(email.getText().equals("")||com.getText().equals("")){
             invemail.setText("mail invalide");
            b=false;
         }else invemail.setText("") ;
        
      if(b) cs.modifier(c);
         
       
    }
        
    

    private void onkeypressedid(KeyEvent event) throws SQLException{
        ClientService cs=new ClientService();
         Client c=new Client();
      
         c=cs.chercherclient(id.getText());
        // nom.setText(c.getNom());
         prenom.setText(c.getPrenom());
         email.setText(c.getMail());
         cin.setText(c.getCin());
         login.setText(c.getUsername());
         password.setText(c.getPassword());
 
     
    }

    

    @FXML
    private void onchercher_dans_table_clicked(KeyEvent event) {
        ClientService cs=new ClientService();
        if(cs.getListeByString(chercherbyid.getText()).size()!=0){
           tableclient.setItems(cs.getListeByString(chercherbyid.getText()));
        
        }
        else{
            
         this.clients = cs.getAllClient();
        tableclient.setItems(this.clients);
        tableclient.refresh();
        
      
        }
       
        
    }

    @FXML
    private void on_update_client_from_table_clicked(ActionEvent event) throws IOException {
       
         c=tableclient.getSelectionModel().getSelectedItem();
            idstatique=c.getId();
            System.out.println(idstatique);
            Parent root = FXMLLoader.load(getClass().getResource("FXMLModifierByAdmin.fxml"));
           
            System.out.println(idstatique);
                    
    Scene newScene= new Scene(root);
    Stage st = new Stage();
    
    if(event.getSource()==btnModifier)
 {
         st.setScene(newScene);
        st.initModality(Modality.APPLICATION_MODAL);
        st.initOwner(btnModifier.getScene().getWindow());
       st.showAndWait();
 }
    else
 {
   st=(Stage)btnModifier.getScene().getWindow();
   st.close();
  }
       

         
//         nom.setText(c.getNom());
//         prenom.setText(c.getPrenom());
//         email.setText(c.getMail());
//         cin.setText(c.getCin());
//         login.setText(c.getUsername());
//         password.setText(c.getPassword());
         
        
    }

    @FXML
    private void itemselected(MouseEvent event) {
        btnModifier.setDisable(false);
        btnBloquer.setDisable(false);
        btnBloquer.setDisable(false);
        btndebloquer.setDisable(false);
        
    }

    @FXML
    private void btnActualiserClicked(ActionEvent event) {
         this.clients = cs.getAllClient();
         tableclient.setItems(this.clients);
        tableclient.refresh();
           btnModifier.setDisable(true);
           btnBloquer.setDisable(true);
           btndebloquer.setDisable(true);
    }

    @FXML
    private void refreshtable(MouseDragEvent event) {
    }

    @FXML
    private void onbtnBloquerClicked(ActionEvent event) throws SQLException {
        
        c=tableclient.getSelectionModel().getSelectedItem();
        c.setEtatBlocage("bloque");
        cs.modifier(c);
         tableclient.setItems(cs.getAllClient());
        tableclient.refresh();
         btnModifier.setDisable(true);
         btnBloquer.setDisable(true);
           btndebloquer.setDisable(true);
        
    }

    @FXML
    private void onDeBloquerClicked(ActionEvent event) throws SQLException {
        c=tableclient.getSelectionModel().getSelectedItem();
        c.setEtatBlocage("nonbloque");
        cs.modifier(c);
         tableclient.setItems(cs.getAllClient());
        tableclient.refresh();
         btnModifier.setDisable(true);
         btnBloquer.setDisable(true);
           btndebloquer.setDisable(true);
    }
    
    
}
