
package javafx_info;

import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 *
 * @author proxc
 */
public class HomeController implements Initializable {
    
    @FXML
    private Tab home;
    private Tab statistique;
    @FXML
    private TabPane admintabpane;
    @FXML
    private JFXButton ptsfidelite;
    @FXML
    private Tab tabgerercompte;
    @FXML
    private Tab tabptsfidelite;
    @FXML
    private JFXButton btngerercompte;
    @FXML
    private JFXButton btnpromotion;
    @FXML
    private JFXButton btnparking;
    @FXML
    private Tab tabpromotion;
    @FXML
    private Tab tabparking;
    @FXML
    private MediaView mediaTM;
    private MediaPlayer mp;
    private Media me;
    @FXML
    private JFXButton idvoir;
    @FXML
    private Tab Produit;
    private void handleButtonAction(MouseEvent event) {
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String path=new File("C:\\Users\\RBS\\Desktop\\tunisiamall\\src\\ressources\\tm.mp4").getAbsolutePath();
        me=new Media(new File(path).toURI().toString());
        mp=new MediaPlayer(me);
        mediaTM.setMediaPlayer(mp);
        mp.setAutoPlay(true);
       final DoubleProperty width = mediaTM.fitWidthProperty();
    final DoubleProperty height = mediaTM.fitHeightProperty();
    
    width.bind(Bindings.selectDouble(mediaTM.sceneProperty(),"width"));
    height.bind(Bindings.selectDouble(mediaTM.sceneProperty(),"height"));
        // TODO
    }    

    @FXML
    private void onhomeclicked(ActionEvent event) {
        admintabpane.getSelectionModel().select(home);
    }

    private void onstatistiqueselected(ActionEvent event) throws IOException {
        admintabpane.getSelectionModel().select(statistique);
            Parent root = FXMLLoader.load(getClass().getResource("Jaime.fxml"));
          
    Scene newScene= new Scene(root);
    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(newScene);
       window.show();
        
        
        
        
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

    @FXML
    private void onProduitselected(ActionEvent event) {
    }
    
}
