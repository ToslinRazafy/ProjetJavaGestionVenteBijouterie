/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package views;

import gestion.LoginUtilisateur;
import models.Utilisateur;
import java.awt.Button;
import java.awt.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Razafitsotra Toslin
 */
public class LoginController implements Initializable {  
    public static String sessionEmail;
    public static String sessionNom;
    public static Boolean connecter = false;
    
    @FXML
    private javafx.scene.control.Button btnConnection;

    @FXML
    private Hyperlink mdpOublier;

    @FXML
    private javafx.scene.control.TextField txtEmail;

    @FXML
    private PasswordField txtMdp;
    
    private Alert alert;
    
    @FXML
    public void connecter() throws IOException{
        if(txtEmail.getText().isEmpty() || txtMdp.getText().isEmpty()){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Message d'erreur");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs");
            alert.showAndWait();
        }else{
            String email = txtEmail.getText();
            String mdp = txtMdp.getText();
            ResultSet resultat = null;
            try {
                Utilisateur user = new Utilisateur(email, mdp);
                LoginUtilisateur loginuser = new LoginUtilisateur();
                resultat = loginuser.loginUtilisateur(user);
                if(resultat.next()){
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Message de connection");
                    alert.setHeaderText(null);
                    alert.setContentText("Connection reuissi !!!");
                    alert.showAndWait();
                    
                    sessionNom = resultat.getString("Nom_utilisateur");
                    sessionEmail = resultat.getString("Email_utilisateur");
                    connecter = true;
                    Parent root = FXMLLoader.load(getClass().getResource("AppForm.fxml"));
                    
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    stage.setTitle("Gestion de vente de bijouterie To-Bijou");
                    stage.setMinHeight(800);
                    stage.setMinWidth(1360);
                    stage.setScene(scene);
                    stage.show();
                    btnConnection.getScene().getWindow().hide();
                }else{
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Message d'erreur");
                    alert.setHeaderText(null);
                    alert.setContentText("Votre email ou mot de passe est incorrect");
                    alert.showAndWait();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
