package com.controle.DAO;


import com.controle.DataBaseConnection.DataBaseConnection;
import com.controle.Models.*;

import java.sql.Time;
import java.time.LocalTime;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

public class IncidentDAOImpl {

    public void inserer(Incident incident) {
        String query = "INSERT INTO incidents (reference, time, status, membre_id) VALUES (?, ?, ?, ?)";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Associer les valeurs
            preparedStatement.setString(1, incident.getReference());
            preparedStatement.setTime(2, java.sql.Time.valueOf(incident.getTime()));
            preparedStatement.setString(3, incident.getStatus());
            preparedStatement.setString(4, incident.getMembre_id());

            // Exécuter la requête
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Incident inséré avec succès !");
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'insertion : " + e.getMessage());
        }
    }

    public void inser(Set<Incident> incidents) {
        for (Incident incident : incidents) {
            String query = "INSERT INTO incidents (reference, time, status, membre_id) VALUES (incident.reference, incident.time, incident.status, incident.membre_id)";

            try (Connection connection = DataBaseConnection.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                // Associer les valeurs
                preparedStatement.setString(1, incident.getReference());
                preparedStatement.setTime(2, java.sql.Time.valueOf(incident.getTime()));
                preparedStatement.setString(3, incident.getStatus());
                preparedStatement.setString(4, incident.getMembre_id());

                // Exécuter la requête
                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Incident inséré avec succès !");
                }
            } catch (SQLException e) {
                System.err.println("Erreur lors de l'insertion : " + e.getMessage());
            }
        }
    }
}
