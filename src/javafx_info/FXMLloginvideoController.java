/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_info;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
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
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import tn.pidev.tm.entite.Client;

import tn.pidev.tm.service.AdminService;
import tn.pidev.tm.service.ClientService;


/**
 * FXML Controller class
 *
 * @author HP-PC
 */
public class FXMLloginvideoController implements Initializable {
    static String usernameautho;
 @FXML
 private MediaView mediaView;
 
    private MediaPlayer mp;
     private Media me;
       static Client client;
         

 ClientService clientService=new ClientService();
    Client c=new Client();

    @FXML
    private Pane login;
    @FXML
    private Button Login1;
    @FXML
    private Button inscription;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Label labelverif;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         String path=new File("C:\\Users\\RBS\\Desktop\\tunisiamall\\src\\ressources\\tm.mp4").getAbsolutePath();
        me=new Media(new File(path).toURI().toString());
        mp=new MediaPlayer(me);
        mediaView.setMediaPlayer(mp);
        mp.setAutoPlay(true);
       final DoubleProperty width = mediaView.fitWidthProperty();
    final DoubleProperty height = mediaView.fitHeightProperty();
    
    width.bind(Bindings.selectDouble(mediaView.sceneProperty(),"width"));
    height.bind(Bindings.selectDouble(mediaView.sceneProperty(),"height"));
    }    

    @FXML
    private void btnLoginOnAction(ActionEvent event) throws SQLException, IOException
    {
             client =new Client();
   
              usernameautho=username.getText();
    
        
   AdminService as=new AdminService();
     String role;
     
       
          role = as.verifierAdmin(username.getText(),  password.getText());
         
     
    
   
        System.out.println(role);
      if (role.equals("admin")){
         
    Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
    Scene newScene= new Scene(root);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(newScene);
       window.show();}
       else if(role.equals("client"))
            {
                

          c=clientService.chercherclientbylogin(usernameautho);
          if(c.getCode().equals("0")){
          
              
          if(c.getEtatBlocage().equals("nonbloque"))  {   
                  
    Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
    Scene newScene= new Scene(root);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(newScene);
 window.show();
          }else labelverif.setText("vous êtes bloqué\nveuillez nous contacter par email");
          
      
               
               }else{
              System.out.println("code");
              Parent root = FXMLLoader.load(getClass().getResource("verifiercode.fxml"));
    Scene newScene= new Scene(root);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(newScene);
 window.show();
              
          }
            
            }
      
            else if(role.equals("propEnseigne"))
            { 

                        c=clientService.chercherclientbylogin(usernameautho);
                System.out.println(c.getEtatBlocage());
          if(c.getEtatBlocage().equals("nonbloque"))  {   
                  System.out.println("non bloque");
    Parent root = FXMLLoader.load(getClass().getResource("Produit.fxml"));
    Scene newScene= new Scene(root);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(newScene);
 window.show();
          }       

    }
            else labelverif.setText("Veuillez Réessayer");

   
    
    }

    @FXML
    private void btnSignUpOnAction(ActionEvent event) throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("Inscrit.fxml"));
    Scene newScene= new Scene(root);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(newScene);
 window.show();
    }
}
