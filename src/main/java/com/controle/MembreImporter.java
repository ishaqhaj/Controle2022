package com.controle;

import com.controle.Models.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class MembreImporter {

    public static void main(String[] args) {
        MembreImporter importer = new MembreImporter();
        String fichier = "C:\\Users\\ishak\\Desktop\\Projets\\JAVA\\Controle2022\\src\\main\\java\\com\\controle\\fichier.txt";

        Set<Membre> membres = importer.chargerListeMembre(fichier);
        membres.forEach(System.out::println);
    }

    // Modify the method to use Path for more robust file handling
    public Set<Membre> chargerListeMembre(String nomFichier) {
        Set<Membre> membres = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(new File(nomFichier)))) {
            String line;

            // Skip header if present (assume first line is a header)
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");
                if (parts.length >= 4) { // Ensure there are enough columns
                    String nom = parts[0].trim();
                    String prenom = parts[1].trim();
                    String email = parts[2].trim();
                    String phone = parts[3].trim();

                    Membre membre = new Membre(nom, prenom, email, phone);
                    membres.add(membre); // HashSet ensures no duplicates
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return membres;
    }
}
