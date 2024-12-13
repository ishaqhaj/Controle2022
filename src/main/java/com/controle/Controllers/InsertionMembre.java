package com.controle.Controllers;

import com.controle.Models.*;
import com.controle.DAO.*;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;


public class InsertionMembre {

    @FXML
    private TextField nomField;   // Champ pour le nom
    @FXML
    private TextField prenomField; // Champ pour le prénom
    @FXML
    private TextField emailField;  // Champ pour l'email
    @FXML
    private TextField phoneField;  // Champ pour le téléphone

    // Méthode pour insérer un membre dans la base de données
    @FXML
    private void save() {
        MembreDAOImpl mem = new MembreDAOImpl();
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        if (nom != null && prenom != null && email != null && phone != null) {
            Membre membre = new Membre(nom,prenom,email,phone);
            mem.insere(membre);
        }else {
            System.out.println("Error : des champs vides !");
 }

    }

    // Méthode pour afficher des alertes
    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
