/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_info;

import com.jfoenix.controls.JFXButton;

import java.net.URL;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.NumberAxisBuilder;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JTable;
import tn.pidev.tm.service.ClientService;
import tn.pidev.tm.service.CommandeService;
import tn.pidev.tm.service.ProduitService;
import tn.pidev.tm.service.PromotionService;
import tn.pidev.tm.service.ServiceEnseigne;

/**
 * FXML Controller class
 *
 * @author HP-PC
 */
public class StatistiquesController implements Initializable {

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
    @FXML
    private PieChart chart;
    @FXML
    private Label labelstat;
    @FXML
    private Button imprimer;

    /**
     * Initializes the controller class.
     */
    @Override
 public void initialize(URL url, ResourceBundle rb) {
        ProduitService P = new ProduitService();
          ClientService C = new ClientService();
          CommandeService Cmd = new CommandeService();
          ServiceEnseigne E = new ServiceEnseigne();
          PromotionService Promo = new PromotionService();
        
            ObservableList<PieChart.Data> pieChartData = null;
            try {
            pieChartData = FXCollections.observableArrayList(
            new PieChart.Data("Nombre de Produits ", P.CalculP()),
            new PieChart.Data("Nombre de Clients", C.CalculP()),
            new PieChart.Data("Nombre de Commandes", Cmd.CalculP()),
            new PieChart.Data("Nombre d'Enseigne", E.CalculP()),
            new PieChart.Data("Nombre de Promotions", Promo.CalculP()));
            } catch (SQLException ex) {
            Logger.getLogger(StatistiquesController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            chart.setData(pieChartData);
            // TODO
            
            chart.getData().stream().forEach(data ->{
                data.getNode().addEventHandler(MouseEvent.ANY, e -> {
                  
                    labelstat.setText("Voici les Statistiques !...  ");
                    
                });
            });
        }

    @FXML
    private void onstatistiqueselected(ActionEvent event) {
    }

    @FXML
    private void onhomeclicked(ActionEvent event) {
    }

    @FXML
    private void ongerercompteelected(ActionEvent event) {
    }

    @FXML
    private void onptsfideliteselected(ActionEvent event) {
    }

    @FXML
    private void onpromotionselected(ActionEvent event) {
    }

    @FXML
    private void onparkingselected(ActionEvent event) {
    }
}

    
    
    
    

