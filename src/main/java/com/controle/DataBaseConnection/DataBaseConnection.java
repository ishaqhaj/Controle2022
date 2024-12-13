package com.controle.DataBaseConnection;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Provides a connection to the database.
 */
public class DataBaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/membres_incidents";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static java.sql.Connection getConnection() throws SQLException {
        java.sql.Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connexion réussie à la base de données !");
        } catch (ClassNotFoundException e) {
            System.err.println("Erreur : Pilote JDBC non trouvé.");
            e.printStackTrace();
            throw new SQLException("Pilote JDBC non chargé", e);
        } catch (SQLException e) {
            System.err.println("Erreur lors de la connexion à la base de données.");
            e.printStackTrace();
            throw e;
        }
        return connection;
    }

    public static void closeConnection(java.sql.Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connexion fermée.");
            } catch (SQLException e) {
                System.err.println("Erreur lors de la fermeture de la connexion.");
                e.printStackTrace();
            }
        }
    }
}