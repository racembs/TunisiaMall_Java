/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_info;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTimePicker;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import com.google.zxing.qrcode.encoder.QRCode;
import com.jfoenix.controls.JFXTimePicker;
import com.jfoenix.controls.JFXDatePicker;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.Properties;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.ResourceBundle;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import net.glxn.qrgen.image.ImageType;
import tn.pidev.tm.entite.Client;
import tn.pidev.tm.entite.Parking;
import tn.pidev.tm.entite.Promotion;
import tn.pidev.tm.service.AdminService;
import tn.pidev.tm.service.ClientService;

import tn.pidev.tm.service.ParkingService;
/**
 * FXML Controller class
 *
 * @author HP-PC
 */
public class ParkingController implements Initializable {

    @FXML
    private TabPane admintabpane;
    @FXML
    private Tab home;
    @FXML
    private TableView<Parking> tableParkPlace;
    @FXML
      private TableColumn<Parking, Integer> numPlace;
    @FXML
    private Button validerPark;
    @FXML
    private DatePicker picker;
    @FXML
    private Label prixPark;
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
    @FXML
    private JFXTimePicker hEntree;
    @FXML
    private JFXTimePicker hSortie;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onvaliderPark(ActionEvent event) throws ParseException {
  // LocalDate value =picker.getValue();
  // Date date = java.sql.Date.valueOf(value);
         LocalDate  localDate2 = picker.getValue();
        
        java.util.Date date1 = java.util.Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
        LocalDate datelocal = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
   Promotion p=new Promotion();
   java.util.Date datedate =Date.from(datelocal.atStartOfDay(ZoneId.systemDefault()).toInstant());
 // String datepic=p.convertdate(date);
    // System.out.println(datepic);
   LocalTime valuehS =hSortie.getValue();  
//   
//     String timepic=valueh1.toString();  
       LocalTime valuehE =hEntree.getValue();  
//       java.sql.Time tE=p.toSqlTime(valuehE);
//java.sql.Time time = new java.sql.Time(valuehS);
//   
//long millis = valuehS.toDateTimeToday().withDate(1970, 1, 1).getMillis();
Time timeS = Time.valueOf(valuehS);
Time timeE = Time.valueOf(valuehE);
//java.sql.Time time = new java.sql.Time(millis);
       // System.out.println(tE);
         //System.out.println(tS);
        //String mot= rechercher.getText();
             ParkingService cs = new  ParkingService();
             System.out.println(cs.getAllNumPlace(datedate,timeE));
        tableParkPlace.setItems(cs.getAllNumPlace(datedate,timeE));
        
        numPlace.setCellValueFactory(new PropertyValueFactory<>("numPlace"));

        
    }

    @FXML
    private void onheureentree(KeyEvent event) {
//        
////          String mot= rechercher.getText();
//         if(event.getCode().toString().equals("ENTER"))
//    {
//         LocalTime valueh =hEntree.getValue();  
//        //String mot= rechercher.getText();
//             ParkingService cs = new  ParkingService();
//        tableParkPlace.setItems(cs.getAllNumPlace(valueh));
//        numPlace.setCellValueFactory(new PropertyValueFactory<>("numPlace"));
//  
//        
//    }
        
    }


