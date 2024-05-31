/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package views;

import gestion.GestionBijoux;
import gestion.GestionClients;
import gestion.GestionCommande;
import gestion.GestionCommandeTemporaire;
import gestion.GestionDetailCommande;
import gestion.GestionsBijouteries;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Clients;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import models.Bijoux;
import models.Commande;
import models.CommandeTemporaire;
import models.DetailCommande;

/**
 * FXML Controller class
 *
 * @author Razafitsotra Toslin
 */
public class AppFormController implements Initializable {

    @FXML
    private Label labelUtilisateur;

    @FXML
    private Button btnAnnulerClient;

    @FXML
    private Button btnBijoux;

    @FXML
    private Button btnClients;

    @FXML
    private Button btnCommandes;

    @FXML
    private Button btnDeconnection;

    @FXML
    private Button btnDetailsCommandes;

    @FXML
    private Button btnEnregistrerClient;

    @FXML
    private Button btnListeCommandes;

    @FXML
    private Button btnMenu;

    @FXML
    private Button btnModiffierClient;

    @FXML
    private Button btnSupprimerClient;

    @FXML
    private Button btnAnnulerBijou;

    @FXML
    private Button btnEnregistrerBijou;

    @FXML
    private Button btnModiffierBijou;

    @FXML
    private Button btnSupprimerBijou;


    @FXML
    private AnchorPane paneCommande;

    @FXML
    private TableView<CommandeTemporaire> tabCommander;

    @FXML
    private TableColumn<CommandeTemporaire, String> tableComTmpDescription;

    @FXML
    private TableColumn<CommandeTemporaire, String> tableComTmpIdBijou;

    @FXML
    private TableColumn<CommandeTemporaire, String> tableComTmpMontant;

    @FXML
    private TableColumn<CommandeTemporaire, String> tableComTmpNomBijou;

    @FXML
    private TableColumn<CommandeTemporaire, String> tableComTmpPU;

    @FXML
    private TableColumn<CommandeTemporaire, String> tableCompTmpQuantite;

    @FXML
    private ComboBox<?> cbSexeClient;


    @FXML
    private Label nbrBijousVendus;

    @FXML
    private Label nbrBijoux;

    @FXML
    private Label nbrClients;


    @FXML
    private AnchorPane paneClient;

    @FXML
    private AnchorPane panelMenu;

    @FXML
    private AnchorPane paneBijou;

    @FXML
    private Label revenusAujourdhuit;

    @FXML
    private Label revenusDuMois;

    @FXML
    private Label revenusTotal;

    @FXML
    private TableView<Clients> tabCliebt;

    @FXML
    private TableColumn<Clients, String> tableAdresseClient;

    @FXML
    private TableColumn<Clients, String> tableIdClient;

    @FXML
    private TableColumn<Clients, String> tableNomClient;

    @FXML
    private TableColumn<Clients, String> tablePrenomClient;

    @FXML
    private TableColumn<Clients, String> tableSexeClient;

    @FXML
    private TableColumn<Clients, String> tableTelClient;

    @FXML
    private TableColumn<Clients, String> tableVilleClient;

    @FXML
    private TableView<Bijoux> tabBijou;

    @FXML
    private TableColumn<Bijoux, String> tableCategorie;

    @FXML
    private TableColumn<Bijoux, String> tableDescription;

    @FXML
    private TableColumn<Bijoux, String> tableIdBijou;

    @FXML
    private TableColumn<Bijoux, String> tableMateriau;

    @FXML
    private TableColumn<Bijoux, String> tableNomBijou;

    @FXML
    private TableColumn<Bijoux, String> tablePrix;

    @FXML
    private TableColumn<Bijoux, String> tableStock;
    

    @FXML
    private TableView<Commande> tabCommande;

    @FXML
    private TableColumn<Commande, String> tabListClentMontantTotal;

    @FXML
    private TableColumn<Commande, String> tabListComDateCom;

    @FXML
    private TableColumn<Commande, String> tabListComIdClient;


    @FXML
    private TableColumn<Commande, String> tabListComNumCom;
    



    @FXML
    private javafx.scene.control.TextField txtAdresseClient;

    @FXML
    private javafx.scene.control.TextField txtNomClient;

    @FXML
    private javafx.scene.control.TextField txtPrenomClient;


