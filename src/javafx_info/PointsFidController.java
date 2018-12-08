/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_info;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.stage.Stage;
import javafx.util.Callback;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import tn.pidev.tm.entite.CarteFidelite;
import tn.pidev.tm.entite.Client;
import tn.pidev.tm.service.CartefideliteService;
import tn.pidev.tm.service.ClientService;

/**
 * FXML Controller class
 *
 * @author HP-PC
 */
public class PointsFidController implements Initializable {

    @FXML
    private TabPane admintabpane;
    @FXML
    private Tab home;
    @FXML
    private Button transformer;
    @FXML
    private TableView<CarteFidelite> tabfidelite;
    private TableColumn<CarteFidelite, ?> tidcarte;
    @FXML
    private TableColumn<CarteFidelite, String> tnom;
    @FXML
    private TableColumn<CarteFidelite, Integer> tnbrpts;
    @FXML
    private TableColumn<CarteFidelite, String> tbenifice;
    
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
           Client client=new Client();
 CartefideliteService cs=new CartefideliteService();
    ClientService clientservice =new ClientService();
      
 
       CarteFidelite carte=new CarteFidelite();
           
    try {
        client=clientservice.chercherclientbylogin(FXMLloginvideoController.usernameautho);
           
      tabfidelite.setItems(cs.getAll(client.getId()));
    } catch (SQLException ex) {
        Logger.getLogger(FXMLclientController.class.getName()).log(Level.SEVERE, null, ex);
    }
      
        
     
       
     
       tnom.setCellValueFactory(new Callback<CellDataFeatures<CarteFidelite,String>,ObservableValue<String>>(){

                @Override
                public ObservableValue<String> call(CellDataFeatures<CarteFidelite, String> param) {
                    return new SimpleStringProperty(param.getValue().getEnseigne().getNom());
                }
            });
               
          tnbrpts.setCellValueFactory(new PropertyValueFactory<>("nombreDePoints"));
          
          tbenifice.setCellValueFactory(new Callback<CellDataFeatures<CarteFidelite,String>,ObservableValue<String>>(){

                @Override
                public ObservableValue<String> call(CellDataFeatures<CarteFidelite, String> param) {
                    return new SimpleStringProperty(param.getValue().getEnseigne().getbon_achat(param.getValue().getId(),param.getValue().getEnseigne().getId()));
                }
            });
    }    

    @FXML
    private void ontransformerclicked(ActionEvent event) throws SQLException, MessagingException, IOException, DocumentException {
        
          
        Alert alert = new Alert(Alert.AlertType.WARNING);
     alert.setTitle("Confirmation");
       alert.setHeaderText("Confirmation");
       alert.setContentText("voulez vous reellement transformer ces points ?");
      Optional<ButtonType> result = alert.showAndWait();
     if (result.get() == ButtonType.OK) {
       CartefideliteService cfs=new CartefideliteService();
      
       CarteFidelite carte=new CarteFidelite();
       carte=tabfidelite.getSelectionModel().getSelectedItem();
       
      
        
         Client c=new Client();
    CartefideliteService cs=new CartefideliteService();
    ClientService clientservice =new ClientService();
     
        c=clientservice.chercherclientbylogin(FXMLloginvideoController.usernameautho);
        String path="C:\\Users\\RBS\\Desktop\\tunisiamall\\bon_achat"+carte.getId()+".pdf";
         genererpdf(carte.getEnseigne().getbon_achat(carte.getId(),carte.getEnseigne().getId()),path,
                 carte.getEnseigne().getNom(),carte.getClient().getNom(),carte.getClient().getPrenom(),carte.getClient().getCin());
          send2("test",c.getMail(),path);
             carte.setNombreDePoints(0);
        cfs.resetcarte(carte);
       tabfidelite.setItems(cs.getAll(c.getId()));
     
      
         
        tnbrpts.setCellValueFactory(new PropertyValueFactory<>("nombreDePoints"));
       
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

    private void voir(ActionEvent event) throws IOException {
        
           Parent root = FXMLLoader.load(getClass().getResource("Commande.fxml"));
          
    Scene newScene= new Scene(root);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(newScene);
       window.show();
        
    }
    public void send2(String msg,String mail,String path) throws AddressException, javax.mail.MessagingException {

    
    
    

    final String username = "tunisiamalleverywhere@gmail.com"; //ur email
    final String password = "279189494";

    Properties props = new Properties();
    props.put("mail.smtp.auth", true);
    props.put("mail.smtp.starttls.enable", true);
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
        return new javax.mail.PasswordAuthentication(username, password);
    }                            
});

    
        
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("tunisiamalleverywhere@gmail.com"));//ur email
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(mail));//u will send to
        message.setSubject("bon d'achat");    
        message.setText(msg);
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        Multipart multipart = new MimeMultipart();
String file = path;
        String fileName = "pdf";
    messageBodyPart = new MimeBodyPart();   
    DataSource source = new FileDataSource(file);      
    messageBodyPart.setDataHandler(new DataHandler(source));
    messageBodyPart.setFileName(fileName);
    multipart.addBodyPart(messageBodyPart);
        message.setContent(multipart);

       
        System.out.println("sending");
        javax.mail.Transport.send(message);
        System.out.println("Done");
        
   


  }
    
  
    private void genererpdf(String bon,String path,String boutique,String nom,String prenom,String cin) throws IOException, DocumentException, MessagingException {
        

    

  
                        Document document = new Document();
       
            PdfWriter.getInstance(document, new FileOutputStream(path));
      
        document.open();
        
            document.add(new Paragraph("\n--------------------  Bon d'achat Tunisia Mall  --------------------------\n\n"
                    + "Boutique :"+boutique
                    + "\n Nom : "+nom
                    + "\n Prenom :"+prenom
                    + "\n Cin :"+cin
                    + "\n PRIX : " +bon+ " \n\n\n"
                    + " a bientôt "
            ));

            document.addTitle("title");
            document.close();
       
         

        System.out.println("pdf avec success");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("information");
        alert.setHeaderText(null);
        alert.setContentText("la reponse a été imprimer en PDF avec success");
        alert.show();
  
       
    }
}
