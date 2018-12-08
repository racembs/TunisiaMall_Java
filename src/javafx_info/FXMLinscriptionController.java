/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_info;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.pidev.tm.entite.CarteFidelite;
import tn.pidev.tm.service.CartefideliteService;
import tn.pidev.tm.entite.Client;
import tn.pidev.tm.entite.Enseigne;
import tn.pidev.tm.service.ClientService;
import tn.pidev.tm.service.ServiceEnseigne;


/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLinscriptionController implements Initializable {

    @FXML
    private Button valider;
    @FXML
    private TextField nom;
    @FXML
    private TextField cin;
    @FXML
    private TextField email;
    @FXML
    private TextField login;
    @FXML
    private TextField prenom;
    @FXML
    private TextField password;
    @FXML
    private TextField cpassword;
    @FXML
    private Label invnom;
    @FXML
    private Label invcin;
    @FXML
    private Label invemail;
    @FXML
    private Label invmdp;
    @FXML
    private Label invlogin;
    @FXML
    private Label invprenom;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onvaliderclicked(ActionEvent event) throws SQLException, IOException {
        boolean b=true;
        Client c=new Client(nom.getText(),prenom.getText(),email.getText()
                    ,cin.getText(),login.getText(),password.getText(),"client");
        ClientService cs=new ClientService();
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
        
        if(login.getText().equals("")){
            invlogin.setText("login invalide");
            b=false;
        }else invlogin.setText("") ;
         if(cs.clientexiste(c)==false){
            invlogin.setText("login ou email existant");
            b=false;
        }else invlogin.setText("") ;
         
         if(password.getText().equals(cpassword.getText())==false||password.getText().equals("")){
             invmdp.setText("password invalide");
            b=false;
        }
         if(email.getText().equals("")||verifieremail(email.getText())==false){
             invemail.setText("mail invalide");
            b=false;
         }else invemail.setText("") ;
         
        
            
               
             
         
      
        if(b==true){
            cs.inserer(c);
            Client newclient=new Client();
           newclient= cs.chercherclientbylogin(login.getText());
            
            ServiceEnseigne serviceenseigne=new ServiceEnseigne();
           List<Enseigne> enseignes = new ArrayList<>();
        
               enseignes= serviceenseigne.getAll();
            CartefideliteService cfs=new CartefideliteService();
           
            
           for(int i=0;i<enseignes.size();i++){
              
                CarteFidelite carte=new CarteFidelite(0,enseignes.get(i),newclient);
               cfs.inserer(carte);
           }
           
         Parent root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
         Scene newScene= new Scene(root);
         Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(newScene);
       window.show();
        }
        
      
        
        
    }
    public boolean verifieremail(String email){
        boolean b1=false;
        boolean b2=false;
            if(email.contains("@")){
               
                b1=true;
            }
            if(email.contains(".")){
              b2=true;
                
            }
            
            
        
        if(b1&&b2)return true;
        return false;
        
        
    }
    
}