    @FXML
    private javafx.scene.control.TextField txtTelClient;

    @FXML
    private javafx.scene.control.TextField txtVilleClient;

    @FXML
    private TextField txtCategorie;

    @FXML
    private TextArea txtDescription;


    @FXML
    private TextField txtMaterieau;

    @FXML
    private TextField txtNomBijou;

    @FXML
    private ImageView txtPhoto;

    @FXML
    private TextField txtPrix;

    @FXML
    private TextField txtQuantite;


    private Image image;

    private Alert alert;

    private String[] listSexe = {"Masculin", "Feminin"};

    private int IdClient;

    private int IdBijou;

    private String path;

    @FXML
    private Button btnPhoto;
    @FXML
    private TextField txtNomClientCom;
    @FXML
    private TextField txtPrenomClientCom;
    @FXML
    private ComboBox<?> txtIdClientCom;
    @FXML
    private ComboBox<?> txtNomBijouCom;
    @FXML
    private TextField txtIdBijouCom;
    @FXML
    private TextField txtQuantiteCom;
    @FXML
    private TextField txtPrixCom;
    @FXML
    private TextField txtQunatiteCommander;
    @FXML
    private TextField txtMontantTotal;
    @FXML
    private TextField txtNumCom;
        
    @FXML
    private Button btnAjouterCom;

    @FXML
    private Button btnAnnulerCommande;
    
    @FXML
    private Button btnValiderCommande;
    
    @FXML
    private AreaChart<?, ?> areaChartCommande;

    @FXML
    private BarChart<?, ?> barChartClient;
    @FXML
    private Label laeblDateCommande;
    @FXML
    private AnchorPane paneListeCommande;
    
    @FXML
    private TableColumn<Commande, String> tabListComPrenomCli;

    @FXML
    private TableColumn<Commande, String> tabListComTelephone;
    
    @FXML
    private TableColumn<Commande, String> tabListComNomCli;

    @FXML
    public void effacementChamps() {
        txtNomClient.setText("");
        txtPrenomClient.setText("");
        txtAdresseClient.setText("");
        txtTelClient.setText("");
        txtVilleClient.setText("");
        cbSexeClient.getSelectionModel().clearSelection();
        cbSexeClient.setPromptText("Séléctionner le sexe");
        txtNomBijou.setText("");
        txtMaterieau.setText("");
        txtCategorie.setText("");
        txtDescription.setText("");
        txtQuantite.setText("");
        txtPrix.setText("");
        path = "";
        txtPhoto.setImage(null);
        masquerButton();
    }

