package com.controle.DAO;

import com.controle.Models.*;

import java.util.List;

public interface MembreDAO {

    void insere(Membre membre);
    List<Incident> chargerListIncidents();
}
