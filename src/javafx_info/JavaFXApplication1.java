/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_info;


import java.sql.Connection;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 *
 * @author RBS
 */
public class JavaFXApplication1 extends Application {
    
    static Connection mycon;
    @Override
    public void start(Stage stage) throws Exception {
       
       
        Parent root = FXMLLoader.load(getClass().getResource("FXMLloginvideo.fxml"));

        stage.initStyle(StageStyle.UNDECORATED);
        Scene scene = new Scene(root);
        
        
        stage.setScene(scene);
        
        stage.show();
        /*Client c=new Client();
        ClientService cs=new ClientService();
        cs.ajouterclient(c);*/
        
        
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       
        launch(args);
        
    }
    
}