    @FXML
    public void supprimerClient() {
        if (txtNomClient.getText().isEmpty() || txtPrenomClient.getText().isEmpty() || txtAdresseClient.getText().isEmpty() || txtVilleClient.getText().isEmpty() || txtTelClient.getText().isEmpty()) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Message d'erreur");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs avant d'enregistrer les donnes");
            alert.showAndWait();
        } else {
            try {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Message de confirmation");
                alert.setHeaderText(null);
                alert.setContentText("Vous voulez vraiment supprimer " + txtNomClient.getText() + " " + txtPrenomClient.getText() + " ?");
                Optional<ButtonType> option = alert.showAndWait();
                if (option.get().equals(ButtonType.OK)) {
                    GestionClients gestion = new GestionClients();
                    gestion.delete(IdClient);
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Message de reuisite");
                    alert.setHeaderText(null);
                    alert.setContentText("Le client a ete bien supprimer");
                    alert.showAndWait();
                    affichageClient();
                    effacementChamps();
                    masquerButton();
                } else {
                    effacementChamps();
                    masquerButton();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void effacerChampCommande() {
        txtIdClientCom.getSelectionModel().clearSelection();
        txtIdClientCom.setPromptText("Selectionnier un client");
        txtNomClientCom.setText(null);
        txtPrenomClientCom.setText(null);
        txtNomBijouCom.getSelectionModel().clearSelection();
        txtNomBijouCom.setPromptText("Selectionner le bijou");
        txtIdBijouCom.setText(null);
        txtQuantiteCom.setText(null);
        txtPrixCom.setText(null);
        txtMontantTotal.setText(null);
        txtQunatiteCommander.setText(null);
    }

    @FXML
    public void annulerCommande() {
        alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Message d'avertissement");
        alert.setHeaderText(null);
        alert.setContentText("Vous voules vraiment annuler la commande");
        Optional<ButtonType> option = alert.showAndWait();
        if (option.get().equals(ButtonType.OK)) {
            GestionCommandeTemporaire gestion = new GestionCommandeTemporaire();
            GestionsBijouteries gestBi = new GestionsBijouteries();
            ResultSet res = gestion.getAll();
            try {
                while (res.next()) {
                    ResultSet res1 = gestBi.getBijou(res.getInt("Num_bijou"));
                    res1.next();
                    gestBi.updateBijou((res.getInt("Quantite_com") + res1.getInt("Stock")), res.getInt("Num_bijou"));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            gestion.delete();
            effacementChamps();
            effacerChampCommande();
            affichageCommandeTmp();
        }
    }

    @FXML
    public void supprimerBijou() {
        if (txtNomBijou.getText().isEmpty() || txtMaterieau.getText().isEmpty() || txtCategorie.getText().isEmpty() || txtDescription.getText().isEmpty() || txtPhoto == null || txtQuantite.getText().isEmpty() || txtPrix.getText().isEmpty()) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Message d'erreur");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs avant d'enregistrer les donnes");
            alert.showAndWait();
        } else {
            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Message de confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Vous voulez vraiment supprimer " + txtNomBijou.getText() + " ?");
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get().equals(ButtonType.OK)) {
                GestionBijoux gestion = new GestionBijoux();
                gestion.delete(IdBijou);
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Message de reuisite");
                alert.setHeaderText(null);
                alert.setContentText("Le bijou a ete bien supprimer");
                alert.showAndWait();
                affichageBijou();
                effacementChamps();
                masquerButton();
            }
        }
    }

    @FXML
    public void modifierClient() {
        if (txtNomClient.getText().isEmpty() || txtPrenomClient.getText().isEmpty() || txtAdresseClient.getText().isEmpty() || txtVilleClient.getText().isEmpty() || txtTelClient.getText().isEmpty() || cbSexeClient.getSelectionModel().getSelectedItem() == null) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Message d'erreur");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs avant d'enregistrer les donnes");
            alert.showAndWait();
        } else {
            GestionClients gestion = new GestionClients();
            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Message de confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Vous voulez vramiant modifier le client ?");
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get().equals(ButtonType.OK)) {
                Clients client = new Clients(0, txtNomClient.getText(), txtPrenomClient.getText(), txtAdresseClient.getText(), txtVilleClient.getText(), txtTelClient.getText(), (String) cbSexeClient.getSelectionModel().getSelectedItem());
                gestion.update(client, IdClient);
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Message de reuissite");
                alert.setHeaderText(null);
                alert.setContentText("Modification reuissi");
                alert.showAndWait();
                effacementChamps();
                affichageClient();
                masquerButton();
            } else {
                effacementChamps();
                masquerButton();
            }
        }
    }

    @FXML
    public void modifierBijou() {
        if (txtNomBijou.getText().isEmpty() || txtMaterieau.getText().isEmpty() || txtCategorie.getText().isEmpty() || txtDescription.getText().isEmpty() || txtPhoto == null || txtQuantite.getText().isEmpty() || txtPrix.getText().isEmpty()) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Message d'erreur");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs avant d'enregistrer les donnes");
            alert.showAndWait();
        } else {
            GestionBijoux gestion = new GestionBijoux();
            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Message de confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Vous voulez vramiant modifier le bijou ?");
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get().equals(ButtonType.OK)) {
                String paths = path;
                paths = paths.replace("\\", "\\\\");
                Bijoux bijou = new Bijoux(0, txtNomBijou.getText(), txtMaterieau.getText(), txtCategorie.getText(), txtDescription.getText(), paths, Integer.parseInt(txtQuantite.getText()), Integer.parseInt(txtPrix.getText()));
                gestion.update(bijou, IdBijou);
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Message de reuissite");
                alert.setHeaderText(null);
                alert.setContentText("Modification reuissi");
                alert.showAndWait();
                effacementChamps();
                affichageBijou();
                masquerButton();
            } else {
                effacementChamps();
                masquerButton();
            }
        }
    }

    @FXML
    public void enregistrementClient() {
        if (txtNomClient.getText().isEmpty() || txtPrenomClient.getText().isEmpty() || txtAdresseClient.getText().isEmpty() || txtVilleClient.getText().isEmpty() || txtTelClient.getText().isEmpty() || cbSexeClient.getSelectionModel().getSelectedItem() == null) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Message d'erreur");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs avant d'enregistrer les donnes");
            alert.showAndWait();
        } else {
            GestionClients gestion = new GestionClients();
            ResultSet resultat = gestion.verify(txtTelClient.getText());
            try {
                if (resultat.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Message d'erreur");
                    alert.setHeaderText(null);
                    alert.setContentText("Le numero " + txtTelClient.getText() + " que vous avez saisie est deja enregistrer");
                    alert.showAndWait();
                    effacementChamps();
                } else {
                    Clients client = new Clients(0, txtNomClient.getText().toUpperCase(), txtPrenomClient.getText(), txtAdresseClient.getText(), txtVilleClient.getText().toUpperCase(), txtTelClient.getText(), (String) cbSexeClient.getSelectionModel().getSelectedItem());
                    gestion.save(client);
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Message de reuissite");
                    alert.setHeaderText(null);
                    alert.setContentText("L'enregistrement de " + txtNomClient.getText() + " " + txtPrenomClient.getText() + " est reuissi");
                    alert.showAndWait();
                    effacementChamps();
                    affichageClient();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @FXML
    public void enregistrementBijou() {
        if (txtNomBijou.getText().isEmpty() || txtMaterieau.getText().isEmpty() || txtCategorie.getText().isEmpty() || txtDescription.getText().isEmpty() || path == null || txtQuantite.getText().isEmpty() || txtPrix.getText().isEmpty()) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Message d'erreur");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs avant d'enregistrer les donnes");
            alert.showAndWait();
        } else {
            GestionBijoux gestion = new GestionBijoux();
            String paths = path;
            paths = paths.replace("\\", "\\\\");
            Bijoux bijou = new Bijoux(0, txtNomBijou.getText(), txtMaterieau.getText(), txtCategorie.getText().toUpperCase(), txtDescription.getText(), paths, Integer.parseInt(txtQuantite.getText()), Integer.parseInt(txtPrix.getText()));
            gestion.save(bijou);
            alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Message de reuissite");
            alert.setHeaderText(null);
            alert.setContentText("L'enregistrement de " + txtNomBijou.getText() + " est reuissi");
            alert.showAndWait();
            effacementChamps();
            affichageBijou();
        }
    }

    @FXML
    public void enregistrementCommandeTemporaire() {
        if (txtNomClientCom.getText().isEmpty() || txtIdBijouCom.getText().isEmpty() || txtQunatiteCommander.getText().isEmpty()) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Message d'erreur");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs avant d'enregistrer les donnes");
            alert.showAndWait();
        } else {
            if (Integer.parseInt(txtQunatiteCommander.getText()) > Integer.parseInt(txtQuantiteCom.getText())) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Message d'erreur");
                alert.setHeaderText(null);
                alert.setContentText("La quantite Commander depasse la quantite dans le stock");
                alert.showAndWait();
            }else if(Integer.parseInt(txtQunatiteCommander.getText()) == 0){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Message d'erreur");
                alert.setHeaderText(null);
                alert.setContentText("La quantite Commander doit supperieur 0");
                alert.showAndWait();
            } else {
                GestionBijoux gestionBijou = new GestionBijoux();
                GestionsBijouteries gesBijou = new GestionsBijouteries();
                GestionCommandeTemporaire gestion = new GestionCommandeTemporaire();
                ResultSet res = gestion.verify(Integer.parseInt(txtIdBijouCom.getText()));

                try {
                    if (res.next()) {
                        int quantite = Integer.parseInt(txtQunatiteCommander.getText());
                        int montant = (res.getInt("Quantite_com") + quantite) * res.getInt("Prix");
                        gestion.updateQuantity((quantite + res.getInt("Quantite_com")), montant, Integer.parseInt(txtIdBijouCom.getText()));
                        ResultSet res1 = gestionBijou.verify(Integer.parseInt(txtIdBijouCom.getText()));
                        res1.next();
                        gesBijou.updateBijou((res1.getInt("Stock") - quantite), Integer.parseInt(txtIdBijouCom.getText()));
                        affichageCommandeTmp();
                    } else {
                        res = gestionBijou.verify(Integer.parseInt(txtIdBijouCom.getText()));
                        res.next();
                        CommandeTemporaire comTmp = new CommandeTemporaire(Integer.parseInt(txtIdBijouCom.getText()), res.getString("Nom_bijou"), res.getString("Description"), Integer.parseInt(txtQunatiteCommander.getText()), res.getInt("Prix"), (Integer.parseInt(txtQunatiteCommander.getText()) * res.getInt("Prix")));
                        gestion.save(comTmp);
                        gesBijou.updateBijou((res.getInt("Stock") - Integer.parseInt(txtQunatiteCommander.getText())), Integer.parseInt(txtIdBijouCom.getText()));
                        affichageCommandeTmp();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                txtMontantTotal.setText(String.valueOf(gestion.sommeTotalComTmp()));
                txtQunatiteCommander.setText(null);
                txtNomBijouCom.getSelectionModel().clearSelection();
                txtIdBijouCom.setText(null);
                txtQuantiteCom.setText(null);
                txtPrixCom.setText(null);
                txtNomBijouCom.setPromptText("Selectionner le bijou");
            }
        }
    }

    @FXML
    public void enregistrementCommande() {
        GestionCommandeTemporaire gestion = new GestionCommandeTemporaire();
        if (gestion.sommeTotalComTmp() > 0) {
            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Message de confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Vous voulez vraiment terminer la commande et l'imprimer ?");
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get().equals(ButtonType.OK)) {
                String idcli = (String) txtIdClientCom.getSelectionModel().getSelectedItem();
                GestionCommande gestionCom = new GestionCommande();
                Commande com = new Commande(0, Integer.parseInt(idcli.substring(0, 1)), Integer.parseInt(txtMontantTotal.getText()), null, null, null, null);
                gestionCom.save(com);
                GestionDetailCommande gestionDetCom = new GestionDetailCommande();
                ResultSet res = gestion.getAll();
                try {
                    while (res.next()) {
                        DetailCommande detCom = new DetailCommande(0, Integer.parseInt(txtNumCom.getText()), res.getInt("Num_bijou"), res.getInt("Quantite_com"), res.getInt("Prix"), res.getInt("Montant"));
                        gestionDetCom.save(detCom);
                    }
                    gestion.delete();
                    affichageCommandeTmp();
                    effacerChampCommande();
                    numBijouList();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        } else {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Message d'erreur");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez faire la commande");

        }
    }

    public void affichageAreaChart() {
        areaChartCommande.getData().clear();
        GestionCommande gc = new GestionCommande();
        ResultSet res = gc.donneAreaChart();
        XYChart.Series chart = new XYChart.Series();
        try {
            while (res.next()) {
                chart.getData().add(new XYChart.Data<>(res.getString("Date_com"), res.getInt("total")));
            }
            areaChartCommande.getData().add(chart);

        } catch (SQLException ex) {
            Logger.getLogger(AppFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void affichageBarChart() {
        barChartClient.getData().clear();
        GestionCommande gc = new GestionCommande();
        ResultSet res = gc.donneBarChart();
        XYChart.Series chart = new XYChart.Series();
        try {
            while (res.next()) {
                chart.getData().add(new XYChart.Data<>(res.getString("Date_com"), res.getInt("nombre")));
            }
            barChartClient.getData().add(chart);

        } catch (SQLException ex) {
            Logger.getLogger(AppFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void importPhoto() {
        FileChooser openfile = new FileChooser();
        openfile.getExtensionFilters().add(new FileChooser.ExtensionFilter("Selectionner un image", "*png", "*jpg", "*jpeg", "*webp"));
        File file = openfile.showOpenDialog(paneBijou.getScene().getWindow());
        if (file != null) {
            path = file.getAbsolutePath();
            image = new Image(file.toURI().toString(), 200, 174, false, true);
            txtPhoto.setImage(image);
        }
    }

    public ObservableList<Clients> listeClient() {
        ObservableList<Clients> listCLient = FXCollections.observableArrayList();
        GestionClients gestion = new GestionClients();
        ResultSet resultat = gestion.getAll();
        try {
            Clients client;
            while (resultat.next()) {
                client = new Clients(resultat.getInt("Id_cli"), resultat.getString("Nom_cli"), resultat.getString("Prenom_cli"), resultat.getString("Adrs_cli"), resultat.getString("Ville"), resultat.getString("Tel_cli"), resultat.getString("Sexe"));
                listCLient.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listCLient;
    }

    public ObservableList<Bijoux> listeBijou() {
        ObservableList<Bijoux> listBijou = FXCollections.observableArrayList();
        GestionBijoux gestion = new GestionBijoux();
        ResultSet resultat = gestion.getAll();
        try {
            Bijoux bijou;
            while (resultat.next()) {
                bijou = new Bijoux(resultat.getInt("Num_bijou"), resultat.getString("Nom_bijou"), resultat.getString("Materiau"), resultat.getString("Categorie"), resultat.getString("Description"), resultat.getString("Photo"), resultat.getInt("Stock"), resultat.getInt("Prix"));
                listBijou.add(bijou);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listBijou;
    }

    public ObservableList<CommandeTemporaire> listeCommandeTmp() {
        ObservableList<CommandeTemporaire> listeCommandeTmp = FXCollections.observableArrayList();
        GestionCommandeTemporaire gestion = new GestionCommandeTemporaire();
        ResultSet res = gestion.getAll();
        try {
            while (res.next()) {
                CommandeTemporaire comTmp = new CommandeTemporaire(res.getInt("Num_bijou"), res.getString("Nom_bijou"), res.getString("Description"), res.getInt("Quantite_com"), res.getInt("Prix"), res.getInt("Montant"));
                listeCommandeTmp.add(comTmp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listeCommandeTmp;
    }
    
    public ObservableList<Commande> listeCommande(){
        ObservableList<Commande> listeCommande = FXCollections.observableArrayList();
        GestionCommande gestion = new GestionCommande();
        ResultSet res = gestion.getAll();
        try {
            while(res.next()){
                Commande com = new Commande(res.getInt("Num_com"), res.getInt("Id_cli"), res.getInt("Montant_tot"), res.getString("Date_com"), res.getString("Nom_cli"), res.getString("Prenom_cli"), res.getString("Tel_cli"));
                listeCommande.add(com);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AppFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeCommande;
        
    }

    @FXML
    public void selectionTableClient() {
        Clients client = tabCliebt.getSelectionModel().getSelectedItem();
        int idClient = tabCliebt.getSelectionModel().getSelectedIndex();
        if ((idClient - 1) < -1) {
            return;
        }
        txtNomClient.setText(client.getNom());
        txtPrenomClient.setText(client.getPrenom());
        txtAdresseClient.setText(client.getAdresse());
        txtVilleClient.setText(client.getVille());
        txtTelClient.setText(client.getTelephone());
        IdClient = client.getId();
        btnSupprimerClient.setVisible(true);
        btnModiffierClient.setVisible(true);
        btnEnregistrerClient.setVisible(false);

    }

    @FXML
    public void seletionTableBijou() {
        Bijoux bijou = tabBijou.getSelectionModel().getSelectedItem();
        int numBijou = tabBijou.getSelectionModel().getSelectedIndex();
        if ((numBijou - 1) < -1) {
            return;
        }
        txtNomBijou.setText(bijou.getNom());
        txtMaterieau.setText(bijou.getMateriau());
        txtCategorie.setText(bijou.getCategorie());
        txtDescription.setText(bijou.getDescription());
        txtQuantite.setText(String.valueOf(bijou.getStock()));
        txtPrix.setText(String.valueOf(bijou.getPrix()));
        path = "File:" + bijou.getPhoto();
        image = new Image(path, 200, 174, false, true);
        txtPhoto.setImage(image);
        IdBijou = bijou.getNum();
        btnSupprimerBijou.setVisible(true);
        btnModiffierBijou.setVisible(true);
        btnEnregistrerBijou.setVisible(false);
    }

    private ObservableList<Clients> listeClient;
    private ObservableList<Bijoux> listeBijoux;
    private ObservableList<CommandeTemporaire> listeCommandeTemporaire;
    private ObservableList<Commande> listCommande;

    public void affichageClient() {
        listeClient = listeClient();
        tableIdClient.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableNomClient.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tablePrenomClient.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        tableAdresseClient.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        tableVilleClient.setCellValueFactory(new PropertyValueFactory<>("ville"));
        tableTelClient.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        tableSexeClient.setCellValueFactory(new PropertyValueFactory<>("sexe"));
        tabCliebt.setItems(listeClient);
    }

    public void affichageBijou() {
        listeBijoux = listeBijou();
        tableIdBijou.setCellValueFactory(new PropertyValueFactory<>("num"));
        tableNomBijou.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tableMateriau.setCellValueFactory(new PropertyValueFactory<>("materiau"));
        tableCategorie.setCellValueFactory(new PropertyValueFactory<>("Categorie"));
        tableDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        tableStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        tablePrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        tabBijou.setItems(listeBijoux);
    }

    public void affichageCommandeTmp() {
        listeCommandeTemporaire = listeCommandeTmp();
        tableComTmpIdBijou.setCellValueFactory(new PropertyValueFactory<>("Num_bijou"));
        tableComTmpNomBijou.setCellValueFactory(new PropertyValueFactory<>("Nom_bijou"));
        tableComTmpDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        tableCompTmpQuantite.setCellValueFactory(new PropertyValueFactory<>("quantiteCommander"));
        tableComTmpPU.setCellValueFactory(new PropertyValueFactory<>("prix"));
        tableComTmpMontant.setCellValueFactory(new PropertyValueFactory<>("montant"));
        tabCommander.setItems(listeCommandeTemporaire);
    }
    
    public void affichageListeCommande(){
        listCommande = listeCommande();
        tabListComNumCom.setCellValueFactory(new PropertyValueFactory<>("Num"));
        tabListComIdClient.setCellValueFactory(new PropertyValueFactory<>("IdCli"));
        tabListClentMontantTotal.setCellValueFactory(new PropertyValueFactory<>("Montant"));
        tabListComDateCom.setCellValueFactory(new PropertyValueFactory<>("Date"));
        tabListComNomCli.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tabListComPrenomCli.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        tabListComTelephone.setCellValueFactory(new PropertyValueFactory<>("tel"));
        tabCommande.setItems(listCommande);
    }

    @FXML
    public void selectionIdClient() {
        String idCli = (String) txtIdClientCom.getSelectionModel().getSelectedItem();
        GestionsBijouteries gestion = new GestionsBijouteries();
        ResultSet res = null;
        if (idCli != null) {
            res = gestion.getClient(Integer.parseInt(idCli.substring(0, 1)));
        }
        try {
            if (res != null) {
                res.next();
                txtNomClientCom.setText(res.getString("Nom_cli"));
                txtPrenomClientCom.setText(res.getString("Prenom_cli"));
            } else {
                txtNomClientCom.setText(null);
                txtPrenomClient.setText(null);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    public void selectionIdBijou() {
        String numBijou = (String) txtNomBijouCom.getSelectionModel().getSelectedItem();
        GestionsBijouteries gestion = new GestionsBijouteries();
        ResultSet res = null;
        if (numBijou != null) {
            res = gestion.getBijou(Integer.parseInt(numBijou.substring(0, 1)));
        }
        try {
            if (res != null) {
                res.next();
                if (numBijou != null) {
                    txtIdBijouCom.setText(res.getString("Num_bijou"));
                    txtQuantiteCom.setText(res.getString("Stock"));
                    txtPrixCom.setText(res.getString("Prix") + " Ar");
                } else {
                    txtIdBijouCom.setText(null);
                    txtQuantiteCom.setText(null);
                    txtPrixCom.setText(null);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void sexeList() {
        List<String> sexe = new ArrayList<>();

        for (String data : listSexe) {
            sexe.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(sexe);
        cbSexeClient.setItems(listData);
    }

    public void idClientList() {
        GestionClients gestion = new GestionClients();
        ResultSet res = gestion.getAll();
        List<String> idclient = new ArrayList<>();
        try {
            while (res.next()) {
                idclient.add(res.getString("Id_cli") + " " + res.getString("Nom_cli") + " " + res.getString("Prenom_cli"));
            }
            ObservableList listidclient = FXCollections.observableArrayList(idclient);
            txtIdClientCom.setItems(listidclient);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void numBijouList() {
        GestionBijoux gestion = new GestionBijoux();
        ResultSet res = gestion.getAll();
        List<String> numbijou = new ArrayList<>();
        try {
            while (res.next()) {
                if (res.getInt("Stock") != 0) {
                    numbijou.add(res.getString("Num_bijou") + " " + res.getString("Nom_bijou") + " " + res.getString("Description"));
                }
            }
            ObservableList listnumbijou = FXCollections.observableArrayList(numbijou);
            txtNomBijouCom.setItems(listnumbijou);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void dectonnection() {
        try {
            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Message de deconnection");
            alert.setHeaderText(null);
            alert.setContentText("Vous voulez vraiment deconnecter ?");
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get().equals(ButtonType.OK)) {
                //C'est pour fermer la fenetre AppFormView la fenetre principale 
                btnDeconnection.getScene().getWindow().hide();

                //Lien pour charger le fichier Login.fxml pour afficher la fenetre de connection
                Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setTitle("Se Connecter");
                stage.setScene(scene);
                stage.show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void afficherPaneClient() {
        paneClient.setVisible(true);
        panelMenu.setVisible(false);
        paneBijou.setVisible(false);
        paneCommande.setVisible(false);
        paneListeCommande.setVisible(false);
        affichageClient();
        sexeList();
    }

    public void afMenu() {
        GestionDetailCommande g = new GestionDetailCommande();
        nbrBijousVendus.setText(String.valueOf(g.nbrBijouVendu()));
        GestionCommande gc = new GestionCommande();
        revenusAujourdhuit.setText(String.valueOf(gc.montantBijouVenduAujourdhuit()) + "Ar");
        revenusTotal.setText(String.valueOf(gc.montantTotalBijouVendu()) + "Ar");
        revenusDuMois.setText(String.valueOf(gc.montantBijouVenduCeMoisCi()) + "Ar");
    }

    @FXML
    public void afficherPaneMenu() {
        panelMenu.setVisible(true);
        paneClient.setVisible(false);
        paneBijou.setVisible(false);
        paneCommande.setVisible(false);
        paneListeCommande.setVisible(false);
        affichageAreaChart();
        affichageBarChart();
        nombreClient();
        nombreBijou();
        afMenu();
    }

    @FXML
    public void afficherPaneBijoux() {
        paneBijou.setVisible(true);
        paneClient.setVisible(false);
        panelMenu.setVisible(false);
        paneCommande.setVisible(false);
        paneListeCommande.setVisible(false);
        affichageBijou();
    }

    @FXML
    public void afficherCommande() {
        LocalDate date = LocalDate.now();
        int annne = date.getYear();
        int jours = date.getDayOfMonth();
        int mois = date.getMonthValue();
        paneCommande.setVisible(true);
        paneClient.setVisible(false);
        panelMenu.setVisible(false);
        paneBijou.setVisible(false);
        paneListeCommande.setVisible(false);
        GestionCommande com = new GestionCommande();
        txtNumCom.setText(String.valueOf(com.countCommande() + 1));
        idClientList();
        numBijouList();
        affichageCommandeTmp();
        laeblDateCommande.setText(String.valueOf(jours)+"-0"+String.valueOf(mois)+"-"+String.valueOf(annne));
    }
    
    @FXML
    public void afficherListeCommande(){
        paneListeCommande.setVisible(true);
        panelMenu.setVisible(false);
        paneClient.setVisible(false);
        paneBijou.setVisible(false);
        paneCommande.setVisible(false);
    }

    public void masquerButton() {
        btnModiffierClient.setVisible(false);
        btnSupprimerClient.setVisible(false);
        btnSupprimerBijou.setVisible(false);
        btnModiffierBijou.setVisible(false);
        btnEnregistrerBijou.setVisible(true);
        btnEnregistrerClient.setVisible(true);
    }

    public void nombreClient() {
        GestionsBijouteries gestion = new GestionsBijouteries();
        nbrClients.setText(String.valueOf(gestion.nombreClient()));
    }

    public void nombreBijou() {
        GestionsBijouteries gestion = new GestionsBijouteries();
        nbrBijoux.setText(String.valueOf(gestion.nombreBijou()));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labelUtilisateur.setText(LoginController.sessionNom);
        panelMenu.setVisible(true);
        affichageAreaChart();
        affichageBarChart();
        affichageClient();
        affichageBijou();
        affichageListeCommande();
        masquerButton();
        nombreClient();
        nombreBijou();
        afMenu();
    }

}