    @FXML
    private void OnNumPlaceClicked(MouseEvent event) throws SQLException, FileNotFoundException, IOException {
           if (event.getClickCount() == 1) //Checking double click
    {
           
        java.util.Date now=new java.util.Date();
         LocalDate  localDate2 = picker.getValue();
        
        java.util.Date date1 = java.util.Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
        LocalDate datelocal = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
   Promotion p=new Promotion();
   java.util.Date datedate =Date.from(datelocal.atStartOfDay(ZoneId.systemDefault()).toInstant());
 
   LocalTime valuehS =hSortie.getValue();  

       LocalTime valuehE =hEntree.getValue();  
       java.sql.Time tE=p.toSqlTime(valuehE);

Time timeS = Time.valueOf(valuehS);
Time timeE = Time.valueOf(valuehE);

        System.out.println(tE);
    
             ParkingService cs = new  ParkingService();
          int numPlace = tableParkPlace.getSelectionModel().getSelectedItem().getNumPlace();
            int idPark = tableParkPlace.getSelectionModel().getSelectedItem().getId();
             AdminService as=new AdminService();
//             ConnexionService co=new ConnexionService();
//             String user=co.getAll().getLogin();
             ClientService clientservice =new ClientService();
             int idclient=as.idclientfind(FXMLloginvideoController.usernameautho);  
             if((timeE.compareTo(timeS)>0)&& (datedate.compareTo(now)<0))
             {
             Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("l'heure d'entree superieure a celle de la sortie !");
            alert.setHeaderText("l'heure d'entree superieure a celle de la sortie ou la date choisi est inferieur a celle d'aujourd'hui!");
            alert.setContentText("");
            ///  Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

            Optional<ButtonType> result = alert.showAndWait();
             }
             else {
             
         Long minutesBetween= Duration.between(valuehS,valuehE).toMinutes()/11;
           System.out.println(minutesBetween); 
           double prix=minutesBetween*0.025;
           prixPark.setText(prix+"DT a payer"+" "+clientservice.chercherId(idclient).getNom());
     Parking p1 =new Parking(idPark,numPlace,clientservice.chercherId(idclient),timeE,timeS,datedate);
     cs.modifier(p1);
    String details = clientservice.chercherId(idclient).getNom()+clientservice.chercherId(idclient).getPrenom()+clientservice.chercherId(idclient).getCin()+numPlace+
            valuehE+"entree"+valuehS+"SORTIE"+datedate+"datePark";
        ByteArrayOutputStream out=net.glxn.qrgen.QRCode.from(details).to(ImageType.JPG).stream();
             
File f=new File("C:\\Users\\HP-PC\\Desktop\\qrcodePark.jpg");
        FileOutputStream fao =new FileOutputStream(f);
        fao.write(out.toByteArray());
        fao.flush();
        
         final String username = "tunisiamalleverywhere@gmail.com"; //ur email
    final String password = "279189494";

    Properties props = new Properties();
    props.put("mail.smtp.auth", true);
    props.put("mail.smtp.starttls.enable", true);
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
    }                            
});

    try {
        
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("tunisiamalleverywhere@gmail.com"));//ur email
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(clientservice.chercherId(idclient).getMail()));//u will send to
        message.setSubject("qrCodeParking");    
        message.setText("veuillez apporter ce qrcode");
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        Multipart multipart = new MimeMultipart();


     
     
    //attached 1 --------------------------------------------
        String file = "C:\\Users\\HP-PC\\Desktop\\qrcodePark.jpg";
        String fileName = "QRcode";
    messageBodyPart = new MimeBodyPart();   
    DataSource source = new FileDataSource(file);      
    messageBodyPart.setDataHandler(new DataHandler(source));
    messageBodyPart.setFileName(fileName);
    multipart.addBodyPart(messageBodyPart);
    //------------------------------------------------------    
     
     //attached 2 --------------------------------------------  
//       String file2="path of file";
//       String fileName2 = "AnyName2";
//    messageBodyPart = new MimeBodyPart();   
//    DataSource source2 = new FileDataSource(file2);      
//    messageBodyPart.setDataHandler(new DataHandler(source2));
//    messageBodyPart.setFileName(fileName2);
//    multipart.addBodyPart(messageBodyPart);
//  //attached 3------------------------------------------------
//       
//       String file3="path of file";
//       String fileName3 = "AnyName3";
//    messageBodyPart = new MimeBodyPart();   
//    DataSource source3 = new FileDataSource(file3);      
//    messageBodyPart.setDataHandler(new DataHandler(source3));
//    messageBodyPart.setFileName(fileName3);
//    multipart.addBodyPart(messageBodyPart);
//    //attached 4------------------------------------------------
//    String file4="path of file";
//       String fileName4 = "AnyName4";
//    messageBodyPart = new MimeBodyPart();   
//    DataSource source4 = new FileDataSource(file4);      
//    messageBodyPart.setDataHandler(new DataHandler(source4));
//    messageBodyPart.setFileName(fileName4);
//    multipart.addBodyPart(messageBodyPart);
    //>>>>>>>>
   
    
    
        message.setContent(multipart);

       
        System.out.println("sending");
        Transport.send(message);
        System.out.println("Done");
        
   

            
}catch (MessagingException e) {
        e.printStackTrace();
    }
        
             } 
        
        
        
        
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
