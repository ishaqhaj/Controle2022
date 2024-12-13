package com.controle.Models;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Membre {
    private String identifiant;
    private String nom;
    private String prenom;
    private String email;
    private String phone;
    private List<Incident> incidents;

    public Membre(String nom, String prenom, String email, String phone) {
        this.identifiant = UUID.randomUUID().toString();
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.phone = phone;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Membre" +
                "identifiant='" + identifiant + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Membre membre = (Membre) o;
//        return Objects.equals(identifiant, membre.identifiant);
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Membre membre = (Membre) o;
        return     Objects.equals(email, membre.email)
                && Objects.equals(phone, membre.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, phone);
    }

}
