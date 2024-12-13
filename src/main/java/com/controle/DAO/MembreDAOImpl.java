package com.controle.DAO;

import com.controle.DataBaseConnection.DataBaseConnection;

import com.controle.Models.* ;

import java.sql.ResultSet;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MembreDAOImpl {


    public void insere(Membre membre) {
        String query = "INSERT INTO membres (identifiant, nom, prenom, email, phone) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Associer les valeurs
            preparedStatement.setString(1, membre.getIdentifiant());
            preparedStatement.setString(2, membre.getNom());
            preparedStatement.setString(3, membre.getPrenom());
            preparedStatement.setString(4, membre.getEmail());
            preparedStatement.setString(5, membre.getPhone());

            // Exécuter la requête
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Membre inséré avec succès !");
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'insertion : " + e.getMessage());
        }
    }

    public List<Incident> chargerListIncidents() {
        List<Incident> incidents = new ArrayList<>();
        String query = "SELECT reference, time, status, membre_id FROM incidents";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                // Lire les données de l'Incident
                String reference = resultSet.getString("reference");
                LocalTime time = resultSet.getTime("time").toLocalTime();
                String status = resultSet.getString("status");
                String membre_id =resultSet.getString("membre_id");

                // Ajouter l'Incident à la liste
                incidents.add(new Incident(reference, time, status, membre_id));
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors du chargement des incidents : " + e.getMessage());
        }

        return incidents;
    }
}
