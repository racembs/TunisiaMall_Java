/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_info;

import com.jfoenix.controls.JFXButton;
import java.io.BufferedReader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;


import javax.mail.*;


import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

import tn.pidev.tm.entite.CarteFidelite;
import tn.pidev.tm.service.CartefideliteService;
import tn.pidev.tm.entite.Client;
import tn.pidev.tm.entite.Enseigne;
import tn.pidev.tm.service.ClientService;
import tn.pidev.tm.service.ServiceEnseigne;



/**
 * FXML Controller class
 *
 * @author HP-PC
 */
public class InscritController implements Initializable {

    @FXML
    private TabPane admintabpane;
    @FXML
    private Tab home;
    @FXML
    private TextField nom;
    @FXML
    private TextField cin;
    @FXML
    private TextField email;
    @FXML
    private TextField login;
    @FXML
    private Button valider;
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
    private TextField numtel;

    

   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onvaliderclicked(ActionEvent event) throws SQLException, IOException, AddressException, javax.mail.MessagingException {
       String code=Integer.toString((int) (Math.random()*(9000 - 1000 )));
      
        boolean b=true;
        Client c=new Client(nom.getText(),prenom.getText(),email.getText()
                    ,cin.getText(),login.getText(),password.getText(),"client","nonbloque",code);
          
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
         if(email.getText().equals("")||controlesaisiemail(email.getText())==false){
             invemail.setText("mail invalide");
            b=false;
         }else invemail.setText("") ;
         
        
 
        if(b==true){
          sendsms(numtel.getText(),code);
            cs.inserer(c);
            Client newclient=new Client();
           newclient= cs.chercherclientbylogin(login.getText());
            
            ServiceEnseigne serviceenseigne=new ServiceEnseigne();
           List<Enseigne> enseignes = new ArrayList<>();
        
               enseignes= serviceenseigne.getAll();
            CartefideliteService cfs=new CartefideliteService();
           
            
           for(int i=0;i<enseignes.size();i++){
              
                CarteFidelite carte=new CarteFidelite(10,enseignes.get(i),newclient);
               cfs.inserer(carte);
           }
           
         Parent root = FXMLLoader.load(getClass().getResource("FXMLloginvideo.fxml"));
         Scene newScene= new Scene(root);
         Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(newScene);
       window.show();
        }
    }
        
      
        
        
    
    public boolean controlesaisiemail(String email){
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
    
    
    public void sendsms(String receiver,String msg){
         try {
   // Construct data
   String apiKey = "apikey=xZeIMVgsG5I-kUCJfX8rX3Vg7UkkwSYj7xLIN4xNMA";
   String message = "&message="+msg;
   String sender = "&sender=21120819";
   String numbers = "&numbers=+216"+receiver;
   
   // Send data
   HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
   String data = apiKey + numbers + message + sender;
   conn.setDoOutput(true);
   conn.setRequestMethod("POST");
   conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
   conn.getOutputStream().write(data.getBytes("UTF-8"));
   final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
   final StringBuffer stringBuffer = new StringBuffer();
   String line;
   while ((line = rd.readLine()) != null) {
    //stringBuffer.append(line);
                                JOptionPane.showMessageDialog(null, "message"+line);
   }
   rd.close();
   
   //return stringBuffer.toString();
  } catch (Exception e) {
   //System.out.println("Error SMS "+e);
                        JOptionPane.showMessageDialog(null, e);
}
    
}

   
}
